import numpy as np
from ks_utils import *

# Modify this code to incorporate your implementation

'''
ECUACION DE RECURRENCIA PARA EL PALÍNDROMO MÁS LARGO DENTRO DE UNA SECUENCIA
            | 1                                      (if i = j)
LPS[i..j] = | PAL[i+1..j-1] + 2                      (if X[i] = X[j])
            | max (PAL[i+1..j], PAL[i..j-1])         (if X[i] != X[j])
'''

def solve_tabulation(n,candidate):

    def longitud_palindromo(X,Y,n,matrix):
        for i in range(1, n+1): 
            for j in range(1, n+1): 
                # Si el caracter coincide en la posición, avanzamos
                if X[i - 1] == Y[j - 1]:
                    matrix[i][j] = matrix[i - 1][j - 1] + 1
     
                # Si no coincide, proseguimos con el muestreo
                else:
                    matrix[i][j] = max(matrix[i - 1][j], matrix[i][j - 1])
        return matrix[n][n]          
    
    def palindromo_mas_largo(X, Y, m, n, matrix):
        if m == 0 or n == 0:
            return ""
 
        # Si el caracter coincide llamamos recocrriendo la matriz por su diagonal
        if X[m - 1] == Y[n - 1]:
     
            return palindromo_mas_largo(X, Y, m - 1, n - 1, matrix) + X[m - 1]
     
        # Si no coinciden:
        
        # Si la celda de arriba es mayor que la celda izquierda
        # entonces la saltamos y movemos el indice
        if matrix[m - 1][n] > matrix[m][n - 1]:
            return palindromo_mas_largo(X, Y, m - 1, n, matrix)
     
        #Si la celad izquierda es mayor que la celda superior
        # entonces movemos el puntero superior y avanzamos. 
        return palindromo_mas_largo(X, Y, m, n - 1, matrix)
 
    
    X = candidate
    Y = candidate[::-1]
    
    ## FASE 1 
    matrix = [ [ 0 for i in range(n+1) ] for j in range(n+1) ]   
    length = longitud_palindromo(X,Y,n,matrix)
 
    ## FASE 2
    lps = palindromo_mas_largo(X, Y, len(X), 
                               len(X), matrix)
       
    #Retorno del valor
    return length, lps
