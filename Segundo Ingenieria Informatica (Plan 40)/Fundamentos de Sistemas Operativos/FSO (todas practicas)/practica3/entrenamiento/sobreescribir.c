#include <sys/types.h>	// open()
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>	// close()
#include <errno.h>	// error handling
#include <string.h>
#include <stdio.h>	// args
#include <stdlib.h>	// exit() y args




/* ---readable--- */
char* path1 = "/etc/passwd";
char* path2 = "/bin/ls";
char* in = "/home/mario/Documentos/practica3/entrenamiento/in.txt";
char* out = "/home/mario/Documentos/practica3/entrenamiento/out.txt";

/* ---non readable--- */
char* path3 = "/var/log/messages";

/* ---directories--- */
char* path4 = "/etc";
char* path5 = "/bin";


int Abrir (char* path, int flags)
{
	int fd;
	errno = 0;	
	
	fd = open(path, flags);
	if (fd == -1) {
		const int err = errno;
		fprintf(stderr, "open failed: %s\n", strerror(errno));
		exit(-1);
	}
	
//	printf("Éxito en Abrir()\n");
	return fd;
}

int Cerrar (int fd)
{
	errno = 0;

	if (close(fd) == -1) {
		fprintf(stderr, "close failed: %s\n", strerror(errno));
		exit(-1);
	}
	
//	printf("Éxito en Cerrar()\n");
	return 0;
}


char Leer(int fd)
{
	char res;
	int nbytes;

start:
	nbytes = read(fd, &res, sizeof(char));
	
	if (nbytes == -1) {
		int err = errno;
		
		if (err == EINTR) { // Comentar !!
			goto start;
		} else {
			fprintf(stderr, "read failed: %s\n", strerror(errno));
			exit(-1);
		}
	}
	if (nbytes==0) res='\0';
	
	return res;
}

int Escribir(int fd, char car)
{
	int nbytes;

start:
	nbytes = write(fd, &car, sizeof(char));
	
	if (nbytes == -1) {
		fprintf(stderr, "write failed: %s\n", strerror(errno));
		exit(-1);
	}
	
	return 0;
}

void Copiar(int fromFd, int toFd) {
	char car;
	
	while ((car = Leer(fromFd)) != '\0') {
		Escribir(toFd, car);
	}

//	printf("Éxito en Copiar()\n");
}

int argsCheck(int arg, char* argv[]) {
	int i;

	for (i=0; i<arg; i++) {
		if (argv[i][0] == '-' && argv[i][1] == 'f')
		{
//			printf("opción: %s\n", argv[i]+1);
			return 1;
		}
	}
	return 0;
}

void pruebas(int option) {
	int fd, ori, dest;
	char car;
	char* cOri = "in.txt";
	char* cDest = "out.txt";
//	printf("\n");

// Inicio
	ori = Abrir (in, O_RDONLY);
	dest = Abrir (out, O_RDONLY);
	
	printf("%s:\n", cOri);
	while ((car = Leer(ori)) != '\0') {
		printf("%c", car);
	}
	printf("\n");
	printf("%s:\n", cDest);
	while ((car = Leer(dest)) != '\0') {
		printf("%c", car);
	}
	
	printf("\n");
	
	
	Cerrar(ori);
	Cerrar(dest);
// Copiar
	ori = Abrir (in, O_RDONLY);
	if (option == 1) {
		dest = Abrir (out, O_WRONLY | O_TRUNC);
	} else {
		printf("Do you want to overwrite %s? [y/n]: ", cDest);
		char ans = getchar();
		
		if (ans == 'y') {
			dest = Abrir (out, O_WRONLY | O_TRUNC);
		} else if (ans == 'n') {
			dest = Abrir (out, O_WRONLY | O_APPEND);
		} else {
			printf("Unexpected input\n");
			exit(-1);
		}
		printf("\n");
	}
	
// Copia
	Copiar (ori, dest);


	Cerrar(ori);
	Cerrar(dest);
// Resultado
	dest = Abrir (out, O_RDONLY);
	
	printf("%s:\n", cDest);
	while ((car = Leer(dest)) != '\0') {
		printf("%c", car);
	}
	
	
	Cerrar(dest);
	printf("\n");
}

int main(int arg, char* argv[])
{
	pruebas(argsCheck(arg, argv));

}
