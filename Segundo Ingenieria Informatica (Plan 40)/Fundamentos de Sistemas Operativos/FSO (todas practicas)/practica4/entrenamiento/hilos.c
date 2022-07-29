#include <stdio.h>
#include <pthread.h>

typedef struct {
	int n;
	char* texto;
} arg_t;

void* imprimir (void* arg) {
	arg_t* args = (arg_t*)arg;

	int max = (int)args->n;
	int i;
	
	for (i=1; i<=max; i++) {
		printf("Hilo %s Iteracion %d\n", args->texto, i);
	}
	return NULL;
}

int main()
{
	pthread_t h_padre, h_hijo;
	
	arg_t params_p = { .n=20, .texto="Padre" };
	arg_t params_h = { .n=20, .texto="Hijo" };

	pthread_create (&h_padre, NULL, imprimir, &params_p);
	pthread_create (&h_hijo, NULL, imprimir, &params_h);
	
	void* dummy;
	pthread_join(h_padre, dummy);
	pthread_join(h_hijo, dummy);
}
