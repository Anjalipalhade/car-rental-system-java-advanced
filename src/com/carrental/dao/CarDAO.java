package com.carrental.dao;

import com.carrental.util.DBConnection;
import java.sql.*;

public class CarDAO {

    public void addCar(String name, String model, double price) {
        Connection con = DBConnection.getConnection();
        if (con == null) return;

        String sql = "INSERT INTO car(name, model, price_per_day, available) VALUES (?, ?, ?, true)";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setString(2, model);
            ps.setDouble(3, price);
            ps.executeUpdate();
            System.out.println("✅ Car added successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showAvailableCars() {
        String sql = "SELECT * FROM car WHERE available = true";

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            System.out.println("\nAvailable Cars:");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("car_id") + " | " +
                                rs.getString("name") + " | " +
                                rs.getString("model") + " | ₹" +
                                rs.getDouble("price_per_day")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
