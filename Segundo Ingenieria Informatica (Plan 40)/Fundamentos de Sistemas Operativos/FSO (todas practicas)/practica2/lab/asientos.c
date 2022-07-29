# include <stdio.h>
# include <stdlib.h>
// #define N 4
// int seat[N];
int N;
int* seat;
int* ptr;
int freeSeats;

int find(int dni) {
	ptr = seat;	
	int i;
	
	for (i=0; i<N; i++) {
		if (ptr[i] < 0) {
			ptr[i] = dni;
			freeSeats--;
			
			return i;
		}
	}
	return -1;
}

int clear(int pos) {
	ptr = seat;
	if (pos<N && pos>=0){
		if (ptr[pos] != -1){
			int aux = ptr[pos];
			ptr[pos] = -1;
			freeSeats++;

			return aux;
		}
	}
	return -1;
}

int test(int pos) {
	ptr = seat;
	
	if (pos<N && pos>=0){
		if (ptr[pos] != -1){
			return ptr[pos];
		}
		return 0;
	}
	return -1;
}

int numClear() {
	return freeSeats;
}

int numSet() {
	return N-freeSeats;
}

void inicialice(int x) {
	N = x;
	seat = malloc(N*sizeof(int));
	freeSeats = N;
	
	ptr = seat;	
	int i;
	
	for (i=0; i<N; i++){
		ptr[i] = -1;
	}
}
