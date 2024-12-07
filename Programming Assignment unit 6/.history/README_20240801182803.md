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
4. `GenericCatalogTest.java`: Contains JUnit tests for the catalog.

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
4. `GenericCatalogTest.java`: Contains JUnit tests for the catalog.

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
