setwd(".")
library(knitr)
library(ggplot2)
library(sqldf)
library(MASS)

datos<-read.table("Archivos/Alturas_Estudiantes_EII.txt", dec = ".", sep=",")

#Apartado A
attach(datos)
n<-length(Alturas)

parametro<-fitdistr(Alturas,"normal")
mu<-parametro$estimate[1]
sigma<-parametro$estimate[2]

#Apartado B
hist(Alturas, freq = F, col="lightblue", ylim=c(0,0.025))
abline(v=mu, col="red", lty=2, lwd=2)
x<-seq(min(Alturas),max(Alturas),5)
points(x,dnorm(x,mu,sigma), type="l", col="blue", lwd=2)

#Apartado C
sdmu<-parametro$sd[1]
sdmu
sdsigma<-parametro$sd[2]
sdsigma

#Poca desviación en ambos casos, 
#la distribución sigue una forma gaussiana