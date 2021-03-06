#PRUEBAS PARA QUE FUNCIONE EL APARTADO A. EXPLICAR CON MAS DETALLE Y GRAFICAR
mu<-20.5
xm<-23.75
s<-4
n<-8
porc<-(xm-mu)/(s/sqrt(n))
porc
probabilidad<-1-pt(porc,n-1)
probabilidad*100
#Porcentaje de la poblaci�n muestreada es 2,7%, luego la muestra es peque�a


#APARTADO B Y C. Recomendable explicar y graficar
#Calculamos si la muestra, una vez verificado su tama�o, entra en el intervalo de confianza, del 90%
alfa<-0.05
df1<-mu-(dt(1-(alfa/2),7)*s/sqrt(n))
df1

alfa<-0.95
df2<-mu+(dt(1-(alfa/2),7)*s/sqrt(n))
df2
#Al ser los valores derecho e izquierdo muy pr�ximos al valor del porcentaje, entra en el intervalo de confiaza,
#Aunque por muy poco. Se podr�a considera como v�lida, pero es imprudente debido a que la holgura
#respecto al IC es m�nima. Viendo el comportamiento se puede concluir

#La varianza general es muy poca luego cualquier submuestra medianamente grande de n entrar� si o s� en el intervalo
#La submuestra tomada respecto al tama�o de la poblaci�n es muy grande, luego habr�a de reducir el tama�o de muestreo

#DEMOSTRACI�N DE LO ANTERIOR: comprobamos si el numero de muestras influye a trav�s de la gr�fica

x<-seq(3,10,1)
plot(x, mu+(dt(1-(alfa/2),x-1)*s/sqrt(x)), type="l", col="red", lwd=2, ylim =c(19.5,21.5),
     xlab="Tama�o de muestras", ylab="Tama�o del Intervalo")
grid()
points(x, mu-(dt(1-(alfa/2),x-1)*s/sqrt(x)), type="l", col="green", lwd=2)
points(x, mu+(dt(1-(alfa/2),x-1)*s/sqrt(x)), pch=19, col="darkred", lwd=2)
points(x, mu-(dt(1-(alfa/2),x-1)*s/sqrt(x)), pch=19, col="darkgreen", lwd=2)

abline(h=mu, col="blue", lwd=1.75, lty=2)

