package entity;

public class DataPackage {

    Battery battery = new Battery();

    public DataPackage() {
        this.battery = battery;
    }

    public Battery getBattery() {
        return battery;
    }

    public void setBattery(Battery battery) {
        this.battery = battery;
    }
}
