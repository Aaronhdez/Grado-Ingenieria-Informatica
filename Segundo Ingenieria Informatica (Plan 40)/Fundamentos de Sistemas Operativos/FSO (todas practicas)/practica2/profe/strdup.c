// Ejemplo de código con error de strdup() 
// Muchos alumnos cometen el mismo error
// Se incluye un test de ejemplo que genera un pepinazo en los Linux del laboratorio

#include <stdlib.h>
#include <stdio.h>
#include <string.h>

char* mi_strdup ( char* original ) {

  char* orig = original;
  int longitud=0;
  while ( *orig != '\0' ) { orig++; longitud++; }
  printf("longitud=%d\n",longitud);
  char* copia = malloc(longitud+1); // estaba malloc(longitud) solamente!!
  
  char* ptr = copia;
  orig = original;
  while ( *orig != '\0' ) {
    *ptr = *orig;
    ptr++;
    orig++;
  }
  *ptr = '\0';
  
  return copia;
  
}

char* otro_strdup( char* original ) {
  int longitud = strlen(original);
  char* copia = malloc(longitud+1); // estaba malloc(longitud) solamente!!
  return strcpy(copia,original);
}

int main() {
  char str [10000];
  int i;
  for (i=0;i<10000;i++) { 
    str[i] = 'A' + (rand()%48); 
  }
  str[9000]='\0';
 
  puts(str); 
  //  char* copia = otro_strdup(str);
  char* copia = mi_strdup(str);
  puts(copia);
  free(copia);
  
  return 0;
}
