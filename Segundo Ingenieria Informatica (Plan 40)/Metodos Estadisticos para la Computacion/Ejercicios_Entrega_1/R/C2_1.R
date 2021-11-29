setwd("./")
#Cuestion 1: Losdatos siguientes representan el peso en kilos de una muestra 
#de 80 personas de la Escuela de Ingeniería Informática

vector2<-c(50, 73, 73, 68, 67, 74, 73, 67, 71, 79, 74, 74, 77, 74, 71, 80, 72, 
          74, 77, 75, 71, 73, 75, 76, 77, 71, 81, 68, 66, 73, 91, 75, 89, 77, 
          93, 57, 66, 83, 86, 90, 55, 77, 78, 91, 82, 83, 87, 96, 85, 88, 101, 
          97, 80, 73, 76, 80, 89, 76, 78, 99, 80, 85, 84, 72, 65, 69, 79, 84, 
          92, 83, 86, 76, 80, 81, 74, 73, 72, 79, 55, 66)
#a)Obténgase una distribución de datos en intervalos de amplitud del 5% de la distribución, 
#construir una tabla de frecuencias absolutas y relativas y definir cada representante de la clase.
vector<-read.table("D:/Universidad/SEGUNDO/Métodos Estadísticos/Ejercicios R/Archivos/PesosEstEII.txt")
pesoDF<-data.frame(vector)
names(pesoDF)<-c("Intervalo", "FrecAbs", "FrecRel")
pesoDF

#Intervalo donde se experimenta la mayor frecuencia en la muestra
#El peso as comun oscila entre 70 y 75 Kgs
attach(pesoDF)
Intervalo[(which.max(FrecAbs))]
detach(pesoDF)

#b)Calcular la media muestral y la desviación estándar muestral.
### La media la da el vector2 con todos los pesos.
mean(vector2)
### Aplicamosla función var para descubrir la varianza.
varianzapeso<-var(vector2)
varianzapeso
### Aplicamos raiz cuadrada y recuperamos la desviación estandar.
desv_est<-sqrt(varianzapeso)
desv_est
###Comprobamos con la funcion sd.
desv_est2<-sd(vector2)
desv_est2

#c)Encontrar la mediana, los cuartiles y el rango intercuartílico. 
###Ejecutamos la mediana con median()
median(vector2)
###Aplicamos quantile para veficiar los cuartiles
quantile(vector2)
###Aplicamos tambien con un ratio de 0.x para encontrar los deciles
quants<-quantile(vector2, c(0.1,0.2,0.3,0.4,0.5,0.6,0.7,0.8,0.9,1))
quants
#Aplicamos la fórmula para resolver el IQR y IDR
rec_iq<-quantile(vector2,0.75)-quantile(vector,0.25)
rec_iq
rec_idec<-quantile(vector2,0.9)-quantile(vector,0.1)
rec_idec
#Comprobamos con la fórmula IQR
RIC<-IQR(vector2)
RIC

#d)Elaborar un histograma con los datos. 
hist(vector2, main="Histograma sin ajustar ouliers", xlab = "Kgs.", ylab = "Frecuencia",
     col="blue", density= 100.0, border= "black", labels= TRUE)

#Ajustamos los cortes al 5% respecto al máximo
cortes<-c(50, 55, 60, 65, 70, 75, 80, 85, 90, 95, 100, 105, 110)
hist(vector2, breaks=cortes, main="Histograma ajustando ouliers",xlab = "Kgs.", ylab = "Frecuencia",
     col="yellow", density= 100.0, border= "black", labels= TRUE)

#e)Construir un diagrama de caja y mostrar los casos atípicos y otros elementos relevantes del mismo.
boxplot(vector2, ylab = "Rangos edades", labels= TRUE, notch=TRUE, outlines=TRUE)

#f)Analizar los valores fuera de rango y la posible corrección de estos "outliers". 
boxplot(vector2, ylab = "Rangos edades", labels= TRUE, notch=TRUE, outlines=FALSE)

#g)Construir un programa R para verificar los distintos apartados anteriores. 

