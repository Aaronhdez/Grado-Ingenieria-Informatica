setwd(".")
library(knitr)
library(ggplot2)
library(sqldf)
library(DMwR2)

#Binomial b�sica
n<-150
p<-0.02
mu<-n*p
sigma<-sqrt(n*p*(1-p))
#APARTADO A
#Analizar el tipo de funci�n subyacente.

#APARTADO B
#Calcular la prob de que el numero de aver�as sea 5.
prob5<-dbinom(5,n,p)

#APARTADO C
#Encontrar la prob de que el numero de aver�as sea 3 o mas.
#Opci�n A con dbinom
prob3omas_db<-1-(dbinom(0,n,p)+dbinom(1,n,p)+dbinom(2,n,p))
#Opci�n B con pbinom
prob3omas_pb<-1-(pbinom(2,n,p))

#APARTADO D
#Tercer cuartil.
qr3<-qbinom(0.75,n,p)

#APARTADO E
#Numero minimo para que la probabilidad sea superior al 99%.
averiassup099<-log(0.99)/log(0.02)

#APARTADO F
#Calcular el percentil 95 de la distribuci�n.
per95<-qbinom(0.95,n,p)

#APARTADO G
#Obtener una muestra de tama�o 1000 de la distribuci�n.
set.seed(35200)
muestra<-rbinom(1000,n,p)
media_muestra<-mean(muestra)
sd_muestra<-sd(muestra)
hist(muestra, breaks=seq(-0.5,max(muestra+0.5)), col="lightblue", freq=F)

#APARTADO H
#Representar gr�ficamente el apartado G.
x<-seq(0,max(muestra)+1)
fx<-dbinom(x,n,p)
points(x,fx, type="b", col="red", lwd=2, pch=19)
abline(v=mu, col="darkblue", lwd=3)
