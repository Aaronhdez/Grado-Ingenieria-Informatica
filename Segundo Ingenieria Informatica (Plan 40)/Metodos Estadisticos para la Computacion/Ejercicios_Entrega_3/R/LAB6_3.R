library(sqldf)
library(MASS)
library(vcd)
library(knitr)

#EJERCICIO 3: Chisq con correción de Yates

XY<-matrix(c(75,73,15,32),ncol=2, nrow=2, byrow=T)
colnames(XY)<-c("Estudiantes II", "Otros títulos")
rownames(XY)<-c("Más de dos horas", "Menos de dos horas")
tabla<-as.table(XY)
kable(tabla)

ampliada<-addmargins(tabla)
kable(ampliada)

#Aplicación del método del constraste de inpedendencia de datos.

ni<-ampliada[3,]
nj<-ampliada[,3]

# Aplicamso la correciónde Yates, debido a que solo es un grado de libertad
N<-as.numeric(ampliada[3,3])

esperada<-tabla^2
suma<-0
for (i in 1:2) {
  for (j in 1:2) {
    esperada[i,j]<-((ni[j]*nj[i])/N)
    suma<-suma+((abs(tabla[i,j]-esperada[i,j])-0.5)^2)/esperada[i,j]
  }
}
chi2<-suma
chi2

#Calculamos de la q chisq para verificar la independencia

gl<-((nrow(tabla)-1)*(ncol(tabla)-1))

qchisq(0.95,gl)

# Como el valor de chi2 es es mayor que qchisq, descartamos la hipotesis de independecia de ambos

#ejecuamos el test chi para re-vereficar lo anterior

resultado1<-chisq.test(tabla,correct = T)
resultado1

# Es decir, existe dependencia ente la carrera y el uso del movil.
