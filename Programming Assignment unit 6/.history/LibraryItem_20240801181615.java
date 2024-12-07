import java.util.Objects;

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
