package edu.cnm.deepdive.mysql;

public class Chat {

    public static void main(String[] args) {
        DatabaseHelper databaseHelper = new DatabaseHelper();
        for (Message message:databaseHelper.readMessages()) {
            System.out.println(message.getMessage());
        }
    }
}
