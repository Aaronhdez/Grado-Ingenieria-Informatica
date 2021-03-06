setwd(".")
library(knitr)
library(readxl)
Construccion <- read_excel("Archivos/Construccion_R.xlsx")
Industria <- read_excel("Archivos/Industria_R.xlsx")
Servicios <- read_excel("Archivos/Servicios_R.xlsx")

#Construccion
barplot(Construccion$Hombres~Construccion$A�os,ylim = c(0,20),xlab = "A�os",ylab = "Horas",
        main = "Ganancia Media/Horas Construcci�n (Hombres)",col = "lightblue")
barplot(Construccion$Mujeres~Construccion$A�os,ylim = c(0,20),xlab = "A�os",ylab = "Horas",
        main = "Ganancia Media/Horas Construcci�n (Mujeres)",col = "lightgreen")

#Industria
barplot(Industria$Hombres~Industria$A�os,ylim = c(0,20),xlab = "A�os",ylab = "Horas",
        main = "Ganancia Media/Horas Industria (Hombres)",col = "lightblue")
barplot(Industria$Mujeres~Industria$A�os,ylim = c(0,20),xlab = "A�os",ylab = "Horas",
        main = "Ganancia Media/Horas Industria (Mujeres)",col = "lightgreen")

#Servicios
barplot(Servicios$Hombres~Servicios$A�os,ylim = c(0,20),xlab = "A�os",ylab = "Horas",
        main = "Ganancia Media/Horas Servicios (Hombres)",col = "lightblue")
barplot(Servicios$Mujeres~Servicios$A�os,ylim = c(0,20),xlab = "A�os",ylab = "Horas",
        main = "Ganancia Media/Horas Servicios (Mujeres)",col = "lightgreen")

