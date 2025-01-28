package cp213;

import java.util.Scanner;

/**
 * Wraps around an Order object to ask for MenuItems and quantities.
 *
 * @author your name here
 * @author Abdul-Rahman Mawlood-Yunis
 * @author David Brown
 * @version 2024-10-15
 */
public class Cashier {

    private Menu menu = null;

    /**
     * Constructor.
     *
     * @param menu A Menu.
     */
    public Cashier(Menu menu) {
	this.menu = menu;
    }

    /**
     * Reads keyboard input. Returns a positive quantity, or 0 if the input is not a
     * valid positive integer.
     *
     * @param scan A keyboard Scanner.
     * @return
     */
    private int askForQuantity(Scanner scan) {
	int quantity = 0;
	System.out.print("How many do you want? ");

	try {
	    String line = scan.nextLine();
	    quantity = Integer.parseInt(line);
	} catch (NumberFormatException nfex) {
	    System.out.println("Not a valid number");
	}
	return quantity;
    }

    /**
     * Prints the menu.
     */
    private void printCommands() {
	System.out.println("\nMenu:");
	System.out.println(menu.toString());
	System.out.println("Press 0 when done.");
	System.out.println("Press any other key to see the menu again.\n");
    }

    /**
     * Asks for commands and quantities. Prints a receipt when all orders have been
     * placed.
     *
     * @return the completed Order.
     */
    public Order takeOrder() {
	System.out.println("Welcome to WLU Foodorama!");

	// your code here
	System.out.println("Welcome to WLU Foodorama!");
    Order order = new Order(); // Create a new order
    Scanner sc = new Scanner(System.in);
    boolean isOrdering = true;

    printCommands(); // Print the menu initially

    while (isOrdering) {
        System.out.print("Command: ");
        String command = sc.nextLine(); // Read user input

        try {
            int itemNumber = Integer.parseInt(command);

            if (itemNumber == 0) {
                // End the order
                isOrdering = false;
            } else if (itemNumber > 0 && itemNumber <= menu.size()) {
                // Valid menu item number
                MenuItem item = menu.getItem(itemNumber - 1); // Get the menu item
                int quantity = askForQuantity(sc); // Ask for the quantity

                if (quantity > 0) {
                    // Add the quantity directly using `update`
                    order.update(item, quantity);
                }
            } else {
                // Invalid menu item number
                System.out.println("Not a valid number");
                printCommands(); // Reprint the menu
            }
        } catch (NumberFormatException e) {
            // Handle non-integer input
            System.out.println("Not a valid number");
            printCommands(); // Reprint the menu
        }
    }

    // Print the receipt
    System.out.println("----------------------------------------");
    System.out.println("Receipt");
    System.out.println(order.toString());

    return order;
    }
}