library(qcc)
datos <- read.table(text = "Causas Suspensos", header = TRUE)
attach(datos)

Causas <- c("Falta de motivación por la asignatura","Escasa base matemática para comprender los conceptos","Horario del semestre","Carga de trabajo del curso donde se ubica la asignatura excesiva","Laboratorios deficientes","Prácticas muy laboriosas","Poco tiempo para el trabajo de curso","Explicaciones en clases teóricas no satisfactorias","Otras causas") 
Suspensos <-c(10,25,15,37,15,8,28,10,6)
names(Causas) <- Suspensos
Causas
Tipos <- Suspensos
names(Tipos) <- Causas
pareto.chart(Tipos)
