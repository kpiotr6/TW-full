#include <stdio.h>
#include <stdlib.h>

int main(int argc, char* argv[]) {
  int i;
  double vector1[] = {1,2,3,4};
  double vector2[] = {4,3,2,1};
  int size = 4;
  double sum = 0;
  i = 0;
  #pragma omp parallel for default(none) private(i) shared(sum,vector1,vector2,size)
  for(i=0;i<size;i++){
    double mul = vector1[i]*vector2[i];
    #pragma omp atomic
    sum+=mul;
  }
  printf("%f\n",sum);
  return 0;
}