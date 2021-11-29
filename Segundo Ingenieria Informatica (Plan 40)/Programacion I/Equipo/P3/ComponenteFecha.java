import java.util.*;
public class ComponenteFecha extends Componente{
    /*-----ATRIBUTOS-----*/
    private Date fecha;
    
    /*-----CONSTRUCTOR-----*/
    public ComponenteFecha(Date fecha){
        this.fecha = (Date) fecha.clone();
    }
    
    /*-----METODOS-----*/
    @Override
    public String toString(){
        Calendar calendario = new GregorianCalendar();
        calendario.setTime(this.fecha);
        return calendario.get(Calendar.DATE)+"/"+
        (calendario.get(Calendar.MONTH)+1)+"/"+
        calendario.get(Calendar.YEAR);
    }
    
    @Override
    public Componente copia(){
        return new ComponenteFecha(this.fecha);
    }
    
}