setwd(".")
library(knitr)

# Distribuci�n de Poisson ya que el n�mero de resultados que ocurren en un 
# intervalo o regi�n espec�fica es independiente del n�mero que ocurre en 
# cualquier otro intervalo de tiempo.

# Del enunciado vemos que el promedio es de 5 clientes cada 20 minutos,por tanto, ??t=5

# a) 
# P(x > 10) = 1 - P(x=<10)
# x=10 
# ??t=15 ya que 60/20=3
ppois(10,15)
1-ppois(10,15)

# b)
# Como solo nos dice menor que 5 incluimos el valor nulo (ning�n cliente)
# P(x<5) = P(0)+P(1)+P(2)+P(3)+P(4)
sum(dpois(0:4,5))
ppois(0:4,5,lower.tail = TRUE)

# c)
# Sabemos que dos horas es lo mismo que dos periodos de 60 min, o lo que es lo mismo
# 120 minutos. As�, como nuestro promedio inicial era cada 20 min, 120/20= 6 y 5*6=30.
# La media de llegadas de clientes en dos horas es 30.

# d)
# Gr�fico distribuci�n del primer apartado
x<-0:13
plot(x,ppois(x,15), xlab="N�mero de clientes",
     ylab="P(X<=x)",type= "s", col="darkgreen", lwd=2,
     main="Clientes en Dep. Reclamaciones")
grid()
points(x,ppois(x,15), pch=19, col="red")

# Gr�fico distribuci�n del segundo apartado
plot(x,ppois(x,5), xlab="N�mero de clientes",
     ylab="P(X<=x)",type= "s", col="darkred", lwd=2,
     main="Clientes en Dep. Reclamaciones")
grid()
points(x,ppois(x,5), pch=19, lwd=2, col="blue")
