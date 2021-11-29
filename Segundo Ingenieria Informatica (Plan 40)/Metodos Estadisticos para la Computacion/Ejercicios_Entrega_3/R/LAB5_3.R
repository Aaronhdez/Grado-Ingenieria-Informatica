setwd(".")
library(knitr)
library(ggplot2)
library(sqldf)
library(MASS)

sueldos<-read.table("Archivos/sueldos_hosteleria.txt", dec = ".", sep=",")
attach(sueldos)

##########################
#Apartado A
##########################

# Podemos, al igual que en ejercicio anterior,
# calcular t y verificar que la media calculada con 
# la media de la empresa son cuasi equivalentes

t.test( Sueldos, alternative=c("two.sided"), mu=18510,
        paired=FALSE, var.equal=FALSE, conf.level=0.95)

# La probailidad es de 0,22/1, es decir, del 22% de ser la media, 
# Esto implica que es considerable como solución.

# Asimismo, el rango de sueldos se acorta respecto al caso anterior,
# lo cual tiene sentido debido a que a menor sa el intrvalo de confianza
# menor es el rango de acierto.