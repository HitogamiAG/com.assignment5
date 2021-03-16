package com.assignmentFive;

import com.assignmentFive.data.PostgresDB;
import com.assignmentFive.data.interfaces.IDB;
import com.assignmentFive.repositories.PreciousRepository;
import com.assignmentFive.repositories.SemiPreciousRepository;
import com.assignmentFive.repositories.interfaces.IPreciousRepository;
import com.assignmentFive.repositories.interfaces.ISemiPreciousRepository;

public class Main {

    public static void main(String[] args) {
        IDB db = new PostgresDB();
        IPreciousRepository repo1 = new PreciousRepository(db);
        ISemiPreciousRepository repo2 = new SemiPreciousRepository(db);
        Application app = new Application(repo1, repo2);
        app.start();
    }

}
