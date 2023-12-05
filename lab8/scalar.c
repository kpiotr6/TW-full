#include <stdio.h>
#include <stdlib.h>

int main(int argc, char* argv[]) {
  int i;
  double scalar;
  double *vector;
  int size;
  i = 0;
  scalar = atof(argv[1]);
  vector = malloc(sizeof(double)*size);
  size = (argc-2);
  for(int i=0;i<size;i++){
    vector[i] = atof(argv[i+2]);
  }

  #pragma omp parallel for default(none) private(i) shared(vector,scalar,size)
  for(i=0;i<size;i++){
    vector[i] = scalar*vector[i];
  }
  for(int i=0;i<size;i++){
    printf("%f ",vector[i]);
  }
  return 0;
}