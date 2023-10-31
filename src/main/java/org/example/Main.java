package org.example;

import java.util.Comparator;
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

                    int id = inputUserId();
                    scanner.nextLine();

                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Email: ");
                    String email = scanner.nextLine();

                    User user = new User(id, name, email);
                    userList.addUser(user);
                    break;

                case 2:
                    // Remove User
                    System.out.println("Remove User: ");
                    int removeId = inputUserId();
                    scanner.nextLine();

                    if (userList.removeUser(removeId)) {
                        System.out.printf("User Id %d is Removed %n", removeId);
                    }
                    else {
                        System.out.printf("User Id %d Not Found %n", removeId);
                    }
                    break;

                case 3:
                    // Search User by ID
                    System.out.println("Search User: ");
                    int searchId = inputUserId();
                    scanner.nextLine();

                    User foundUser = userList.getUserById(searchId);
                    if (foundUser != null) {
                       // System.out.println("User Found: " + foundUser.getName() + " (" + foundUser.getEmail() + ")");
                        System.out.println("Id: " + foundUser.getId() + ", Name: " + foundUser.getName() + ", Email: " + foundUser.getEmail());
                    } else {
                        System.out.println("User Not Found.");
                    }
                    break;

                case 4:
                    // Sort Users by Name
                    List<User> sortedUsers = userList.getAllUsers();
                    if (!sortedUsers.isEmpty()) {
                        sortedUsers.sort(Comparator.comparing(User::getName));
                        System.out.println("Users Sorted By Name:");
                        for (User user1 : sortedUsers) {
                            System.out.println("Id: " + user1.getId() + ", Name: " + user1.getName() + ", Email: " + user1.getEmail());
                        }
                    }
                    else {
                        System.out.println("No User Found To Sort By Name");
                    }
                    break;

                case 5:
                    // Display All Users
                    List<User> allUsers = userList.getAllUsers();
                    System.out.println("All Users:");
                    for (User u : allUsers) {
                        System.out.println("Id: " + u.getId() + ", Name: " + u.getName() + ", Email: " + u.getEmail());
                    }
                    break;

                case 6:
                    // Exit
                    System.out.println("Exiting The Program.");
                    System.exit(0);
                    break;
            }
        }
    }

    static int inputUserId()
    {
        int id;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter Id: ");
            if (scanner.hasNextInt()) {
                id = scanner.nextInt();
                scanner.nextLine();
                break;
            } else {
                System.out.println("Invalid Input. Please Enter a Valid Integer For Id.");
                scanner.nextLine();
            }
        }
        return id;
    }
}
