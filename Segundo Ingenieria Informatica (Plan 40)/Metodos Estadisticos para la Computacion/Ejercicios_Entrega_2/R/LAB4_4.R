setwd(".")
library(knitr)
library(ggplot2)
library(mgcv)

empleo<-read.csv("Archivos/Empleos_Informatica_Canarias_2009-18.csv", sep=";")
attach(empleo)

######################################################
#APARTADO A 
######################################################

#------------CAN 62------------#
CAN_62<-empleo[TRIMESTRES=="CNAE_62",2]
index<-seq(length(CAN_62),1,-1)
CAN_62_t<-CAN_62[index]

plot(1:length(CAN_62_t), CAN_62_t, xaxt="n", type="l",
     xlab="Año", ylab="Personas Empladas CNAE:62",
     ylim = c(0,max(CAN_62_t)),col="red", lwd=2)
years<-c("2009","2010","2011","2012","2013","2014","2015",
         "2016","2017","2018")
axis(side=1, at = seq(1,length(CAN_62),4), 
     labels = years)
grid()

#GRAFICAS DE EMPLEO PARA GC Y TF
TFE_62<-TENERIFE[TRIMESTRES=="CNAE_62"]
GCA_62<-GRAN.CANARIA[TRIMESTRES=="CNAE_62"]

#PUNTOS PARA CADA UNA DE LAS ANTERIORES
points(1:length(CAN_62),TFE_62[index], type="l", col="blue",lwd=2)
points(1:length(CAN_62),GCA_62[index], type="l", col="yellow",lwd=2)

#------------CAN 63------------#
CAN_63<-empleo[TRIMESTRES=="CNAE_63",2]
index<-seq(length(CAN_63),1,-1)
CAN_63_t<-CAN_63[index]

plot(1:length(CAN_63_t), CAN_63_t, xaxt="n", type="l",
     xlab="Año", ylab="Personas Empladas CNAE:63",
     ylim = c(0,max(CAN_63_t)),col="red", lwd=2)
years<-c("2009","2010","2011","2012","2013","2014","2015",
         "2016","2017","2018")
axis(side=1, at = seq(1,length(CAN_63),4), 
     labels = years)
grid()

#GRAFICAS DE EMPLEO PARA GC Y TF
TFE_63<-TENERIFE[TRIMESTRES=="CNAE_63"]
GCA_63<-GRAN.CANARIA[TRIMESTRES=="CNAE_63"]

#PUNTOS PARA CADA UNA DE LAS ANTERIORES
points(1:length(CAN_63),TFE_63[index], type="l", col="blue",lwd=2)
points(1:length(CAN_63),GCA_63[index], type="l", col="yellow",lwd=2)

#------------CAN 95------------#
CAN_95<-empleo[TRIMESTRES=="CNAE_95",2]
index<-seq(length(CAN_95),1,-1)
CAN_95_t<-CAN_95[index]

plot(1:length(CAN_95_t), CAN_95_t, xaxt="n", type="l",
     xlab="Año", ylab="Personas Empladas CNAE:95",
     ylim = c(0,max(CAN_95_t)),col="red", lwd=2)
years<-c("2009","2010","2011","2012","2013","2014","2015",
         "2016","2017","2018")
axis(side=1, at = seq(1,length(CAN_95),4), 
     labels = years)
grid()

#GRAFICAS DE EMPLEO PARA GC Y TF
TFE_95<-TENERIFE[TRIMESTRES=="CNAE_95"]
GCA_95<-GRAN.CANARIA[TRIMESTRES=="CNAE_95"]

#PUNTOS PARA CADA UNA DE LAS ANTERIORES
points(1:length(CAN_95),TFE_95[index], type="l", col="blue",lwd=2)
points(1:length(CAN_95),GCA_95[index], type="l", col="yellow",lwd=2)

######################################################
#APARTADO B
######################################################

#Hecho para el CAN62.

#----------------- Grafica inicial -----------------#
y63<-CAN_63_t
x63<-seq(1,40)
y62<-CAN_62_t
x62<-seq(1,40)
y95<-CAN_95_t
x95<-seq(1,40)

plot(x63,y63, xlim=c(1,52), ylim=c(min(y63),2.5*max(y62)),
     xlab="Predicción Empleo", ylab ="Numero de puestos", col="red", type="l", lwd=2)
points(x62,y62, type="l", col="orange", lwd=2)
points(x95,y95, type="l", col="blue", lwd=2)


#-----------------CAN 62-----------------#
x<-x62
y<-y62
modelogam62<-gam(y~s(x))
xv62<-(40:52)
yv62<-predict(modelogam62, list(x=xv62))
points(xv62,yv62, type="l", col="brown", lwd=2)


#-----------------CAN 63-----------------#
x<-x63
y<-y63
modelogam63<-gam(y~s(x))
xv63<-(40:52)
yv63<-predict(modelogam63,list(x=xv63))
points(xv63,yv63, type="l", col="pink", lwd=2)


#-----------------CAN 95-----------------#
x<-x95
y<-y95
modelogam95<-gam(y~s(x))
xv95<-(40:52)
yv95<-predict(modelogam95,list(x=xv95))
points(xv95,yv95, type="l", col="lightblue", lwd=2)

#-----------------FINAL -----------------#

abline(v=40, col="black", lwd=2, lty=2)
grid()

