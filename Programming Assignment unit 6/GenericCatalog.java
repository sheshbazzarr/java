import java.util.ArrayList;
import java.util.List;

public class GenericCatalog<T> {
    private List<T> items;

    public GenericCatalog() {
        items = new ArrayList<>();
    }

    public void addItem(T item) { items.add(item); }
    public void removeItem(T item) throws Exception {
        if (!items.remove(item)) {
            throw new Exception("Item not found");
        }
    }
    public List<T> getItems() { return items; }
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
