setwd(".")
library(knitr)
library(ggplot2)
library(sqldf)

#APARTADO A
#Obtener el dataframe ordenado por nombre de paises
datos<-read.table("Archivos/Empleo.txt", dec = ".", sep=",")
datos_ord_pais<-datos[order(datos$Pais),]

#APARTADO B
#Calcular la media, mediana y cuantiles de la duraci�n
attach(datos_ord_pais)
media_d<-mean(Duracion)
mediana_d<-median(Duracion)
cuantiles_d<-quantile(Duracion)

#APARTADO C
#Evaluar los par�metros de dispersi�n de la duraci�n.
var_d<-var(Duracion)
sd_d<-sd(Duracion)

detach()
#APARTADO D
#Ordenar los pa�ses por semanas trabajadas.
datos_ord_semana<-datos[order(datos$Duracion),]

#APARTADO E
#Visualizar las diferencias con un diagrama de caja y distinguir 
#los valores singulares. explicar 
attach(datos_ord_semana)
boxplot(Duracion, notch = T,col = "Yellow",
        ylab = "Media de jornada semanal",
        xlab = "Paises en la UE")
grid()
abline(h=Duracion[Pais=="Espa�a"],col="blue",lwd=2, lty=2)
text(1.35,y=Duracion[Pais=="Espa�a"] +0.25,labels="Espa�a")
detach()

#APARTADO F
attach(datos_ord_pais)
par(mar=c(6,6,2,2)+0.1)
plot(1:nlevels(Pais), Duracion[Pais==levels(Pais)],
    xaxt = "n", lwd =3, type="h", col="orange",
    xlab="Pais_EU",
    ylab="Duracion jornada semanal")
grid()
axis(side =1, at = 1:length(Pais), labels=F)
text(1:nlevels(Pais), par("usr")[3]-0.1,
     labels=Pais, srt=30, pos=2, cex=0.6,
     xpd = TRUE)
points(which(Pais=="Espa�a"), Duracion[Pais="Espa�a"], type="h",
       col="green",lwd=3)
points(which(Pais=="Espa�a"), Duracion[Pais="Espa�a"], type="p",
       col="green",lwd=3)
detach()

#APARTADO G (OPCIONAL)
#Revisar las horas trabajadas por semana en GRE, ESP Y GER (USAR $ -> NO ATACHAR DATOS)
horas_trabajo<-read.table("Archivos/H_T_A_UE_2017.txt", dec = ".", sep=",")
#Apartado H horas trabajadas(el fichero)/ semanas_trabajadas (OJO"ESP"-"Espa�a")
attach(horas_trabajo)
media_semanal_ESP<-as.numeric(horas_trabajo[horas_trabajo$Pais=="ESP",])/as.numeric(datos$Duracion[datos$Pais == "Espa�a"])
media_semanal_GRE<-as.numeric(horas_trabajo[horas_trabajo$Pais=="GRC",])/as.numeric(datos$Duracion[datos$Pais == "Grecia"])
media_semanal_GER<-as.numeric(horas_trabajo[horas_trabajo$Pais=="DEU",])/as.numeric(datos$Duracion[datos$Pais == "Alemania"])
data.frame(media_semanal_ESP,media_semanal_GER,media_semanal_GRE)

