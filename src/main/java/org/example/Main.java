package org.example;

import org.example.data_objects.Product;
import org.example.data_objects.Warehouse;

import java.util.ArrayList;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static boolean running = true;


    public static void main(String[] args) {
        WarehouseManager warehouseManager = new WarehouseManager();
        ProductManager productManager = new ProductManager();

        addInitialData(warehouseManager, productManager);

        while (running) {
            int selection = getMainMenuSelection();

            handleMenuSelection(selection, warehouseManager, productManager);

        }
    }

    /**
     * Adds a few warehouses to the warehouse manager
     *
     * @param warehouseManager The warehouse manager to add warehouses to
     */

    private static void addInitialData(WarehouseManager warehouseManager, ProductManager productManager) {
        // Add initial warehouses
        Warehouse kista = new Warehouse(1, "Kista");
        Warehouse gothenburg = new Warehouse(2, "Göteborg");
        Warehouse stockholm = new Warehouse(3, "Stockholm");

        warehouseManager.addNewObject(kista);
        warehouseManager.addNewObject(gothenburg);
        warehouseManager.addNewObject(stockholm);

        Product iphone = new Product("iphone", 100, "some darn phone");
        Product usbcCharger = new Product("usbcCharger", 5050, "some darn phone charger");

        productManager.addNewObject(iphone);
        productManager.addNewObject(usbcCharger);

        warehouseManager.addProductToWarehouse(kista.getId(), iphone);
        warehouseManager.addProductToWarehouse(kista.getId(), usbcCharger);
        warehouseManager.addProductToWarehouse(kista.getId(), iphone);

        warehouseManager.addProductToWarehouse(gothenburg.getId(), usbcCharger);

    }


    /**
     * Shows the main menu to the user and returns the selection
     *
     * @return The user selection
     */
    private static int getMainMenuSelection() {
        while (true) {
            try {
                System.out.print("\n\n------ MENU ------\n" +
                        "1. Show warehouses\n" +
                        "2. Add warehouse\n" +
                        "3. Add product\n" +
                        "4. Add product to warehouse\n" +
                        "Print everything\n" +
                        "0. Exit\n" +
                        "Select");

                String input = scanner.nextLine();

                return Integer.parseInt(input);
            } catch (NumberFormatException exception) {
                System.out.println("Invalid input! Please enter a number");
            }
        }

    }

    private static void handleMenuSelection(int selection, WarehouseManager warehouseManager, ProductManager productManager) {
        switch (selection) {
            case 1:
                printAllWarehouses(warehouseManager);
                break;
            case 2:
                addWarehouseToManager(warehouseManager);
                break;
            case 3:
                addProductToManager(productManager);
                break;
            case 4:
                addProductToWarehouse(warehouseManager, productManager);
                break;
            case 5:
                printEverything(warehouseManager);
                break;
            case 0:
                stopRunning();
                break;
            default:
                System.out.println("Invalid menu selection");
                break;
        }
    }

    private static void printEverything(WarehouseManager warehouseManager) {
        ArrayList<Warehouse> warehouses = warehouseManager.getAllObjects();

        for (var warehouse: warehouses) {
            ArrayList<Product> products = warehouse.getAllProducts();
            System.out.println(warehouse.getLocation());
            printProducts(products);
            System.out.println("---");

        }

    }


    /**
     * Prints all warehouses of the warehouse manager
     *
     * @param warehouseManager The warehouse manager to print warehouses of
     */

    private static void printAllWarehouses(WarehouseManager warehouseManager) {
        //Hämtar alla varuhus
        var warehouses = warehouseManager.getAllObjects();

        printWarehouses(warehouses);
    }

    /**
     * Prints all warehouse in the list
     *
     * @param warehouses A list of warehouse to print
     */

    private static void printWarehouses(ArrayList<Warehouse> warehouses) {
        // Loopar genom alla varuhus och skriver ut.
        for (Warehouse warehouse : warehouses) {
            System.out.println(warehouse);
        }
    }

    private static void addWarehouseToManager(WarehouseManager warehouseManager) {
        Warehouse newWarehouse = getWarehouseFromUserInput();

        warehouseManager.addNewObject(newWarehouse);

        System.out.println("Warehouse added successfully");

    }

    private static Warehouse getWarehouseFromUserInput() {
        System.out.print("Input location");
        String location = scanner.nextLine();

        return new Warehouse(location);
    }

    private static void addProductToManager(ProductManager productManager) {
        Product product = getProductToManager();

        productManager.addNewObject(product);

    }

    private static Product getProductToManager() {
        // name, price, description
        System.out.println("\nEnter name: ");
        String name = scanner.nextLine();

        int price = getNumberinput("\nEnter price: ");


        System.out.println("\nEnter description: ");
        String description = scanner.nextLine();

        return new Product(name, price, description);
    }
    private static void addProductToWarehouse(WarehouseManager warehouseManager, ProductManager productManager) {
        System.out.println("Select a warehouse");
        printAllWarehouses(warehouseManager);
        int warehouseId = getNumberinput("Enter ID: ");

        System.out.println("Select a product");
        printAllProducts(productManager);
        int productId = getNumberinput("Enter ID:");

        Product product = productManager.getObjectById(productId);
        warehouseManager.addProductToWarehouse(warehouseId, product);

    }

    private static void printAllProducts(ProductManager productManager) {
        ArrayList<Product> products = productManager.getAllObjects();

        printProducts(products);
    }

    private static void printProducts(ArrayList<Product> products) {
        for (var product: products){
            System.out.println(product);
        }
    }

    private static int getNumberinput(String prompt) {

        while (true) {
            try {
                System.out.println(prompt);
                String input = scanner.nextLine();
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("invalid input");
            }
        }
    }

        private static void stopRunning () {
            running = false;
            System.out.println("Program will stop now.\n" +
                    "Have a great day!");
        }

    }