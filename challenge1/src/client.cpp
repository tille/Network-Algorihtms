#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <netdb.h> 
#include <string>
#include <iostream>
#include <arpa/inet.h>

using namespace std;

void error(int id) {
  string msg;
  if(id==1) msg = "Please specific a server and port... example => ./client server_ip 2001";
  else if(id==2) msg = "Error opening socket";
  else if(id==3) msg = "Error, no such host";
  else if(id==4) msg = "Error connecting";
  else if(id==5) msg = "Error writing to socket";
  else if(id==6) msg = "Error reading from socket";
  cout << msg << endl;
  exit(0);
}

struct package{
  int id;
  char cont[255];
};

int main(int argc, char *argv[]) {

  if( argc < 3 ) error(1);
  int id = 1;
  
  int sockfd, portno, n;
  struct sockaddr_in serv_addr;
  struct hostent *server;
  
  if( (sockfd = socket(AF_INET, SOCK_STREAM, 0)) < 0 ) error(2);
  if( (server = gethostbyname(argv[1])) == NULL ) error(3);
  
  serv_addr.sin_family = AF_INET;
  bcopy((char *)server->h_addr, (char *)&serv_addr.sin_addr.s_addr, server->h_length);
  //serv_addr.sin_addr.s_addr = inet_addr(argv[1]);
  serv_addr.sin_port = htons(2001);
  memset(&(serv_addr.sin_zero), 0, 8);
  
  if (connect(sockfd,(struct sockaddr *) &serv_addr,sizeof(serv_addr)) < 0) error(4);
  //char const *c = myString.c_str();
  
  package info;
  char buffer[sizeof(info)]; 
  
  while( true ){
    memset(info.cont,0,255);
    printf("R:>> ");
    fgets(info.cont,255,stdin);
    info.id = id++; string exp(info.cont);
    exp = exp.substr(0,exp.size()-1);
    memcpy(&buffer, &info, sizeof(package));  
    if( (n = write(sockfd, buffer, sizeof(buffer))) < 0 ) error(5);

    memset(buffer,0,256);  
    if( (n = read(sockfd,buffer,255)) < 0 ) error(6);
    string buffer2(buffer);
    if( buffer2 == "close" ) break;
    else printf(" => %s\n",buffer);
  }
  
  close(sockfd);
  return 0;
}