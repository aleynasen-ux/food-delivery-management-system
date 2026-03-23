package takeaway;

import java.sql.*;
import java.util.ArrayList;

public class MenuItem {

    private int item_id;
    private String item_name;
    private double price;

    public MenuItem(int id, String name, double price) {
        this.item_id = id;
        this.item_name = name;
        this.price = price;
    }

    public int getItemId() { return item_id; }
    public String getItemName() { return item_name; }
    public double getPrice() { return price; }

    // ADD
    public static void addMenuItemDB(int id, String name, double price) {
        String sql = "INSERT INTO menu_item (item_id, item_name, price) VALUES (?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setDouble(3, price);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // UPDATE
    public static void updateMenuItemDB(int id, String name, double price) {
        String sql = "UPDATE menu_item SET item_name=?, price=? WHERE item_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, name);
            ps.setDouble(2, price);
            ps.setInt(3, id);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public static void deleteMenuItemDB(int id) {
        String sql = "DELETE FROM menu_item WHERE item_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // GET BY ID
    public static MenuItem getMenuItemByIdDB(int id) {
        MenuItem m = null;
        String sql = "SELECT * FROM menu_item WHERE item_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                m = new MenuItem(
                        rs.getInt("item_id"),
                        rs.getString("item_name"),
                        rs.getDouble("price")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return m;
    }

    // GET ALL
    public static ArrayList<MenuItem> getAllMenuItemsDB() {
        ArrayList<MenuItem> list = new ArrayList<>();
        String sql = "SELECT * FROM menu_item";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new MenuItem(
                        rs.getInt("item_id"),
                        rs.getString("item_name"),
                        rs.getDouble("price")
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
