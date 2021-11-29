setwd(".")
library(knitr)
library(readxl)
Natalidad <- read_excel("Archivos/Natalidad.xlsx")
attach(Natalidad)
Nacimientos <- Natalidad$`Nacimientos(ambos sexos)`
plot(Nacimientos~Años,col = "blue",main = "Natalidad en Las Palmas de GC", type = "l", lwd = 2)
points(Nacimientos~Años, pch=19, col="blue")
grid()
