package com.assignmentFive;

import com.assignmentFive.controllers.PreciousController;
import com.assignmentFive.controllers.SemiPreciousController;
import com.assignmentFive.repositories.interfaces.IPreciousRepository;
import com.assignmentFive.repositories.interfaces.ISemiPreciousRepository;

import java.util.Scanner;

public class Application {
    private final PreciousController controller1;
    private final SemiPreciousController controller2;
    private final Scanner scanner;

    public Application(IPreciousRepository repo1, ISemiPreciousRepository repo2){
        scanner = new Scanner(System.in);
        controller1 =new PreciousController(repo1);
        controller2 = new SemiPreciousController(repo2);
    }

    public void start() {
        while(true) {
            System.out.println("Welcome to GemCalculator!");
            System.out.println("*************************");
            System.out.println("Enter numbers to work with program");
            System.out.println("1. Precious Stones Menu");
            System.out.println("2. Semi-Precious Stones Menu");
            System.out.println("3. Show Precious Stones table");
            System.out.println("4. Show Semi-Precious Stones table");
            System.out.println("5. Weight Calculator");
            System.out.println("6. Price Calculator");
            System.out.println("7. Weight&Cost Calculator");
            System.out.println("8. Exit program");
            System.out.println("*************************");

            switch(scanner.nextInt()){
            case 8 -> {
                System.out.println("Good bye!");
                break;
            }
            case 1 -> {
                while(true){
                    System.out.println("Choose option(1-3):");
                    System.out.println("1. Get Precious Stone by id");
                    System.out.println("2. Add Precious Stone");
                    System.out.println("3. Back to Main Menu");
                    switch (scanner.nextInt()){
                    case 3 -> {
                        break;
                    } case 1 -> {
                        getPreciousStoneById();
                    } case 2 -> {
                        createPreciousStone();
                    }
                    default -> System.out.println("Wrong input");}
                }
            } case 2 -> {
                while(true){
                    System.out.println("Choose option(1-3):");
                    System.out.println("1. Get Semi-Precious Stone by id");
                    System.out.println("2. Add Semi-Precious Stone");
                    System.out.println("3. Back to Main Menu");
                    switch (scanner.nextInt()){
                    case 3 -> {
                        break;
                    } case 1 -> {
                        getSemiPreciousStoneById();
                    } case 2 -> {
                        createSemiPreciousStone();
                    } default -> System.out.println("Wrong input!");}
                }
            } case 3 -> {
                getAllPreciousStones();
            } case 4 -> {
                getAllSemiPreciousStones();
            } case 5 -> {
                System.out.println("Welcome to GemWeight Calculator:");
                weightCalculator();
            } case 6 -> {
                System.out.println("Welcome to GemCost Calculator:");
                costCalculator();
            } case 7 -> {
                System.out.println("Welcome to Weight&Cost Calculator:");
                totalCalculator();
            }
            default -> System.out.println("Wrong input");
            }
        }
    }

    public void getPreciousStoneById() {
        System.out.println("Enter id:");

        int id = scanner.nextInt();
        String response = controller1.getPreciousStone(id);
        System.out.println(response);
    }

    public void createPreciousStone() {
        System.out.println("Enter name:");
        String name = scanner.next();
        System.out.println("Enter weight:");
        double weight = scanner.nextDouble();
        System.out.println("Enter cost:");
        double cost = scanner.nextDouble();

        String response = controller1.createPreciousStone(name, weight, cost);
        System.out.println(response);
    }

    public void getSemiPreciousStoneById() {
        System.out.println("Enter id:");

        int id = scanner.nextInt();
        String response = controller2.getPreciousStone(id);
        System.out.println(response);
    }

    public void createSemiPreciousStone() {
        System.out.println("Enter name:");
        String name = scanner.next();
        System.out.println("Enter weight:");
        double weight = scanner.nextDouble();
        System.out.println("Enter cost:");
        double cost = scanner.nextDouble();

        String response =controller2.createPreciousStone(name, weight, cost);
        System.out.println(response);
    }

    public void getAllPreciousStones() {
        String response = controller1.getAllPreciousStones();
        System.out.println(response);
    }

    public void getAllSemiPreciousStones() {
        String response = controller2.getAllSemiPreciousStones();
        System.out.println(response);
    }

    public void weightCalculator() {
        double sumPreciousWeight = 0;
        double sumSemiPreciousWeight = 0;
        System.out.println("Enter ids of PRECIOUS stones(divide them by enter):");
        System.out.println("Enter 1234 to go to semiprecious stones");
        while(true){
        int id = scanner.nextInt();
        if(id == 1234){break;}
        double weight = controller1.getWeight(id);
        sumPreciousWeight += weight;
        }
        System.out.println("Enter ids of SEMIPRECIOUS stones(divide them by enter):");
        System.out.println("Enter 1234 to finish");
        while(true){
            int id = scanner.nextInt();
            if(id == 1234){break;}
            double weight = controller2.getWeight(id);
            sumSemiPreciousWeight += weight;
        }
        System.out.println("Total weight: " + (sumPreciousWeight+sumSemiPreciousWeight));
    }

    public void costCalculator() {
        double sumPreciousCost = 0;
        double sumSemiPreciousCost = 0;
        System.out.println("Enter ids of PRECIOUS stones(divide them by enter):");
        System.out.println("Enter 1234 to go to semiprecious stones");
        while(true){
            int id = scanner.nextInt();
            if(id == 1234){break;}
            double cost = controller1.getCost(id);
            sumPreciousCost += cost;
        }
        System.out.println("Enter ids of SEMIPRECIOUS stones(divide them by enter):");
        System.out.println("Enter 1234 to finish");
        while(true){
            int id = scanner.nextInt();
            if(id == 1234){break;}
            double cost = controller2.getCost(id);
            sumSemiPreciousCost += cost;
        }
        System.out.println("Total cost: " + (sumPreciousCost+sumSemiPreciousCost));
    }

    public void totalCalculator() {
        double sumPreciousWeight = 0;
        double sumSemiPreciousWeight = 0;
        double sumPreciousCost = 0;
        double sumSemiPreciousCost = 0;
        System.out.println("Enter ids of PRECIOUS stones(divide them by enter):");
        System.out.println("Enter 1234 to go to semiprecious stones");
        while(true){
            int id = scanner.nextInt();
            if(id == 1234){break;}
            double cost = controller1.getCost(id);
            sumPreciousCost += cost;
            double weight = controller1.getWeight(id);
            sumPreciousWeight += weight;
        }
        System.out.println("Enter ids of SEMIPRECIOUS stones(divide them by enter):");
        System.out.println("Enter 1234 to finish");
        while(true){
            int id = scanner.nextInt();
            if(id == 1234){break;}
            double cost = controller2.getCost(id);
            sumSemiPreciousCost += cost;
            double weight = controller2.getWeight(id);
            sumSemiPreciousWeight += weight;
        }
        System.out.println("Total weight: " + (sumPreciousWeight+sumSemiPreciousWeight));
        System.out.println("Total cost: " + (sumPreciousCost+sumSemiPreciousCost));
    }
}
