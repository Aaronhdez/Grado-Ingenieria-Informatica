setwd(".")
library(knitr)
library(ggplot2)
library(sqldf)
library(DMwR2)
default<-read.table("Archivos/Puromicina.txt", dec = ".", sep=",",header=T)

#APARTADO A
#Media, mediana
attach(default)
media_VR<-aggregate(velocidad_reaccion~Puromicina,default,mean)
kable(media_VR)

mediana_VR<-aggregate(velocidad_reaccion~Puromicina,default,median)
kable(mediana_VR)

#APARTADO B
#parámetros de dispersión
varianza_VR<-aggregate(velocidad_reaccion~Puromicina,default,var)
kable(varianza_VR)

sd_VR<-aggregate(velocidad_reaccion~Puromicina,default,sd)
kable(sd_VR)
detach()

#APARTADO C
#Visualizar si la concetraciónde sustrato influye

#Datos sin ajuste.
attach(default)
plot(concentracion[Puromicina=="treated"], 
     velocidad_reaccion[Puromicina=="treated"], 
     col="red", pch=19)
grid()
points(concentracion[Puromicina=="untreated"], 
     velocidad_reaccion[Puromicina=="untreated"], 
     col="#037005", pch=19)
detach()

#Datos ajustados.
medias_datos<-aggregate(velocidad_reaccion~Puromicina+concentracion, default, mean)
kable(medias_datos)
attach(medias_datos)
plot(concentracion[Puromicina=="treated"], 
     velocidad_reaccion[Puromicina=="treated"], 
     col="red", pch=19)
grid()
points(concentracion[Puromicina=="untreated"], 
       velocidad_reaccion[Puromicina=="untreated"], 
       col="orange", pch=17)

#APARTADO D
datos_ord_velocidad<-default[order(default$velocidad_reaccion),]
kable(datos_ord_velocidad)

#APARTADO E
yt<-velocidad_reaccion[Puromicina=="treated"]
xt<-concentracion[Puromicina=="treated"]
modelo1<-lm(yt~xt+I(xt^(1/2)))
xv<-seq(from=0,to=1.1,by=0.01)
yv<-predict(modelo1,list(xt=xv))
lines(xv,yv, col="red", lwd=2)

yt2<-velocidad_reaccion[Puromicina=="untreated"]
xt2<-concentracion[Puromicina=="untreated"]
modelo2<-lm(yt2~xt2+I(xt2^(1/2)))
xv2<-seq(from=0, to=1.1, by=0.01)
yv2<-predict(modelo2, list(xt2=xv2))
lines(xv2,yv2, col="#ff8033", lwd=2)
detach()

# APARTADO F
datos_NA<-read.table("Archivos/Puromicina_NA.txt", dec = ".", sep=",", header=T)
kable(datos_NA)
# Completa los NA con un valor centralizado.
datos_ajustados<-centralImputation(datos_NA)
kable(datos_ajustados)
# Método del vecino mas cercano. Ajusta los NA al k mas cercano a ellos.
datos_ajustados_vecino<-knnImputation(datos_NA)
kable(datos_ajustados_vecino)
# Empleando NA.omit()
datos_ajustados_naomit<-na.omit(datos_NA)
kable(datos_ajustados_naomit)
# Empleado complete.cases()
datos_ajustados_cc<-datos_NA[complete.cases(datos_NA)==TRUE,]
kable(datos_ajustados_cc)

attach(datos_ajustados_naomit)
media_VR_naomit<-aggregate(velocidad_reaccion~Puromicina,datos_ajustados_naomit,mean)
kable(media_VR_naomit)
mediana_VR_naomit<-aggregate(velocidad_reaccion~Puromicina,datos_ajustados_naomit,median)
kable(mediana_VR_naomit)
detach()

attach(datos_ajustados_cc)
media_VR_cc<-aggregate(velocidad_reaccion~Puromicina,datos_ajustados_cc,mean)
kable(media_VR_cc)
mediana_VR_cc<-aggregate(velocidad_reaccion~Puromicina,datos_ajustados_cc,median)
kable(mediana_VR_cc)
detach()

#Creramos una tabl nueva con 0
datos_ceros<-datos_NA
datos_ceros$concentracion[is.na(datos_ceros$concentracion)]<-0
datos_ceros$velocidad_reaccion[is.na(datos_ceros$velocidad_reaccion)]<-0
kable(datos_ceros)

datos_ceros_knn<-knnImputation(datos_ceros)

# Resumenes de las tablas ajustadas
summary(datos_NA)
summary(datos_ajustados)
summary(datos_ajustados_vecino)
summary(datos_ajustados_naomit)
summary(datos_ajustados_cc)
summary(datos_ceros_knn)
