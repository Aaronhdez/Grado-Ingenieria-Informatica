setwd(".")
library(knitr)
library(readxl)
Afiliaciones <- read_excel("Archivos/AfiliacionesSS.xls")
attach(Afiliaciones)
Asalariados <- subset(Afiliaciones, Tipo_Empleo== "Asalariados", select = c("Tipo_Empleo", "Cantidad", "Año", "Sexo"))
Autonomos <- subset(Afiliaciones, Tipo_Empleo== "Autonomos", select = c("Tipo_Empleo", "Cantidad", "Año", "Sexo"))

Asalariados_Hombres <- subset(Asalariados, Sexo== "Hombre", select = c("Cantidad", "Año"))
Asalariados_Mujeres <- subset(Asalariados, Sexo== "Mujer", select = c("Cantidad", "Año"))

Autonomos_Hombres <- subset(Autonomos, Sexo== "Hombre", select = c("Cantidad", "Año"))
Autonomos_Mujeres <- subset(Autonomos, Sexo== "Mujer", select = c("Cantidad", "Año"))

#Asalariados
plot(Asalariados_Mujeres$Cantidad~Asalariados_Mujeres$Año,col = "green",type = "l",xlab = "Años",ylab = "Cantidad",
     lwd = 2,main = "Asalariados - Las Palmas de Gran Canaria")
points(Asalariados_Mujeres$Cantidad~Asalariados_Mujeres$Año,col = "green", pch=19)
points(Asalariados_Hombres$Cantidad~Asalariados_Hombres$Año,col = "lightblue",type = "l",lwd = 2)
points(Asalariados_Hombres$Cantidad~Asalariados_Hombres$Año,col =  "lightblue", pch=19)
grid()
#Autonomos
plot(Autonomos_Hombres$Cantidad~Autonomos_Hombres$Año,col = "darkblue",type = "l",xlab = "Años",ylab = "Cantidad",
     lwd = 2,main = "Autónomos - Las Palmas de Gran Canaria",ylim = c(0,max(Autonomos_Hombres$Cantidad)))
points(Autonomos_Hombres$Cantidad~Autonomos_Hombres$Año,col = "darkblue", pch=19)
points(Autonomos_Mujeres$Cantidad~Autonomos_Mujeres$Año,col = "darkgreen",type = "l",lwd = 2)
points(Autonomos_Mujeres$Cantidad~Autonomos_Mujeres$Año,col = "darkgreen", pch=19)
grid()

# Asalariados y Autonomos conjunto
plot(Asalariados_Mujeres$Cantidad~Asalariados_Mujeres$Año,col = "green",type = "l",xlab = "Años",ylab = "Cantidad",
     lwd = 2,main = "Asalariados y Autonomos  - Las Palmas de Gran Canaria",ylim = c(0,max(Asalariados_Mujeres$Cantidad)))
points(Asalariados_Mujeres$Cantidad~Asalariados_Mujeres$Año,col = "green", pch=19)
points(Asalariados_Hombres$Cantidad~Asalariados_Hombres$Año,col = "lightblue",type = "l",lwd = 2)
points(Asalariados_Hombres$Cantidad~Asalariados_Hombres$Año,col =  "lightblue", pch=19)
points(Autonomos_Mujeres$Cantidad~Autonomos_Mujeres$Año,col = "darkgreen",type = "l",lwd = 2)
points(Autonomos_Hombres$Cantidad~Autonomos_Hombres$Año,col = "darkblue", pch=19)
points(Autonomos_Mujeres$Cantidad~Autonomos_Mujeres$Año,col = "darkgreen", pch=19)
grid()

grid()
