library(sqldf)
library(MASS)
library(vcd)
library(knitr)

#eJERCICIO 2: Chisq normal

XY<-matrix(c(34,73,63,16,12,12),ncol=3, nrow=2, byrow=T)
colnames(XY)<-c("Fert. A", "Fert. B", "Fert. C")
rownames(XY)<-c("Han florecido", "No han florecido")
tabla<-as.table(XY)
kable(tabla)

ampliada<-addmargins(tabla)
kable(ampliada)

#Aplicación del método del constraste de inpedendencia de datos.

ni<-ampliada[3,]
nj<-ampliada[,4]
N<-as.numeric(ampliada[3,4])

pXY<-tabla^2
suma<-0;
for (i in 1:3) {
  for (j in 1:2) {
    suma<-suma+as.numeric(pXY[j,i]/(ni[i]*nj[j]))
  }
}
chi2<-N*(suma-1)

chi2

#Calculamos de la q chisq para verificar la independencia

gl<-((nrow(tabla)-1)*(ncol(tabla)-1))

qchisq(0.95,gl)

#ejecuamos el test chi para vaerficar lo anterior

resultado1<-chisq.test(tabla,correct = T)
resultado1

#Como el valor de p es inferior a 0,5, y el valor de chi2 es mayor que el qchisq
#Asumimos que son dependientes. Entonces verificamos cual de todos da mejor rendimiento

prop_f<-100*(ampliada[1,]/ampliada[3,])
kable(prop_f)

#El B da mejor rendimiento, luego nos quedamos con éste