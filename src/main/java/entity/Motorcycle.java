package entity;

import utils.GenerateRandomStringID;

import java.util.Random;

public class Motorcycle {

    String chassi = GenerateRandomStringID.getSaltString();
    DataPackage dataPackage = new DataPackage();

    public Motorcycle() {
        this.chassi = chassi;
        this.dataPackage = dataPackage;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public DataPackage getDataPackage() {
        return new DataPackage();
    }
}
