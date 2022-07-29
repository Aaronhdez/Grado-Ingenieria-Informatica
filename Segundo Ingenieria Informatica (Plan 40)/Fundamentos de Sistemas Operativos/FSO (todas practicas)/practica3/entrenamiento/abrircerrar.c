#include <sys/types.h>	//open()
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>	//close()
#include <errno.h>	//error handling
#include <string.h>
#include <stdio.h>
#include <stdlib.h>	//exit()


/* ---readable--- */
char* path = "/home/mario/Documentos/practica3/entrenamiento/in.txt";
char* path1 = "/etc/passwd";
char* path2 = "/bin/ls";

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
//		perror("open");
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


int main()
{
	int fd1, fd2, fd3;

// Open
	fd1 = Abrir (path1, O_RDONLY);
	printf("%d\n", fd1);

	fd2 = Abrir (path, O_WRONLY);
	printf("%d\n", fd2);
	
	fd3 = Abrir (path, O_RDWR);
	printf("%d\n", fd3);

// Close
	Cerrar(fd1);
	
	Cerrar(fd2);
	
	Cerrar(fd3);
	
	printf("Closing saccessful\n");
}
