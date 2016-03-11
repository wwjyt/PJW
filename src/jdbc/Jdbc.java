package jdbc;

import shop.Customer;

import java.sql.*;
import java.util.ArrayList;

public class Jdbc {

    private static Connection getConn() {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/shop";
        String username = "root";
        String password = "return";
        Connection conn = null;
        try {
            Class.forName(driver);
            conn = (Connection) DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static int insert(Customer customer) {
        Connection conn = getConn();
        int i = 0;
        String sql = "INSERT INTO customer (C_id,name) VALUES (?,?)";
        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setInt(1, customer.getC_id());
            pstmt.setString(2, customer.getName());
            i = pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

    public static int update(Customer customer) {
        Connection conn = getConn();
        int i = 0;
        String sql = "UPDATE customer SET name = '"+customer.getName()+"' WHERE C_id = '"+customer.getC_id()+"'";
        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            i = pstmt.executeUpdate();
            System.out.println("resutl: " + i);
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

    public static int delete(String name) {
        Connection conn = getConn();
        int i = 0;
        String sql = "DELETE FROM customer WHERE NAME ='" + name + "'";
        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            i = pstmt.executeUpdate();
            System.out.println("resutl: " + i);
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

    public static ArrayList<Customer> getAll() {
        Connection conn = getConn();
        String sql = "SELECT * FROM customer";
        PreparedStatement pstmt;
        ArrayList<Customer> list = new ArrayList<Customer>();
        try {
            pstmt = (PreparedStatement)conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            int col = rs.getMetaData().getColumnCount();
            System.out.println("============================");
            while (rs.next()) {
                Customer customer = new Customer();
                customer.setC_id(rs.getInt("C_id"));
                customer.setName(rs.getString("name"));
                list.add(customer);
                for (int i = 1; i <= col; i++) {
                    System.out.print(rs.getString(i) + "\t");
                    if ((i == 2) && (rs.getString(i).length() < 8)) {
                        System.out.print("\t");
                    }
                }
                System.out.println("");
            }
            System.out.println("============================");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
