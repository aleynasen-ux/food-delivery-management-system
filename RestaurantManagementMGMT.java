package takeaway;

import java.sql.*;
import java.util.ArrayList;

public class RestaurantManagement {

    private int mgmt_id;
    private String restaurant_name;
    private String location;

    public RestaurantManagement(int id, String name, String loc) {
        this.mgmt_id = id;
        this.restaurant_name = name;
        this.location = loc;
    }
   
    
    public int getMgmtId() { return mgmt_id; }
    public String getRestaurantName() { return restaurant_name; }
    public String getLocation() { return location; }

    // ADD
    public static void addManagementDB(int id, String name, String loc) {
        String sql = "INSERT INTO restaurant_management (mgmt_id, restaurant_name, location) VALUES (?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, loc);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // UPDATE
    public static void updateManagementDB(int id, String name, String loc) {
        String sql = "UPDATE restaurant_management SET restaurant_name=?, location=? WHERE mgmt_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, name);
            ps.setString(2, loc);
            ps.setInt(3, id);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public static void deleteManagementDB(int id) {
        String sql = "DELETE FROM restaurant_management WHERE mgmt_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // GET BY ID
    public static RestaurantManagement getManagementByIdDB(int id) {
        RestaurantManagement m = null;
        String sql = "SELECT * FROM restaurant_management WHERE mgmt_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                m = new RestaurantManagement(
                        rs.getInt("mgmt_id"),
                        rs.getString("restaurant_name"),
                        rs.getString("location")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return m;
    }

    // GET ALL
    public static ArrayList<RestaurantManagement> getAllManagementsDB() {
        ArrayList<RestaurantManagement> list = new ArrayList<>();
        String sql = "SELECT * FROM restaurant_management";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new RestaurantManagement(
                        rs.getInt("mgmt_id"),
                        rs.getString("restaurant_name"),
                        rs.getString("location")
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
