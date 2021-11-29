setwd(".")
library(knitr)
mu <- 7.45
sigma_cuad <- 0.8
n <- 20
s2 <- 20
X2<- (n-1)*s2/sigma_cuad
xlim <- qchisq(0.95,19)
xlim2 <- 1- pchisq((20*19)/0.8,19)
