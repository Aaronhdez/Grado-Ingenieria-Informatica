package algorithm;

import java.util.HashMap;
import java.util.Map;
import persistence.algorithm.ProgramingStrategy;

public class Memoization implements ProgramingStrategy {
    private Map<String, Integer> dict;
    private int longestNumber;
    private int left;
    private int right;
    private String sequence;
    private String palindrome;
    
    public Memoization(String sequence,int left, int right){
        this.dict = new HashMap<String, Integer>();
        this.left = left;
        this.right = right;
        this.sequence = sequence;
    }

    @Override
    public void process() {  
        this.longestNumber= lpsSolve(dict,this.left,this.right,this.sequence);
        this.palindrome=longestPalindrome(sequence,left,right,dict);
    }


    private int lpsSolve(Map<String, Integer> dict, int left, int right, String sequence) {
        String key = left + "|" + right;
        
        // Condición de retorno cuando la dicotomía ha finalizado (secuencias pares)
        if (left > right) {
            dict.put(key,0);
        }
        
        // Condición de retorno cuando la dicotomía ha finalizado (secuencias impares)
        if (left == right) {
            dict.put(key,1);
        }
        

        if (!dict.containsKey(key))
        {
            if (sequence.charAt(left) == sequence.charAt(right)) {
                dict.put(key, lpsSolve(dict, left + 1, right - 1, sequence) + 2);
            }
            else {
                 /*
                Si no lo es significa que ambos no son palíndromos, así que 
                seguimos buscando tanto por la izquierda como por la derecha
                (desfasando los indices) para ver si existe alguna otra 
                subsecuencia palindrómica. 
                */          
                 
                 int max = Integer.max(lpsSolve(dict, left, right - 1, sequence),
                                        lpsSolve(dict, left + 1, right, sequence));
 
            dict.put(key,max);
            }
        }
        return dict.get(key);
    }
    
    private String longestPalindrome(String sequence, int m, int n, Map<String, Integer> dict){
        if (m > n) {
            return "";
        }
        
        if (m == n){
            return sequence.charAt(n)+"";
        }
        
        String key = m + "|" + n;
        
        if (dict.containsKey(key)){
            // Si el caracter coincide llamamos recocrriendo la matriz por su diagonal
            if (sequence.charAt(m) == sequence.charAt(n)){
                return sequence.charAt(n) + longestPalindrome(sequence, m+1 , n-1 , dict) +  sequence.charAt(n);
            }
        }
        
        // Si no coinciden
        int substractn = n - 1;
        String key1 = m+1 + "|" + n ;
        String key2 = m + "|" + substractn ;
 
        // Si la celda de arriba es mayor que la celda izquierda
        // entonces la saltamos y movemos el indice
        if (dict.containsKey(key1) && dict.containsKey(key2)) {
            if (dict.get(key1) > dict.get(key2)){
                return longestPalindrome(sequence, m + 1, n, dict);
            }
            
             // Si la celda izquierda es mayor que la celda superior
            // entonces movemos el puntero superior y avanzamos.
            return longestPalindrome(sequence, m, n - 1, dict);
        }
        return "";
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
