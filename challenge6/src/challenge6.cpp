#include <iostream>
#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <time.h>

using namespace std;

const int mx = 10, my = 10, m = 5;
int matrix_ui[mx][my];
double matrix_corr[my][my];
int sr[my][m];
double r[my];
int cont;
int visited[my][my];

double corr(int a, int u){
  double s1=0, s2=0, temp = 0, ans = 0;
  
  for( int i = 0; i < mx; ++i )
    temp += ((matrix_ui[i][a] - r[a]) * (matrix_ui[i][u] - r[u]) );

  for( int i = 0; i < mx; ++i )
    s1 += double(matrix_ui[i][a] - r[a]) * double(matrix_ui[i][a] - r[a]);

  for( int i = 0; i < mx; ++i )
    s2 += double(matrix_ui[i][u] - r[u]) * double(matrix_ui[i][u] - r[u]);
    
  ans = sqrt(s1) * sqrt(s2);
  return temp / ans;
}

void fill(){
  srand ( time(NULL) );
  memset(visited, 0, sizeof visited);
  
  for( int i = 0; i < mx; ++i ){
    for( int j = 0; j < my; ++j ){
      int num = rand() % 6;
      matrix_ui[i][j] = num;
    }
  }
}

void average(){
  for( int i = 0; i < my; ++i ){
    cont = 0;
    for( int j = 0; j < mx; ++j ){
      int temp = matrix_ui[i][j];
      r[i] += temp;
      if(temp) cont++;
    }
    r[i] /= cont;
  }
}

void calc_corr(){
  for(int i = 0; i < my; ++i ){
    for( int j = 0; j < my; ++j ){
      matrix_corr[i][j] = corr(i,j);
    }
  }
}

void calc_sr(){
  for( int i = 0; i < my; ++i ){
    for( int mx = 0; mx < m; ++mx ){
      double act = -2;
      int node = -1;
      for( int j = 0; j < my; ++j ){
        if( matrix_corr[i][j] > act && !visited[i][j] && i!=j){
          node = j;
          act = matrix_corr[i][j];
        }
      }
      visited[i][node] = 1;
      sr[i][mx] = node;
    }
  }
}

void print_results(){
  for( int i = 0; i < my; ++i ){
    for( int j = 0; j < m; ++j ){
      cout << sr[i][j] << " ";
    }
    cout << endl;
  }
}

int main(){
  
  fill();
  average();
  calc_corr();
  calc_sr();
  print_results();
  
  return 0;
}