setwd(".")
library(knitr)
n1 <- 16
x1 <- 1515.60
s1 <- sqrt(61.500)
n2 <- 10
x2 <- 1298.35
s2 <- sqrt(90.201)
#Apartado A, Intervalo confianza del 95%

a<- ((s1^2/n1)+(s2^2/n2))^2
b<- (s1^2/n1)^2/(n1-1)
c<- (s2^2/n2)^2/(n2-1)
v<-a/(b+c)

izquierda005<-qt(0.025,v)
derecha005<-qt(0.975,v)

t<-(x1-x2)/sqrt((s1^2/n1)+(s2^2/n2))

#Apartado B, Intervalo de confianza del 90%

izquierda010<-qt(0.05,v)
derecha010<-qt(0.95,v)

t
izquierda005
derecha005

#Apartado C, no hay discrminación debido a que el valor v no entra en el intervalo

#Apartado D, n1 = 45, n2 = 30
n1 <- 45
n2 <- 30

a2<- (s1^2/n1+s2^2/n2)^2
b2<- (s1^2/n1)^2/(n1-1)
c2<- (s2^2/n2)^2/(n2-1)
v2<-a2/(b2+c2)

izquierda005_2<-qt(0.025,v2)
derecha005_2<-qt(0.975,v2)

t2<-(x1-x2)/sqrt((s1^2/n1)+(s2^2/n2))

t2
izquierda005_2
derecha005_2
