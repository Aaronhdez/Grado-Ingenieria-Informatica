## Ejercicio 1: Trabajando los comandos básicos

#1. Creamos una variable "A", en insertamos en ella el resultante del comando search.
A<-search()
A

#2. Probamos el comando list sin elementos, e insertamos sus resultados en una nueva variable B.
B<-list()
B

#3. Borramos la variable B, insertando previamente sus valores en otra nueva denominada C.
C<-B
C
rm(B)

#4. Revisamos los objetos creados con objects()
objects()

#5. Cargamos una librería nueva y empleamos search() para verificar que se ha creado.
library(Matrix)
search()

#6. Cargamos un dataset en una variable. Usaremos la tabla de datos BEPS, del dataset carData como ejemplo:
BEPS<-read.csv(url("https://vincentarelbundock.github.io/Rdatasets/csv/carData/BEPS.csv"))

#7. Mostramos el cabecero de la tabla con head().
head(BEPS)

#8. Insertamos el cabecero en una nueva variable BEPS_head
BEPS_head<-head(BEPS)
objects()


#9. Con el comando subset(), seleccionamos aquellos cuyo genero sea masculino de la tabla e insertamos el cabecero de la tabla resultante en la variable "BEPS_male_head"
BEPS_male_head<-subset(BEPS, gender=="male")
View(BEPS_male_head)