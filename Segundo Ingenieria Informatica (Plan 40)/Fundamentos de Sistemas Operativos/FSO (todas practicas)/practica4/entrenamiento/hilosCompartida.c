#include <stdio.h>
#include <pthread.h>
#include <stdbool.h>

typedef struct {
	int n;
	char* texto;
} arg_t;

pthread_mutex_t mutex = PTHREAD_MUTEX_INITIALIZER;
pthread_cond_t cond = PTHREAD_COND_INITIALIZER;
bool flag = false;

void* padre (void* arg) {
	arg_t* args = (arg_t*)arg;

	int max = (int)args->n;
	int i;
	
	for (i=1; i<=max; i++) {
		pthread_mutex_lock(&mutex);
		while(flag) {
			pthread_cond_wait(&cond, &mutex);
		}
		pthread_mutex_unlock(&mutex);
		
		printf("Hilo %s Iteracion %d\n", "Padre", i);

		pthread_mutex_lock(&mutex);
		flag = true;
		pthread_cond_signal(&cond);
		pthread_mutex_unlock(&mutex);
	}
	return NULL;
}

void* hijo (void* arg) {
	arg_t* args = (arg_t*)arg;

	int max = (int)args->n;
	int i;
	
	for (i=1; i<=max; i++) {
		pthread_mutex_lock(&mutex);
		while(!flag) {
			pthread_cond_wait(&cond, &mutex);
		}
		pthread_mutex_unlock(&mutex);
		
		printf("Hilo %s Iteracion %d\n", "Hijo", i);

		pthread_mutex_lock(&mutex);
		flag = false;
		pthread_cond_signal(&cond);
		pthread_mutex_unlock(&mutex);
	}
	return NULL;
}

int main()
{
	pthread_t h_padre, h_hijo;
	
	arg_t params_p = { .n=20, .texto="Padre" };
	arg_t params_h = { .n=20, .texto="Hijo" };
	
	
	pthread_create (&h_padre, NULL, padre, &params_p);
	pthread_create (&h_hijo, NULL, hijo, &params_h);
	
	void* dummy;
	pthread_join(h_padre, dummy);
	pthread_join(h_hijo, dummy);
	
	
}
