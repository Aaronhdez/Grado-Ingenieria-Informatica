setwd(".")#700 1100 10 900
library(knitr)
limsup<-900+150
liminf<-900-150
prob<-0.99
mu<-900
sd<-100
sigma<-10000
#Apartado A
2*pnorm(750,900,100) # Se multilica por 2
#Apartado B
sigma_new <- (1050-900)/qnorm(0.995)
z <- (1050-900)/sigma_new

#Apartado C: El tamaño de la muestra es 1 mismamente, debido a la sigma

#Apartado D Visualizacion
x<-seq(700,1100,10)
plot(x, dnorm(x,900,sigma_new), type = "l", col="red",ylim = c(0,0.01), lwd=2,
     xlab="Rojo: sigma=58,23 || Verde: sigma=100", ylab="")
points(x, dnorm(x,900,100), type = "l", col="green", lwd=2)
abline(v=750, col="black", lwd=2)
abline(v=1050, col="black", lwd=2)
grid()


