/*
	Ejemplos de uso de la biblioteca <string.h>
*/

#include <string.h>
#include <stdlib.h>
#include <stdio.h>

// dos funciones auxiliares
void imprime_cadena (const char* string);
void ejemplo_comparar_cadenas ();
void ejemplo_buscar_subcadenas();

main()
{
  // declaración de dos cadenas mediante char*
  char* hello = "hola";
  char* world = "mundo";
  
  // declaración de una cadena como un vector
  // son vectores de cinco elementos, porque hay que contar con el NUL 
  char vector_a[5] = "hola";
  char vector_b[] = { 'h', 'o', 'l', 'a', '\0' };
  
  // concatenamos dos cadenas
  // haremos el equivalente a este código en Java:
  // String hello_world = hello + " " + world;
  
  // Forma 1: sólo compila con C99
  {
    int longitud = strlen(hello)+1+strlen(world)+1;
 		char hello_world [longitud];
  	strcpy (hello_world,hello);
  	strcat (hello_world," ");
  	strcat (hello_world,world);
  	
  	imprime_cadena(hello_world);
  }
  
  // Forma 2: memoria dinámica, funciona en cualquier versión de C
  {
    int longitud = strlen(hello)+1+strlen(world)+1;
  	char* hello_world = (char*)malloc(longitud);
  	strcpy (hello_world,hello);
  	strcat (hello_world," ");
  	strcat (hello_world,world);
  	
  	imprime_cadena(hello_world);
  	// si no invocamos a free(), el espacio reservado con malloc()
  	// seguirá estando no disponible, aunque no sea accesible
  	free(hello_world);
  }
  
  // un ejemplo, ver implementación más abajo
  ejemplo_comparar_cadenas();
  
  // otro ejemplo
	ejemplo_buscar_subcadenas();
  
  exit(0);
  
}


void imprime_cadena (const char* string)
{
	// El formato %zu sirve para imprimir valores de tipo size_t
	// que es lo que devuelve strlen()
	printf("La cadena \"%s\" tiene %zu caracteres\n", 
	       string, strlen(string) );
}

// Ejemplo de lectura de cadenas desde el teclado 
// y de uso de la función strcmp()
 #define TAMSTRING 100
void ejemplo_comparar_cadenas ()
{

  char a[TAMSTRING], b[TAMSTRING];
  
  printf("escriba un texto: ");
  // fgets() lee una línea de texto de la entrada estándar.
  // Como mucho se leen TAMSTRING-1 caracteres.
  fgets(a,TAMSTRING-1,stdin);
  
  // fgets() añade el salto de línea final. La siguiente línea
  // sustituye el salto de línea por un NUL.
  // Esto no servirá si escribimos una línea con más de TAMSTRING caracteres.
  // Dejamos como ejercicio dar con una solución más general.
  a[strlen(a)-1] = '\0';
  
  printf("escriba otro texto: ");
  fgets(b,TAMSTRING-1,stdin);
  b[strlen(b)-1] = '\0';
 
	int resultado = strcmp(a,b);
	if ( resultado == 0 )
	{
		puts("las dos cadenas son idénticas");
	}
	else if ( resultado < 0 ) // a va antes que b lexicográficamente
	{
	  printf("\"%s\" va antes que \"%s\"\n",a,b);
	}
	else 
	{
		printf("\"%s\" va antes que \"%s\"\n",b,a);
	}
}

// Ejemplo de uso de la función strstr()

void busca_subcadena (const char* palabra, const char* texto)
{
  // lugar recoge el puntero al carácter en 'texto' que contiene
  // la palabra buscada
	char* lugar = strstr(texto,palabra);
	
	if ( lugar == NULL )
	{
		printf("la palabra [%s] no se encuentra\n",palabra);
	} else {
	  // usamos aritmética de punteros para calcular la posición
	  int posicion = lugar-texto;
		printf("la palabra [%s] se encuentra en la posición %d\n",
		       palabra,posicion);
	}
}

void ejemplo_buscar_subcadenas()
{
	char* texto = "En un lugar de la Mancha, de cuyo nombre no quiero acordarme";
	char* palabra1 = "nombre";
	char* palabra2 = "hola";

  busca_subcadena(palabra1,texto);
  busca_subcadena(palabra2,texto);
	
}

