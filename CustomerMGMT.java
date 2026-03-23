package takeaway;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Customer {

    private int customer_id;
    private String name;
    private String phone;
    private String address;

   
    public Customer(int id, String name, String phone, String address) {
        this.customer_id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

  
    public int getCustomerId() { return customer_id; }
    public String getName() { return name; }
    public String getPhone() { return phone; }
    public String getAddress() { return address; }


   public static void addCustomerDB(int id, String name, String phone, String address) {
    try {
        System.out.println("ADD CUSTOMER METHOD CALLED");

        java.sql.Connection con = DBConnection.getConnection();
        String sql = "INSERT INTO customer (customer_id, name, phone, address) VALUES (?, ?, ?, ?)";
        java.sql.PreparedStatement pst = con.prepareStatement(sql);

        pst.setInt(1, id);
        pst.setString(2, name);
        pst.setString(3, phone);
        pst.setString(4, address);

        int rows = pst.executeUpdate();
        System.out.println("Inserted rows: " + rows);

        con.close();
    } catch (Exception e) {
        e.printStackTrace(); // BU ÇOK ÖNEMLİ
    }
}


   public static Customer getCustomerByIdDB(int id) {
    Customer c = null;

    try {
        java.sql.Connection con = DBConnection.getConnection();
        String sql = "SELECT * FROM customer WHERE customer_id = ?";
        java.sql.PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, id);

        java.sql.ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            c = new Customer(
                rs.getInt("customer_id"),
                rs.getString("name"),
                rs.getString("phone"),
                rs.getString("address")
            );
        }

        con.close();
    } catch (Exception e) {
        e.printStackTrace();
    }

    return c;
}

    public static void updateCustomerDB(int id, String name, String phone, String address) {
        String sql = "UPDATE customer SET name=?, phone=?, address=? WHERE customer_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, name);
            ps.setString(2, phone);
            ps.setString(3, address);
            ps.setInt(4, id);

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

 
    public static void deleteCustomerDB(int id) {
        String sql = "DELETE FROM customer WHERE customer_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static java.util.ArrayList<Customer> getAllCustomersDB() {
    java.util.ArrayList<Customer> list = new java.util.ArrayList<>();

    try {
        java.sql.Connection con = DBConnection.getConnection();
        String sql = "SELECT * FROM customer";
        java.sql.PreparedStatement pst = con.prepareStatement(sql);
        java.sql.ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            Customer c = new Customer(
                rs.getInt("customer_id"),
                rs.getString("name"),
                rs.getString("phone"),
                rs.getString("address")
            );
            list.add(c);
        }

        con.close();
    } catch (Exception e) {
        e.printStackTrace();
    }

    return list;
}
}
