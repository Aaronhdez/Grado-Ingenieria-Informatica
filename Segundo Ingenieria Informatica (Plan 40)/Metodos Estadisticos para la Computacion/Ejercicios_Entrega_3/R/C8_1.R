setwd(".")
library(knitr)
library(pwr)

#Mu y sigma son desconocidas, distribucion N(mu,sigma^2)
datos <- c(3.58,10.03,4.77,9.71,10.4,14.66,8.45,5.4,9.75,10.1)
alfa <- 0.05
n <- 10

#Apartado A, 
# - H0 = mu >= 10 
# - H1 = mu < 10
xm <- mean(datos)
sigma <- var(datos)
mu <- 10
t <- (xm-mu)/sigma/sqrt(n)
t
qt(0.05,9) # Se rechaza la hipótesis, pues qt es menor que t

#Apartado B 
# - H0 = mu < 10, 
# - H1 = mu >= 10
qt(0.95,9) # Como qt por el otro extremo es mayor que t se acepta la hipotesis nula

#Apartado C, Calculo Errores Tipo I y II y la Potencia de la prueba

# El Error tipo I es alfa = 0.05
t1<-alfa

# La potencia viene dada por 1-beta. Se puede extraer con pwr.t.test
potencia<-pwr.t.test(mu,1,0.05,type="one.sample")
potencia
# beta sale de la potencia t = 1-beta
beta <- 1-t
beta + potencia$power
