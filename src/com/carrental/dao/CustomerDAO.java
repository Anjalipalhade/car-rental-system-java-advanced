package com.carrental.dao;

import java.sql.*;
import com.carrental.util.DBConnection;

public class CustomerDAO {

    public void addCustomer(String name , String phone) {
        String sql = "INSERT INTO customer(name , phone) VALUES (?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, name);
            ps.setString(2, phone);
            ps.executeUpdate();

            System.out.println("Customer added Successfuly");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
