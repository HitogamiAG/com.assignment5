package com.assignmentFive.entities;

public class Stone {
    private int id;
    private String name;
    private double weight;
    private double cost;

    public Stone(String name, double weight, double cost){
        this.name = name;
        this.weight= weight;
        this.cost= cost;
    }

    public Stone(int id, String name, double weight, double cost){
        this.id= id;
        this.name = name;
        this.weight= weight;
        this.cost= cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                        ", name='" + name + '\'' +
                        ", weight=" + weight +
                        ", cost=" + cost +
                        '}' + '\n';
    }
}
