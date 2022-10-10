package entity.embedded;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;
import javax.validation.constraints.Size;

@Embeddable
public class AgentData implements Serializable {
    @Size(max = 50)
    private String agentName;
    @Size(max = 50)
    private String agentPassword;

    public AgentData(String name, String password) {
        this.agentName = name;
        this.agentPassword = password;
    }

    public AgentData() {
    }

    public String getName() {
        return agentName;
    }

    public void setName(String name) {
        this.agentName = name;
    }

    public String getPassword() {
        return agentPassword;
    }

    public void setPassword(String password) {
        this.agentPassword = password;
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
        final AgentData other = (AgentData) obj;
        if (!Objects.equals(this.agentName, other.agentName)) {
            return false;
        }
        return Objects.equals(this.agentPassword, other.agentPassword);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.agentName);
        hash = 29 * hash + Objects.hashCode(this.agentPassword);
        return hash;
    }
}
