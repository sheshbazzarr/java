import java.util.Scanner;

public class LibraryCatalogApp {
    private static GenericCatalog<LibraryItem<String>> catalog = new GenericCatalog<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            System.out.println("1. Add Item");
            System.out.println("2. Remove Item");
            System.out.println("3. View Catalog");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addItem();
                    break;
                case 2:
                    removeItem();
                    break;
                case 3:
                    viewCatalog();
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addItem() {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        System.out.print("Enter item ID: ");
        String itemID = scanner.nextLine();
        LibraryItem<String> item = new LibraryItem<>(title, author, itemID);
        catalog.addItem(item);
        System.out.println("Item added successfully.");
    }

    private static void removeItem() {
        System.out.print("Enter item ID to remove: ");
        String itemID = scanner.nextLine();
        LibraryItem<String> item = new LibraryItem<>(null, null, itemID);
        try {
            catalog.removeItem(item);
            System.out.println("Item removed successfully.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void viewCatalog() {
        System.out.println(catalog);
    }
}
