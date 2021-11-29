setwd("C:/Users/ACER1/Desktop/Ejerciciotoday")
library(knitr)
library(readxl)
Tabla <- read_excel("Edad_media_vejez_nat_pob.xls")
attach(Tabla)
#Edad con Poblacion
cor(EDAD,POBLACION,method = "pearson")
cor(EDAD,POBLACION,method = "spearman")

#Vejez con Poblacion
cor(VEJEZ,POBLACION,method = "pearson")
cor(VEJEZ,POBLACION,method = "spearman")

#Natalidad con Poblacion
cor(NATALIDAD,POBLACION,method = "pearson")
cor(NATALIDAD,POBLACION,method = "spearman")

#Edad con Vejez
cor(EDAD,VEJEZ,method = "pearson")
cor(EDAD,VEJEZ,method = "spearman")

#Edad con Natalidad
cor(EDAD,NATALIDAD,method = "pearson")
cor(EDAD,NATALIDAD,method = "spearman")
