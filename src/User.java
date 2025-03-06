import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private final String role;
    private static final List<User> allUsers = new ArrayList<>();
    private static final List<User> managers = new ArrayList<>();
    private static final List<User> standardUsers = new ArrayList<>();

    private User(String name, String role) {
        this.name = name;
        this.role = role;
        allUsers.add(this);
        if (role.equals("Manager")) {
            managers.add(this);
        } else {
            standardUsers.add(this);
        }
    }

    public static void showAllUsers() {
        if (allUsers.isEmpty()) {
            System.out.println("No registered users.");
            return;
        }
        System.out.println("\n--- All Users ---");
        for (User user : allUsers) {
            user.showInfo();
        }
    }

    public static void showManagers() {
        if (managers.isEmpty()) {
            System.out.println("No managers found.");
            return;
        }
        System.out.println("\n--- Managers ---");
        for (User user : managers) {
            user.showInfo();
        }
    }

    public static void showStandartUsers() {
        if (standardUsers.isEmpty()) {
            System.out.println("No standard users found.");
            return;
        }
        System.out.println("\n--- Standard Users ---");
        for (User user : standardUsers) {
            user.showInfo();
        }
    }

    public void showInfo() {
        System.out.println("Name: " + name + " | Role: " + role);
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void updateUserName(String oldName, String newName) {
        User user = findUserByName(oldName);
        if (user == null) {
            System.out.println("Error: No user found with the name '" + oldName + "'.");
        } else {
            user.setName(newName);
            System.out.println("Successfully updated: " + oldName + " -> " + newName);
        }
    }

    public static User findUserByName(String name) {
        for (User user : allUsers) {
            if (user.name.equals(name)) {
                return user;
            }
        }
        return null;
    }

    public static void deleteUserByName(String nameToDelete) {
        User userToDelete = findUserByName(nameToDelete);
        if (userToDelete == null) {
            System.out.println("Error: User not found.");
            return;
        }

        allUsers.remove(userToDelete);
        if (userToDelete.role.equals("Manager")) {
            managers.remove(userToDelete);
        } else {
            standardUsers.remove(userToDelete);
        }

        System.out.println("User '" + nameToDelete + "' has been successfully deleted.");
    }

    public static class UserFactory {
        public static User managerExecutor(String name) {
            return new User(name, "Manager");
        }

        public static User standartUserExecutor(String name) {
            return new User(name, "Standard User");
        }
    }
}
