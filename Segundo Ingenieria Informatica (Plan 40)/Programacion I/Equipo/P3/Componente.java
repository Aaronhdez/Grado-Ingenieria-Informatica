/**
 * @author Aaron Hernandez, Victor Zuluaga, Javier Suarez
 * @version 11/11/2019
 */
public abstract class Componente{
    
    /*-----METODOS-----*/
    @Override
    public abstract String toString();
    public int nCaracteres(){
        String s = this.toString();
        int contador = 0;
        for (int i = 0;i < s.length();i++){
            if(!(s.charAt(i)==' ')){
                contador++;
            }
        }
        return contador;
    }
    public int nPalabras(){
        String s = this.toString();
        int contador = 0;
        boolean b = false;
        for (int i = 0;i < s.length();i++){
            if(!(s.charAt(i)==' ') && b == false){
                contador++;
                b = true;
            }
            if(s.charAt(i)==' '){
                b = false;
            }
        }
        return contador;
    }
    public abstract Componente copia();
    
}