package com.assignmentFive.repositories;

import com.assignmentFive.data.interfaces.IDB;
import com.assignmentFive.entities.Precious;
import com.assignmentFive.repositories.interfaces.IPreciousRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PreciousRepository implements IPreciousRepository {
    private final IDB db;

    public PreciousRepository(IDB db) {
        this.db = db;
    }

    @Override
    public boolean createPreciousStone(Precious precious) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO precious(name,weight,cost) VALUES (?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, precious.getName());
            st.setDouble(2, precious.getWeight());
            st.setDouble(3, precious.getCost());


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
    public Precious getPreciousStone(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name,weight,cost FROM precious WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Precious precious = new Precious(rs.getInt("id"),
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
    public List<Precious> getAllPreciousStones() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name,weight,cost FROM precious";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Precious> preciousStones = new ArrayList<>();
            while (rs.next()) {
                Precious user = new Precious(rs.getInt("id"),
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
            String sql = "SELECT weight FROM precious WHERE id=?";
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
            String sql = "SELECT cost FROM precious WHERE id=?";
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
