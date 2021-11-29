setwd(".")
library(knitr)
library(ggplot2)
library(sqldf)
library(MASS)

# Operaciones básicas rectas
## Calcular residuales     residuals(modelo)
## Calcular SCE            sum(e^2)
## Calcular el s2          SCE/(n-2)
## Calcular la Varianza    sqrt(SCE/(n-2))
## Calcular el STCC        sum((growth-mean(growth))^2)
## Calcular el Coef. Det   1-(SCE/STCC)         
### A mas cercano a la unidad, mejor es el ajuste

# Inferencias rectas (Dist T)
## Confint -> Informa del intervalo de confianza de la pendiente
## qt(conf, length(tannin-2))
## También es ofecido por el summary (ver: t-value y PR)
## Si PR es demasiado elevado, la estimaes mala.

# Predicción (Dist T)
## predict(modelo, dato-nuevo...)
### Por defecto -> calcula toda la predicción
### Con para una tangente concreta, realiza una predicción específica

# Uso de ANOVA
## 1. Calculamos SCE y STCC
## 2. Calculamos SCR = STCC - SCE
## 3. Calcular el s2 = sum((Y-b0+b1*x))
## 4. Calcular el F = SCR/s2
## 5. Calcular la probailidad

# Calculo de Errores en al recta.
## 1. SCEpuro = Suma
## 2. SC(Sin ajuste) = SCE - SCEpuro
## 3. Calcular k <- nlevels(x_Factor)
## 4. Calcular s2_puro <- SCEpuro/(length(X)-k)

### EJERCICIO

datos<-read.table("Archivos/Aloe_Vera.txt", sep=",", dec=".")
attach(datos)

#Apartado a)
boxplot(Masa~Variedad, Variedad, col="red")
boxplot(Masa_Seca~Variedad, Variedad, col="green")
boxplot(Num_Hojas~Variedad, Variedad, col="yellow")
boxplot(Altura~Variedad, Variedad, col="lightblue")

masa_seca<-aggregate(Masa_Seca~Variedad, Variedad, mean)
masa_seca
masa<-aggregate(Masa~Variedad, Variedad, mean)
masa

#Apartado b
Barbadensis<-subset(datos, subset=(Variedad == "barbadensis"))
detach()
attach(Barbadensis)

x<-Masa
y<-Altura
n<-length(x)
plot(Altura~Masa, data = Barbadensis, ylim=c(0,length(y)))

#Apartado c
modelobar<-lm(y~x)
abline(modelobar, col="red", lwd=2)

#Apartado d
summary(modelobar)
confint(modelobar)

#Calculo manual de los errores
e<-residuals(modelobar)
SCE<-sum(e^2)
SCE
s2<-SCE/(n-2)
s2
var<-sqrt(SCE/(n-2))
var

#Apartado e
x0<-5.1
predicción_masa<-predict(modelobar,newdata = data.frame(x=x0))
predicción_masa

points(x0,predicción_masa, pch=16,col="black")
lines(c(x0,x0), c(x0,predicción_masa),col="red")

inter_prediccion<-predict(modelobar,level=0.95, newdata = 
                            data.frame(x=x0), interval = "pred")
inter_prediccion

lines(c(x0,x0), c(inter_prediccion[2],inter_prediccion[3]),col="darkgreen")
points(c(x0,x0), c(inter_prediccion[2],inter_prediccion[3]),col="darkgreen")

#Apartado f

STCC<-sum((y-mean(y))^2)
STCC
cdd<-1-(SCE/STCC)
cdd

#Muy próximo a la unidad. muy buen ajuste

#Apartado g
x_factor<-as.factor(x)
datos2<-data.frame(x_factor,y)
detach(Barbadensis)

attach(datos2)
Y_M_F<-rep(0,length(x_factor))
for (i in 1:length(x_factor)) {
  Y_M_F[i]<-mean(y[x_factor==x[i]])
}

SCEpuro <- sum((y-Y_M_F)^2)

#Error falta de ajuste
SC <- SCE-SCEpuro
SC

#Calculo del s2puro
k<-nlevels(x_factor)
s2puro<-SCEpuro/(n-k)
s2puro

fSC<-SC/(s2puro*(k-2))
fSC

1-pf(fSC,1,k-2)

#Apartado h (OPCIONAL)



