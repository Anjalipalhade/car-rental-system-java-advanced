package com.carrental.dao;

import java.sql.*;
import com.carrental.util.DBConnection;

public class RentalDAO {

    public void rentCar(int carId, int customerId) {
        try (Connection con = DBConnection.getConnection()) {

            String rentSql =
                    "INSERT INTO rental(car_id, customer_id) VALUES (?, ?)";
            PreparedStatement ps = con.prepareStatement(rentSql);
            ps.setInt(1, carId);
            ps.setInt(2, customerId);
            ps.executeUpdate();

            String updateSql =
                    "UPDATE car SET available = false WHERE car_id = ?";
            PreparedStatement ps2 = con.prepareStatement(updateSql);
            ps2.setInt(1, carId);
            ps2.executeUpdate();

            System.out.println("Car rented successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
