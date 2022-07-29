#include <sys/types.h>	//open()
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>	//close()
#include <errno.h>	//error handling
#include <string.h>
#include <stdio.h>
#include <stdlib.h>	//exit()


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
	
	return fd;
}

int Cerrar (int fd)
{
	errno = 0;

	if (close(fd) == -1) {
		fprintf(stderr, "close failed: %s\n", strerror(errno));
		exit(-1);
	}
	
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
			fprintf(stderr, "close failed: %s\n", strerror(errno));
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
		fprintf(stderr, "close failed: %s\n", strerror(errno));
		exit(-1);
	}
	
	return 0;
}

void Copiar(int fromFd, int toFd) {
	char car;
	
	while ((car = Leer(fromFd)) != '\0') {
		Escribir(toFd, car);
	}
}


int main()
{
	int fd, ori, dest;
	char car;
	char* cOri = "in.txt";
	char* cDest = "out.txt";
	printf("\n");

// Leer
	fd = Abrir (in, O_RDONLY);
	
	printf("Lectura de texto \"%s\":\n", cOri);
	
	while ((car = Leer(fd)) != '\0') {
		printf("%c", car);
	}

	printf("\n");

// Copiar
	ori = Abrir (in, O_RDONLY);
	dest = Abrir (out, O_WRONLY | O_TRUNC);
	
	Copiar (ori, dest);

	fd = Abrir (out, O_RDONLY);
	
	printf("Lectura de texto \"%s\" después de Copiar():\n", cDest);
	
	while ((car = Leer(fd)) != '\0') {
		printf("%c", car);
	}

	printf("\n");

}
