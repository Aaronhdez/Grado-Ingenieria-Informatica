library(sqldf)
library(MASS)
library(vcd)
library(knitr)
library(ggplot2)

#EJERCICIO 5: Test de Kruskal-Wallis (Generaliz. de Mann y Whitney)

P<-c(15,12,10,8,9,6,10)
A<-c(7,8,9,8,7,10,9,8,7,10)
B<-c(8,9,8,6,7,8,9,8,7,6)
C<-c(10,12,10,8,9,11,10,9,8)
tratamientos_f<-factor(rep(1:4, c(length(P),length(A),length(B),length(C))),
                       labels = c("Placebo","Tratamiento A","Tratamiento B","Tratamiento C"))
tratamientos_v<-c(P,A,B,C)
datos_t<-as.data.frame(tratamientos_v)
datos_t[,2]<-tratamientos_f
names(datos_t)<-c("Tiempo_recuperacion", "Tipo_tratamiento")
kable(datos_t)

tabla<-table(datos_t)
kable(tabla)

g<-ggplot(data=datos_t, aes(x=Tipo_tratamiento, 
                            y=Tiempo_recuperacion, 
                            color=Tipo_tratamiento))
g+geom_boxplot()

g2<-g+xlab("Tipo de procedimiento")
g2<-g2+ylab("Tiempo hasta recuperación")
g2<-g2+geom_point(aes(shape=Tipo_tratamiento))
g2

attach(datos_t)
kruskal.test(Tiempo_recuperacion,Tipo_tratamiento, datos_tratamiento)

#Al salir la propabilidad de igualdad muy baja, 
#concluimos definitivamente que son diferentes entre si.

#Verificamos cual de las dos más bajas es mejor, si la A o la B
wilcox.test(Tiempo_recuperacion[Tipo_tratamiento=="Tratamiento A"],
            Tiempo_recuperacion[Tipo_tratamiento=="Tratamiento B"],
            alternative = "two.sided")

#Ante una probabilidad de 0,25 segun el test de Wilcoxon, se puede asumir
#que ambos tratatmientos para las plantas producen resultados iguales.



