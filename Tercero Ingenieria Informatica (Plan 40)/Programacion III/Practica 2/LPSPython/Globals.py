# -*- coding: utf-8 -*-
from ks_utils import *
from solve_tabulation import *
from solve_memoization import *
import time
    
#Flags para sources
FILE_SOURCE = ""  
DIR_SOURCE = ""    
CURRENT_TIME = 0
    
#Flags para el proceso
FILE_MODE = False
DIR_MODE = False
PROCESS_MODE = -1
SHOW_PALINDROME = False
SHOW_REMAINING = False  
SHOW_TIME = False
SHOW_IDEF = False
DISPLAY_HELP = False 
CHECK=False

##################################
# GESTION DE ARGUMENTOS
##################################

def manageArgs(args):
    
    #Preparamos los controladores del cargador        
    flag=0
    global FILE_MODE
    global DIR_MODE
    global PROCESS_MODE
    global SHOW_TIME
    global CHECK
    global DISPLAY_HELP
    global FILE_SOURCE
    global DIR_SOURCE
    global DISPLAY_HELP
    
    for i in range (1,len(args)):
        arg = args[i]
        if((arg == "-f" or arg == "--file") and flag == 0):
            if (i == len(args)-1):
                print ("archivo no especificado")
                return
            else:
                FILE_MODE = True
                FILE_SOURCE = args[i+1]
                flag=1
                
        if((arg == "-d" or arg == "--directory") and flag == 0):
            if i == len(args)-1:
                print ("directorio no especificado")
                return
            else:
                DIR_MODE = True
                DIR_SOURCE = args[i+1]
                flag=1
        
        #Carga de opciones monovalor
        if(arg == "-t" or arg == "--time"):             
            SHOW_TIME=True
        if(arg == "--check"):   
            CHECK=True
        if(arg == "-h" or arg == "--help"):    
            DISPLAY_HELP=True
            return
        
        #Carga de opciones multivalor
        #Carga el primero que cumple la opción
        if((arg == "-sm" or arg == "--memoization") and PROCESS_MODE == -1): 
            PROCESS_MODE=2
        if((arg == "-st" or arg == "--tabulation") and PROCESS_MODE == -1):  
            PROCESS_MODE=3

def displayHelp():
        print("Bienvenido al menú de ayuda ")
        print("Estos son los argumentos opcionales: ")
        print("-f Especificar el nombre de un fichero con los datos "
                           + "de entrada del algoritmo")
        print("-d Especificar un directorio con el conjunto de ficheros a procesar")
        print("-t Mostrar el tiempo en segundos de ejecucion")
        print("--check Mostrar la comparación de resultados por ambos métodos")
        print("-h Menú de ayuda")
        print("Operaciones de procesado:"+ 
              "\n  -sm: estrategia memoizatiom"+
              "\n  -st: estrategia tabulation")
    

   
def displayResults(candidate,length,lps):
    global CURRENT_TIME
    global DIR_MODE
    
    print("Para el candidato: " + str(candidate) + "\nSe encuentran los siguientes resultados:\n")
    print("Maxima Longitud: " + str(length))
    print("Palindromo resultante: " + str(lps) + "\n")
    
    if(CHECK == True):
        if(PROCESS_MODE == 2):
            length2,lps2 = solve_tabulation(len(candidate),candidate)
            print("RESOLUCIÓN POR METODO ALTERNATIVO (tabulation)")
            
        else:
            length2,lps2 = solve_memoization(len(candidate),candidate)
            print("RESOLUCIÓN POR METODO ALTERNATIVO (memoization)")
            
        print("Maxima Longitud: " + str(length2))
        print("Palindromo resultante: " + str(lps2))
        

    if(SHOW_TIME == True):
        finishTime = time.time_ns() - CURRENT_TIME
        print("Tiempo de ejecución completo (μs): " + str(finishTime//1000));
        if(DIR_MODE == True):
            resetGlobalTime() 
    print("")


# Auxiliares para obtener el valor de los globales fuera del contexto 
# del modulo local
def resetGlobalTime():
    global CURRENT_TIME
    CURRENT_TIME = time.time_ns();

def helpMode():
    return DISPLAY_HELP
    
def getGlobalTime():
    return CURRENT_TIME
    
def returnFile():
    return FILE_MODE   

def returnFileSource():
    return FILE_SOURCE 

def returnDir():
    return DIR_MODE   

def returnDirSource():
    return DIR_SOURCE 

def returnBenefit():
    return SHOW_PALINDROME   

def returnRemaining():
    return SHOW_REMAINING 

def returnTime():
    return SHOW_TIME   

def returnCheck():
    return CHECK 

def returnProcessMode():
    return PROCESS_MODE
    
    