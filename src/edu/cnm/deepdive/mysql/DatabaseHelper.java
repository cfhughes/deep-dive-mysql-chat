package edu.cnm.deepdive.mysql;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper {

    public List<Message> readMessages() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://chatdb.chsxb0fzcvdr.us-east-1.rds.amazonaws.com/chat" +
                            "?user=databaseuser&password=databasepass");

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM chat.messages");

            List<Message> messages = new ArrayList<>();

            while (resultSet.next()) {
                Message message = new Message();
                message.setMessage(resultSet.getString("message"));
                message.setUsername(resultSet.getString("username"));
                messages.add(message);
            }

            return messages;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
