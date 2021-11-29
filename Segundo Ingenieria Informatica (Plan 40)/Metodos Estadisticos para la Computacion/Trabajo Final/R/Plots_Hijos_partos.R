setwd(".") 
library(knitr)
library(readxl)
datos <- read_excel("Archivos/Hijos_por_partos.xlsx")
attach(datos)
y1 <- datos$`Un hijo`
y2 <- datos$`Dos hijos`
y3 <- datos$`Tres o mas hijos`
plot(Total~Años,type = "l",main = "Total Evolución anual de hijos por parto", lwd=2, col = "darkgreen")
points(Total~Años, pch=19, col="darkgreen")
grid()
lt <- lm(Total~Años)
abline(lt,col = "black", lwd=2, lty=3)

plot(y1~Años,type="l",main = "Un hijo por parto", lwd=2, ylab = "Un hijo",col ="red")
points(y1~Años, pch=19, col="red")
grid()
ly1 <- lm(y1~Años)
abline(ly1,col = "black", lwd=2, lty=3)

plot(y2~Años,type="l",main = "Dos hijos por parto", lwd=2, ylab = "Dos hijos",col ="blue")
points(y2~Años, pch=19, col="blue")
grid()
ly2 <- lm(y2~Años)
abline(ly2,col = "black", lwd=2, lty=3)

plot(y3~Años,type="l",main = "Tres o mas hijos por parto", lwd=2, ylab = "Tres o mas hijos",col ="orange")
points(y3~Años, pch=19, col="orange")
grid()
ly3 <- lm(y3~Años)
abline(ly3,col = "black", lwd=2, lty=3)
