#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>
#include <stdlib.h>
#include <stdio.h>
#include "mistring.h"

/*
*
*/
int contiene(char caracter, char *cadena, int len){
	int k;
	for(k = 0; k<len; k++){
		if(caracter == cadena[k]){
			return 1;
		}
	}
	return 0;
}

void opcion_s(int count, char *cadena, char *f1, char *f2){
	/*
	  PASO 1: CADENA1.LEN == CADENA2.LEN
	*/
	int lenCad1 = mi_strlen(cadena);
	if(lenCad1==0){		
		exit(0);
	}

	/*
	  PASO 2: ABRIR LOS ARCHIVOS F1 Y F2 Y COMPROBAR ERRORES
	*/	
	int fsrc = open (f1, O_RDONLY);
	if(fsrc == -1){
		printf("Error apertura Arch1");		
		exit(1);		
	}
	int fdst = open (f2, O_WRONLY | O_CREAT, 0644);	
	if(fdst == -1){
		printf("Error apertura Arch2");		
		exit(1);		
	}

	/*
	  PASO 3: CONFIGURAR EL BUFFER	
	*/
	char buffer[200]; int i; char aux='*';
	int leidos = read(fsrc,buffer,100);
	int total = 0;				//opcional, indica los bytes leidos
	int suprimidos = 0;			//opcional, indica los bytes suprimidos

	/*
	  PASO 4: ALGORITMO DE LECTURA
	*/
	while(leidos == 200){
		for(i=0; i<leidos; i++){
			if(contiene(buffer[i], cadena, lenCad1) == 1){
				if(buffer[i] != aux){
					write(fdst, &buffer[i], sizeof(char));
					aux = buffer[i];
				} else {
					suprimidos++;
				}					
			} else {
				write(fdst, &buffer[i], sizeof(char));
			}
		}
		total = total + leidos;
		leidos = read(fsrc,buffer,100);
	}
	//En la última iteración sale del while y fuera.
	for(i=0; i<leidos; i++){
		for(i=0; i<leidos; i++){
			if(contiene(buffer[i], cadena, lenCad1) == 1){
				if(buffer[i] != aux){
					write(fdst, &buffer[i], sizeof(char));
					aux = buffer[i];
				} else {
					suprimidos++;
				}					
			} else {
				aux = buffer[i];
				write(fdst, &buffer[i], sizeof(char));
			}
		}
	}
	total = total + leidos;

	//Lectura de bytes
	printf("Bytes leidos: %d\n", total);
	printf("Bytes copiados: %d\n", total-suprimidos);

	close(fsrc);
	close(fdst);

	exit(0);
	
}

void opcion_d(int count, char *cadena, char *f1, char *f2){
	/*
	  PASO 1: CADENA1.LEN == CADENA2.LEN
	*/
	int lenCad1 = mi_strlen(cadena);
	if(lenCad1==0){		
		exit(0);
	}

	/*
	  PASO 2: ABRIR LOS ARCHIVOS F1 Y F2 Y COMPROBAR ERRORES
	*/	
	int fsrc = open (f1, O_RDONLY);
	if(fsrc == -1){
		printf("Error apertura Arch1");		
		exit(1);		
	}
	int fdst = open (f2, O_WRONLY | O_CREAT, 0644);	
	if(fdst == -1){
		printf("Error apertura Arch2");		
		exit(1);		
	}

	/*
	  PASO 3: CONFIGURAR EL BUFFER	
	*/
	char buffer[200]; int i; char aux='*';
	int leidos = read(fsrc,buffer,100);
	int total = 0;				//opcional, indica los bytes leidos
	int suprimidos = 0;			//opcional, indica los bytes suprimidos

	/*
	  PASO 4: ALGORITMO DE LECTURA
	*/
	while(leidos == 200){
		for(i=0; i<leidos; i++){
			if(contiene(buffer[i], cadena, lenCad1) == 0){
				write(fdst, &buffer[i], sizeof(char));
			} else {
				suprimidos++;			
			}
		}
		total = total + leidos;
		leidos = read(fsrc,buffer,100);
	}
	//En la última iteración sale del while y fuera.
	for(i=0; i<leidos; i++){
		for(i=0; i<leidos; i++){
			if(contiene(buffer[i], cadena, lenCad1) == 0){
				write(fdst, &buffer[i], sizeof(char));
			} else {
				suprimidos++;			
			}
		}
	}
	total = total + leidos;

	//Lectura de bytes
	printf("Bytes leidos: %d\n", total);
	printf("Bytes copiados: %d\n", total-suprimidos);

	close(fsrc);
	close(fdst);

	exit(0);
}

void opcion_default(int count, char *cadena1, char *cadena2,  char *f1, char *f2){
	
	/*
	  PASO 1: CADENA1.LEN == CADENA2.LEN
	*/
	int lenCad1 = mi_strlen(cadena1);
	if(lenCad1!=mi_strlen(cadena2)){
		printf("ARG1 y ARG2 difieren en longitud");		
		exit(1);
	}	
	/*
	  PASO 2: ABRIR LOS ARCHIVOS F1 Y F2 Y COMPROBAR ERRORES
	*/	
	int fsrc = open (f1, O_RDONLY);
	if(fsrc == -1){
		printf("Error apertura Arch1");		
		exit(1);		
	}
	int fdst = open (f2, O_WRONLY | O_CREAT, 0644);	
	if(fdst == -1){
		printf("Error apertura Arch2");		
		exit(1);		
	}
	
	/*
	  PASO 3: CONFIGURAR EL BUFFER	
	*/
	char buffer[100]; int i; int k; char aux;
	int leidos = read(fsrc,buffer,100);
	int total = 0;				//opcional, indica los bytes leidos
	
	/*
	  PASO 4: ALGORITMO DE LECTURA
	*/
	while(leidos == 100){
		for(i=0; i<leidos; i++){
			aux = buffer[i];
			for(k=0; k<lenCad1; k++){
				if(buffer[i] == cadena1[k]){
					aux = cadena2[k];
					break;	
				}
			}
			write(fdst, &aux, sizeof(char));
		}
		total = total + leidos;
		leidos = read(fsrc,buffer,100);
	}
	//En la última iteración sale del while y fuera.
	for(i=0; i<leidos; i++){
		aux = buffer[i];
		for(k=0; k<lenCad1; k++){
			if(buffer[i] == cadena1[k]){
				aux = cadena2[k];
				break;	
			}
		}
		write(fdst, &aux, sizeof(char));
	}
	total = total + leidos;

	//Lectura de bytes
	printf("Bytes leidos: %d\n", total);
	printf("Bytes copiados: %d\n", total);

	close(fsrc);
	close(fdst);
}


int main(int argc, char *argv[]){
	/*
	  PARTE 1D: getopt. SI NO SE VA AESCOGER OPCION, DAR SALIDA AL DICHO CAMINO.
	*/
	int opt;
	while((opt = getopt (argc, argv, "s:d")) != -1){
		switch(opt){
			case 's':
				//COMPROBAR ARG 3
				opcion_s(argc, argv[2], argv[3], argv[4]);
			case 'd':
				opcion_d(argc, argv[2], argv[3], argv[4]);
			default:
				fprintf(stderr, "Argumento inválido \n");
				exit(EXIT_FAILURE);
		}
	}
	opcion_default(argc, argv[1], argv[2], argv[3], argv[4]);
}
