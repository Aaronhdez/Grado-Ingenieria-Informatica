#Iniciamos el espacio de trabajo en Nuestro directorio de proyecto
setwd(".")
library(knitr)
library(carData)
help(Davis)
summary(Davis)

##Apartado A
#Soluciones NA's.
#1. Eliminarlos  #2. Omititirlos --> opci贸n 2
datos<-na.omit(Davis)
names(datos)<-c("sexo", "peso", "altura", "peso_m", "altura_m")
attach(datos)
summary(datos)

#Apartado B
#Media con aggregate, en funci贸n del sexo, de los pesos y alturas medidas del DF datos
aggregate(cbind(peso_m,altura_m)~sexo,datos,mean)
#Mediana con aggregate, en funci贸n del sexo, de los pesos y alturas medidas del DF datos
aggregate(cbind(peso_m,altura_m)~sexo,datos,median)
#Desviaci贸n media con aggregate, en funci贸n del sexo, de los pesos y alturas medidas del DF datos
aggregate(cbind(peso_m,altura_m)~sexo,datos,sd)

#Aparatado C
#Media con aggregate, en funci贸n del sexo, de los pesos y alturas declarados del DF datos
aggregate(cbind(peso,altura)~sexo,datos,mean)
#Mediana con aggregate, en funci贸n del sexo, de los pesos y alturas declarados del DF datos
aggregate(cbind(peso,altura)~sexo,datos,median)
#Desviaci贸n media con aggregate, en funci贸n del sexo, de los pesos y alturas declarados del DF datos
aggregate(cbind(peso,altura)~sexo,datos,sd)


#-------------------------------------
#Apartado D (sin ajustar los outliers)
#-------------------------------------

#Apartado D (Pesos mujeres)
#Boxplot de los pesos de las mujeres -- OPCION B
boxplot(subset(datos, select = c(peso,peso_m))[sexo=="F",], main="Pesos Mujeres")
abline(h=median(peso_m[sexo=="F"]), col="red", lty=2, lwd=2)

#Aparatdo D (Pesos hombres)
#Boxplot de los pesos de los hombres -- OPCION B
boxplot(subset(datos, select = c(peso,peso_m))[sexo=="M",], main="Pesos Hombres")
abline(h=median(peso_m[sexo=="M"]), col="red", lty=2, lwd=2)

#Apartado D (Alturas mujeres)
#Boxplot de los pesos de las mujeres -- OPCION B
boxplot(subset(datos, select = c(altura,altura_m))[sexo=="F",], main="Alturas Mujeres")
abline(h=median(altura_m[sexo=="F"]), col="red", lty=2, lwd=2)

#Apartado D (Alturas hombres)
#Boxplot de los pesos de los hombres -- OPCION B
boxplot(subset(datos, select = c(altura,altura_m))[sexo=="M",], main="Alturas Mujeres")
abline(h=median(altura_m[sexo=="M"]), col="red", lty=2, lwd=2)

#-------------------------------------
#Apartado E (ajustando los outliers)
#-------------------------------------

#Plot con las muestras en funci髇 del peso declarado con el medido
x <- peso_m[sexo=="F"]
limitesup<-quantile(x,.85)
limiteinf<-quantile(x,.15)
p_corregido<-x
p_corregido[p_corregido<limiteinf] <-limiteinf
p_corregido[p_corregido>limitesup] <-limitesup

x2 <- peso[sexo=="F"]
limitesup_p2<-quantile(x2,.85)
limiteinf_p2<-quantile(x2,.15)
p2_corregido<-x2
p2_corregido[p2_corregido<limiteinf_p2] <-limiteinf_p2
p2_corregido[p2_corregido>limitesup_p2] <-limitesup_p2

boxplot(p_corregido,p2_corregido, col="grey")
abline(h=median(p2_corregido), col="red", lty=2, lwd=2)

#Plot con las muestras en funcion de la altura declarada con la medida
x3 <- altura_m[sexo=="F"]
limitesup_a<-quantile(x3,.85)
limiteinf_a<-quantile(x3,.15)
a_corregido<-x3
a_corregido[a_corregido<limiteinf_a] <-limiteinf_a
a_corregido[a_corregido>limitesup_a] <-limitesup_a

x4 <- altura[sexo=="F"]
limitesup_a2<-quantile(x4,.85)
limiteinf_a2<-quantile(x4,.15)
a2_corregido<-x4
a2_corregido[a2_corregido<limiteinf_a2] <-limiteinf_a2
a2_corregido[a2_corregido>limitesup_a2] <-limitesup_a2

boxplot(a_corregido,a2_corregido, col="grey")
abline(h=median(a2_corregido), col="red", lty=2, lwd=2)
abline(h=median(a_corregido), col="blue", lty=2, lwd=2)
grid()
