import numpy as np
from ks_utils import *
import collections

# Modify this code to incorporate your implementation

'''
ECUACION DE RECURRENCIA PARA EL PALÍNDROMO MÁS LARGO DENTRO DE UNA SECUENCIA
            | 1                                      (if i = j)
LPS[i..j] = | PAL[i+1..j-1] + 2                      (if X[i] = X[j])
            | max (PAL[i+1..j], PAL[i..j-1])         (if X[i] != X[j])
'''

'''
Si el el caracter es el mismo en ambas posiciones, entonces tenemos
un posible palíndromo, por lo que lo almacenamos y seguimos buscando.
Añadimos además la longituda de los dos caracteres al computo total
'''


def solve_memoization(n,candidate):
    def getKey(i,j):
        return str(i)+"|"+str(j)

    def longitud_palindromo(candidate, dict, i, j):        
        key = getKey(i,j)
        
        if key not in dict:
        # Condición de retorno cuando la dicotomía ha finalizado (secuencias pares)
            if i > j:
                 dict[key] = 0
        #Condición de retorno cuando la dicotomía ha finalizado (secuencias impares)
            elif i == j:
                 dict[key] = 1
            
            
            elif candidate[i] == candidate[j]:
                dict[key] = longitud_palindromo(candidate, dict, i+1, j-1) + 2
            else:
                """
                Si no lo es significa que ambos no son palíndromos, así que 
                seguimos buscando tanto por la izquierda como por la derecha
                (desfasando los indices) para ver si existe alguna otra 
                subsecuencia palindrómica. 
                """
                dict[key] = max(longitud_palindromo(candidate, dict, i+1, j), 
                                longitud_palindromo(candidate, dict, i, j-1))
                
                # Retorno de la solución del subproblema
        return dict[key]
    
    
    def palindromo_mas_largo(X, m, n, dict):
        if m > n:
            return ""
        
        if m == n:
            return X[n]
 
        key = getKey(m,n)
        if key in dict:
            # Si el caracter coincide llamamos recursivamemnte modificamos 
            # los indices 
            if X[m] == X[n]:
                return X[n] + palindromo_mas_largo(X, m + 1, n - 1, dict) + X[n]
         
        # Si no coinciden:   
        # Generamos las claves los las letras anteriores por la izquierda y por
        # la derecha y verificamos que estén en el diccionario
        key1 = getKey(m+1,n)
        key2 = getKey(m,n-1)
        if key1 in dict and key2 in dict :
            # Si están, retornamos el mayor valor que surge de verificar ambas 
            # en el diccionario (finalmente retornara aquella subsecuencia 
            # palindrómica máxima)
            if dict.get(key1) > dict.get(key2) :
                return palindromo_mas_largo(X, m + 1, n, dict)
         
            return palindromo_mas_largo(X, m, n - 1, dict)
        
    dict = {}
    X = candidate
    
    ## FASE 1  
    length = longitud_palindromo(X, dict, 0, n-1)
    
    ## FASE 2
    lps = palindromo_mas_largo(X, 0, n-1, dict)
    
    '''
    # Ajustamos el resultado del palíndromo
    if length % 2 == 0:
        lps = lps[::-1] + lps 
    else:
        lps = lps[0:len(lps)-1] + lps[::-1]   
    '''
    #Retorno del valor
    return length,lps