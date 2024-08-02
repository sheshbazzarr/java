


## Programming Assignment Unit 6

**Daniel Endale**  
Department of Computer Science, University of the People  
CS 1103-01 Programming 2 - AY2024-T5  

**Instructor: Ashish Musale**  

**Date: Aug 01, 2024**

---
# Generic Library Catalog

This project implements a generic library catalog in Java that can store and manage different types of library items, such as books, DVDs, and magazines. The goal is to utilize generic classes and methods to ensure flexibility and code reusability.

## Features

- Generic catalog class to store information about library items.
- Generic `LibraryItem` class with attributes such as `title`, `author`, and `itemID`.
- Methods to add a new library item, remove an item, and retrieve item details.
- Command-line interface for users to interact with the library catalog.
- Comprehensive testing using JUnit.

## Project Structure

The project consists of the following files:

1. `LibraryItem.java`: Defines the `LibraryItem` class.
2. `GenericCatalog.java`: Defines the generic catalog class.
3. `LibraryCatalogApp.java`: Provides the command-line interface for user interaction.


## Classes and Methods

### LibraryItem.java

The `LibraryItem` class is a generic class that represents a library item. It includes the following attributes:

- `title`: The title of the item.
- `author`: The author of the item.
- `itemID`: A unique identifier for the item.

#### Example:

```java
public class LibraryItem<T> {
    private String title;
    private String author;
    private T itemID;

    public LibraryItem(String title, String author, T itemID) {
        this.title = title;
        this.author = author;
        this.itemID = itemID;
    }

    // Getters and Setters
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
    public T getItemID() { return itemID; }
    public void setItemID(T itemID) { this.itemID = itemID; }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", Item ID: " + itemID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LibraryItem<?> that = (LibraryItem<?>) o;
        return Objects.equals(itemID, that.itemID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemID);
    }
}
# GenericCatalog

## Overview
The `GenericCatalog` class is a generic implementation for managing a collection of items. This class provides methods to add, remove, and retrieve items, ensuring flexibility and reusability by using Java generics.

## Features
- **Generic Type Support**: The class can manage any type of items specified by the generic type parameter `T`.
- **Basic Operations**: Add, remove, and retrieve items from the catalog.
- **String Representation**: Provides a string representation of the catalog for easy display.

## Class Implementation

### Code
```java
import java.util.ArrayList;
import java.util.List;

public class GenericCatalog<T> {
    private List<T> items;

    public GenericCatalog() {
        items = new ArrayList<>();
    }

    public void addItem(T item) {
        items.add(item);
    }

    public void removeItem(T item) throws Exception {
        if (!items.remove(item)) {
            throw new Exception("Item not found");
        }
    }

    public List<T> getItems() {
        return items;
    }

    public T getItemDetails(T item) {
        int index = items.indexOf(item);
        return (index != -1) ? items.get(index) : null;
    }

    @Override
    public String toString() {
        StringBuilder catalogString = new StringBuilder("Catalog:\n");
        for (T item : items) {
            catalogString.append(item.toString()).append("\n");
        }
        return catalogString.toString();
    }
}
# Library Catalog Application

## Overview
The `LibraryCatalogApp` class is a command-line application that manages a library catalog using the `GenericCatalog` class. It allows users to add, remove, and view library items interactively. This application demonstrates the use of generics and basic user input handling in Java.

## Features
- **Add Items**: Add new library items to the catalog.
- **Remove Items**: Remove existing items from the catalog.
- **View Catalog**: Display all items currently in the catalog.
- **Interactive Menu**: Provides a simple menu for user interaction.

## Class Implementation

### Code
```java
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
            scanner.nextLine();

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
![Add Item ]()
![Remove Item ]()
![View Catalog  Item ]()
![Exit  Item ]()

# Library Catalog Application

## Overview
The `LibraryCatalogApp` class is a command-line application for managing a library catalog using the `GenericCatalog` class. It allows users to add, remove, and view library items interactively.

## Code Implementation

### Classes

#### 1. `GenericCatalog<T>`
Manages a collection of items using generics.

#### 2. `LibraryItem<T>`
Represents a library item with a title, author, and a generic itemID.

#### 3. `LibraryCatalogApp`
Provides a command-line interface for interacting with the library catalog.

## Usage

### Prerequisites
Ensure you have Java Development Kit (JDK) installed on your system. You can download it from [Oracle's website](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) or use a package manager for your operating system.

### Setting Up the Project
1. **Clone the Repository:**
   ```sh
   git clone https://github.com/sheshbazzarr/java.git
   cd library-catalog
