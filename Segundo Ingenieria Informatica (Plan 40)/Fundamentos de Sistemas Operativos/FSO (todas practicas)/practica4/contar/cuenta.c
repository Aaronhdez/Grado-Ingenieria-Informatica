#include <stdio.h>
#include <stdlib.h>

int main (int argc, char *argv[]) {
  int p = 0;
  int max = atoi(argv[1]);

  for (; p < max; p++) {
    printf("%d\n", p);
  }
}
