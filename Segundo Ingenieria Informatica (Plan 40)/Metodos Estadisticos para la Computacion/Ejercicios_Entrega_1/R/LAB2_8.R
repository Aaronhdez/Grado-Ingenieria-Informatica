#Iniciamos el espacio de trabajo en Nuestro directorio de proyecto
setwd(".")
library(knitr)
library(carData)
library(ggplot2)

#Apartado A y B

xaxis <- seq(from=0, to=10, by=0.1)
yaxis<- (xaxis)^2 + 3*xaxis + 4
cX<-xaxis
cY<-yaxis
xinf<-0.1
xsup<-9.9
incr<-0.1
plot_scale <- function(x,y,x1,x2,inc){
  if(length(x) != length(y)) stop("La dimensión en los vectores no es la misma")
  if(!is.numeric(x1)) stop("ERROR: Entrada no numerica")
  if(!is.numeric(x2)) stop("ERROR:Entrada no numérica")
  plot(x,y, col = 'grey')
  n1<-as.integer(x1/inc)
  n2<-as.integer(x2/inc)
  #Generamos las coordenadas de las x para el poligono.
  curva_x<- seq(x1,x2,inc)
  traza_x<-c(x1, curva_x,x2)
  #Generamos las coordenadas de las y.
  curva_y <- y[n1:(n1 + length(curva_x)-1)]
  traza_y<-c(0,curva_y, 0)
  polygon(traza_x, traza_y, col = '#ffff00')
}
plot_scale(xaxis,yaxis,xinf,xsup,incr)
grid()

#Apartado c

# FUNCION MEJORADA
plot_scale <- function(x,y,x1,x2,inc){
  if(length(x) != length(y)) stop("La dimensión en los vectores no es la misma")
  if(!is.numeric(x1)) stop("ERROR: Entrada no numerica")
  if(!is.numeric(x2)) stop("ERROR:Entrada no numérica")
  plot(x,y, main = 'Gráfica de ejemplo', xlab = 'X axis', ylab = 'Y axis', col = 'grey')
  n1<-as.integer(x1/inc)
  n2<-as.integer(x2/inc)
  curva_x<- seq(x1,x2,inc)
  curva_y <- y[n1:(n1 + length(curva_x)-1)]
  traza_x<-c(x1, curva_x,x2)
  traza_y<-c(0,curva_y, 0)
  polygon(traza_x, traza_y, col = '#ff1100')
}
plot_scale(xaxis,yaxis,xinf,xsup,incr)
grid()

#Apartado D y E

xaxis<-seq(from=0, to=10, by=0.5)
yaxis<-(xaxis)^2 + 3*xaxis + 4
funcion_parab<-data.frame(xaxis,yaxis)
funcion_parab_ajustada<-funcion_parab[funcion_parab$xaxis>2,]
funcion_parab_ajustada<-funcion_parab_ajustada[funcion_parab_ajustada$xaxis<4,]

attach(funcion_parab)
g<-ggplot(data = funcion_parab, mapping = aes(x=xaxis, y=yaxis))
g2<-g + geom_line()
g2<-g2 + xlab("X axis") 
g2<-g2 + ylab("Y axis")
g2<-g2 + ggtitle("Función con zona rellena por geom_area()")
g2<-g2 + geom_area(data=funcion_parab_ajustada, mapping = aes(fill = 'red'))
g2
detach()

