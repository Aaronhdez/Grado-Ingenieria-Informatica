/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ulpgc.diu.app.helpers;

/**
 *
 * @author Usuario
 */
public class Helper {
    public static String getHelpInfo(){
        return "Ayuda:\n"
                + "1. Haga clic en Abrir para seleccionar la imagen\n"
                + "2. Haciendo clic en Editar le aparecerá un diálogo solicitando el factor de realce:\n"
                + "   - Debe ser Entero.\n"
                + "   - Puede realzarse cuantas veces se quiera.\n"
                + "   - El resultado previo no se conserva (se realza desde la imagen original).\n"
                + "3. Haga click en Guardar una vez haya finalizado para conservar sus cambios";       
    }
}
