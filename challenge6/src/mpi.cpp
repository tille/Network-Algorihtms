#include <iostream>
#include <stdio.h>
#include <math.h>

#include "mpi.h"
#define MASTER 0
#define FROM_MASTER 1
#define FROM_WORKER 2

int taskId,
    numTasks,
    numWorkers,
    sourceId,
    destId,
    currentWorker=0;
    
MPI_Status status;
double start;

const int mx = 10, my = 10, m = 5;
int matrix_ui[mx][my], matrix_ui_temp[mx][my], matrix_ui_temp2[mx][my];
double matrix_corr[my][my], matrix_corr_temp[my][my];
int sr[my][m];
double r[my], r_temp[my];
int cont;
int visited[my][my];

void initMPI( int argc, char **argv){
  MPI_Init(&argc, &argv);
  MPI_Comm_rank(MPI_COMM_WORLD, &taskId);
  MPI_Comm_size(MPI_COMM_WORLD, &numTasks);
  numWorkers = numTasks-1;
}

double corr(int a, int u){
  double s1=0, s2=0, temp = 0, ans = 0;
  
  for( int i = 0; i < mx; ++i )
    temp += ((matrix_ui_temp[i][a] - r[a]) * (matrix_ui_temp[i][u] - r[u]) );

  for( int i = 0; i < mx; ++i )
    s1 += double(matrix_ui_temp[i][a] - r[a]) * double(matrix_ui_temp[i][a] - r[a]);

  for( int i = 0; i < mx; ++i )
    s2 += double(matrix_ui_temp[i][u] - r[u]) * double(matrix_ui_temp[i][u] - r[u]);
    
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
  
  int count = mx*my;
  MPI_Send(&matrix_ui[0][0], count, MPI_INT, 1, FROM_MASTER, MPI_COMM_WORLD);
}

void average(){
  int count = mx*my;
  MPI_Recv(&matrix_ui_temp[0][0], count, MPI_INT, w, FROM_MASTER, MPI_COMM_WORLD, &status); // revisar

  for( int i = 0; i < my; ++i ){
    cont = 0;
    for( int j = 0; j < mx; ++j ){
      int temp = matrix_ui[i][j];
      r[i] += temp;
      if(temp) cont++;
    }
    r[i] /= cont;
  }
  
  MPI_Send(&matrix_ui_temp[0][0], count, MPI_INT, 2, 1, MPI_COMM_WORLD);
  MPI_Send(&r[0], my, MPI_INT, 2, 1, MPI_COMM_WORLD);
}

void calc_corr(){
  int count = mx*my;
  MPI_Recv(&matrix_ui_temp2[0][0], count, MPI_INT, 1, FROM_MASTER, MPI_COMM_WORLD, &status); // revisar
  MPI_Recv(&r_temp[0], my, MPI_INT, 1, FROM_MASTER, MPI_COMM_WORLD, &status); // revisar

  for(int i = 0; i < my; ++i ){
    for( int j = 0; j < my; ++j ){
      matrix_corr[i][j] = corr(i,j);
    }
  }
  
  count = my*my;
  MPI_Send(&matrix_corr[0][0], count, MPI_INT, 3, 2, MPI_COMM_WORLD); // hay que enviar la matriz_corr
}

void calc_sr(){
  int count = my*my;
  MPI_Recv(&matrix_corr_temp[0], count, MPI_INT, 2, FROM_MASTER, MPI_COMM_WORLD, &status); // revisar
  
  for( int i = 0; i < my; ++i ){
    for( int mx = 0; mx < m; ++mx ){
      double act = -2;
      int node = -1;
      for( int j = 0; j < my; ++j ){
        if( matrix_corr_temp[i][j] > act && !visited[i][j] && i!=j){
          node = j;
          act = matrix_corr_temp[i][j];
        }
      }
      visited[i][node] = 1;
      sr[i][mx] = node;
    }
  }
  
  // aqui PUEDE imprimir
}

void main(int argc, char **argv) {
  printf("argc %d argv %s\n",argc,argv[0]);
  initMPI(argc, argv);
  start = MPI_Wtime();

  if (taskId == MASTER) fill();
  else if(taskId == 1) average();
  else if(taskId == 2) calc_corr();
  else if(taskId == 3) calc_sr();
  //printf("Processing time: %lf\n", MPI_Wtime()-start);

  print_results();
  MPI_Finalize();
}

