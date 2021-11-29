setwd(".")
library(knitr)
datos <- c(6.2,6.6,5.8,5.4,5.3,6.15,6.68,7.0,5.8,5.6,5.85,6.2,6.4,6.75,5.3,6.3)
n <- length(datos)
pro <- 5.35
media <- mean(datos)
s <- var(datos)
sd_c <-sd(datos)

#Apartado A, con alfa == 0.01, 
# - H0 -> mu >= 5.35 
# - H1 -> mu != 5.35
alfa <- 0.01
t <- (media-pro)/s/sqrt(n)
t
qt <- qt(0.01,15)

#Se acepta h0 puesto que la proximidad a 0 es mayor que qt.

#Apartado B, prob = 0.99.
pro2 <- 6.0
d_c <- (pro2-promedio)/s
b <- 0.99
power.t.test(n = NULL, delta = d_c,sd = sd_c,sig.level = 0.01,power = b,alternative = "one.sided")

# A una probabilidad el 99%, el power test da un tamaño de muestra de aprox 4 miembros.

#Apartado C 
b_2 <- 0.90
power.t.test(n = NULL, delta = d_c,sd = sd_c,sig.level = 0.01,power = b_2,alternative = "one.sided")

# A una probabilidad el 90%, el power test da un tamaño de muestra de aprox 3 miembros.