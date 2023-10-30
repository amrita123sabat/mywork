package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class UserList1 {
    private List<User1> userList = new ArrayList<>();

    public void addUser(User1 user) {
        userList.add(user);
    }

    public void removeUser(int id) {
        userList.removeIf(user -> user.getId() == id);
    }

    public User1 getUserById(int id) {
        for (User1 user : userList) {
            System.out.println("Comparing ID: " + user.getId() + " with " + id);
            if (user.getId() == id) {
                System.out.println("User found");
                return user; // User found
            }
        }
        System.out.println("User not found");
        return null; // User not found
    }


    public void sortUsersByName() {
        userList.sort(Comparator.comparing(User1::getName));
    }

    public List<User1> getAllUsers() {
        return new ArrayList<>(userList);
    }
}