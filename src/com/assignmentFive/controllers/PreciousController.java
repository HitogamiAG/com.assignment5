package com.assignmentFive.controllers;

import com.assignmentFive.entities.Precious;
import com.assignmentFive.repositories.interfaces.IPreciousRepository;

import java.util.List;

public class PreciousController {
    private final IPreciousRepository repo1;


    public PreciousController(IPreciousRepository repo1) {
        this.repo1 = repo1;
    }

    public String createPreciousStone(String name, double weight, double cost){
        Precious precious = new Precious(name, weight, cost);

        boolean created = repo1.createPreciousStone(precious);
        return (created ? "Precious Stone was not created!" : "Precious Stone was created");
    }

    public String getPreciousStone(int id) {
        Precious precious =repo1.getPreciousStone(id);
        return (precious == null? "Precious was not found" : precious.toString());
    }

    public String getAllPreciousStones() {
        List<Precious> preciousStones = repo1.getAllPreciousStones();
        return preciousStones.toString();
    }

    public double getWeight(int id) {
        double weight = repo1.getWeight(id);
        return weight;
    }

    public double getCost(int id) {
        double cost = repo1.getCost(id);
        return cost;
    }
}
