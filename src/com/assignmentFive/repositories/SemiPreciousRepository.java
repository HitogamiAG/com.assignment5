package com.assignmentFive.repositories;

import com.assignmentFive.data.interfaces.IDB;
import com.assignmentFive.entities.SemiPrecious;
import com.assignmentFive.repositories.interfaces.ISemiPreciousRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SemiPreciousRepository implements ISemiPreciousRepository {
    private final IDB db;

    public SemiPreciousRepository(IDB db) {
        this.db = db;
    }

    @Override
    public boolean createSemiPreciousStone(SemiPrecious semiPrecious) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO semiprecious(name,weight,cost) VALUES (?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, semiPrecious.getName());
            st.setDouble(2, semiPrecious.getWeight());
            st.setDouble(3, semiPrecious.getCost());


            boolean executed = st.execute();
            return executed;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public SemiPrecious getSemiPreciousStone(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name,weight,cost FROM semiprecious WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                SemiPrecious precious = new SemiPrecious(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("weight"),
                        rs.getDouble("cost"));

                return precious;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<SemiPrecious> getAllSemiPreciousStones() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name,weight,cost FROM semiprecious";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<SemiPrecious> preciousStones = new ArrayList<>();
            while (rs.next()) {
                SemiPrecious user = new SemiPrecious(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("weight"),
                        rs.getDouble("cost"));

                preciousStones.add(user);
            }

            return preciousStones;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    public double getWeight(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT weight FROM semiprecious WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                double weight =
                        rs.getDouble("weight");

                return weight;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return 0;
    }

    public double getCost(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT cost FROM semiprecious WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                double cost =
                        rs.getDouble("cost");

                return cost;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return 0;
    }
}
