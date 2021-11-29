#PRUEBAS PARA QUE FUNCIONE EL APARTADO A. EXPLICAR CON MAS DETALLE Y GRAFICAR
mu<-20.5
xm<-23.75
s<-4
n<-8
porc<-(xm-mu)/(s/sqrt(n))
porc
probabilidad<-1-pt(porc,n-1)
probabilidad*100
#Porcentaje de la población muestreada es 2,7%, luego la muestra es pequeña


#APARTADO B Y C. Recomendable explicar y graficar
#Calculamos si la muestra, una vez verificado su tamaño, entra en el intervalo de confianza, del 90%
alfa<-0.05
df1<-mu-(dt(1-(alfa/2),7)*s/sqrt(n))
df1

alfa<-0.95
df2<-mu+(dt(1-(alfa/2),7)*s/sqrt(n))
df2
#Al ser los valores derecho e izquierdo muy próximos al valor del porcentaje, entra en el intervalo de confiaza,
#Aunque por muy poco. Se podría considera como válida, pero es imprudente debido a que la holgura
#respecto al IC es mínima. Viendo el comportamiento se puede concluir

#La varianza general es muy poca luego cualquier submuestra medianamente grande de n entrará si o sí en el intervalo
#La submuestra tomada respecto al tamaño de la población es muy grande, luego habría de reducir el tamaño de muestreo

#DEMOSTRACIÓN DE LO ANTERIOR: comprobamos si el numero de muestras influye a través de la gráfica

x<-seq(3,10,1)
plot(x, mu+(dt(1-(alfa/2),x-1)*s/sqrt(x)), type="l", col="red", lwd=2, ylim =c(19.5,21.5),
     xlab="Tamaño de muestras", ylab="Tamaño del Intervalo")
grid()
points(x, mu-(dt(1-(alfa/2),x-1)*s/sqrt(x)), type="l", col="green", lwd=2)
points(x, mu+(dt(1-(alfa/2),x-1)*s/sqrt(x)), pch=19, col="darkred", lwd=2)
points(x, mu-(dt(1-(alfa/2),x-1)*s/sqrt(x)), pch=19, col="darkgreen", lwd=2)

abline(h=mu, col="blue", lwd=1.75, lty=2)

