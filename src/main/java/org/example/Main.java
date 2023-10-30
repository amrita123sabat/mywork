package org.example;

import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserList userList = new UserList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add User");
            System.out.println("2. Remove User");
            System.out.println("3. Search User by ID");
            System.out.println("4. Sort Users by Name");
            System.out.println("5. Display All Users");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Add User
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Email: ");
                    String email = scanner.nextLine();
                    User user = new User(id, name, email);
                    userList.addUser(user);
                    break;

                case 2:
                    // Remove User
                    System.out.print("Enter User ID to Remove: ");
                    int removeId = scanner.nextInt();
                    userList.removeUser(removeId);
                    break;

                case 3:
                    // Search User by ID
                    System.out.print("Enter User ID to Search: ");
                    int searchId = scanner.nextInt();

                    // Debug: Print the list of users
                    System.out.println("All Users:");
                    for (User u : userList.getAllUsers()) {
                        System.out.println("ID: " + u.getId() + ", Name: " + u.getName() + ", Email: " + u.getEmail());
                    }

                    User foundUser = userList.getUserById(searchId);
                    if (foundUser != null) {
                        System.out.println("User found: " + foundUser.getName() + " (" + foundUser.getEmail() + ")");
                    } else {
                        System.out.println("User not found.");
                    }
                    break;

                case 4:
                    // Sort Users by Name
                    userList.sortUsersByName();
                    List<User> sortedUsers = userList.getAllUsers();

                    System.out.println("Users sorted by name:");
                    for (User user1 : sortedUsers) {
                        System.out.println("ID: " + user1.getId() + ", Name: " + user1.getName() + ", Email: " + user1.getEmail());
                    }
                    break;


                case 5:
                    // Display All Users
                    List<User> allUsers = userList.getAllUsers();
                    System.out.println("All Users:");
                    for (User u : allUsers) {
                        System.out.println("ID: " + u.getId() + ", Name: " + u.getName() + ", Email: " + u.getEmail());
                    }
                    break;

                case 6:
                    // Exit
                    System.out.println("Exiting the program.");
                    System.exit(0);
                    break;
            }
        }
    }
}
