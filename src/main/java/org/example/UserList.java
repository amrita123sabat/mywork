package org.example;

import java.util.ArrayList;
// import java.util.Comparator;
import java.util.List;

public class UserList {
    private final List<User> userList = new ArrayList<>();

    public void addUser(User user) {
        userList.add(user);
    }

    public boolean removeUser(int id) {
        return userList.removeIf(user -> user.getId() == id);
    }

    public User getUserById(int id) {
        for (User user : userList) {
            if (user.getId() == id) {
                return user; // User found
            }
        }
        return null;
    }
     public List<User> getAllUsers() {
        return new ArrayList<>(userList);
    }
}
