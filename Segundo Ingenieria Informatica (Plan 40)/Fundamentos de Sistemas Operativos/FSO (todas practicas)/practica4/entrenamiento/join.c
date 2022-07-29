#include <stdio.h>
#include <pthread.h>

void* caracter (void* arg) {
	int car = (int)arg;
	int i;

	for(i=0; i<10; i++) {
		printf("%c", car);
	}

	return NULL;
}

void* numero (void* arg) {
	int i;

	for(i=0; i<10; i++) {
		printf("%d", i);
	}

	return NULL;
}

int main()
{
	pthread_t hilos[26];
	int i;

	//	MAYUS
	for (i=0; i<26; i++) {
		pthread_create (&hilos[i], NULL, caracter, (void*)(i+65));
	}

	for (i=0; i<26; i++) {
		void* dummy;
		pthread_join((hilos[i]), dummy);
	}

	printf("\nFIN MAYUSCULAS\n");

	//	MINUS
	for (i=0; i<26; i++) {
		pthread_create (&hilos[i], NULL, caracter, (void*)(i+97));
	}

	for (i=0; i<26; i++) {
		void* dummy;
		pthread_join((hilos[i]), dummy);
	}

	printf("\nFIN MINUSCULAS\n");

	//	NUMS
	for (i=0; i<10; i++) {
		pthread_create (&hilos[i], NULL, numero, NULL);
	}

	for (i=0; i<10; i++) {
		void* dummy;
		pthread_join((hilos[i]), dummy);
	}

	printf("\nFIN NUMEROS\n");
}
