#include <stdio.h>
#include <stdlib.h>
#include <math.h>

double func(double x) { 
  return sin(x)*x*x ;
}
int main(int argc, char* argv[]) {
  int i;
  double a = atof(argv[1]);
  double b = atof(argv[2]);
  int n = atoi(argv[3]);
  double len = (b-a)/n;
  double val = 0;
  double *vals = malloc(sizeof(double)*(n+1));
  double tmp = 0;
  i = 0;
  #pragma omp parallel for default(none) private(i) shared(n,vals,a,len)
  for(i=0;i<n;i++){
    vals[i] = func(a+i*len);
  }
  vals[n] = func(b);
  #pragma omp parallel for default(none) private(i,tmp) shared(n,vals,len,val)
  for(i=0;i<n;i++){
    tmp = (vals[i]+vals[i+1])*len/2;
    #pragma omp atomic
    val+=tmp;
  }
  printf("%f\n",val);
  return 0;
}