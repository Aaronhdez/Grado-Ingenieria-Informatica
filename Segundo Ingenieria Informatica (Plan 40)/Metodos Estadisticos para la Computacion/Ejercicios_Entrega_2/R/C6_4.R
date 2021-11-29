setwd(".") 
library(knitr)
#Apartado A
PA <- 1-pchisq(24*9.1/6,24)
PA
#Apartado B
PBmenos<-pchisq(24*10.745/6,24)
PBmas<-pchisq(24*3.462/6,24)
PB <- PBmenos-PBmas
PB

#Visualizacion
x <- seq(0,1,0.01)
plot(x, pchisq(x*(25/6),24), col="blue", type="l",
     xlab="Probabilidad", ylab="", lwd=2)
abline(v=pchisq(24*9.1/6,24), col="green", lwd=2)
abline(v=pchisq(24*10.745/6,24), col="darkred", lwd=2)
abline(v=pchisq(24*3.462/6,24), col="red", lwd=2)
grid()

