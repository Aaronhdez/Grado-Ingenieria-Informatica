setwd(".")
library(knitr)
library(readxl)
Afiliaciones <- read_excel("Archivos/AfiliacionesSS.xls")
attach(Afiliaciones)
Asalariados <- subset(Afiliaciones, Tipo_Empleo== "Asalariados", select = c("Tipo_Empleo", "Cantidad", "A�o", "Sexo"))
Autonomos <- subset(Afiliaciones, Tipo_Empleo== "Autonomos", select = c("Tipo_Empleo", "Cantidad", "A�o", "Sexo"))

Asalariados_Hombres <- subset(Asalariados, Sexo== "Hombre", select = c("Cantidad", "A�o"))
Asalariados_Mujeres <- subset(Asalariados, Sexo== "Mujer", select = c("Cantidad", "A�o"))

Autonomos_Hombres <- subset(Autonomos, Sexo== "Hombre", select = c("Cantidad", "A�o"))
Autonomos_Mujeres <- subset(Autonomos, Sexo== "Mujer", select = c("Cantidad", "A�o"))

#Asalariados
plot(Asalariados_Mujeres$Cantidad~Asalariados_Mujeres$A�o,col = "green",type = "l",xlab = "A�os",ylab = "Cantidad",
     lwd = 2,main = "Asalariados - Las Palmas de Gran Canaria")
points(Asalariados_Mujeres$Cantidad~Asalariados_Mujeres$A�o,col = "green", pch=19)
points(Asalariados_Hombres$Cantidad~Asalariados_Hombres$A�o,col = "lightblue",type = "l",lwd = 2)
points(Asalariados_Hombres$Cantidad~Asalariados_Hombres$A�o,col =  "lightblue", pch=19)
grid()
#Autonomos
plot(Autonomos_Hombres$Cantidad~Autonomos_Hombres$A�o,col = "darkblue",type = "l",xlab = "A�os",ylab = "Cantidad",
     lwd = 2,main = "Aut�nomos - Las Palmas de Gran Canaria",ylim = c(0,max(Autonomos_Hombres$Cantidad)))
points(Autonomos_Hombres$Cantidad~Autonomos_Hombres$A�o,col = "darkblue", pch=19)
points(Autonomos_Mujeres$Cantidad~Autonomos_Mujeres$A�o,col = "darkgreen",type = "l",lwd = 2)
points(Autonomos_Mujeres$Cantidad~Autonomos_Mujeres$A�o,col = "darkgreen", pch=19)
grid()

# Asalariados y Autonomos conjunto
plot(Asalariados_Mujeres$Cantidad~Asalariados_Mujeres$A�o,col = "green",type = "l",xlab = "A�os",ylab = "Cantidad",
     lwd = 2,main = "Asalariados y Autonomos  - Las Palmas de Gran Canaria",ylim = c(0,max(Asalariados_Mujeres$Cantidad)))
points(Asalariados_Mujeres$Cantidad~Asalariados_Mujeres$A�o,col = "green", pch=19)
points(Asalariados_Hombres$Cantidad~Asalariados_Hombres$A�o,col = "lightblue",type = "l",lwd = 2)
points(Asalariados_Hombres$Cantidad~Asalariados_Hombres$A�o,col =  "lightblue", pch=19)
points(Autonomos_Mujeres$Cantidad~Autonomos_Mujeres$A�o,col = "darkgreen",type = "l",lwd = 2)
points(Autonomos_Hombres$Cantidad~Autonomos_Hombres$A�o,col = "darkblue", pch=19)
points(Autonomos_Mujeres$Cantidad~Autonomos_Mujeres$A�o,col = "darkgreen", pch=19)
grid()

grid()
