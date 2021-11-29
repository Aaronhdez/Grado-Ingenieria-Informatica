setwd(".")
library(knitr)

notas_al <- c(5.7,8.6,3.6,1.5,8.8,5.9,4.9,8.6,7.6,5.0,
             7.7,2.6,8.6,7.5,5.8,6.2,9.9,7.1,5.6,6.2,
             7.6,6.5,6.7,4.5,4.8,6.9,8.9,2.6,5.5,7.0)#Mira tabla uminima
n1 <- length(notas_al)

notas_pr <- c(5.0,7.0,5.2,1.3,7.2,6.6,3.1,8.6,6.0,6.1,
                  8.0,5.0,9.2,7.3,4.2,6.6,9.1,7.6,4.0,5.1,
                  8.0,8.1,9.1,4.5,3.2,7.6,7.1,4.6,6.0,5.8)
n2 <- length(notas_pr)
alfa <- 0.05

#Cáculo manual
notas_al_ord <- sort(notas_al)
notas_pr_ord <- sort(notas_pr)
notas_al_ord
notas_pr_ord

# Valores de los rangos calculados a mano
R1 <- 808.5
R2 <- 849.5

U1 <- n1*n2+((n1*(n1+1))/2)-R1
U2 <- n1*n2+((n2*(n2+1))/2)-R2
U1
U2
mu_U <- (n1*n2)/2
sigma_U_2 <- (n1*n2*(n1+n2+1))/12
Z <- (U2-mu_U)/sqrt(sigma_U_2)
Z
qnorm(0.025)
qnorm(0.975) 

# Como z (0.96837) se encuntra en el intervalo (-1.95, 1.95), se acepta la hipótesis nula, H0.

# Usando wilcox.test
# Quitamos los 0 de X-Y

resta <- notas_al - notas_pr
resta
notas_al_new <- c(5.7,8.6,3.6,1.5,8.8,5.9,4.9,7.6,5.0,
             7.7,2.6,8.6,7.5,5.8,6.2,9.9,7.1,5.6,6.2,
             7.6,6.5,6.7,4.8,6.9,8.9,2.6,5.5,7.0)

notas_pr_new <- c(5.0,7.0,5.2,1.3,7.2,6.6,3.1,6.0,6.1,
                  8.0,5.0,9.2,7.3,4.2,6.6,9.1,7.6,4.0,5.1,
                  8.0,8.1,9.1,3.2,7.6,7.1,4.6,6.0,5.8)

wilcox.test(notas_al_new,notas_pr_new,paired = T,exact = F) 

# Como el valor de probabilidad se dispara a cais el 72% por el test de Wilcoxon, se acepta hipótesis nula
