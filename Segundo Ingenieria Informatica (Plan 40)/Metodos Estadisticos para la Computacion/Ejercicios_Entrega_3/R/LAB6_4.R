library(sqldf)
library(MASS)
library(vcd)
library(knitr)

#EJERCICIO 4: Test de Mcnemar

XY<-matrix(c(103,12,18,35),ncol=2, nrow=2, byrow=T)
colnames(XY)<-c("Fracturado (Jefe)", "Brazo normal (Jefe)")
rownames(XY)<-c("Fracturado (Internista)", "Brazo normal (Internista)")
tabla<-as.table(XY)
kable(tabla)

#Aplicación del método de Mcnemar
#Mide la simetría de la matriz

resultado_mcn<-mcnemar.test(tabla)
resultado_mcn

#Como la probabilidad es baja, se puede considerar que no existe simetría entre ambos
#Por ende, admitimos la hipótesis de simetría

resultado_chi2<-chisq.test(tabla)
resultado_chi2

#Al salir la probabilidad de independecia muy cercana al cero, se puede constratar 
#que son dependientes ambos del trtamiento.