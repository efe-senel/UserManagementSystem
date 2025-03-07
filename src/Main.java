import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1- Create Manager");
            System.out.println("2- Create Standard User");
            System.out.println("3- List Users");
            System.out.println("4- Edit Users");
            System.out.println("5- Exit");
            System.out.print("Your choice: ");

            int selection = scanner.nextInt();
            scanner.nextLine();
            String name;

            switch (selection) {
                case 1:
                    System.out.print("Enter name: ");
                    name = scanner.nextLine();
                    User manager = User.UserFactory.createManager(name);
                    System.out.println("Manager '" + name + "' has been created.");
                    break;
                case 2:
                    System.out.print("Enter name: ");
                    name = scanner.nextLine();
                    User normalUser = User.UserFactory.createStandartUser(name);
                    System.out.println("Standard user '" + name + "' has been created.");
                    break;
                case 3:
                    System.out.println("\n1- Show Managers");
                    System.out.println("2- Show Standard Users");
                    System.out.println("3- Show All Users");
                    System.out.print("Your choice: ");
                    int listSelection = scanner.nextInt();
                    scanner.nextLine();

                    switch (listSelection) {
                        case 1:
                            User.showManagers();
                            break;
                        case 2:
                            User.showStandartUsers();
                            break;
                        case 3:
                            User.showAllUsers();
                            break;
                        default:
                            System.out.println("Invalid selection.");
                    }
                    break;
                case 4:
                    System.out.println("\n1- Delete User");
                    System.out.println("2- Update User Name");
                    System.out.print("Your choice: ");
                    int editSelection = scanner.nextInt();
                    scanner.nextLine();

                    switch (editSelection) {
                        case 1:
                            System.out.print("Enter the name of the user to delete: ");
                            String nameToDelete = scanner.nextLine();
                            User.deleteUserByName(nameToDelete);
                            break;
                        case 2:
                            System.out.print("Enter the current name of the user: ");
                            String oldName = scanner.nextLine();
                            System.out.print("Enter the new name: ");
                            String newName = scanner.nextLine();
                            User.updateUserName(oldName, newName);
                            break;
                        default:
                            System.out.println("Invalid selection.");
                    }
                    break;
                case 5:
                    System.out.println("Exiting the program...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid selection! Please try again.");
            }
        }
    }
}
