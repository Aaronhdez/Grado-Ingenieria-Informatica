setwd(".")
library(knitr)
n<-30
x<-780
sigma<-40
z<- -1.96
#Apartado A
Liminf<- x+z*sigma/sqrt(n)
Liminf
Limsup<- x-z*sigma/sqrt(n)
Limsup

#Apartado C 
qnorm(0.005)
z99<--2.5758
mu<--1*(sigma/sqrt(n))*z+x
mu
k<-x-mu
k
Muestra<-(z99*sigma)/k
Muestra<-Muestra^2
Muestra #La muestra debe ser de tamaño 51

#Apartado D
liminf99 <-x+z99*sigma/sqrt(n)
liminf99
limsup99 <-x-z99*sigma/sqrt(n)
limsup99


#Apartado E
xm<-seq(650,910,10)
xpol<-seq(Liminf,Limsup,1)
y<-dnorm(xm, x, sigma)
ypol<-dnorm(xpol, x, sigma)
xpol<-c(xpol,Limsup,Liminf)
ypol<-c(ypol,0,0)

plot(xm, y, type="l", col="red", lwd=2, xlab="Densidad")
abline(v=780, col="black", lwd=2)
polygon(xpol, ypol, col="grey", density=35)
grid()

