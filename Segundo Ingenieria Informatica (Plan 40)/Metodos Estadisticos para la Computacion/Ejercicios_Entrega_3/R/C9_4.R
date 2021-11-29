setwd(".")
library(knitr)
d1 <- c(92,89,86,83,77,71,62,2.6,53,40)
d2 <- c(88,85,93,79,70,87,52,84,41,64)
n <- length(T1)

#Coeficiente de Correlación de Pearson

# Manualmente, Aplicamos formula rp = (n*(sum) x*y - (sum)x * (sum)y)/sqrt((n*(sum)x^2-((suma)x)^2)*(n*(suma)y^2-((suma)y)^2))
suma_xy <- sum(d1*d2)
suma_x <- sum(d1)
suma_y <- sum(d2)

rp <- (n*suma_xy-suma_x*suma_y)/sqrt((n*49899.76-429811.36)*(n*57865-552049))
rp
#Usando la función cor
cor(d1,d2,method = c("pearson")) # Dependencia positiva/proporcional


#Coeficiente de Spearman

#Manualmente, ordenando por rangos de menor a mayor valor en cada conjunto
di_cuadrado <- (10-9)^2+(9-7)^2+(8-10)^2+(7-5)^2+(6-4)^2+
               (5-8)^2 + (4-2)^2 + (1-6)^2 + (3-1)^2+ (2-3)^2
r <- 1-((6*di_cuadrado/(n*(n^2-1))))
r
# Usando la función cor
cor(d1,d2,method = c("spearman"))
