package com.assignmentFive.repositories.interfaces;

import com.assignmentFive.entities.SemiPrecious;

import java.util.List;

public interface ISemiPreciousRepository {
    boolean createSemiPreciousStone(SemiPrecious precious);
    SemiPrecious getSemiPreciousStone(int id);
    List<SemiPrecious> getAllSemiPreciousStones();
    double getWeight(int id);
    double getCost(int id);
}