setwd(".")
library(knitr)
library(ggplot2)
library(sqldf)
library(MASS)

sueldos<-read.table("Archivos/sueldos_hosteleria.txt", dec = ".", sep=",")
attach(sueldos)

##########################
#Apartado A
##########################

n<-length(Sueldos)
media<-mean(Sueldos)
S<-sd(Sueldos)
t<-qt(0.95,n-1)

#Calculamos los limites intervalo de confianza para mu: 
#Formula: x-t+(S/sqrt(n))

mu1<-(media-t*(S/sqrt(n))) #Limite por la izquierda
mu2<-(media+t*(S/sqrt(n))) #Limite por la derecha

##########################
#Apartado B
##########################

#Calculamos los limites intervalo de confianza para sigma
#Formula: sqrt((n-1)*S^2/xilim)

xisup<-qchisq(0.95,n-1)
xiinf<-qchisq(0.05,n-1)

sigma21<-((n-1)*S^2)/xiinf
sigma22<-((n-1)*S^2)/xisup

sdsigma1<-sqrt(sigma21) #Limite por la izquierda
sdsigma2<-sqrt(sigma22) #Limite por la derecha

##########################
#Apartado C
##########################

mu_real<-18510
sd_real<-850
liminf<-15000
limsup<-21000
salarios<-seq(15000,21000,10)
plot(salarios, dnorm(salarios, mu_real, sd_real), type="l", col="darkred", lwd=2)
grid()
points(Sueldos,dnorm(Sueldos,18510,850), type="h", lwd=1, col="darkblue")
points(Sueldos,dnorm(Sueldos,18510,850), type="p", pch=19, lwd=1, col="darkblue")
abline(v=media, col="red", lwd=3)
abline(v=18510, col="blue", lwd=3)

#Podemos calcular t y verificar que la media calculada con 
#la media de la empresa son cuasi equivalentes

t.test( Sueldos, alternative=c("two.sided"), mu=18510,
        paired=FALSE, var.equal=FALSE, conf.level=0.9)

#La probailidad es de 0,22/1, es decir, del 22% de ser la media, 
#Esto implica que es considerable como solución.
