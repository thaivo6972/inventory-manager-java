import java.util.HashMap;
import java.util.Scanner;

public class InventoryManager {

    private static HashMap<String, Integer> inventory = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("\n=== Inventory Manager ===");
            System.out.println("1. Add Item");
            System.out.println("2. Update Quantity");
            System.out.println("3. View Inventory");
            System.out.println("4. Remove Item");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addItem();
                    break;
                case 2:
                    updateItem();
                    break;
                case 3:
                    viewInventory();
                    break;
                case 4:
                    removeItem();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
        System.out.println("Exiting program...");
    }

    private static void addItem() {
        System.out.print("Enter item name: ");
        String name = scanner.nextLine();

        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();

        inventory.put(name, quantity);
        System.out.println("Item added.");
    }

    private static void updateItem() {
        System.out.print("Enter item name: ");
        String name = scanner.nextLine();

        if (inventory.containsKey(name)) {
            System.out.print("Enter new quantity: ");
            int quantity = scanner.nextInt();
            inventory.put(name, quantity);
            System.out.println("Quantity updated.");
        } else {
            System.out.println("Item not found.");
        }
    }

    private static void viewInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }

        System.out.println("\nCurrent Inventory:");
        for (String item : inventory.keySet()) {
            System.out.println(item + " : " + inventory.get(item));
        }
    }

    private static void removeItem() {
        System.out.print("Enter item name to remove: ");
        String name = scanner.nextLine();

        if (inventory.remove(name) != null) {
            System.out.println("Item removed.");
        } else {
            System.out.println("Item not found.");
        }
    }
}