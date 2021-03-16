package com.assignmentFive.repositories.interfaces;

import com.assignmentFive.entities.Precious;

import java.util.List;

public interface IPreciousRepository {
    boolean createPreciousStone(Precious precious);
    Precious getPreciousStone(int id);
    List<Precious> getAllPreciousStones();
    double getWeight(int id);
    double getCost(int id);
}
