library(sqldf)
library(MASS)
library(vcd)
library(knitr)

#se desea contrastar
dias<-c(0,1,2,3,4,5,6)
solicitudes<-c(41,81,87,54,30,12,3)
var_poisson<-data.frame(dias,solicitudes);
kable(var_poisson)
var_p<-c(rep(dias,solicitudes))

ajuste_pois<-goodfit(var_p, type="poisson", method = "MinChisq")
summary(ajuste_pois)

ajuste_pois$par

#Graficar

hist(var_p, breaks=(-0.5:6.5), col="lightblue", freq=T,
     xlab="Varianza de p",
     ylab ="Densidad de probailidad")
points(0:6, ajuste_pois$fitted, col="red", type="l", lwd=2)
