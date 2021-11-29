setwd(".")
library(readxl)
library(tseries)
datos <- read_xlsx("Tabla_resumen_distritos.xlsx")
attach(datos)
n <- length(D1_H)
#############################################COEFICIENTES DE PEARSON Y SPEARMAN: TODOS LOS CASOS#########################

# USAREMOS LA FUNCIÓN COR() PARA OBTENER EL COEFICIENTE CORRESPONDIENTE

#---------------------------------------------- DISTRITO 1 CON DISTRITO 2---------------------------------
# D1_H con D2_ H
cor(D1_H,D2_H,method = c("spearman"))
cor(D1_H,D2_H,method = c("pearson"))
# D1_M con D2_M
cor(D1_M,D2_M,method = c("spearman"))
cor(D1_M,D2_M,method = c("pearson"))

#CON RESPECTO A SPEARMAN, ENTRE ESTOS 2 DISTRITOS EXISTE UNA CORRELACIÓN POSITIVA ENTRE HOMBRES Y MUJERES.
#CON RESPECTO A PEARSON, ENTRE ESTOS 2 DISTRITOS EXISTE UNA DEPENDENCIA NEGATIVA/NO PROPORCIONAL EN LOS HOMBRES
#Y UNA POSITIVA/PROPORCIONAL EN LAS MUJERES

#---------------------------------------------- DISTRITO 1 CON DISTRITO 3---------------------------------
# D1_H con D3_ H
cor(D1_H,D3_H,method = c("spearman"))
cor(D1_H,D3_H,method = c("pearson"))
# D1_M con D3_M
cor(D1_M,D3_M,method = c("spearman"))
cor(D1_M,D3_M,method = c("pearson"))

#CON RESPECTO A SPEARMAN, ENTRE ESTOS 2 DISTRITOS EXISTE UNA CORRELACIÓN POSITIVA DE IGUAL VALOR ENTRE HOMBRES Y MUJERES.
#CON RESPECTO A PEARSON, ENTRE ESTOS 2 DISTRITOS EXISTE UNA DEPENDENCIA POSTIVA ALTA ENTRE HOMBRES Y MUJERES

#---------------------------------------------- DISTRITO 1 CON DISTRITO 4---------------------------------
# D1_H con D4_ H
cor(D1_H,D4_H,method = c("spearman"))
cor(D1_H,D4_H,method = c("pearson"))
# D1_M con D4_M
cor(D1_M,D4_M,method = c("spearman"))
cor(D1_M,D4_M,method = c("pearson"))

#CON RESPECTO A SPEARMAN, ENTRE ESTOS 2 DISTRITOS EXISTE UNA CORRELACIÓN NEGATIVA ENTRE HOMBRES 
#Y UNA CORRELACIN POSITIVA TOTAL ENTRE MUJERES.
#CON RESPECTO A PEARSON, ENTRE ESTOS 2 DISTRITOS EXISTE UNA DEPENDENCIA NEGATIVA/NO PROPORCIONAL ENTRE HOMBRES
#Y UNA DEPENDENCIA POSITIVA/PROPORCIONAL ALTA ENTRE MUJERES
#---------------------------------------------- DISTRITO 1 CON DISTRITO 5---------------------------------
# D1_H con D5_ H
cor(D1_H,D5_H,method = c("spearman"))
cor(D1_H,D5_H,method = c("pearson"))
# D1_M con D5_M
cor(D1_M,D5_M,method = c("spearman"))
cor(D1_M,D5_M,method = c("pearson"))

#CON RESPECTO A SPEARMAN, ENTRE ESTOS 2 DISTRITOS EXISTE UNA CORRELACIÓN NEGATIVA TOTAL ENTRE HOMBRES Y MUJERES.
#CON RESPECTO A PEARSON, ENTRE ESTOS 2 DISTRITOS EXISTE UNA DEPENDENCIA NEGATIVA/NO PROPORCIONAL EN AMBOS SEXOS
#---------------------------------------------- DISTRITO 2 CON DISTRITO 3---------------------------------
# D2_H con D3_ H
cor(D2_H,D3_H,method = c("spearman"))
cor(D2_H,D3_H,method = c("pearson"))
# D2_M con D3_M
cor(D2_M,D3_M,method = c("spearman"))
cor(D2_M,D3_M,method = c("pearson"))

#CON RESPECTO A SPEARMAN Y PEARSON ENTRE ESTOS 2 DISTRITOS EXISTE UNA CORRELACIÓN NEGATIVA Y
# UNA DEPENDENCIA NEGATIVA/NO PROPORCIONAL  ENTRE HOMBRES Y UNA CORRELACIÓN POSITIVA Y UNA DEPENDENCIA
# POSITIVA/PROPORCIONAL ALTAS ENTRE LAS MUJERES.
#---------------------------------------------- DISTRITO 2 CON DISTRITO 4---------------------------------
# D2_H con D3_ H
cor(D2_H,D4_H,method = c("spearman"))
cor(D2_H,D4_H,method = c("pearson"))
# D2_M con D4_M
cor(D2_M,D4_M,method = c("spearman"))
cor(D2_M,D4_M,method = c("pearson"))

#CON RESPECTO A SPEARMAN Y PEARSON ENTRE ESTOS 2 DISTRITOS EXISTE UNA CORRELACIÓN NEGATIVA TOTAL Y
# UNA DEPENDENCIA NEGATIVA/NO PROPORCIONAL ALTA ENTRE HOMBRES Y UNA CORRELACIÓN POSITIVA Y UNA DEPENDENCIA
# POSITIVA/PROPORCIONAL ALTA ENTRE LAS MUJERES.
#---------------------------------------------- DISTRITO 2 CON DISTRITO 5---------------------------------
# D2_H con D5_ H
cor(D2_H,D5_H,method = c("spearman"))
cor(D2_H,D5_H,method = c("pearson"))
# D2_M con D5_M
cor(D2_M,D5_M,method = c("spearman"))
cor(D2_M,D5_M,method = c("pearson"))

#CON RESPECTO A SPEARMAN Y PEARSON ENTRE ESTOS 2 DISTRITOS EXISTE UNA CORRELACIÓN NEGATIVA Y
#UNA DEPENDENCIA NEGATIVA/NO PROPORCIONAL  ENTRE HOMBRES Y MUJERES 
#---------------------------------------------- DISTRITO 3 CON DISTRITO 4---------------------------------
# D3_H con D4_ H
cor(D3_H,D4_H,method = c("spearman"))
cor(D3_H,D4_H,method = c("pearson"))
# D3_M con D4_M
cor(D3_M,D4_M,method = c("spearman"))
cor(D3_M,D4_M,method = c("pearson"))

#CON RESPECTO A SPEARMAN, ENTRE ESTOS 2 DISTRITOS EXISTE UNA CORRELACIÓN POSITIVA  ENTRE HOMBRES Y MUJERES.
#CON RESPECTO A PEARSON, ENTRE ESTOS 2 DISTRITOS EXISTE UNA DEPENDENCIA NEGATIVA/NO PROPORCIONAL ENTRE HOMBRES
#Y UNA POSITIVA/PROPORCIONAL ALTA ENTRE MUJERES 
#---------------------------------------------- DISTRITO 3 CON DISTRITO 5---------------------------------
# D3_H con D5_ H
cor(D3_H,D5_H,method = c("spearman"))
cor(D3_H,D5_H,method = c("pearson"))
# D3_M con D5_M
cor(D3_M,D5_M,method = c("spearman"))
cor(D3_M,D5_M,method = c("pearson"))

#CON RESPECTO A SPEARMAN Y PEARSON ENTRE ESTOS 2 DISTRITOS EXISTE UNA CORRELACIÓN NEGATIVA Y
#UNA DEPENDENCIA NEGATIVA/NO PROPORCIONAL  ENTRE HOMBRES Y MUJERES 
#---------------------------------------------- DISTRITO 4 CON DISTRITO 5---------------------------------
# D4_H con D5_ H
cor(D4_H,D5_H,method = c("spearman"))
cor(D4_H,D5_H,method = c("pearson"))
# D4_M con D5_M
cor(D4_M,D5_M,method = c("spearman"))
cor(D4_M,D5_M,method = c("pearson"))

#CON RESPECTO A SPEARMAN, ENTRE ESTOS 2 DISTRITOS EXISTE UNA CORRELACIÓN POSITIVA  ENTRE HOMBRES 
#Y UNA CORRELACION NEGATIVA ALTA ENTRE MUJERES.
#CON RESPECTO A PEARSON, ENTRE ESTOS 2 DISTRITOS EXISTE UNA DEPENDENCIA POSITIVA/ PROPORCIONAL ALTA ENTRE HOMBRES
#Y UNA NEGATIVA/NO PROPORCIONAL ALTA ENTRE MUJERES 


########################################### TESTS DE NORMALIDAD ########################################
# HACEMOS UN MODELO LINEAL, SACAMOS RESIDUALES Y APLICAMOS TESTS DE NORMALIDAD
# NOTA: EN CADA CONJUNTO, SE REPITEN O SON APROX LOS MISMOS VALORES PARA LOS TEST, POR TANTO CON UNA CONCLUSION VALE
# HAY ALGUNOS QUE NO, COMO EL PRIMER CONJUNTO DE D1 Y D2
#---------------------------------------------- DISTRITO 1 CON DISTRITO 2---------------------------------
modelo <- lm(D2_H~D1_H)
e <- residuals(modelo)
shapiro.test(e)
ks.test(e,"pnorm")
jarque.bera.test(e)

modelo <- lm(D2_M~D1_M)
e <- residuals(modelo)
shapiro.test(e)
ks.test(e,"pnorm")
jarque.bera.test(e)

#CON RESPECTO A LOS HOMBRES EN ESTOS DOS DISTRITOS, EXISTE POCA NORMALIDAD  USANDO TESTS DE SHAPHIRO Y KS, 
#PERO SEGUN JARQUE BERA, HAY NORMALIDAD
#CON RESPECTO A LAS MUJERES, EXISTE MUY POCA NORMALIDAD SEGUN SHAPIRO Y KS, PERO HAY NORMALIDAD SEGUN JARQUE BERA

#---------------------------------------------- DISTRITO 1 CON DISTRITOS 3,4 Y 5---------------------------------
modelo <- lm(D3_H~D1_H)
e <- residuals(modelo)
shapiro.test(e)
ks.test(e,"pnorm")
jarque.bera.test(e)

modelo <- lm(D3_M~D1_M)
e <- residuals(modelo)
shapiro.test(e)
ks.test(e,"pnorm")
jarque.bera.test(e)

#CON RESPECTO A LOS HOMBRES EN ESTOS DOS DISTRITOS, EXISTE NORMALIDAD  USANDO TESTS DE SHAPHIRO, KS Y JARQUE BERA 
#CON RESPECTO A LAS MUJERES, EXISTE MUY POCA NORMALIDAD SEGUN SHAPIRO, PERO HAY NORMALIDAD SEGUN KS Y JARQUE BERA



#---------------------------------------------- DISTRITO 2 CON DISTRITOS 3,4 Y 5---------------------------------
modelo <- lm(D3_H~D2_H)
e <- residuals(modelo)
shapiro.test(e)
ks.test(e,"pnorm")
jarque.bera.test(e)

modelo <- lm(D3_M~D2_M)
e <- residuals(modelo)
shapiro.test(e)
ks.test(e,"pnorm")
jarque.bera.test(e)

#CON RESPECTO A LOS HOMBRES EN ESTOS DOS DISTRITOS, EXISTE NORMALIDAD  USANDO TESTS DE SHAPHIRO Y JARQUE BERA
# PERO SEGUN KS, HAY MUY POCA NORMALIDAD
#CON RESPECTO A LAS MUJERES, EXISTE MUY POCA NORMALIDAD SEGUN SHAPIRO Y KS, PERO HAY NORMALIDAD SEGUN JARQUE BERA



#---------------------------------------------- DISTRITO 3 CON DISTRITOS 4 Y 5---------------------------------
modelo <- lm(D4_H~D3_H)
e <- residuals(modelo)
shapiro.test(e)
ks.test(e,"pnorm")
jarque.bera.test(e)

modelo <- lm(D4_M~D3_M)
e <- residuals(modelo)
shapiro.test(e)
ks.test(e,"pnorm")
jarque.bera.test(e)

#CON RESPECTO A LOS HOMBRES Y MUJERES, EXISTE MUY POCA NORMALIDAD SEGUN SHAPIRO Y KS PERO EXISTE BASTANTE SEGUN JARQUE BERA

#---------------------------------------------- DISTRITO 4 CON DISTRITO 5---------------------------------
modelo <- lm(D5_H~D4_H)
e <- residuals(modelo)
shapiro.test(e)
ks.test(e,"pnorm")
jarque.bera.test(e)

modelo <- lm(D5_M~D4_M)
e <- residuals(modelo)
shapiro.test(e)
ks.test(e,"pnorm")
jarque.bera.test(e)

#CON RESPECTO A LOS HOMBRES Y MUJERES, EXISTE NORMALIDAD CON P-VALUE BAJO, Y SEGUN JARQUE BERA EXISTE BASTANTE NORMALIDAD
