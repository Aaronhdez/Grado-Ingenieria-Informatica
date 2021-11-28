package algorithm;

import persistence.algorithm.ProgramingStrategy;

/*
ECUACION DE RECURRENCIA PARA EL PALÍNDROMO MÁS LARGO DENTRO DE UNA SECUENCIA
            | 1                                      (if i = j)                                    
LPS[i..j] = | PAL[i+1..j-1] + 2                      (if X[i] = X[j])                          
            | max (PAL[i+1..j], PAL[i..j-1])         (if X[i] != X[j])
'''

'''
Si el el caracter es el mismo en ambas posiciones, entonces tenemos
un posible palíndromo, por lo que lo almacenamos y seguimos buscando.
Añadimos además la longituda de los dos caracteres al computo total
*/

public class Tabulation implements ProgramingStrategy {
    private int[][] matrix;
    private int longestNumber;
    private String sequence;
    private String inversedSequence;
    private int m;
    private int n;
    private String palindrome;
    

    public Tabulation(String sequence, String inversedSequence, int m, int n) {
        this.m = m;
        this.n = n;
        this.sequence = sequence;
        this.inversedSequence = inversedSequence;
        matrix = new int[m+1][m+1];
    }
    
    
    @Override                                                                                                          
    public void process() {                                                                                           
        for (int i = 1; i <= n; i++)                                                                                   
        {                                                                                                    
            for (int j = 1; j <= n; j++)                                                                                
            {
                // Si el caracter coincide en la posición, avanzamos                                          
                if (sequence.charAt(i - 1) == inversedSequence.charAt(j - 1)) {                               
                    matrix[i][j] = matrix[i - 1][j - 1] + 1;                                                        
                }                                                                                             
                // Si no coincide, proseguimos con el muestreo                                               
                else {                                                                                        
                    matrix[i][j] = Integer.max(matrix[i - 1][j], matrix[i][j - 1]);                           
                }                                                                                             
            }
        }
        longestNumber = matrix[n][n];                                                                            
        palindrome = longestPalindrome(sequence,inversedSequence,n,n,matrix);
        
    }
    
    private String longestPalindrome(String sequence, String inversedSequence, int m, int n, int[][] matrix){
        if (m == 0 || n == 0) {
            return "";
        }

        // Si el caracter coincide llamamos recocrriendo la matriz por su diagonal
        if (sequence.charAt(m - 1) == inversedSequence.charAt(n - 1))
        {
            return longestPalindrome(sequence, inversedSequence, m - 1, n - 1, matrix) + sequence.charAt(m - 1);
        }
        
        // Si no coinciden:
        
        // Si la celda de arriba es mayor que la celda izquierda
        // entonces la saltamos y movemos el indice
        if (matrix[m - 1][n] > matrix[m][n - 1]) {
            return longestPalindrome(sequence, inversedSequence, m - 1, n, matrix);
        }
        
        // Si la celda izquierda es mayor que la celda superior
        // entonces movemos el puntero superior y avanzamos.
        return longestPalindrome(sequence, inversedSequence, m, n - 1, matrix);
    }
 
 
    @Override
    public String getLongest() {
        return this.longestNumber+"";
    }

    @Override
    public String getPalindrome() {
        return this.palindrome;
    }
        
    }

   

