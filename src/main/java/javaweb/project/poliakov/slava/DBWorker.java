package javaweb.project.poliakov.slava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by SiXFOiL on 10.08.2017.
 */
public class DBWorker {
    Connection connection = null;
    Statement statement = null;

    public DBWorker() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        System.out.println("-----------------");

        //connection = DriverManager.getConnection("jdbc:mysql://localhost/warplanes?serverTimezone=UTC", "root", "");

        // openshift DB connection here mysql://warplanesmysql:3306/
        connection = DriverManager.getConnection("jdbc:mysql://warplanesmysql:3306/warplanes?serverTimezone=UTC",
                                                "root", "sexfoil");

        statement = connection.createStatement();
        System.out.println("Successful  connection with DB ...");
        System.out.println("-----------------");
    }



    public void updateDatabase(String query) {
        try {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /*public void addUserToDatabase(String query) {
        try {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/

    public boolean isUserExist(String login) {

        boolean isExist = false;
        String query = "SELECT * FROM  users WHERE name = '" + login + "'";

        try {
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                isExist = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isExist;
    }


    public User getUser(String login, String password) {
        String query;
        User user = null;

        query = "SELECT * FROM  users WHERE name = '" + login + "'";

        try {
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                user = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("password"),
                        resultSet.getString("sex"),
                        resultSet.getString("email"),
                        resultSet.getInt("age"),
                        resultSet.getInt("money"),
                        resultSet.getString("cart")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (user != null && password.equals(user.getPassword())) {
            return user;
        } else {
            return null;
        }
    }

    public ArrayList<Product> getProducts(String what, String kind) {
        String query;
        ArrayList<Product> products = new ArrayList<Product>();
        query = "SELECT " + what + " FROM  planes" + kind;

        try {
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Product p = new Product(
                        resultSet.getInt("plane_id"),
                        resultSet.getString("name"),
                        resultSet.getString("mark"),
                        resultSet.getString("model"),
                        resultSet.getString("role"),
                        resultSet.getString("country"),
                        resultSet.getString("description"),
                        resultSet.getInt("crew"),
                        resultSet.getInt("max_speed"),
                        resultSet.getInt("service_ceiling"),
                        resultSet.getString("picture"),
                        resultSet.getInt("price")
                        );
                products.add(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    public Product getOneProduct(String what, String kind) {
        String query;
        Product product = null;
        query = "SELECT " + what + " FROM  planes" + kind;

        try {
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                product = new Product(
                        resultSet.getInt("plane_id"),
                        resultSet.getString("name"),
                        resultSet.getString("mark"),
                        resultSet.getString("model"),
                        resultSet.getString("role"),
                        resultSet.getString("country"),
                        resultSet.getString("description"),
                        resultSet.getInt("crew"),
                        resultSet.getInt("max_speed"),
                        resultSet.getInt("service_ceiling"),
                        resultSet.getString("picture"),
                        resultSet.getInt("price")
                        );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    public void closeConnection(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
