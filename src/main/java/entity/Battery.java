package entity;

import java.util.UUID;
import java.util.Random;

public class Battery {

    String id = UUID.randomUUID().toString();
    int soc = new Random().nextInt(100)+1;

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

    public int getSoc() {
        return soc;
    }

    public void setSoc(int soc) {
        this.soc = soc;
    }
}
