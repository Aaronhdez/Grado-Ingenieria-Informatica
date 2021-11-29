setwd(".")
library(knitr)

# a)
datos<-c(1500.21, 880.66, 605.22, 1210.12, 2010.1, 701.30, 2060.01, 810.10,
         1012.34, 1500.08, 2500.00, 917.45, 890.50, 515.01, 820.39, 1800.30,
         625.12, 1002.20, 2015.22, 720.25, 1102.45, 3200.00, 1601.79, 1219.70,
         1005.40, 2150.1, 623.56)
kable(datos)
# Media
mu<-mean(datos)
mu
# Desviación
sigma<-sd(datos)
sigma
# Tamaño datos
n<-length(datos)
n
# Intervalo de confianza inferior y superior
confInf<-mu-qt(0.95, df=(n-1))*sigma/sqrt(n)
confInf
confSup<-mu+qt(0.95, df=(n-1))*sigma/sqrt(n)
confSup

# b) Explicacion.Es una prueba Xi cuadrado. SI el resultado es < 1 se considera correcto res < 1 estaba perfe la cosa, 
# Ante caso contrario entonces la hipotesis se rechaza.
# (n-1)*s^2 / sigma^2 -> Prueba Xi cuadrado
a<-qchisq(0.95,26)
b<-a*a
c<-b*26
d<-1000*1000
res<-c/d
res*100
# Al ser mayor de 3 se rechaza la hipótesis.