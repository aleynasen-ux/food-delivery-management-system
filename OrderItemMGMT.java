package takeaway;

import java.sql.*;
import java.util.ArrayList;

public class OrderItem {

    private int order_item_id;
    private int order_id;
    private int item_id;
    private int quantity;

    public OrderItem(int oid, int orderId, int itemId, int qty) {
        this.order_item_id = oid;
        this.order_id = orderId;
        this.item_id = itemId;
        this.quantity = qty;
    }

    public int getOrderItemId() { return order_item_id; }
    public int getOrderId() { return order_id; }
    public int getItemId() { return item_id; }
    public int getQuantity() { return quantity; }

    // ADD
    public static void addOrderItemDB(int oid, int orderId, int itemId, int qty) {
        String sql = "INSERT INTO order_item (order_item_id, order_id, item_id, quantity) VALUES (?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, oid);
            ps.setInt(2, orderId);
            ps.setInt(3, itemId);
            ps.setInt(4, qty);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // UPDATE
    public static void updateOrderItemDB(int oid, int orderId, int itemId, int qty) {
        String sql = "UPDATE order_item SET order_id=?, item_id=?, quantity=? WHERE order_item_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, orderId);
            ps.setInt(2, itemId);
            ps.setInt(3, qty);
            ps.setInt(4, oid);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public static void deleteOrderItemDB(int oid) {
        String sql = "DELETE FROM order_item WHERE order_item_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, oid);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // GET BY ID
    public static OrderItem getOrderItemByIdDB(int oid) {
        OrderItem oi = null;
        String sql = "SELECT * FROM order_item WHERE order_item_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, oid);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                oi = new OrderItem(
                        rs.getInt("order_item_id"),
                        rs.getInt("order_id"),
                        rs.getInt("item_id"),
                        rs.getInt("quantity")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return oi;
    }

    // GET ALL
    public static ArrayList<OrderItem> getAllOrderItemsDB() {
        ArrayList<OrderItem> list = new ArrayList<>();
        String sql = "SELECT * FROM order_item";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new OrderItem(
                        rs.getInt("order_item_id"),
                        rs.getInt("order_id"),
                        rs.getInt("item_id"),
                        rs.getInt("quantity")
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
