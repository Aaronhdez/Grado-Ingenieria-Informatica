setwd(".")
library(knitr)
library(readxl)

#PRUEBAS GENERALES, COEFICIENTES DE PEARSON Y SPEARMAN ROJO-AMARILLO
Tabla_grande <- read_excel("Tabla_Grande_pruebas_multiples.xlsx")
attach(Tabla_grande)
cor(Hijos_parto,Crecimiento,method = "pearson") # Dependencia positiva/proporcional baja
cor(Hijos_parto,Crecimiento,method = "spearman") # Correlacion positiva baja

#PRUEBAS ESPECIFICAS 1, PEARSON Y SPEARMAN CON HIJOS Y TRABAJADORES EN AÑOS 2009-2011
Subtabla_Trabajadores <- read_excel("Subtabla_Trabajadores_pruebas_multiples.xlsx")
attach(Subtabla_Trabajadores)
cor(Hijos_parto,Trabajadores_sector,method = "pearson") # Dependencia negativa/No proporcional
cor(Hijos_parto,Trabajadores_sector,method = "spearman") # Correlación negativa

#PRUEBAS ESPECIFICAS 2, PEARSON Y SPEARMAN CON HIJOS Y TRABAJADORES Y CON HIJOS Y AFILIACIONES ss EN AÑOS 2012-2017
Subtabla_Trabajadores_Afiliaciones <- read_excel("Subtabla_Afiliaciones_Trabajadores_pruebas_multiples.xlsx")
attach(Subtabla_Trabajadores_Afiliaciones)
cor(Hijos_parto,Afiliaciones_SS,method = "pearson") # Dependencia negativa/No proporcional alta
cor(Hijos_parto,Afiliaciones_SS,method = "spearman")# Correlación negativa alta
cor(Hijos_parto,Trabajadores_sector,method = "pearson") # Dependencia negativa/No proporcional alta
cor(Hijos_parto,Trabajadores_sector,method = "spearman") # Correlación negativa alta