setwd(".")
library(knitr)
library(readxl)
Construccion <- read_excel("Archivos/Construccion_R.xlsx")
Industria <- read_excel("Archivos/Industria_R.xlsx")
Servicios <- read_excel("Archivos/Servicios_R.xlsx")

#Construccion
barplot(Construccion$Hombres~Construccion$Años,ylim = c(0,20),xlab = "Años",ylab = "Horas",
        main = "Ganancia Media/Horas Construcción (Hombres)",col = "lightblue")
barplot(Construccion$Mujeres~Construccion$Años,ylim = c(0,20),xlab = "Años",ylab = "Horas",
        main = "Ganancia Media/Horas Construcción (Mujeres)",col = "lightgreen")

#Industria
barplot(Industria$Hombres~Industria$Años,ylim = c(0,20),xlab = "Años",ylab = "Horas",
        main = "Ganancia Media/Horas Industria (Hombres)",col = "lightblue")
barplot(Industria$Mujeres~Industria$Años,ylim = c(0,20),xlab = "Años",ylab = "Horas",
        main = "Ganancia Media/Horas Industria (Mujeres)",col = "lightgreen")

#Servicios
barplot(Servicios$Hombres~Servicios$Años,ylim = c(0,20),xlab = "Años",ylab = "Horas",
        main = "Ganancia Media/Horas Servicios (Hombres)",col = "lightblue")
barplot(Servicios$Mujeres~Servicios$Años,ylim = c(0,20),xlab = "Años",ylab = "Horas",
        main = "Ganancia Media/Horas Servicios (Mujeres)",col = "lightgreen")

