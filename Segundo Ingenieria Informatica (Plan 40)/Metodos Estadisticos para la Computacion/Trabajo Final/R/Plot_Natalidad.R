setwd(".")
library(knitr)
library(readxl)
Natalidad <- read_excel("Archivos/Natalidad.xlsx")
attach(Natalidad)
Nacimientos <- Natalidad$`Nacimientos(ambos sexos)`
plot(Nacimientos~A�os,col = "blue",main = "Natalidad en Las Palmas de GC", type = "l", lwd = 2)
points(Nacimientos~A�os, pch=19, col="blue")
grid()
