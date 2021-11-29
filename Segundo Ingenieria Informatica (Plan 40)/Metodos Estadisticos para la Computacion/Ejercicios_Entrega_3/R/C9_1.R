library(knitr)
Tabla<-matrix(c(35,31,47,55),2,2,byrow=TRUE)
colnames(Tabla)<-c("Hombre","Mujer"); rownames(Tabla)<-c("Interesados/as","No Interesadas/os")
Tabla<-as.table(Tabla) 
kable(Tabla)

#Se distribuyen con una distribucion:
#v = (2-1)(2-1) = 1 grado de libertad
qchisq(0.95,1)

#Pruebas de homogeneidad de forma teorica
XY<-matrix(c(35,47,31,55),
           ncol=2,nrow = 2)
colnames(XY)<-c("Hombre", "Mujer")
rownames(XY)<-c("Interesados/as","No Interesados/as")
XY
pXY<-matrix(c(35/66*35/82,47/102*47/82, 31/66*31/86,55/102*55/86),
            ncol=2,nrow = 2)
sum(pXY)

CHI2<-sum(XY)*(sum(pXY)-1)
CHI2

# Región Crítica
gl<-(nrow(XY)-1)*(ncol(XY)-1)
qchisq(0.95,gl)

CHI2<-sum(XY)*(sum(pXY)-1)
CHI2

# Región Crítica
gl<-(nrow(XY)-1)*(ncol(XY)-1)
qchisq(0.95,gl)

test<-chisq.test(XY)
test

#Vemos el valor del estadístico de contraste (0.7750765), 
#los grados de libertad (1) y el bajo p-valor 0.4701 mayor que 0.05, nos 
#permite concluir que con esos datos podemos aceptar la hipótesis nula de homogeneidad de los terrenos.
#Los porcentajes de Interesados/as serán iguales ya sea hombre o mujer

#Ahora lo hacemos a través de las pruebas de Magnemar
#Pruebas de Magnemar
result <- mcnemar.test(Tabla, correct = T)
result
# 0.08943 > 0.05 Por tanto se admite la hipótesis nula de existencia de simetría

#El valor para 1-a de la distribución x2 con 1 grados de libertad es:
qchisq(0.95, 1)
x2 <- (47-32)^2/(47+31)
x2
#Y para x2= 2.884615 con 1 grado de libertad.
res <- 1-pchisq(2.884615,1)
res

#Cómo 0.08942938 > 0.05 concluimos que la hipótesis nula se cumple, en consecuencia también la simetría

result2 <- chisq.test(Tabla, correct = TRUE)
result2
#Como 0.4701 > 0.05