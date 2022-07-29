#include <sys/types.h>
#include <sys/stat.h>
#include <unistd.h>
#include <time.h>
#include <stdio.h>

char* fecha_tostring ( time_t* t )
{
  static char strfecha[20];
  struct tm tm = *localtime(t);

  //return ctime (t);
  //return asctime(tm);

  sprintf(strfecha,"%02d:%02d:%02d %04d-%02d-%02d",
          tm.tm_hour,tm.tm_min,tm.tm_sec,1900+tm.tm_year,1+tm.tm_mon,tm.tm_mday);
  return strdup(strfecha);
}

main (int argc, char* argv[]) {
  struct stat info_stat;
  
  // recupero la información del fichero
  stat(argv[1], &info_stat);
  
  printf("información sobre \"%s\":\n", argv[1]);
  printf(
  	"permisos=%03o\n"
  	"longitud=%ld bytes\n"
  	"última modificación=%s\n"
  	"último acceso=%s\n"
  	"último cambio=%s\n",
  	info_stat.st_mode, info_stat.st_size, 
  	fecha_tostring(&info_stat.st_mtime),
  	fecha_tostring(&info_stat.st_atime),
  	fecha_tostring(&info_stat.st_ctime)
  	 );
}
