#include <stdio.h>
#include <stdlib.h>
#include "mistring.h"

int mi_strlen (char* str){
	int i = 0;
	while(str[i] != '\0'){
		i++;
	}
	return i;
		
}

char* mi_strcpy (char* s1, char* s2){
	int i = 0;
	while(s2[i] != '\0'){
		s1[i] = s2[i];
		i++;
	}
	s1[i+1] = '\0';
	return s1;
}

char* mi_strcat (char* s1, char* s2){
	int lon = mi_strlen(s1);
	mi_strcpy(s1+lon, s2);
	return s1;
}

char* mi_strdup (char* str){
	int len = mi_strlen(str);
	char* ptr = malloc(len * sizeof(char));
	mi_strcpy(ptr, str);
	return ptr;
}

int mi_strequals (char* s1, char* s2){
	if(mi_strlen(s1) != mi_strlen(s2)){
		return 0;
	}
	int cont = 0;
	while(s1[cont] != '\0'){
		if(s1[cont] != s2[cont]){
			return 0;
		}
	cont++;
	}
	return 1;
}
