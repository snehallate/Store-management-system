import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class StoreManagementSystem extends JFrame {

// Database connection parameters
private final String userName = "root";
private final String password = "mysql_2024";
private final String serverName = "localhost";
private final int portNumber = 3306;
private final String dbName = "store_db";

// Table names
private final String productsTableName = "products";
private final String customersTableName = "customers";
private final String ordersTableName = "orders";
private final String orderItemsTableName = "order_items";

// Database connection object
private Connection conn;

// GUI components
private JTextField productIdField, productNameField, productPriceField,
productQuantityField;

private JTextField customerIdField, customerNameField, customerEmailField;

private JTextField orderIdField, orderCustomerIdField,
orderTotalAmountField;

private JTextField orderItemIdField, orderItemOrderIdField,
orderItemProductIdField, orderItemQuantityField,
orderItemSubtotalField;

private JButton addProductButton, addCustomerButton, addOrderButton,
addOrderItemButton;

private JTextArea outputArea;

// Constructor
public StoreManagementSystem() {

// Establish database connection
try {

conn = DriverManager.getConnection(
"jdbc:mysql://" + serverName +
":" + portNumber + "/" + dbName,
userName, password);

} catch (SQLException e) {

e.printStackTrace();

JOptionPane.showMessageDialog(this,
"Failed to connect to the database.");

System.exit(1);
}

// Set up GUI components for products, customers,
// orders, and order items
// (omitted for brevity)

setTitle("Store Management System");
setSize(800, 700);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setLayout(new BorderLayout());

JPanel mainPanel = new JPanel();
mainPanel.setLayout(new GridLayout(4, 1));

// Product Panel
JPanel productPanel = new JPanel(new GridLayout(5, 2));

productIdField = new JTextField();
productNameField = new JTextField();
productPriceField = new JTextField();
productQuantityField = new JTextField();

addProductButton = new JButton("Add Product");

productPanel.add(new JLabel("Product ID"));
productPanel.add(productIdField);

productPanel.add(new JLabel("Product Name"));
productPanel.add(productNameField);

productPanel.add(new JLabel("Price"));
productPanel.add(productPriceField);

productPanel.add(new JLabel("Quantity"));
productPanel.add(productQuantityField);

productPanel.add(addProductButton);

// Customer Panel
JPanel customerPanel = new JPanel(new GridLayout(4, 2));

customerIdField = new JTextField();
customerNameField = new JTextField();
customerEmailField = new JTextField();

addCustomerButton = new JButton("Add Customer");

customerPanel.add(new JLabel("Customer ID"));
customerPanel.add(customerIdField);

customerPanel.add(new JLabel("Customer Name"));
customerPanel.add(customerNameField);

customerPanel.add(new JLabel("Customer Email"));
customerPanel.add(customerEmailField);

customerPanel.add(addCustomerButton);

// Order Panel
JPanel orderPanel = new JPanel(new GridLayout(4, 2));

orderIdField = new JTextField();
orderCustomerIdField = new JTextField();
orderTotalAmountField = new JTextField();

addOrderButton = new JButton("Add Order");

orderPanel.add(new JLabel("Order ID"));
orderPanel.add(orderIdField);

orderPanel.add(new JLabel("Customer ID"));
orderPanel.add(orderCustomerIdField);

orderPanel.add(new JLabel("Total Amount"));
orderPanel.add(orderTotalAmountField);

orderPanel.add(addOrderButton);

// Order Item Panel
JPanel orderItemPanel = new JPanel(new GridLayout(6, 2));

orderItemIdField = new JTextField();
orderItemOrderIdField = new JTextField();
orderItemProductIdField = new JTextField();
orderItemQuantityField = new JTextField();
orderItemSubtotalField = new JTextField();

addOrderItemButton = new JButton("Add Order Item");

orderItemPanel.add(new JLabel("Order Item ID"));
orderItemPanel.add(orderItemIdField);

orderItemPanel.add(new JLabel("Order ID"));
orderItemPanel.add(orderItemOrderIdField);

orderItemPanel.add(new JLabel("Product ID"));
orderItemPanel.add(orderItemProductIdField);

orderItemPanel.add(new JLabel("Quantity"));
orderItemPanel.add(orderItemQuantityField);

orderItemPanel.add(new JLabel("Subtotal"));
orderItemPanel.add(orderItemSubtotalField);

orderItemPanel.add(addOrderItemButton);

mainPanel.add(productPanel);
mainPanel.add(customerPanel);
mainPanel.add(orderPanel);
mainPanel.add(orderItemPanel);

outputArea = new JTextArea(10, 50);

JScrollPane scrollPane = new JScrollPane(outputArea);

add(mainPanel, BorderLayout.CENTER);
add(scrollPane, BorderLayout.SOUTH);

// Button Actions
addProductButton.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
addProduct();
}
});

addCustomerButton.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
addCustomer();
}
});

addOrderButton.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
addOrder();
}
});

addOrderItemButton.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
addOrderItem();
}
});

setVisible(true);
}

// Adding Products
private void addProduct() {

try {

// Retrieve product details
int id = Integer.parseInt(productIdField.getText());

String name = productNameField.getText();

double price =
Double.parseDouble(productPriceField.getText());

int quantity =
Integer.parseInt(productQuantityField.getText());

// Construct SQL INSERT query
String insertQuery =
"INSERT INTO " + productsTableName +
" (id, name, price, quantity) VALUES (?, ?, ?, ?)";

// Prepare statement
PreparedStatement statement =
conn.prepareStatement(insertQuery);

statement.setInt(1, id);
statement.setString(2, name);
statement.setDouble(3, price);
statement.setInt(4, quantity);

// Execute statement
statement.executeUpdate();

// Success message
outputArea.append(
"Product added: ID=" + id +
", Name=" + name +
", Price=" + price +
", Quantity=" + quantity + "\n"
);

} catch (SQLException | NumberFormatException ex) {

JOptionPane.showMessageDialog(this,
"Error adding product: " + ex.getMessage());

ex.printStackTrace();
}
}

// Adding Customers
private void addCustomer() {

try {

int id = Integer.parseInt(customerIdField.getText());

String name = customerNameField.getText();

String email = customerEmailField.getText();

String insertQuery =
"INSERT INTO " + customersTableName +
" (id, name, email) VALUES (?, ?, ?)";

PreparedStatement statement =
conn.prepareStatement(insertQuery);

statement.setInt(1, id);
statement.setString(2, name);
statement.setString(3, email);

statement.executeUpdate();

outputArea.append(
"Customer added: ID=" + id +
", Name=" + name +
", Email=" + email + "\n"
);

} catch (SQLException | NumberFormatException ex) {

JOptionPane.showMessageDialog(this,
"Error adding customer: " + ex.getMessage());

ex.printStackTrace();
}
}

// Adding Orders
private void addOrder() {

try {

int id = Integer.parseInt(orderIdField.getText());

int customerId =
Integer.parseInt(orderCustomerIdField.getText());

double totalAmount =
Double.parseDouble(orderTotalAmountField.getText());

String insertQuery =
"INSERT INTO " + ordersTableName +
" (id, customer_id, total_amount) VALUES (?, ?, ?)";

PreparedStatement statement =
conn.prepareStatement(insertQuery);

statement.setInt(1, id);
statement.setInt(2, customerId);
statement.setDouble(3, totalAmount);

statement.executeUpdate();

outputArea.append(
"Order added: ID=" + id +
", Customer ID=" + customerId +
", Total Amount=" + totalAmount + "\n"
);

} catch (SQLException | NumberFormatException ex) {

JOptionPane.showMessageDialog(this,
"Error adding order: " + ex.getMessage());

ex.printStackTrace();
}
}

// Adding Order Items
private void addOrderItem() {

try {

int id =
Integer.parseInt(orderItemIdField.getText());

int orderId =
Integer.parseInt(orderItemOrderIdField.getText());

int productId =
Integer.parseInt(orderItemProductIdField.getText());

int quantity =
Integer.parseInt(orderItemQuantityField.getText());

double subtotal =
Double.parseDouble(orderItemSubtotalField.getText());

String insertQuery =
"INSERT INTO " + orderItemsTableName +
" (id, order_id, product_id, quantity, subtotal) " +
"VALUES (?, ?, ?, ?, ?)";

PreparedStatement statement =
conn.prepareStatement(insertQuery);

statement.setInt(1, id);
statement.setInt(2, orderId);
statement.setInt(3, productId);
statement.setInt(4, quantity);
statement.setDouble(5, subtotal);

statement.executeUpdate();

outputArea.append(
"Order Item added: ID=" + id +
", Order ID=" + orderId +
", Product ID=" + productId +
", Quantity=" + quantity +
", Subtotal=" + subtotal + "\n"
);

} catch (SQLException | NumberFormatException ex) {

JOptionPane.showMessageDialog(this,
"Error adding order item: " + ex.getMessage());

ex.printStackTrace();
}
}

// Main Method
public static void main(String[] args) {

SwingUtilities.invokeLater(new Runnable() {

public void run() {

new StoreManagementSystem();
}
});
}
}
```
