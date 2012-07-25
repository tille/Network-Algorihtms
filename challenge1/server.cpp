/* Este server corre sobre el puerto 2001 
   Recibe peticiones de multiples clientes y se encarga de crear un hilo 
   para cada uno, los datos que estamos recibiendo seran operaciones matematicas
   y estaran seran evaluadas haciendo uso de la RPN (Notacion Polaca Inversa). */
   
#include <stdio.h>
#include <stdlib.h>
#include <string>
#include <unistd.h>
#include <sys/types.h> 
#include <sys/socket.h>
#include <netinet/in.h>
#include <sstream>
#include <string>
#include <iostream>
#include <arpa/inet.h>
#include <stack>

using namespace std;

template <class T> string toStr(const T &x)
{ stringstream s; s << x; return s.str(); }

int err;

double eval(double n1, double n2, string op){
  if( op == "+" ) return n1+n2;
  else if( op  == "-" ) return n1-n2;
  else if( op == "*" ) return n1*n2;
  else if( op == "/" && n2 != 0) return n1/n2;
  else{
    err = 1;
    return 0;
  }
}

double calc(string exp){
  char buffer[256]; memset(buffer,0,256);
  err = 0; char temp[128]; 
  
  exp = exp.substr(0,exp.size()-1);
  exp = "( " +  exp + " )";
  for( unsigned int i=0; i<exp.size(); ++i ) buffer[i] = exp[i];
  
  char *ini;
  string tope;
  double n1,n2;
  ini = strtok(buffer, " ");
  stack<string> op; stack<double> term;
  
  while( ini != NULL && err != 1 ){
    string act(ini);
    
    if( act == "+" || act == "-" || act == "*" || act == "/" || act == "(" ){ 
      
      if(op.size()) tope = op.top();
      else tope = "-1";

      while( ( tope == "*" || tope == "/" ) && ( act == "+" || act == "-" ) ){
        op.pop();
        n2 = term.top(); term.pop(); 
        n1 = term.top(); term.pop();
        term.push( eval(n1,n2,tope) );
        tope = op.top();
      }
      op.push(act);
    }else if( act == ")" ){
      
      if(op.size()) tope = op.top();
      else break;
      
      while( tope != "(" && op.size() ){
        op.pop();
        n2 = term.top(); term.pop(); 
        n1 = term.top(); term.pop();
        term.push( eval(n1,n2,tope) );
        tope = op.top();
      }
      op.pop();
    }else{
      memset(temp,0,128);
      for( int j=0; j<act.size(); ++j){
        if( (act[j]-'0' < 10 && act[j]-'0'>-1) || act[j]=='.' ) temp[j]=act[j];
        else{ err = 1; break; }
      }
      double num = atof(temp);
      term.push(num);
    }
    ini = strtok(NULL," ");
  }
  
  if( term.size() == 1 ) return term.top();
  else{
    err = 1;
    return 0;
  }
}

struct package{
  int id;
  char cont[255];
};

void error(const char *msg) {
  perror(msg);
  exit(1);
}

int main(int argc, char *argv[]) {

  char buffer[260]; buffer[260]= '\0';
  int temp; temp = err = 0;
  
  int sockfd, newsockfd, n;
  struct sockaddr_in serv_addr, client;

  if ( (sockfd = socket(AF_INET, SOCK_STREAM, 0)) < 0 ) error("ERROR opening socket");
  
  serv_addr.sin_family = AF_INET;
  serv_addr.sin_addr.s_addr = INADDR_ANY;
  serv_addr.sin_port = htons(2001);
  memset(&(serv_addr.sin_zero), 0, 8);
  
  if (bind(sockfd, (struct sockaddr *) &serv_addr, sizeof(serv_addr)) < 0) error("ERROR on binding");

  listen(sockfd,10);

  while(true){
    
    socklen_t clilen = sizeof(struct sockaddr_in);
    if( (newsockfd = accept(sockfd, (struct sockaddr *) &client, &clilen)) < 0 ) error("ERROR on accept");
    printf("server: conexion desde: %s\n", inet_ntoa(client.sin_addr));
    
    if(!fork()){
      while( true ){
        memset(buffer,0,260);
        if( (n = read(newsockfd,buffer,260)) < 0 ) error("ERROR reading from socket");
    
        package cp;
        memcpy(&cp, buffer, 260);
        string buffer2(cp.cont);
        if(buffer2 == "close\n") break;
        if( cp.id != temp ){
          printf("Se recibio: %s",cp.cont);
          temp = cp.id;
          double result = calc(buffer2);
          if( err == 1 ) sprintf (buffer, "Invalid Expresion, Please type /? for help.");
          else if( (result - int(result)) == double(0) ) sprintf (buffer, "%d",int(result));
          else sprintf (buffer, "%f", result);
          if( (n = write(newsockfd,buffer,64)) < 0 ) error("ERROR writing to socket");
          memset(buffer,0,260);
        }
      }
      if( (n = write(newsockfd,"close",8)) < 0 ) error("ERROR writing to socket");
      close(newsockfd);
      //while(waitpid(-1,NULL,WNOHANG) > 0);
    }
  }
  
  close(sockfd);
  return 0; 
}
