#include <sys/types.h>
#include <sys/stat.h>
#include <fcatl.h>
#include <stdio.h>
#include <stdlib.h>

char* archivo1 = "/prueba_texto.txt";
char* archivo2 = "/etc/psswd";
char* archivo3 = "/bin/ls";

int Abrir(char * nombre)
{
	if (close(fd) == -1){
		fprintf(stderr,"Error el cerrar el fichero\n");
		exit(-1);
	}
}

//char Leer
char Leer(int fd)
{
	char car;
	int nbytes;
	
	nbytes = read(fd, &car, sizeof(char));
	if (nbytes==-1){
		fprintf(stderr, "Error en la lectura del fichero");
		exit(-1);
	}
	if (nbytes==0) car='\0';
	return car;
}

char Escribir()
{
	char car;
	char nbytes;
	
}

char Copiar(int fdOrigen, int fdDestino)
{
	char car;
	char nbytes;

	//Lee
	nbytes = read(fd, &car, sizeof(char));
	if (nbytes==-1){
		fprintf(stderr, "Error en la lectura del fichero");
		exit(-1);
	}
	if (nbytes==0) car='\0';
	

}

main()
{
	int arch1;
	char caracter;
	arch1 = Abrir(archivo1);
	if (arch1 == -1)
		fprintf(stderr, "Error de apertura en %s\n",archivo1);
	else
		printf("Apertura correcta con identificador : %d\n", arch1);
	
	while ((caracter = Leer(arch1)) != '\0') {
		printf("\c",caracter);
	}
	Cerrar(arch1);
	exit(0);
}


