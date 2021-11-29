setwd(".")
library(ggplot2)
library(knitr)
datosestudiantes<-read.table("Archivos/Datos_hsb.txt", sep = ",",dec = ".",header = T)

#a) Calcular las medias de progreso por las distintas categorías y razonar posibles
conclusiones

#Generamos una tabla con aggregate indicando las diferentes asignaturas en funcion de los elementos pedidos
media_mt<-aggregate(cbind(P_Lectura,P_Matematicas,P_Ciencias,P_Escritura,P_Sociales)~Raza+Sexo+Estatus_Socieconomico,data = datosestudiantes,mean)
kable(media_mt)

#b) Evaluar la influencia del centro en los resultados de aprendizaje de la época

#Generamos cada uno de nuestros plots
g0<-ggplot(data = datosestudiantes, aes(x=Tipo_Escuela,y=P_Matematicas))
g1<- g0+geom_boxplot()+aes(colour=Sexo)+xlab("Centro")+ylab("Nota Matemáticas")+ggtitle("Puntuaciones según centro de aprendizaje (EEUU)")
g1

g2<-ggplot(data = datosestudiantes, aes(x=Tipo_Escuela,y=P_Sociales))
g3<-g2+geom_boxplot()+aes(colour=Sexo)+xlab("Centro")+ylab("Ciencias Sociales")+ggtitle("Puntuaciones según centro de aprendizaje (EEUU)")
g3

g4<-ggplot(data = datosestudiantes, aes(x=Tipo_Escuela,y=P_Lectura))
g5<-g4+geom_boxplot()+aes(colour=Sexo)+xlab("Centro")+ylab("Lectura")+ggtitle("Puntuaciones según centro de aprendizaje (EEUU)")
g5

g6<-ggplot(data = datosestudiantes, aes(x=Tipo_Escuela,y=P_Escritura))
g7<-g6+geom_boxplot()+aes(colour=Sexo)+xlab("Centro")+ylab("Escritura")+ggtitle("Puntuaciones según centro de aprendizaje (EEUU)")
g7

g8<-ggplot(data = datosestudiantes, aes(x=Tipo_Escuela,y=P_Ciencias))
g9<-g8+geom_boxplot()+aes(colour=Sexo)+xlab("Centro")+ylab("Ciencias")+ggtitle("Puntuaciones según centro de aprendizaje (EEUU)")
g9

#c) Estudiar posibles relaciones entre la capacidad de lectura y el aprendizaje de
#otras disciplinas.

g10<-ggplot(data = datosestudiantes, aes(x=P_Lectura, y=P_Matematicas))
g11<- g10+geom_boxplot()+aes(colour=Sexo)+xlab("Destreza en Lectura")+ylab("Matemáticas (0-100)")+ggtitle("Resultados del aprendizaje")
g11

g12<-ggplot(data = datosestudiantes, aes(x=P_Lectura,y=P_Sociales))
g13<-g12+geom_boxplot()+aes(colour=Sexo)+xlab("Destreza en Lectura")+ylab("Sociales (0-100)")+ggtitle("Resultados del aprendizaje")
g13

g14<-ggplot(data = datosestudiantes, aes(x=P_Lectura,y=P_Escritura))
g15<-g14+geom_boxplot()+aes(colour=Sexo)+xlab("Destreza en Lectura")+ylab("Escritura (0-100)")+ggtitle("Resultados del aprendizaje")
g15

g16<-ggplot(data = datosestudiantes, aes(x=P_Lectura,y=P_Ciencias))
g17<-g16+geom_boxplot()+aes(colour=Sexo)+xlab("Destreza en Lectura")+ylab("Ciencias (0-100)")+ggtitle("Resultados del aprendizaje")
g17

#d) Visualizar si el sexo o la raza de origen en 1980 tenían influencias significativas en el nivel de aprendizaje. 

g18<- g0+geom_boxplot()+xlab("Tipo de Centro")+ylab("Matemáticas (0-100)")+ggtitle("Puntuaciones en relación con la raza")
g18 <- g18+aes(colour=Sexo)+facet_wrap(~Estatus_Socieconomico)
g18

g19<- g2+geom_boxplot()+xlab("Tipo de Centro")+ylab("Sociales (0-100)")+ggtitle("Puntuaciones en relación con la raza")
g19<-g19+aes(colour=Sexo)+facet_wrap(~Estatus_Socieconomico)
g19

g20<-g4+geom_boxplot()+xlab("Tipo de Centro")+ylab("Lectura (0-100)")+ggtitle("Puntuaciones en relación con la raza")
g20<-g20+aes(colour=Sexo)+facet_wrap(~Estatus_Socieconomico)
g20

g21<-g6+geom_boxplot()+xlab("Tipo de Centro")+ylab("Escritura (0-100)")+ggtitle("Puntuaciones en relación con la raza")
g21<-g21+aes(colour=Sexo)+facet_wrap(~Estatus_Socieconomico)
g21

g22<-g8+geom_boxplot()+xlab("Tipo de Centro")+ylab("Ciencias (0-100)")+ggtitle("Puntuaciones en relación con la raza")
g22<-g22+aes(colour=Sexo)+facet_wrap(~Estatus_Socieconomico)
g22

g30<-g18+facet_wrap(~Raza)
g30
g31<-g19+facet_wrap(~Raza)
g31
g32<-g20+facet_wrap(~Raza)
g32
g33<-g21+facet_wrap(~Raza)
g33
g34<-g22+facet_wrap(~Raza)
g34
