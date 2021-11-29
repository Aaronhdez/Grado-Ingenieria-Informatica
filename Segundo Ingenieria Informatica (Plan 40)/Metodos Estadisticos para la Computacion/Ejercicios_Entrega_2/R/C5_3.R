setwd(".")
library(knitr)
n<-185
p<-0.019 #Probabilidad de que un pasajero no se presente al vuelo 
q<-0.981 #Probabilidad de que un pasajero si se presente al vuelo 
mu<-(n*p)
sigma<-sqrt(n*p*q)
z <- (186-mu)/sigma

x<-seq(0,16,1)
plot(x, pnorm(x-mu/sigma),type="l", col="red", lwd=2,
     xlab="'185 + x' Pasajeros")
abline(v=11, col="darkgreen", lwd=2, xlab="196")
grid()
pnorm(z)