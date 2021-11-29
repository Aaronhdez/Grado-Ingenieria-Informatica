setwd(".")
library(knitr)
library(readxl)

Paro_Hombres <- read_excel("Archivos/Paro_Hombres.xlsx")
Paro_Mujeres <- read_excel("Archivos/Paro_Mujeres.xlsx")

#Paro Hombres por Edades
Edad_16_19_H<-subset(Paro_Hombres,Paro_Hombres$EDAD=="16 a 19 años", select=c("2019","2018","2017","2016","2015","2014","2013","2012","2011","2010","2009","2008"))
Edad_20_24_H <- subset(Paro_Hombres,Paro_Hombres$EDAD=="20 a 24 años",select = c("2019","2018","2017","2016","2015","2014","2013","2012","2011","2010","2009","2008"))
Edad_25_34_H <- subset(Paro_Hombres,Paro_Hombres$EDAD=="25 a 34 años",select = c("2019","2018","2017","2016","2015","2014","2013","2012","2011","2010","2009","2008"))
Edad_35_44_H <- subset(Paro_Hombres,Paro_Hombres$EDAD=="35 a 44 años",select = c("2019","2018","2017","2016","2015","2014","2013","2012","2011","2010","2009","2008"))
Edad_45_54_H <- subset(Paro_Hombres,Paro_Hombres$EDAD=="45 a 54 años",select = c("2019","2018","2017","2016","2015","2014","2013","2012","2011","2010","2009","2008"))
Edad_55_omas_H <- subset(Paro_Hombres,Paro_Hombres$EDAD=="55 y más años",select = c("2019","2018","2017","2016","2015","2014","2013","2012","2011","2010","2009","2008"))

#Paro Mujeres por Edades
Edad_16_19_M <- subset(Paro_Mujeres,Paro_Mujeres$EDAD=="16 a 19 años",select = c("2019","2018","2017","2016","2015","2014","2013","2012","2011","2010","2009","2008"))
Edad_20_24_M <- subset(Paro_Mujeres,Paro_Mujeres$EDAD=="20 a 24 años",select = c("2019","2018","2017","2016","2015","2014","2013","2012","2011","2010","2009","2008"))
Edad_25_34_M <- subset(Paro_Mujeres,Paro_Mujeres$EDAD=="25 a 34 años",select = c("2019","2018","2017","2016","2015","2014","2013","2012","2011","2010","2009","2008"))
Edad_35_44_M <- subset(Paro_Mujeres,Paro_Mujeres$EDAD=="35 a 44 años",select = c("2019","2018","2017","2016","2015","2014","2013","2012","2011","2010","2009","2008"))
Edad_45_54_M <- subset(Paro_Mujeres,Paro_Mujeres$EDAD=="45 a 54 años",select = c("2019","2018","2017","2016","2015","2014","2013","2012","2011","2010","2009","2008"))
Edad_55_omas_M <- subset(Paro_Mujeres,Paro_Mujeres$EDAD=="55 y más años",select = c("2019","2018","2017","2016","2015","2014","2013","2012","2011","2010","2009","2008"))
                                                                                    
#Diagrama de sectores
Paro_H_2019 <- mean(Paro_Hombres$`2019`)
Empleo_H_2019 <- 100-mean(Paro_Hombres$`2019`)
Paro_M_2019 <- mean(Paro_Mujeres$`2019`)
Empleo_M_2019 <- 100-mean(Paro_Mujeres$`2019`)
Paro_H <- c(Paro_H_2019,Empleo_H_2019)
lbs <- c("Desempleados","Empleados")

pie(Paro,labels = lbs,col = c("blue","lightblue"),main = "Empleo medio 2019 (hombres)")
Paro_M <- c(Paro_H_2019,Empleo_H_2019)
lbs <- c("Desempleadas","Empleadas")
pie(Paro,labels = lbs,col = c("darkgreen","green"),main = "Empleo medio 2019 (mujeres)")

# Diagrama de caja
boxplot(Paro_Hombres$`2019`,Paro_Mujeres$`2019`,col = "grey", main = "Paro en 2019 (Hombres - Mujeres)")
grid()

xparo<-seq(2019,2008,-1)
#Combinado por Edades
plot(xparo,Edad_16_19_H,type = "l",ylim = c(0,100),col = "red",main = "Paro Hombres y Mujeres 16-19 años",
     lwd=2, xlab = "Años",ylab = "Tasa de paro")
grid()
points(xparo,Edad_16_19_H,col = "red", pch=17, lwd=2)
points(xparo,Edad_16_19_M,col = "blue",type = "l", lwd=2)
points(xparo,Edad_16_19_M,col = "blue", pch=17, lwd=2)

plot(xparo,Edad_20_24_H,col = "red",type = "l",ylim = c(0,100),main = "Paro Hombres y Mujeres 20-24 años",
     lwd=2, xlab = "Años",ylab = "Tasa de paro")
grid()
points(xparo,Edad_20_24_H,col = "red", pch=17, lwd=2)
points(xparo,Edad_20_24_M,col = "blue",type = "l", lwd=2)
points(xparo,Edad_20_24_M,col = "blue", pch=17, lwd=2)

plot(xparo,Edad_25_34_H,col = "red",type = "l",ylim = c(0,100),main = "Paro Hombres y Mujeres 25-39 años",
     lwd=2, xlab = "Años",ylab = "Tasa de paro")
grid()
points(xparo,Edad_25_34_H,col = "red", pch=17, lwd=2)
points(xparo,Edad_25_34_M,col = "blue",type = "l", lwd=2)
points(xparo,Edad_25_34_M,col = "blue", pch=17, lwd=2)

plot(xparo,Edad_35_44_H,col = "red",type = "l",ylim = c(0,100),main = "Paro Hombres y Mujeres 35-44 años",
     lwd=2, xlab = "Años",ylab = "Tasa de paro")
grid()
points(xparo,Edad_35_44_H,col = "red", pch=17, lwd=2)
points(xparo,Edad_35_44_M,col = "blue",type = "l", lwd=2)
points(xparo,Edad_35_44_M,col = "blue", pch=17, lwd=2)

plot(xparo,Edad_45_54_H,col = "red",type = "l",ylim = c(0,100),main = "Paro Hombres y Mujeres 45-54 años",
     lwd=2, xlab = "Años",ylab = "Tasa de paro.")
grid()
points(xparo,Edad_45_54_H,col = "red", pch=17, lwd=2)
points(xparo,Edad_45_54_M,col = "blue",type = "l", lwd=2)
points(xparo,Edad_45_54_M,col = "blue", pch=17, lwd=2)

plot(xparo,Edad_55_omas_H,col = "red",type = "l",ylim = c(0,100),main = "Paro Hombres y Mujeres 55 o más años",
     lwd=2, xlab = "Años",ylab = "Tasa de paro.")
grid()
points(xparo,Edad_55_omas_H,col = "red", pch=17, lwd=2)
points(xparo,Edad_55_omas_M,col = "blue",type = "l", lwd=2)
points(xparo,Edad_55_omas_M,col = "blue", pch=17, lwd=2)

plot(xparo,Edad_55_omas_H,col = "red",type = "l",ylim = c(0,100),main = "Paro Hombres y Mujeres 55 o más años",
     lwd=2, xlab = "Años",ylab = "Tasa de paro.")
grid()
points(xparo,Edad_55_omas_H,col = "red", pch=17, lwd=2)
points(xparo,Edad_55_omas_M,col = "blue",type = "l", lwd=2)
points(xparo,Edad_55_omas_M,col = "blue", pch=17, lwd=2)

Paro_Medio <- read_excel("Archivos/Media_Paro_H_Paro_M.xlsx")
Paro_M_H<-subset(Paro_Medio, Paro_Medio$SEXO=="Hombres", select=c("2019","2018","2017","2016","2015","2014","2013","2012","2011","2010","2009","2008"))
Paro_M_M<-subset(Paro_Medio, Paro_Medio$SEXO=="Mujeres", select=c("2019","2018","2017","2016","2015","2014","2013","2012","2011","2010","2009","2008"))

plot(xparo,Paro_M_H,col = "red",type = "l",ylim = c(0,100),main = "Paro medio por Sexo",
     lwd=2, xlab = "Años",ylab = "Tasa de paro")
grid()
points(xparo,Paro_M_H,col = "red", pch=17, lwd=2)
points(xparo,Paro_M_M,col = "blue",type = "l", lwd=2)
points(xparo,Paro_M_M,col = "blue", pch=17, lwd=2)
