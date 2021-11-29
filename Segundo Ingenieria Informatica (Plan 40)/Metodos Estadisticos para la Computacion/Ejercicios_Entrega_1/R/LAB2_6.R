setwd(".")
library(knitr)
accidentes<-read.table("Archivos/Accidentes_1969_1984_UK.txt", header=T, dec=',', sep=",")

#a) Analizar la serie temporal de fallecidos en accidentes, encontrar 
# sus zonas de valor maximo y visualziar el efecto de entrada en vigor de la ley
attach(accidentes)
kable(accidentes[1:10,])
n<-length(law)
kable(accidentes[n-10:n,])

#Generamos el plot.
plot(1:length(DriversKilled), DriversKilled, 
     xaxt="n", type="l", 
     col="orange",xlab="Meses(años 1969-19)", 
     ylab="Num. falllecidos")
years<-seq(1969,1985,1)
axis(1,at=seq(1,length(DriversKilled)+12,12),
     lablels <-as.character(years))
grid()

#Establecemos la fecha de apliación de la ley.
Febrero_83<-(1983-1969)*12+2
abline(v=Febrero_83, col="red",lwd=2)

#Creamos las medias de la apliación de la ley.
media_no_ley<-mean(DriversKilled[1:Febrero_83])
media_ley<-mean(DriversKilled[Febrero_83:length(DriversKilled)])

#Line(c(x1x2),c(y1,y2),)
lines(c(0,Febrero_83),c(media_no_ley,media_no_ley), col="blue")
lines(c(Febrero_83,192),c(media_ley,media_ley), col="red")

#Creamos un boxplot de mabas antes y después de la aplicación de la ley.
boxplot(DriversKilled~law,
        xlab="Con(1) y Sin(0) apliación de la ley",
        ylab="Num Fallecidos/mes", col="orange")
grid()

#---------------------------#

#b) Analizar la relaciones existentes entre las conductores fallecidos y las victimas
# según estuvieran en los asientos delanteros o traseros. Explicar y estudiar en detalle 
# el alcance de las suposiciones establecidas en los posibles modelos

#Generamos el plot.
plot(DriversKilled,front, col="blue", 
     ylim=c(0,max(front)), text(80,180,label="Prueba"))
grid()
modelo1<-lm(front~DriversKilled)
abline(modelo1,col="lightblue",lwd=2)
points(DriversKilled,rear, col="red")
modelo2<-lm(rear~DriversKilled)
abline(modelo2,col="pink",lwd=2)

#Generamos el segundo plot con los puntos.(ANTES DE LA LEY)
plot(DriversKilled[law==0],front[law==0], col="blue", 
     ylim=c(0,max(front)), pch=2)
grid()
modelo1<-lm(front[law==0]~DriversKilled[law==0])
abline(modelo1,col="lightblue",lwd=2)
points(DriversKilled,rear, col="red", pch=19)
modelo2<-lm(rear[law==0]~DriversKilled[law==0])
abline(modelo2,col="pink",lwd=2)

#Generamos el segundo plot con los puntos.(DESPUES DE LA LEY)
plot(DriversKilled[law==1],front[law==1], col="blue", 
     ylim=c(0,max(front)), pch=2)
grid()
modelo1<-lm(front[law==1]~DriversKilled[law==1])
abline(modelo1,col="lightblue",lwd=2)
points(DriversKilled,rear, col="red", pch=1)
modelo2<-lm(rear[law==1]~DriversKilled[law==1])
abline(modelo2,col="pink",lwd=2)

#---------------------------#
#Aparado C)

#b) Analizar y evaluar el efecto que tienen las furgonetas ligeras (tipo Van)
# en el conjunto de accidentes mortales antes y después de la aplicación de la ley.
# Justificar las respuestas

#Generamos el plot.
plot(1:length(VanKilled), VanKilled, 
     xaxt="n", type="l", 
     col="purple",xlab="Meses(años 1969-19)", 
     ylab="Num. fallecidos (Furgonetas)")
years<-seq(1969,1985,1)
axis(1,at=seq(1,length(VanKilled)+12,12),
     lablels <-as.character(years))
grid()

#Generamos el boxplot de furgonetas
#Establecemos la fecha de apliación de la ley.
Febrero_83<-(1983-1969)*12+2
abline(v=Febrero_83, col="green2",lwd=2)

#Creamos las medias de la apliación de la ley.
media_no_ley_f<-mean(VanKilled[1:Febrero_83])
media_ley_f<-mean(VanKilled[Febrero_83:length(DriversKilled)])

#Creamos las lineas de las medias.
lines(c(0,Febrero_83),c(media_no_ley_f,media_no_ley_f), col="blue")
lines(c(Febrero_83,192),c(media_ley_f,media_ley_f), col="red")

boxplot(VanKilled~law,
        xlab="Antes(0) y después(1) apliación de la ley",
        ylab="Num Fallecidos en furgonetas/mes", col="purple")
grid()

