/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.embedded;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;
import javax.validation.constraints.Size;

@Embeddable
public class ClientData implements Serializable {
    @Size(max = 50)
    private String clientName;
    @Size(max = 50)
    private String clientPassword;

    public ClientData(String name, String password) {
        this.clientName = name;
        this.clientPassword = password;
    }

    public ClientData() {
    }

    public String getName() {
        return clientName;
    }

    public void setName(String name) {
        this.clientName = name;
    }

    public String getPassword() {
        return clientPassword;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ClientData other = (ClientData) obj;
        if (!Objects.equals(this.clientName, other.clientName)) {
            return false;
        }
        if (!Objects.equals(this.clientPassword, other.clientPassword)) {
            return false;
        }
        return true;
    }
    
    
}
