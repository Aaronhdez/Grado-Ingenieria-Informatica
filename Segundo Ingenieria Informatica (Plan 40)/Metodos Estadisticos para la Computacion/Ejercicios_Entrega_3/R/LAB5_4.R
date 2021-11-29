setwd(".")
library(knitr)
library(ggplot2)
library(sqldf)
library(MASS)

poda<-read.table("Archivos/plantas_poda.txt", dec = ".", sep=",")
attach(poda)
aov(Biomasa~Tipo_Poda)

#APARTADO A
x25<-mean(Biomasa[Tipo_Poda=="n25"])
x50<-mean(Biomasa[Tipo_Poda=="n50"])
x10<-mean(Biomasa[Tipo_Poda=="r10"])
x5<-mean(Biomasa[Tipo_Poda=="r5"])
xcont<-mean(Biomasa[Tipo_Poda=="control"])

# Ejecutamos un boxplot para ver las medias
boxplot(Biomasa~Tipo_Poda, col="yellow")
grid()

# Ejecutamos el aov
anova<-aov(Biomasa~Tipo_Poda, data=poda)
summary(anova)

#Ejecutamos el limite de f para verificar que la F del test anova
k<-5
n<-length(Biomasa)
pf<-qf(0.95,k-1,n-k)

#Y por ultimo el inverso para verficar que coincide con el valor de 
#probabilidad del test ANOVA.

Pr<-1-pf(4.302,k-1,n-k)

#APARTADO B

#Estudiar
#No se pueden considera que son equivalents porque al 0,05 de diferencia 
#da un resultado mucho menor, luego la probabilidad de que ocurra el ehcho
#de que todas de la o mismo es muy baja, por no decir nula.

#A cotianución nos fijamos en las medias correspondientes y observamos que la 
#media en r10 y r5 es muy similar, luego verificamos mediante un test cual de mabas
#es cualitativamente mejor

#Hipotesis 0: r5 y r6 tienen medias imilates
#Hipotesis 1: no la tienen
#confianza al 0.05

t.test(x10, x5)

#Como el t.test da casi igual en probabilidad, ambas son practicamente iguales

#-----------------------------------------#

t.test(x5, x25, alternative = "less")

#EXTRA DE CLASE: HECHO DE FORMA DIRECTA
x25<-(Biomasa[Tipo_Poda=="n25"])
x50<-(Biomasa[Tipo_Poda=="n50"])
x10<-(Biomasa[Tipo_Poda=="r10"])
x5<-(Biomasa[Tipo_Poda=="r5"])
xcont<-(Biomasa[Tipo_Poda=="control"])

yij<-c(x25,x50,x10,x5,xcont)

Y_m_T<-mean(yij)

SCT<-sum((yij-Y_m_T)^2)

pobs<-6
STC<-pobs*(sum((mean(x25)-Y_m_T)^2) + 
        sum((mean(x50)-Y_m_T)^2) +
        sum((mean(x10)-Y_m_T)^2) +
        sum((mean(x5)-Y_m_T)^2) +
        sum((mean(xcont)-Y_m_T)^2)
       )
SCE<-SCT-STC
S12<-STC/(k-1)
S2<-SCE/(length(Biomasa)-k)
fman<-S12/S2
