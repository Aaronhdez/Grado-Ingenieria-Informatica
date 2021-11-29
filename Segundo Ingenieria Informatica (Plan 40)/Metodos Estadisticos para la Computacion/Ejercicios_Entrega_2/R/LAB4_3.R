setwd(".")
library(knitr)
library(ggplot2)
germinacion<-read.table("Archivos/germination.csv", header=T, sep=",")
attach(germinacion)

#APARTADO A
n_germinadas<- sample - count
p_n_germinadas<- 100*(n_germinadas/sample)
germinacion<-cbind(germinacion,n_germinadas,p_n_germinadas)
attach(germinacion)
kable(germinacion[1:10,])

#APARTADO B
medias_n_g<-aggregate(p_n_germinadas~Orobanche+extract, germinacion, mean)
kable(medias_n_g)
boxplot(p_n_germinadas~Orobanche+extract,col="green")

#A73 judia
abline(h = medias_n_g[1,3], col="red", lwd="2")

#A75 judia
abline(h = medias_n_g[2,3], col="red", lwd="2")

#A73 pepino
abline(h = medias_n_g[3,3], col="red", lwd="2")

#A75 pepino
abline(h = medias_n_g[4,3], col="red", lwd="2")
grid()

#APARTADO C
#Judias
boxplot(p_n_germinadas[extract=="judia"]~Orobanche[extract=="judia"], 
        col="lightblue", ylim=c(0,100), xlab="genotipo")

modelo1<-lm(p_n_germinadas[extract=="judia"]~Orobanche[extract=="judia"])
abline(modelo1, col="blue", lwd=3)
text(1.5,50,labels="judia")
grid()

#Pepinos
boxplot(p_n_germinadas[extract=="pepino"]~Orobanche[extract=="pepino"], 
        col="orange", ylim=c(0,100), xlab="genotipo", add=T)
modelo1<-lm(p_n_germinadas[extract=="pepino"]~Orobanche[extract=="pepino"])
abline(modelo1, col="brown", lwd=3)
text(1,20,labels="pepino")
