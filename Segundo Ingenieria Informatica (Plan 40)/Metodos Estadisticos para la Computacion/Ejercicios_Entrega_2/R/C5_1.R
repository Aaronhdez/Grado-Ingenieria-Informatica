setwd(".")
library(knitr)
library(ggplot2)
library(sqldf)

#Apartado a) 
mu <- 176.5
sigma <- 7.1
Z_160 <- (160-mu)/sigma
Z_160

pnorm(Z_160)

x<-seq(-3,3,0.01)
z<-seq(-3,Z_160,0.01)
p<-dnorm(z)
z<-c(z,Z_160,-3)
p<-c(p,min(p),min(p))
plot(x,dnorm(x), type="l",xaxt="n",
     ylab = "Densidad de Probabilidad", xlab="Altura", lwd=3)

axis(1,at=-3:3, labels = c("155.2","162.3","169.4","176.5","183.1","190.7","197.8"))
polygon(z,p,col="red")
grid()

#Apartado b)

mu <- 176.5
sigma <- 7.1
Z_171.5 <- (171.5-mu)/sigma
Z_171.5

mu <- 176.5
sigma <- 7.1
Z_180 <- (180-mu)/sigma
Z_180
pnorm(Z_180)-pnorm(Z_171.5)

x<-seq(-3,3,0.01)
z<-seq(Z_171.5, Z_180,0.01)
p<-dnorm(z)
z<-c(z,Z_180,Z_171.5)
p<-c(p,0,0)
plot(x,dnorm(x), type="l",xaxt="n",
     ylab = "Densidad de Probabilidad", xlab="Altura", lwd=3)
axis(1,at=-3:3, labels = c("155.2","162.3","169.4","176.5","183.1","190.7","197.8"))
polygon(z,p,col="yellow")
grid()

#Apartado c) 
mu <- 176.5
sigma <- 7.1
Z_175 <- (175-mu)/sigma
Z_175
pnorm(Z_175)

x<-seq(-3,3,0.01)
z<-seq(Z_175,Z_175,0.00)
p<-dnorm(z)
z<-c(z,Z_175,Z_175)
p<-c(p,min(p),min(p))
plot(x,dnorm(x), type="l",xaxt="n",
     ylab = "Densidad de Probabilidad", xlab="Altura", lwd=3)

axis(1,at=-3:3, labels = c("155.2","162.3","169.4","176.5","183.1","190.7","197.8"))
polygon(z,p,col="red")
grid()

#Apartado D
mu <- 176.5
sigma <- 7.1
Z_190 <- (190-mu)/sigma
Z_190

1-pnorm(Z_190)

x<-seq(-3,3,0.01)
z<-seq(Z_190,3,0.01)
p<-dnorm(z)
z<-c(z,3,Z_190)
p<-c(p,min(p),min(p))
plot(x,dnorm(x), type="l",xaxt="n",ylab = "Densidad de Probabilidad",
     xlab="Altura", lwd=2)
axis(1,at=-3:3, labels = c("155.2","162.3","169.4","176.5","183.1","190.7","197.8"))
polygon(z,p,col="darkgreen")
grid()

#Apartado e)

