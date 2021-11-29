setwd(".")
library(knitr)
library(sqldf)

# a)
# A buena hora
pnorm(50,25.5,5.1)
pnorm(50,25.5,5.1)*240
# Tarde
1-pnorm(50,25.5,5.1)
1-pnorm(50,25.5,5.1)*240

# b)
# La probabilidad de que tarde al menos 30 min
pnorm(30,25.5,5.1)*240

# c)
# Si sale a las 8:26, la probabibilidad de que llegue tarde será
1-pnorm(34,25.5,5.1)

# Gráfico de la distribución normal
mean<-25.5
sd<-5.1
x <- seq(-5, 5, length=100)*sd+mean
hx <- dnorm(x, mean, sd)

plot(x, hx, type="l", xlab="Tiempo (min)", col="red",
     main="Tiempo de llegada al trabajo", lwd = 2,
     ylab="Densidad")
grid()

lb<-20.4
ub<-30.6
filtro<-x>=lb&x<=ub
lines(x, hx)
polygon(c(lb,x[filtro],ub), c(0,hx[filtro],0), col="red")

zonaprob<- (pnorm(ub, mean, sd) - pnorm(lb, mean, sd))*100
zonaprob
