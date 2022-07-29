#include <string.h>
#include <stdio.h>

#define VSIZE 100

main () 
{
 char hola[5] = "hola";
 char mundo[6] = "mundo";
 char holaMundo[VSIZE];

 int i,contador;

// holaMundo = hola

	strcpy (holaMundo, hola);

// holaMundo = holaMundo + " " + mundo

	strcat (holaMundo, " ");
	strcat (holaMundo, mundo);

//Contador de caracteres

	contador=0;

	while(holaMundo[contador]!=0){
 	contador++;
	}

	printf("Numero de Caracteres = %d\n",contador);

        for (i=0;i<contador;i++){
          printf("%c",holaMundo[i]);
        }

}










