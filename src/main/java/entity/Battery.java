package entity;

import java.util.UUID;

public class Battery {

    String id = UUID.randomUUID().toString();
    String soc = "State of Charge: 100%";

    public Battery() {
        this.id = UUID.randomUUID().toString();
        this.soc = soc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSoc() {
        return soc;
    }

    public void setSoc(String soc) {
        this.soc = soc;
    }
}
