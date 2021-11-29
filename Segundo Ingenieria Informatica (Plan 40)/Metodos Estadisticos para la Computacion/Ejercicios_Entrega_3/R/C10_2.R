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

#####################
## Apartado a)
#####################

## Generamos la tabla de elementos 
datos<-read.csv("Archivos/azucar.csv", sep =";", dec=",")
names(datos)<-c("Temperatura", "Conversion")
kable(datos)

## Generamos el modelo de regresión lineal a mano
# Primero el plot
attach(datos)
x<-Temperatura
y<-Conversion
n<-length(x)
plot(y~x, data = datos, ylim=c(0,length(y)), col="blue", pch=19)
grid()

# Segundo el modelo lineal (el abline)
linealbasico<-lm(y~x)
abline(linealbasico, col="red", lwd=2)

#####################
## Apartado b)
#####################

## Calculamos la SCE y realizamos la prueba de ajuste. Obtenemos también los residuales
residuales<-residuals(linealbasico)
qres<-quantile(residuales)
SCE<-sum(residuales^2)
s2<-SCE/(n-2)
var<-sqrt(SCE/(n-2))
STCC<-sum((y-mean(y))^2)
SCR<-STCC-SCE

## Calculamos el STCC y luego determinamos el ajuste mediante el CdD.
CdD <- 1-(SCE/STCC)
CdD

#####################
## Apartado c)
#####################

## Verificamos confint los intervalos.
confint(linealbasico)
sup<-qt(0.975, n-2)
sup
inf<-1-qt(0.975, n-2)
inf
## La prueba de confint verifica un untervalo de intercepción de entre 4,32 y 8,50 en el eje de las, valor bastante amplio

#####################
## Apartado d)
#####################

## Verificamos con summary la prueba de ajuste general calculada manualmente.
summary(linealbasico)

## Los cuartiles coinciden al 100% con los residuales
## El error coincide con la varianza calculada bajo 9 grados de libertad.
## El MRS determina un cerca del 50% respecto a la unidad, equivalente al coeficiente de determinación calculado manualmente.
## Tiene sentido hasta ciueto punto, puesto que la pendiente es pequeña luego la dependencia es objeto de contraste
## El error de ajuste es del 1.47%, luego es posible realizar una prueba muy fiable del modelo.

## Realizamos la predicción 

x0<-1.75
prediccion<-predict(linealbasico, newdata=data.frame(x=x0))
prediccion

plot(y~x, data = datos, ylim=c(0,length(y)), col="blue", pch=19)
abline(linealbasico, col="red", lwd=2)
grid()
points(x0,prediccion, pch=16,col="black")

inter_prediccion<-predict(linealbasico,level=0.95, newdata = data.frame(x=x0), interval = "pred")
inter_prediccion
lwr<-inter_prediccion[2]
upr<-inter_prediccion[3]
lines(c(x0,x0), c(lwr,upr),col="green")
points(x0,lwr, pch=16,col="darkgreen")
points(x0,upr, pch=16,col="darkgreen")

## Mediante el uso de la función predict se ven claramente los dos puntos extremos del intervalo de confianza.
## Debido a la ambigüedad de ajuste, se observa un rango de confianza amplio, de cerca de 3.5 puntos en la escala

#####################
## Apartado e)
#####################

## Defición teórica

## Realización del apartado (sacado de apuntes)

plot(y~x, data = datos, ylim=c(0,length(y)), col="blue", pch=19)
abline(linealbasico, col="red", lwd=2)
grid()
lines(c(x0,x0), c(lwr,upr),col="green")
points(x0,lwr, pch=16,col="darkgreen")
points(x0,upr, pch=16,col="darkgreen")

confi_prediccion2<-predict(linealbasico,level=0.95, newdata = data.frame(x=x0), interval = "confidence")
confi_prediccion2
lwr2<-confi_prediccion2[2]
upr2<-confi_prediccion2[3]
lines(c(x0,x0), c(lwr2,upr2),col="orange")
points(x0,lwr2, pch=16,col="brown")
points(x0,upr2, pch=16,col="brown")
points(x0,prediccion, pch=16,col="black")

#####################
## Apartado f)
#####################

## Hacer GGplot

datos<- data.frame(x,y)
g<-ggplot(data=datos, aes(x=x , y=y))
g+geom_point(colour= "red")+ geom_smooth(method= "lm")+ geom_linerange(aes(x=1.75, ymin=lwr2, ymax=upr2))
