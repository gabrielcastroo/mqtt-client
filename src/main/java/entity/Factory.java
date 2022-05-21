package entity;

import utils.GenerateRandomStringID;

import java.util.ArrayList;
import java.util.List;

public class Factory {

    String id = GenerateRandomStringID.getSaltString();
    String nome = "";
    List<Motorcycle> motorcycles = new ArrayList<>();

}
