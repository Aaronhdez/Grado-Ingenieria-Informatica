library(qcc)
datos <- read.table(text = "Causas Suspensos", header = TRUE)
attach(datos)

Causas <- c("Falta de motivaci�n por la asignatura","Escasa base matem�tica para comprender los conceptos","Horario del semestre","Carga de trabajo del curso donde se ubica la asignatura excesiva","Laboratorios deficientes","Pr�cticas muy laboriosas","Poco tiempo para el trabajo de curso","Explicaciones en clases te�ricas no satisfactorias","Otras causas") 
Suspensos <-c(10,25,15,37,15,8,28,10,6)
names(Causas) <- Suspensos
Causas
Tipos <- Suspensos
names(Tipos) <- Causas
pareto.chart(Tipos)
