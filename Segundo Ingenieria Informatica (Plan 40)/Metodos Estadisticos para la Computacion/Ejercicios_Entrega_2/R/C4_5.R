setwd(".")
library(knitr)

#Apartado A
Prob_A <- dnbinom(14,1,0.035) 
Prob_A

#Apartado B
pctg_mal <- 3.5
pctg_bien <- 100-3.5
pctg_bien

x1<-seq(0,10,1)
#Apartado E
x <- dbinom(x1,120,0.035)*120
plot(x,type = "l",col = "red",lwd = 2,
     xlab = "Tiempo de espera (min)",
     ylab = "Pasajeros",
     main = "Revisión Equipajes AENA GC")
grid()
points(x, type="h")
points(x, type="p", col="darkred", pch=19)

