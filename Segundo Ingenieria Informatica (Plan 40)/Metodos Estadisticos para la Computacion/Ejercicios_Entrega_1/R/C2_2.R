setwd("/")
library(knitr)
library(e1071)
library(ineq)
salarios <- c(rep(750,5),rep(1200,60),rep(1750,125),rep(2250,25),rep(2750,15))
Empleados<- c(5,60,125,25,15)
N<- length(salarios)
Freq_relativa <- Empleados/N
hist(salarios)
hist(salarios,breaks = c(600,900,1500,2000,2500,3000) ,xlab ="Salarios" , ylab = "Frecuencia absoluta", 
     main = "Histograma Frecuencia Absoluta",col = "blue",freq = T)
hist(salarios,breaks = c(600,900,1500,2000,2500,3000) ,xlab ="Salarios" ,ylab ="Frecuencia relativa" ,
     main = "Histograma Frecuencia Absoluta",col = "green",freq = F)

boxplot(salarios,main = "Diagrama de Caja de los Salarios")
abline(h=median(salarios), col="blue", lty=2, lwd=2)

#Apartado B
mean(salarios)
median(salarios)
Moda<-function(x){
  ux<-unique(x)
  ux[which.max(tabulate(match(x,ux)))]
}
Moda(salarios)
var(salarios)
sd(salarios)

#Apartado C
empleados_salariomas <- salarios[salarios > 1800]

#Apartado D
Tercer_Cuartil <- quantile(salarios,0.75)
kable(Tercer_Cuartil)

#Apartado E
tercer_cuartil<- quantile(salarios,0.75)
percentil_95 <- quantile(salarios,0.95)
Recorrido_interdecil <- quantile(salarios,0.90)-quantile(salarios,0.10)

#Apartado F
# Concetracion = GiNi
Gini(salarios,corr = F)

#Apartado G
skewness(salarios,na.rm = FALSE)
kurtosis(salarios)

