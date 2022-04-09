/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ulpgc.gs1.persistence;

import es.ulpgc.gs1.model.data.RegisterData;
import es.ulpgc.gs1.model.data.RegisterDataAdv;
import es.ulpgc.gs1.model.data.RegisterDataAlojamiento;
import javax.swing.JDialog;
/**
 *
 * @author Usuario
 */
public interface RegistrySystem {
    public boolean register(RegisterData registerData, JDialog parent);
    
    public boolean registerAdv(RegisterDataAdv registerDataAdv, JDialog parent );
    
    public boolean registerAlojamiento(RegisterDataAlojamiento registerDataAlojamiento, JDialog parent );
}
