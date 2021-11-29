setwd(".")
library(knitr)
library(ggplot2)
library(sqldf)
library(MASS)
library(tseries)

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

#Apartado a)
y<-c(50,56,62,70,80)
x<-c(0,4,5,6,9)
n<- length(x)
plot(x,y,ylim = c(0,max(y)+2), pch = 18, col ="Blue", xlab ="Muertes",  ylab = "Dosis de sustancia", cex = 1.5)
grid()

#Medias
x_m<-mean(x)
y_m<-mean(y)
x2<-(x*x)
x_var<-sum(x2)/length(x)-(x_m^2)
y2<-(y*y)
y_var<-sum(y2)/length(y)-(y_m^2)
covar<-sum(x*y)/length(y)-(x_m * y_m)
pend<-covar/x_var
ord<-y_m-(pend*x_m)

# Creamos el modelo lineal resultante
modelo<-lm(y~x)
summary(modelo)

# Asignamos los coeficientes y verificamos el intervalo de confianza para los coeficientes
coef<-coefficients(modelo)

confint(modelo)
abline(modelo, col = "red", lwd = 2)

#Apartado b)
SCE<-sum((y-(ord + pend*x))^2)
SCE

summary.aov(modelo)
x_factor <- as.factor(x)
x_factor
datos<-data.frame(x_factor, y)
datos

y_m_f <- rep(0,n) 
for(i in 1:n) {y_m_f[i] <- mean(y[x_factor == x[i]])}
SCEpuro <- sum((y-y_m_f)^2)
SCEpuro
SCE

SC_ajuste <- SCE-(SCEpuro)
SC_ajuste

##Como solo existe una observación par cada x de la muestra, el SCEpuro será cero debido a la nulidad de la resta de diferencias.

qf(0.95, 1, n-2)
e<-residuals(modelo)
plot(e, type= "h", lwd = 3, col = "green")
grid()
abline(h= 0, col = "grey", lwd = 2)

#Test Shappiro para verificar la normalidad
shapiro.test(e)

#Test Kologorov Smirnov
ks.test(e,"pnorm")

##Apartado c) y d)
confint(modelo)
coefficients(modelo)
coef<-coefficients(modelo)
predicion_DLM<- predict(modelo, newdata= data.frame(x=5), interval = "pred")
predicion_DLM


lwr<-predicion_DLM[2]
upr<-predicion_DLM[3]
puntomedio<-5*coef[2]+coef[1]
puntomedio

plot(x, y, ylim = c(0,max(y)), col = "black", pch=19,
     xlab="Muertes",
     ylab="Dosis")
grid()
abline(modelo, col = "brown", lwd = 2)
lines(c(5,5), c(lwr, upr), col="blue")
points(c(5,5), c(lwr, upr), col="blue",pch=19)
points(5, puntomedio, col="darkgreen",pch=19,lwd=3)


