/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import Model.menu.McDonaldsMenu;
import Model.menu.Menu;
import Model.menu.TelepizzaMenu;
import java.util.Iterator;

/**
 * El camarero implementará las dos instancias de menus y también tendrá asociada 
 * una instancia de la interfaz para ver cual se imprime
 * 
 * Dicha instacia es un supertipo Iterator que será quien se implemente en los modelos
 * de manú de cada clase
 */
public class Camarero {
    Menu mcdMenu;
    Menu tlpMenu;
    Menu stbMenu;

    public Camarero(Menu mcdMenu, Menu tlpMenu, Menu stbMenu) {
        this.mcdMenu = mcdMenu;
        this.tlpMenu = tlpMenu;
        this.stbMenu = stbMenu;
    }

    /**
     * El método del camarero justifica la asociación indicada en el modelo UML, 
     * aquí se crea el sistema de iteradoress definido.
     */
    public void imprimeMenu(){
        System.out.println("HAMBUGUESAS");
        imprimeMenu(mcdMenu.createIterator());
        System.out.println("PIZZAS");
        imprimeMenu(tlpMenu.createIterator());
        System.out.println("CAFES");
        imprimeMenu(stbMenu.createIterator());
    }
    
    /**
     * Este método de sobrecarga (redefinido igual pero con un parámetro de más), 
     * indicado   
     */
    public void imprimeMenu(Iterator iter){
        while(iter.hasNext()){
            MenuItem item = (MenuItem) iter.next();
            System.out.println(item.getName()+", "
                    +item.getPrice()+" - "
                    +item.getDescription());
        }
    }
}
