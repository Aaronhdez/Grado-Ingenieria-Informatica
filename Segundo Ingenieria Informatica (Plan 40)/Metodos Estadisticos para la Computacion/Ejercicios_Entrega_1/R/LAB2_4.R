#empezamos el trabajo
setwd(".")
datos_empleados <- read.table("Archivos/empleados.txt",sep = ",", header = TRUE)
datos_salarios <- read.table("Archivos/salarios.txt",sep = "\t",header = TRUE)
#APARTADO 1
##Analizar el contenido de los Data Frames con los comandos tail() y head()
head(datos_empleados)
tail(datos_empleados)

head(datos_salarios)
tail(datos_salarios)

#APARTADO 2
##Razonar sobre los tipos de datos que lo integran (factores y vectores).
summary(datos_empleados)
summary(datos_salarios)
##analizamos 


#APARTADO 3
tapply(datos_salarios$Salario,datos_salarios$Num_Empleado,mean)
tapply(datos_salarios$Salario,datos_salarios$Num_Empleado,median)
tapply(datos_salarios$Salario,datos_salarios$Num_Empleado,sd)
#Creamos una tabala nueva con la media de los salarios por numero de empleado 
VectorSalario<-c(tapply(datos_salarios$Salario,datos_salarios$Num_Empleado,mean))
SueldoMax<-which.max(VectorSalario)
SueldoMin<-which.min(VectorSalario)

#APARTADO 4
VectorSalario<-as.numeric(datos_salarios$Salario)
VectorEmpleado<-as.numeric(datos_salarios$Num_Empleado)
boxplot(VectorSalario~VectorEmpleado,ylab="Salario Medio",xlab="Nº de Empleado", col="green")

#APARTADO 5
#Combinamos las dos tablas en una nueva y sobre esta un dataframe
tablanew<-merge(datos_salarios,datos_empleados)
datos_c<-data.frame(tablanew)
#Lo anclamos
attach(tablanew)
#apartado c
tapply(Salario,Num_Empleado,mean)
tapply(Salario,Num_Empleado,median)
tapply(Salario,Num_Empleado,sd)
VSalario<-c(tapply(Salario,Num_Empleado,mean))
PMax<-which.max(VSalario)
PMin<-which.min(VSalario)
#apartado d

VectorSalarionew<-as.numeric(Salario)
VectorEmpleadonew<-as.numeric(Num_Empleado)
boxplot(VectorSalarionew~VectorEmpleadonew,
        ylab="Salario Medio (combinados)",
        xlab="Nº de Empleado (combinada)", 
        col="red")
detach()

#APARTADO 6
##Con los comandos interval() , now() y ymd() del paquete lubridate, determinar
##la edad de los diez empleados y añadir una nueva columna con el campo 
##Edad" al data frame resultante del apartado anterior
attach(tablanew)

library(lubridate)
current<-as.Date(now())
vectorFechas<-c(as.Date(Fecha_nacimiento))
Años<-c(year(current)-year(vectorFechas))
datosEdad<-data.frame(Num_Empleado=Num_Empleado,Edad=Años)
tablanew<-merge(tablanew,datosEdad)

##podemos comprobarlo creando un data frame filtrando por empleado y 
##haciendo las medias de cada empleado (es su edad).

prueba<-data.frame(tablanew)
detach()
attach(tablanew)
aggregate(Edad~Num_Empleado,prueba,mean)

#APARTADO 7
##Anadir un nuevo registro al data frame del apartado e). Explicar en detalle el
##proceso.
##Tiempo de trabajo en semanas según el contrato de cada cliente en semanas laborales
from<-c(as.Date(Desde_Fecha))
to<-c(as.Date(Fecha_Contrato))
workingWeeks<-c(difftime(to,from, units = "days"))
workingWeeksArray<-as.numeric(workingWeeks,"days")
workingWeeksArray<-workingWeeksArray/5
tablanew<-cbind(tablanew,Semanas_Contrato=workingWeeksArray)
kable(tablanew)

