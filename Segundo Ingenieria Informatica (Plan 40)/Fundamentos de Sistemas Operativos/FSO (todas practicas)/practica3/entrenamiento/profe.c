int Abrir (char* nombre)
{
	int result;
	result = open(nombre, O_RDONLY);
	return result;
}

int Cerrar (int id)
{
	if (close(fd)==-1) {
		fprintf(stderr,"Error al cerrar el fichero\n");
		exit(-1);
	}
}

char Leer(int fd)
{
	char car;
	int nbytes;
	
	nbytes = read(fd,&car,sizeof(char));
	if(nbytes==-1) {
		fprintf(stderr,"Error en la lectura del fichero\n");
		exit(-1);
	}
	if (nbytes==0) car='\0';
	return car;
}

main()
{
	int arch1;
	char caracter;
	arch1 = Abrir(archivo1);
	if (arch1==-1) {
		fprintf(stderr, "Error de apertura en %s\n", archiv1);
	else
		printf("Apertura correcta con identificador: %d\n", archivo1);
	
	while ((caracter = Leer(arch1)) != '\0') {
		printf("%c", caracter);
	}
	Cerrar(arch1);
	exit(0);
}
