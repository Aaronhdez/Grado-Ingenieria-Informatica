setwd(".")
library(knitr)

#Apartado A

interval<-0.01
x<-seq(from=-1,to=2,by=interval)
f_X<-function(x1){
  f<-rep(0,length(x1))
  for(i in 1:length(x1)) {
    if((x1[i]<=0)|(x1[i]>=1)) {
      fX=0
    } else {
      fX=5*((1-x1[i])*(1-x1[i])*(1-x1[i])*(1-x1[i]))
    }
    f[i]=fX 
  }
  return(f)
}
plot(x,f_X(x), col="blue", type="l", lwd = 3,
     ylab = "función de densidad f(x)")
grid()
min(f_X(x))
prob_1<-integrate(f_X,-1,2)
prob_1

#Apartado B

x_1 <- 0
x_2 <- 0.1
p <- f_X(seq(x_1,x_2,interval))
z <- c(x_1,seq(x_1,x_2,interval),x_2)
p <- c(0,p,0)
polygon(z,p,col = "green",density = 20.5)
integrate(f_X,x_1,x_2)

# Apartado C
plot(x,f_X(x), col="blue", type="l", lwd = 3,
     ylab = "función de densidad f(x)")
grid()
x_3 <- 0.5
x_4 <- 1
p <- f_X(seq(x_3,x_4,interval))
z <- c(x_3,seq(x_3,x_4,interval),x_4)
p <- c(0,p,0)
polygon(z,p,col = "green",density = 20.5)
integrate(f_X,x_3,x_4)
