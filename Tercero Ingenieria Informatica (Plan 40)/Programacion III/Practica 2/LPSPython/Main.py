from solve_greedy import *
from solve_tabulation import *
from solve_memoization import *
from ks_utils     import *
from my_tests     import *
from Globals      import *
import sys, os

myTestMode = False

def main():
    args = sys.argv
    manageArgs(args)
    if (helpMode()):
        displayHelp()
        return
    if (returnFile()):
        fileProcess(returnFileSource())
    if (returnDir()):
        dirProcess(returnDirSource())

##################################
# PROCESADO DE FICHEROS
##################################

def fileProcess(fileName):
    resetGlobalTime()
    fileStream = open(fileName,"r")
    first_line = fileStream.readline().split()
    first = int(first_line[0])
    last = int(first_line[1])
    candidate = fileStream.readline()
    
    print("*************************************************************")
    
    if(returnProcessMode() == 2):
        print(fileName +": ESTRATEGIA SELECCIONADA: MEMORIZALIZACIÓN\n")
        processMemoization(first,last,candidate)
    if(returnProcessMode() == 3):
        print(fileName +": ESTRATEGIA SELECCIONADA: TABULACIÓN\n")
        processTabulation(first,last,candidate)
        
##################################
# PROCESADO DE DIRECTORIOS
##################################
def dirProcess(dirName):
    
    files_list = os.listdir(dirName)
    for file in files_list:
        path = dirName+"/"+file
        fileProcess(path)

##################################
# PROCESADO DE DATOS
##################################

# Tabulación    
def processTabulation(first,last,candidate):
    length,lps = solve_tabulation(len(candidate),candidate)
    displayResults(candidate,length,lps)
    return

# Memoization
def processMemoization(first,last,candidate):
    length,lps = solve_memoization(len(candidate),candidate)
    displayResults(candidate,length,lps)
    return

#=============================================================================
#=============================================================================

if myTestMode:
    # Check my tests
    tests = TestKSP()
    tests.test_from_data_to_item()
    tests.test_4() 
    # ..                        # Add more tests as you consider convenient
    # print(0, "[ ]")             # Dummy result to mandatory tests

else:
    main()