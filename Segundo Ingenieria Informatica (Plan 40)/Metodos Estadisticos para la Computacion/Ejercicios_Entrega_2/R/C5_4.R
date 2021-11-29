setwd(".")
library(knitr) 
#Apartado A 
#P(X > 1)
n <- 35
p <- 0.05
PA <- 1-pbinom(1,n,p)
x <- seq(1,50,1)
y35 <-1-pbinom(x,n,p)

#Apartado B P(X > 10)
n2 <- 500
p2 <- 0.05
PB <-1-pbinom(9,n2,p2)
y500 <-1-pbinom(x,n2,p2)

#Visualizacion
plot(x,y35, type="l", col="blue",main = "Probabilidades",ylab = "Probabilidades", ylim = c(0, max(y500)))
points(x,y500,type = "l",col="green")
grid()
