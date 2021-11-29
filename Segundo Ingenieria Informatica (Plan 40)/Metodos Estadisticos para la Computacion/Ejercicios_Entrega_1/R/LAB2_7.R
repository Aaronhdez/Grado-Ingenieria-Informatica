#Iniciamos el espacio de trabajo en Nuestro directorio de proyecto
setwd(".")
library(knitr)
#Cargamos el dataset Correspondiente de casa.txt en una variable
Ventas<-read.table("Archivos/Ventas_Provincia.txt", header=T, sep=',', dec='.', stringsAsFactors=F)
kable(Ventas)
attach(Ventas)
names(Ventas)

## APARTADO A
#Creamos el factor determinante de la tabla
provincias<-(Provincia)
fprovincia<-as.factor(provincias)
levels(fprovincia)
#Tabla con las medias anuales
t_medias<-aggregate(Total_Ventas~Provincia,Ventas,mean)
kable(t_medias)
#Tabla con las sumas anuales
t_suma<-aggregate(Total_Ventas~Provincia,Ventas,sum)
kable(t_suma)
detach()

## APARTADO B
#Seleccionamos la provincia que vende mas y la que menos vende
attach(t_suma)
t_suma[which.max(t_suma[,2]),]
#max<-Provincia[which.max(Total_Ventas)]
#max
t_suma[which.min(t_suma[,2]),]
#min<-Provincia[which.min(Total_Ventas)]
#min
detach()

## APARTADO C
#Seleccionamos de la tabla una nuevo dataframe con SQL según lso requerimientos pedidos
library(sqldf)
Ventas2dosem<-sqldf("SELECT * FROM Ventas where Provincia='Barcelona' OR Provincia='Caceres' OR Provincia='Madrid'")
Ventas2dosem<-sqldf("SELECT * FROM Ventas2dosem where Year_Mes > '2012-06-01'")
kable(Ventas2dosem)
detach()

## APARTADO D
attach(Ventas2dosem)
mesdata<-as.Date(Year_Mes)
meses<-unique(mesdata)
#Puntos Barcelona
plot(meses,Total_Ventas[Provincia=="Barcelona"], 
     ylim=c(0,max(Total_Ventas)),type = "b",
     col = "red", xlab = "Segundo Semestre",
     ylab = "Ventas", pch=15)
#Puntos Caceres
points(meses,Total_Ventas[Provincia=="Caceres"],
       ylim=c(0,max(Total_Ventas)),type = "b",
       col = "yellow", pch=19)
#Puntos Madrid
points(meses,Total_Ventas[Provincia=="Madrid"], 
       ylim=c(0,max(Total_Ventas)),type = "b",
       col = "blue", pch=2)
grid()

## Boxpot del Ventas2osem
boxplot(Total_Ventas~Provincia)

## APARTADO E
#Creamos la varible g
library(ggplot2)
g<-ggplot(data=Ventas2dosem, aes(x=Year_Mes, 
                                 y=Total_Ventas, 
                                 group=Provincia, 
                                 colour=Provincia))
g2<-g + geom_point(size=2)
g2<-g2 + geom_line(size=1)
g2<-g2 + xlab("Meses") 
g2<-g2 + ylab("Cantidad")
g2<-g2 + ggtitle("Ventas segundo semestre")
g2

## APARTADO F con grafica
g3<-ggplot(data=Ventas2dosem, aes(x=Year_Mes, 
                                  y=Total_Ventas, 
                                  group=Provincia, 
                                  colour=Provincia))
g3<-g3 + geom_bar(stat="identity", 
                  aes(fill=Provincia), 
                  position="dodge")
g3<-g3 + xlab("Meses") 
g3<-g3 + ylab("Cantidad")
g3<-g3 + ggtitle("Ventas segundo semestre")
g3

## APARTADO F con boxplot
g4<-ggplot(data=Ventas2dosem, aes(x=Year_Mes, 
                                  y=Total_Ventas, 
                                  group=Provincia, 
                                  colour=Provincia))
g4<-g4 + geom_boxplot()
g4<-g4 + xlab("Meses") 
g4<-g4 + ylab("Cantidad")
g4<-g4 + ggtitle("Ventas segundo semestre")
g4

## APARTADO F con violin plot
g5<-ggplot(data=Ventas2dosem, aes(x=Year_Mes, 
                                y=Total_Ventas, 
                                group=Provincia, 
                                colour=Provincia))
g5<-g5 + geom_violin()
g5<-g5 + xlab("Meses") 
g5<-g5 + ylab("Cantidad")
g5<-g5 + ggtitle("Ventas segundo semestre")
g5
