#include <stdio.h>

int main()

{

int x,*puntero;
int vec [10]={9,3,4,8,1,5,2,0,7,5};

puntero = vec;

for (x=0;x<10;x++) {
   if (*(puntero+x)==5)
     printf("encontre un cinco\n");
     else printf("v[%d] vale: %d\n",x,*(puntero+x));
}

}

