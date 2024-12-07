import com.ecommerce.Customer;
import com.ecommerce.Product;
import com.ecommerce.orders.Order;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Creating instances of products
        Product product1 = new Product("P001", "Laptop", 999.99);
        Product product2 = new Product("P002", "Smartphone", 599.99);

        // Creating an instance of customer
        Customer customer = new Customer("C001", "Alice");

        // Adding products to the customer's shopping cart
        customer.addProductToCart(product1);
        customer.addProductToCart(product2);

        // Displaying shopping cart total
        System.out.println("Total Cost: " + customer.calculateTotalCost());

        // Placing an order
        List<Product> cart = new ArrayList<>(customer.getShoppingCart());
        Order order = new Order("O001", customer, cart);

        // Displaying order summary
        System.out.println(order.generateOrderSummary());
    }
}
