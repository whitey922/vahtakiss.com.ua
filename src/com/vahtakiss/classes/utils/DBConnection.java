package com.vahtakiss.classes.utils;

//import com.vahtakiss.classes.User;

import com.vahtakiss.classes.basement.Beverage;
import com.vahtakiss.classes.basement.BeverageFactory;

import java.sql.*;
import java.util.HashMap;

public class DBConnection {
    private static final String dbName = "gbua_vahtakiss";
    private static final String dbUser = "gbua_vahtakiss";
    private static final String dbPass = "mysql301.1gb.ua";
    private static DBConnection instance;
    private Connection connection;

    public static DBConnection getInstance() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        if (instance == null) {
            instance = new DBConnection(String.format("jdbc:mysql://mysql301.1gb.ua/gbua_vahtakiss?user=gbua_vahtakiss&password=677afec7789", new Object[0]));
        }

        return instance;
    }

    public DBConnection(String dbURL) throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        this.connection = DriverManager.getConnection(dbURL);
    }

//    public List<User> getUsersList() {
//        ArrayList userList = null;
//
//        try {
//            Statement e = this.connection.createStatement();
//            ResultSet rs = e.executeQuery("select * from users");
//            userList = new ArrayList();
//
//            while(rs.next()) {
//                String uid = rs.getString("uid");
//                String surname = rs.getString("surname");
//                String name = rs.getString("name");
//                String urlPhoto = rs.getString("url_photo");
//                userList.add(new User(uid, surname, name, urlPhoto));
//            }
//        } catch (Exception var8) {
//            var8.printStackTrace();
//        }
//
//        return userList;
//    }

    public void addUser(String uid, String surname, String name, String urlPhoto) throws SQLException {
        String query = "INSERT INTO users(uid, first_name, last_name, photo) values (?, ?, ?, ?)";
        PreparedStatement preparedStmt = this.connection.prepareStatement(query);
        preparedStmt.setString(1, uid);
        preparedStmt.setString(2, name);
        preparedStmt.setString(3, surname);
        preparedStmt.setString(4, urlPhoto);
        preparedStmt.execute();
    }

    public HashMap<String, Beverage> getUsualOrders(String uid) {
        BeverageFactory factory = new BeverageFactory();
        HashMap<String, Beverage> beverageMap = new HashMap<String, Beverage>();

        try {
            String query = "select * from usual_order WHERE uid=?";
            PreparedStatement preparedStmt = this.connection.prepareStatement(query);
            preparedStmt.setString(1, uid);
            ResultSet rs = preparedStmt.executeQuery();
            while (rs.next()) {
                HashMap<String, String> mapUsualOrder = new HashMap<String, String>();
                String id = rs.getString("id");
                mapUsualOrder.put("coffee", rs.getString("coffee"));
                mapUsualOrder.put("sugar", rs.getString("sugar"));
                mapUsualOrder.put("milk", rs.getString("milk"));
                mapUsualOrder.put("nuts", rs.getString("nuts"));
                mapUsualOrder.put("syrup", rs.getString("syrup"));
                mapUsualOrder.put("zephyr", rs.getString("zephyr"));
                beverageMap.put(id, factory.createBeverage(mapUsualOrder));
            }
        } catch (Exception var8) {
            var8.printStackTrace();
        }
        return beverageMap;
    }
}
