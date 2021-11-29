library(resample)
#DATOS
grasa_A<-c(164,172,168,177,195,156)
grasa_B<-c(178,191,197,182,177,185)
grasa_C<-c(175,193,178,171,176,163)
grasa_D<-c(155,166,149,164,168,170)

##CREAMOS LAS POBLACIONES
#MEDIAS
mu_A<-mean(grasa_A)
mu_B<-mean(grasa_B)
mu_C<-mean(grasa_C)
mu_D<-mean(grasa_D)

#DESVIACIONES TIPICAS
sigma_A<-sqrt(var(grasa_A))
sigma_B<-sqrt(var(grasa_B))
sigma_C<-sqrt(var(grasa_C))
sigma_D<-sqrt(var(grasa_D))

#POBLACIONES
pobA<-rnorm(grasa_A,mean=mu_A,sd=sigma_A)
pobB<-rnorm(grasa_B,mean=mu_B,sd=sigma_B)
pobC<-rnorm(grasa_C,mean=mu_C,sd=sigma_C)
pobD<-rnorm(grasa_D,mean=mu_D,sd=sigma_D)

#HACEMOS LAS PRUEBAS Y LAS VISUALIZAMOS
size<-length(grasa_A)
A<-sample(pobA,size)
B<-sample(pobB,size)
C<-sample(pobC,size)
D<-sample(pobD,size)

#HALLAMOS LAS DIFERENCIAS DE MEDIAS ENTRE GRUPOS
AB<-mean(A)-mean(B)
AC<-mean(A)-mean(C)
AD<-mean(A)-mean(D)
BC<-mean(B)-mean(C)
BD<-mean(B)-mean(D)
CD<-mean(C)-mean(D)

permutaciones<-choose(4*size,size)
permutaciones

#PRUEBAS Y VISUALIZACION
TEST1<-permutationTest2(data = pobA,mean, data2 = pobB, R=permutaciones, seed =35200)
TEST1
plot(TEST1, col="grey")
abline(v=AB,lty=3,col="blue",lwd=3)
abline(v=-AB,lty=3,col="red",lwd=3)
points(AB,0,lwd=5, col="orange", pch=19)

TEST2<-permutationTest2(data = pobA,mean, data2 = pobC, R=permutaciones, seed =35200)
TEST2
plot(TEST2, col="grey")
abline(v=AC,lty=3,col="blue",lwd=3)
abline(v=-AC,lty=3,col="red",lwd=3)
points(AC,0,lwd=5, col="orange", pch=19)

TEST3<-permutationTest2(data = pobA,mean, data2 = pobD, R=permutaciones, seed =35200)
TEST3
plot(TEST3, col="grey")
abline(v=AD,lty=3,col="blue",lwd=3)
abline(v=-AD,lty=3,col="red",lwd=3)
points(AD,0,lwd=5, col="orange",pch=19)


TEST4<-permutationTest2(data = pobB,mean, data2 = pobC, R=permutaciones, seed =35200)
TEST4
plot(TEST4, col="grey")
abline(v=BC,lty=3,col="blue",lwd=3)
abline(v=-BC,lty=3,col="red",lwd=3)
points(BC,0,lwd=5, col="orange")

TEST5<-permutationTest2(data = pobB,mean, data2 = pobD, R=permutaciones, seed =35200)
TEST5
plot(TEST5, col="grey")
abline(v=BD,lty=3,col="blue",lwd=3)
abline(v=-BD,lty=3,col="red",lwd=3)
points(BD,0,lwd=5, col="orange")

TEST6<-permutationTest2(data = pobC,mean, data2 = pobD, R=permutaciones, seed =35200)
TEST6
plot(TEST6, col="grey")
abline(v=CD,lty=3,col="blue",lwd=3)
abline(v=-CD,lty=3,col="red",lwd=3)
points(CD,0,lwd=5, col="orange")

#Hemos utilizado el test de permutaciones, ya que su proposito es la de encontrar la diferencia que hay entre grupos. Para ser
#mas exactos, el valor para todas las posibles reorganizaciones de las observaciones en los distintos grupos.

#El p-value de dos colas se calcula como la proporción de permutaciones
#muestrales en las que el valor luto de la diferencia calculaa es
#mayor o igual al valor luto de la diferencia observaa.

#Como podemos observar gracias a los tests y a los plots, si existen diferencias notorias entre muestras, siendo la mas notoria
#la grasa C con la D, y la B con la D. Esto se puede visualizar, ya sea por el p-value sacado por los tests de 
#permutaciones (cuanto menor sea, mayor la diferencia),o con los plots, que cuyas lineas verticales muestran el rango de diferencia que hay entre la media observada y la calculada.
#La grasa A y D son casi parecidas, teniendo un p-value mayor y una diferencia proxima a 0

##Para el apartado B: cogeremos como referencia la grasa que tenga mayor media entre poblaciones. 
