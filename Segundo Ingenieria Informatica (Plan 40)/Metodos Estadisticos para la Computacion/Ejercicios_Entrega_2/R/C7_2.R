setwd(".")
library(knitr)
diametros <- c(1.01,0.97,1.03,1.04,0.99,0.98,0.99,
           1.01,1.03)
#Apartado A, intervalo de confianza del 99% para la media
mu <- mean(diametros)
sigma <- sd(diametros)
n <- length(diametros)
liminf <- mu - qt(0.99,df=(n-1))*sigma/sqrt(n)
limisup <- mu + qt(0.99,df = (n-1))*sigma/sqrt(n)

liminf
limsup

#Comprobacion usando t.test
t.test(diametros,conf.level = 0.99)

#El valor de los limites calculado manualmente es muy aproximado al del test, luego se podría afirmar que efectivamente, los limites calculados son correctos

#Apartado B, se podria hacer alguna inferencia sobre varianza poblacional

s2<- var(diametros)
liminf_var <-(n-1)*s2/qchisq(1-(0.99/2),n-1)
limsup_var <-(n-1)*s2/qchisq((0.99/2),n-1)

pinfvar<-liminf_var*100
psupvar<-limsup_var*100
