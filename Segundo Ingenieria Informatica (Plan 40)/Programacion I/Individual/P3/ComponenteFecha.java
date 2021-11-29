import java.util.*;
public class ComponenteFecha extends Componente {
    private Date fecha;

    /**
     * Constructor default.
     * 
     * @param   Date    fecha suinistrada.
     */
    public ComponenteFecha(Date newfecha){
        super();
        this.fecha = (Date) newfecha.clone();
    }
    /**
     * Devuelve un nuevo objeto copia del actual. 
     * El objeto copiado es independiente del original.
     */
    public ComponenteFecha copia(){
        ComponenteFecha res = new ComponenteFecha(this.fecha);
        return res;
    }
    /**
     * Devuelve una String que representa el componente.
     */ 
    @Override
    public String toString(){
        Calendar calendario = new GregorianCalendar();
        calendario.setTime(this.fecha);
        return (calendario.get(Calendar.DATE)+"/"+
        (calendario.get(Calendar.MONTH)+1)+"/"+
        calendario.get(Calendar.YEAR));
    }
}