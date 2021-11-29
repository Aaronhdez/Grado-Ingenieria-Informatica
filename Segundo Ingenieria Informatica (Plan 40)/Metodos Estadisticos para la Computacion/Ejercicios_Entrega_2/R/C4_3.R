setwd(".")
library(knitr)

n <- 10
p <- 0.45
#Apartado A

p4 <- dbinom(4,n,p)
#Apartado B

p6<- 1-pbinom(5,n,p)

#Apartado C = Es una expicacion que debe hacer cada uno mirando las diapos de binomial


#Apartado D
set.seed(15000)
muestra <- rbinom(20,n,p)
hist(muestra,breaks=seq(0,max(muestra)+1),col = "green",density = 25,freq = FALSE,
     main = "Histograma de la Muestra",xlab = "Muestra",ylab = "Frecuencia Relativa")
x <- seq(0,10,1)
fx <- dbinom(x,n,p)
points(x,fx,type = "b",col = "blue",lwd = 2)
