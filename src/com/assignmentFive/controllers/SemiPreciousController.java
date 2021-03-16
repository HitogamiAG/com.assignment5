package com.assignmentFive.controllers;

import com.assignmentFive.entities.SemiPrecious;
import com.assignmentFive.repositories.interfaces.ISemiPreciousRepository;

import java.util.List;

public class SemiPreciousController {
    private final ISemiPreciousRepository repo2;


    public SemiPreciousController(ISemiPreciousRepository repo2) {
        this.repo2 = repo2;
    }

    public String createPreciousStone(String name, double weight, double cost){
        SemiPrecious semiPrecious = new SemiPrecious(name, weight, cost);

        boolean created = repo2.createSemiPreciousStone(semiPrecious);
        return (created ? "SemiPrecious Stone was not created!" : "SemiPrecious Stone was created");
    }

    public String getPreciousStone(int id) {
        SemiPrecious semiPrecious =repo2.getSemiPreciousStone(id);
        return (semiPrecious == null? "Precious was not found" : semiPrecious.toString());
    }

    public String getAllSemiPreciousStones() {
        List<SemiPrecious> preciousStones = repo2.getAllSemiPreciousStones();
        return preciousStones.toString();
    }

    public double getWeight(int id) {
        double weight = repo2.getWeight(id);
        return weight;
    }

    public double getCost(int id) {
        double cost = repo2.getCost(id);
        return cost;
    }
}