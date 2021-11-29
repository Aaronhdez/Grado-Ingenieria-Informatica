setwd(".")
library(knitr)
library(ggplot2)
library(sqldf)
library(MASS)

evol_pob<-read.csv("Archivos/Evolucion_poblacional_LP.csv", sep = ";", dec = ".")
names(evol_pob)<-c("Poblacion","Year")

evol_pob
attach(evol_pob)

g<-ggplot(evol_pob, mapping = aes(x=Year, y=Poblacion))
g<-g+geom_line(col="lightblue", lwd=2)+geom_point(col="blue", lwd=2)
g<-g+geom_vline(xintercept = 1940, col="black", lwd=1.25, lty=2)
g<-g+ggtitle("Evolución Población según Censo (ISTAC)", )
g<-g+scale_y_continuous(labels = function(x) format(x, scientific = TRUE))
g
