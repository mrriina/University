package com.example.spp_lab2;

import java.sql.*;

public class DatabaseHandler extends Config {
    Connection dbConnection;

    public DatabaseHandler() {
        try {
            dbConnection = DriverManager.getConnection(dbURL, dbUser, dbPassword);

            if (dbConnection != null) {
                System.out.println("Connected to 'warehouses'");
            }
            else{
                System.out.println("Failed connection!");
            }

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getClients() throws SQLException {

//        ============  SELECT  ===========
//        String sql = "SELECT * FROM product";
//        Statement statement = dbConnection.createStatement();
//        ResultSet rs = statement.executeQuery(sql);
//
//        while (rs.next()) {
//            System.out.println(rs.getInt("idproduct") + " : " + rs.getString("name") + ", " + rs.getString("model") + ", " + rs.getString("price"));
//        }




//        ============  INSERT  ===========
//        String sql = "INSERT INTO product (name, model, price) VALUES (?,?,?)";
//        PreparedStatement ps = dbConnection.prepareStatement(sql);
//        ps.setString(1, "prod3");
//        ps.setString(2, "sesrt");
//        ps.setInt(3, 88);
//        ps.executeUpdate();




//        ============  DELETE  ===========
//          String sql = "DELETE FROM product WHERE idproduct=?";
//          PreparedStatement ps = dbConnection.prepareStatement(sql);
//          ps.setInt(1, 7);
//          ps.executeUpdate();




//        ============  UPDATE  ===========
//          String sql = "UPDATE product SET model=? WHERE idproduct=?";
//          PreparedStatement ps = dbConnection.prepareStatement(sql);
//          ps.setString(1, "new");
//          ps.setInt(2, 2);
//          ps.executeUpdate();

    }
}

