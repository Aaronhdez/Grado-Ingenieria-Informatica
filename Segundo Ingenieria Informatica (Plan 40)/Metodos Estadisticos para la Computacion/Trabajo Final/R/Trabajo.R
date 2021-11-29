setwd(".")
library(knitr)
library(ggplot2)
library(sqldf)
library(MASS)
library(DMwR2)
library(pyramid)
library(readxl)

###############################
#Evolución poblacional general
###############################

evol_pob<-read.csv("Archivos/Evolucion_poblacional_LP.csv", sep = ";", dec = ".")
names(evol_pob)<-c("Poblacion","Year")

attach(evol_pob)

g_pob<-ggplot(evol_pob, mapping = aes(x=Year, y=Poblacion), freq=FALSE)
g_pob<-g_pob+geom_rect(aes(ymin=0, ymax=max(Poblacion), xmin=1910, xmax=1927), fill="lightblue", alpha=0.5)
g_pob<-g_pob+geom_rect(aes(ymin=0, ymax=max(Poblacion), xmin=1927, xmax=1931), fill="grey", alpha=0.2)
g_pob<-g_pob+geom_rect(aes(ymin=0, ymax=max(Poblacion), xmin=1931, xmax=1936), fill="lightblue", alpha=0.2)
g_pob<-g_pob+geom_rect(aes(ymin=0, ymax=max(Poblacion), xmin=1936, xmax=1939), fill="darkgreen", alpha=0.2)
g_pob<-g_pob+geom_rect(aes(ymin=0, ymax=max(Poblacion), xmin=1939, xmax=1950), fill="darkgrey", alpha=0.2)
g_pob<-g_pob+geom_rect(aes(ymin=0, ymax=max(Poblacion), xmin=1950, xmax=1960), fill="grey", alpha=0.2)
g_pob<-g_pob+geom_rect(aes(ymin=0, ymax=max(Poblacion), xmin=1960, xmax=1975), fill="lightgrey", alpha=0.2)
g_pob<-g_pob+geom_rect(aes(ymin=0, ymax=max(Poblacion), xmin=1975, xmax=2018), fill="lightblue", alpha=0.2)
g_pob<-g_pob+geom_vline(xintercept = 1927, col="#994d00", lwd=1.25, lty=2)
g_pob<-g_pob+geom_vline(xintercept = 1931, col="#994d00", lwd=1.25, lty=2)
g_pob<-g_pob+geom_vline(xintercept = 1936, col="#994d00", lwd=1.25, lty=2)
g_pob<-g_pob+geom_vline(xintercept = 1939, col="#994d00", lwd=1.25, lty=2)
g_pob<-g_pob+geom_vline(xintercept = 1950, col="#994d00", lwd=1.25, lty=2)
g_pob<-g_pob+geom_vline(xintercept = 1960, col="#994d00", lwd=1.25, lty=2)
g_pob<-g_pob+geom_vline(xintercept = 1975, col="#994d00", lwd=1.25, lty=2)
g_pob<-g_pob+geom_line(col="black", lwd=2)
g_pob<-g_pob+geom_vline(xintercept = 1940, col="darkgrey", lwd=1.25, lty=2)
g_pob<-g_pob+ggtitle("Evolución Población según Censo (ISTAC)")
g_pob

detach(evol_pob)

############################
##Evolución familias (Anticonceptivos)
############################

prom_hogares<-read.csv("Archivos/Promedio_hogar.csv", sep = ";", dec = ",")
kable(prom_hogares)

attach(prom_hogares)

g_hog<-ggplot(prom_hogares, mapping = aes(x=periodo, y=media))
g_hog<-g_hog+geom_vline(xintercept = 1927, col="#994d00", lwd=1.25, lty=2)
g_hog<-g_hog+geom_vline(xintercept = 1931, col="#994d00", lwd=1.25, lty=2)
g_hog<-g_hog+geom_vline(xintercept = 1936, col="#994d00", lwd=1.25, lty=2)
g_hog<-g_hog+geom_vline(xintercept = 1939, col="#994d00", lwd=1.25, lty=2)
g_hog<-g_hog+geom_vline(xintercept = 1950, col="#994d00", lwd=1.25, lty=2)
g_hog<-g_hog+geom_vline(xintercept = 1960, col="#994d00", lwd=1.25, lty=2)
g_hog<-g_hog+geom_vline(xintercept = 1975, col="#994d00", lwd=1.25, lty=2)
g_hog<-g_hog+geom_line(col="black", lwd=1.30)+geom_point(col="black", lwd=2.2)
g_hog<-g_hog+ggtitle("Evolución nucleos familiares (ISTAC)")
g_hog

############################
##Evolución poblacional (Anticonceptivos), Modelos lineales
############################

periodo1<-subset(prom_hogares, periodo<1978, select=c(periodo, media))
periodo2<-subset(prom_hogares, periodo>=1978, select=c(periodo, media))
antic_1<-lm(periodo1$media~periodo1$periodo)
antic_2<-lm(periodo2$media~periodo2$periodo)

linea1<-c(1910:1985,0)
linea3<-c(1985:2011,0)
linea2<-c(1985:2011,0)

for (i in 1910:1985) {
  linea1[i]<-antic_1$coefficients[1]+antic_1$coefficients[2]*i
}

for (i in 1985:2011) {
  linea3[i]<-antic_1$coefficients[1]+antic_1$coefficients[2]*i
  linea2[i]<-antic_2$coefficients[1]+antic_2$coefficients[2]*i
}

plot(prom_hogares)
grid()
points(linea3, type="l", col="red", lwd=2)
points(linea1, type="l",col="darkred", lwd=2)
points(linea2, type="l", col="blue", lwd=2)
abline(v=1978, col="black", lwd=2, lty=3)
abline(v=1985, col="black", lwd=2, lty=2)

############################
##Evolución poblacional (2013-2016), Pirámides
############################

piramide_2013 <- read_excel("Archivos/Piramide_distritos2013FIN.xls", col_types = c("numeric", "numeric","text", "text"))
piramide_2014 <- read_excel("Archivos/Piramide_distritos2014FIN.xls", col_types = c("numeric", "numeric","text", "text"))
piramide_2015 <- read_excel("Archivos/Piramide_distritos2016FIN.xls", col_types = c("numeric", "numeric","text", "text"))
piramide_2016 <- read_excel("Archivos/Piramide_distritos2016FIN.xls", col_types = c("numeric", "numeric","text", "text"))
distritos <- c("Cono Sur","Centro","Isleta-Puerto","Ciudad Alta","San Lorenzo")

for(i in 1:5){
  pyramid(as.data.frame(piramide_2013[piramide_2013$DISTRITO==as.character((i)),1:4]),
          Llab = "Hombres", 
          Rlab="Mujeres",
          Clab = "Edades",
          AxisFM = "d",
          Laxis = seq(0,5000,1000),
          Raxis = seq(0,5000,1000),
          main= paste("Población Distrito (2013) -",distritos[i]))
}

for(i in 1:5){
  pyramid(as.data.frame(piramide_2014[piramide_2014$DISTRITO==as.character((i)),1:4]),
          Llab = "Hombres", 
          Rlab="Mujeres",
          Clab = "Edades",
          AxisFM = "d",
          #Laxis = seq(0,max(piramide_2014$HOMBRES),1000),
          #Raxis = seq(0,max(piramide_2014$MUJERES),1000),
          Laxis = seq(0,5000,1000),
          Raxis = seq(0,5000,1000),
          main= paste("Población Distrito (2014) -",distritos[i]))
}

for(i in 1:5){
  pyramid(as.data.frame(piramide_2015[piramide_2015$DISTRITO==as.character((i)),1:4]),
          Llab = "Hombres", 
          Rlab="Mujeres",
          Clab = "Edades",
          AxisFM = "d",
          Laxis = seq(0,5000,1000),
          Raxis = seq(0,5000,1000),
          main= paste("Población Distrito (2015) -",distritos[i]))
}

for(i in 1:5){
  pyramid(as.data.frame(piramide_2016[piramide_2016$DISTRITO==as.character((i)),1:4]),
          Llab = "Hombres", 
          Rlab="Mujeres",
          Clab = "Edades",
          AxisFM = "d",
          Laxis = seq(0,5000,1000),
          Raxis = seq(0,5000,1000),
          main= paste("Población Distrito (2016) -",distritos[i]))
}

############################
##Piramides poblacionales
############################

Datos <- read_excel("Archivos/Piramides_2018-2000.xls",col_types = c("numeric","numeric","text","text"))
#datos_2018 <- subset(Datos,Año == 2018, c("Edad","Hombres","Mujeres"))
#datos_2000 <- subset(Datos,Año == 2000, c("Edad","Hombres","Mujeres"))
attach(Datos)
#Piramide 2000
pyramid(as.data.frame(Datos[Year=="2000",1:3]),
          Llab = "Hombres", 
          Rlab="Mujeres",
          Clab = "Edades",
          AxisFM = "d",
          Laxis = seq(0,20000,10000),
          Raxis = seq(0,20000,10000),
          main= paste("Pirámide poblacional (2000)"))
#Piramide 2018
pyramid(as.data.frame(Datos[Year=="2018",1:3]),
          Llab = "Hombres", 
          Rlab="Mujeres",
          Clab = "Edades",
          AxisFM = "d",
          Laxis = seq(0,20000,10000),
          Raxis = seq(0,20000,10000),
          main= paste("Pirámide poblacional (2018)"))
  
