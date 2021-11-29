setwd(".")
library(carData)
library(knitr)
help(MplsStops)

#APARTADO A
#Cargamos y anclamos la librería
GEN_DATA<-MplsStops
summary(GEN_DATA)
attach(GEN_DATA)

#APARTADO B
#Hacemos Attach y creamos nuestro subset
DATA_PR_2<-subset(GEN_DATA[problem=="traffic",], select = c(race,gender,neighborhood))
DATA_PR_2_HEAD<-head(DATA_PR_2)
detach(GEN_DATA)

#Mostramos las columnas y cambiamos su nombre
kable(DATA_PR_2[1:10,])
names(DATA_PR_2)<-c("raza","genero","barrio")
kable(DATA_PR_2[1:10,])
# Volvemos a anclar
attach(DATA_PR_2)

#APARTADO C
# Tabla de frecuencias de accidentes
ftable(raza)
DATA_PR_2_RACE<-data.frame(ftable(raza))
kable(DATA_PR_2_RACE)

#APARTADO D
# Grafico de accidentes por raza
attach(DATA_PR_2_RACE)
pie(Freq, labels=raza)
detach()
# Grafico de accidentes por genero
ftable(genero)
DATA_PR_2_GENDER<-data.frame(ftable(genero))
kable(DATA_PR_2_GENDER)
pie(DATA_PR_2_GENDER$Freq, labels=DATA_PR_2_GENDER$genero)

# Calculamos suma de frecuencia de accidentes
ACC_SUM<-sum(DATA_PR_2_RACE$Freq)
# Creamos un dataframe con el porcentaje respecto al total de accidentes
PCTG_RACE<-100*DATA_PR_2_RACE/ACC_SUM
names(PCTG_RACE)<-c("raza","porcentaje")
attach(PCTG_RACE)
raza<-DATA_PR_2_RACE$raza
kable(PCTG_RACE)
pie(porcentaje, labels=raza)
detach()

#APARTADO E
# Maximo barrio por accidentes.
# Tabla de accidentes por barrio
DATA_PR_2_NEIGH<-data.frame(ftable(barrio))
kable(DATA_PR_2_NEIGH)
# Calculos del maximo de accidentes y su barrio
max(DATA_PR_2_NEIGH$Freq)
which.max(DATA_PR_2_NEIGH$Freq)
DATA_PR_2_NEIGH$barrio[which.max(DATA_PR_2_NEIGH$Freq)]
# Grafico de accidentes por barrio
pie(DATA_PR_2_NEIGH$Freq, labels=DATA_PR_2_NEIGH$barrio, cex=0.75, radius=1.25)

#Nuevo Dataset con los barrios ajustados por encima de 1000
DATA_PR_2_NEIGH_RED<-DATA_PR_2_NEIGH[DATA_PR_2_NEIGH$Freq > 1000,]
kable(DATA_PR_2_NEIGH_RED)

#Sumamos y añadimos al Dataset DATA_PR_2_NEIGH
DPR2_N<-sum(DATA_PR_2_NEIGH$Freq)
DPR2_NR<-sum(DATA_PR_2_NEIGH_RED$Freq)
DATA_PR_2_NEIGH_NEO<-rbind(DATA_PR_2_NEIGH_RED, data.frame(barrio="otros", Freq=DPR2_N-DPR2_NR))
pie(DATA_PR_2_NEIGH_NEO$Freq, labels=DATA_PR_2_NEIGH_NEO$barrio, cex=0.75, main = "Accidentes por barrio")


