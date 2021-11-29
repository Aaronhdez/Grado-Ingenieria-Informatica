#Iniciamos el espacio de trabajo en Nuestro directorio de proyecto
#setwd()
setwd(".")
library(sqldf)
library(knitr)
#Cargamos el dataset Correspondiente de casa.txt en una variable
Datcasas<-read.table("Archivos/casas.txt", header=T, dec=',', sep="\t")
#Anclamos la variable Datcasas para   tener su datos disponibles.
attach(Datcasas)
#Revisamos con kable que hemos tomado la tabla correcta.
kable(Datcasas)
#Creamos nuestro vector precio
Datca_precios<-c(Precio)
#Generamos uns tabla de frecuencias de precios
ftable(Datca_precios)
#Generamos una variable de A con la funci?n RANK y hacemos kable sobre ella
pre_rango<-rank(Datca_precios)
kable(pre_rango)
#Genarmos una variable de B con la funci?n SORT y hacemos kable sobre ella
pre_sort<-sort(Datca_precios)
kable(pre_sort)
#Genarmos una variable de C con la funci?n ORDER y hacemos kable sobre ella
c<-order(Datca_precios)
Loc_orden<-Localizacion[order(Precio)]
kable(Loc_orden)
#Generamos un dataframe final con lo anterior.
pre_orden<-data.frame(Loc_orden,pre_sort,pre_rango)
#cambiamos los nombres de las columnas
names(pre_orden)<-c("Localizacion","Precios","Ranking")
kable(pre_orden)
#Ahora,usando sqldf,generamos tres tablas nueva que provenga de una consulta SQL para aquellas 
#cuyo precio sea mayor que 190, clasificadas por precio de mayor a menor y por orden y rango.
library(sqldf)
Compara_mas190<-sqldf("SELECT * FROM pre_orden WHERE Precios > 190 ORDER BY Precios DESC")
kable(Compara_mas190)
Compara_Pre_maymen<-sqldf("SELECT * FROM pre_orden ORDER BY Precios DESC")
kable(Compara_Pre_maymen)
Compara_Pre_rank<-sqldf("SELECT * FROM pre_orden ORDER BY Ranking ASC")
kable(Compara_Pre_rank)
#Por ultimo crearemos una columna que a?adiremos al nuevo dataframe donde se indique la desviacion
#porcentual respecto al precio medio
detach()

#Añadido al ejercicio para comprobación de SQL

attach(pre_orden)
#Calcuylamos la media y la desviaci?n
mediapre<-mean(Precios)
mediapre
desv_pre<-mediapre-Precios
porcen<-(mediapre-Precios)/Precios
desv<-porcen*100
#A?adimos la columna a un nuevo dataframe
Compara_desv<-data.frame(Localizacion,Precios,Ranking)
Compara_desv<-cbind(Compara_desv,desv,desv_pre)
names(Compara_desv)<-c("Localizaci?n","Precios","Ranking","Desv","Montante")
kable(Compara_desv)
# Buscamos las viviendas cuya desviaci?n de precio est? e un rango del 15% respecto a la media
# Generamos una tabla.
x<-sqldf("SELECT * FROM Compara_desv where Desv < 15 AND Desv > -15 ORDER BY DESV")
kable(x)

