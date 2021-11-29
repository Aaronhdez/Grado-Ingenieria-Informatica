setwd(".")
library(knitr)
library(ggplot2)
library(sqldf)
library(DMwR2)

#APARTADO A
#Calcular la probabilidad de que sea mayor o igual a 5.5
lambda<-3
p55<-ppois(5.5,lambda)
mu<-lambda
sigma<-sqrt(lambda)

#APARTADO B
px1y6_con1<-ppois(6,lambda)-ppois(0,lambda)
px1y6_sin1<-ppois(6,lambda)-ppois(1,lambda)

#APARTADO C
#Calcular el 5% de los valores mas bajos.
per75<-qpois(0.75,lambda)

#APARTADO D
#Calcular el 5% de los valores mas bajos.
per5<-qpois(0.05,lambda)

#APARTADO E
set.seed(35200)
sample<-rpois(500,3)
media_sample<-mean(sample)
sd_sample<-sd(sample)
hist(sample, breaks=seq(-0.5,max(sample+0.5)), col="lightblue", freq=F, add=F)

#APARTADO F
#Pillamos lambda por defect (3).
x<-seq(0,max(sample)+1)

x2<-seq(0,30)
fx<-dpois(x2,lambda)
fx2<-dpois(x2,2*lambda)
fx3<-dpois(x2,4*lambda)

plot(x2,fx3, col="red",type="b", lwd=2, pch=19, ylim=c(0,max(fx)))
points(x2,fx2, type="b", col="darkgreen", lwd=2, pch=19)
points(x2,fx, type="b", col="blue", lwd=2, pch=19)
grid()


