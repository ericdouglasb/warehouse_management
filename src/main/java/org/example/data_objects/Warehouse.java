package org.example.data_objects;

import java.util.ArrayList;

public class Warehouse extends BaseDataObject {
    private String location;
    private ArrayList<Product> products = new ArrayList<>();

    public Warehouse(String location){
        setLocation(location);
    }

    public Warehouse(int id, String location) {
        setId(id);
        setLocation(location);

    }


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        // kista / KISTA / kIsTa --> Kista

        String firstLetter = location.substring(0, 1).toUpperCase();
        String rest = location.substring(1).toLowerCase();

        this.location = firstLetter + rest;
    }

    public ArrayList<Product> getAllProducts() {
        return products;
    }

    /**
     * Adds a product to the warehouse stock
     *
     * @param product The product to add to the warehouse stock
     */
    public void addProduct(Product product) {
        products.add(product);
    }

    /**
     * Removes one product with the specified id
     *
     * @param productId The product id to remove
     */
    public void removeProductById(int productId) {
        // remove => id:1
        // id:1, name:iphone <--
        // id:2 name:juice
        // id:1 name:iphone

        // Loop over every product
        int index = getIndexOfFirstProductById(productId);
        products.remove(index);

    }
        private int getIndexOfFirstProductById(int productId) {
            for (int i = 0; i < products.size(); i++) {

                // Save the product to local variable
                Product product = products.get(i);

                // If current products id == id to remove
                if (product.getId() == productId) {

                    // Exit loop and method
                    return i;
                }
            }
            return -1;
        }

    @Override
    public String toString() {
        return "Warehouse{" +
                "id=" + id +
                ", location='" + location + '\'' +
                ", products count=" + products.size() +
                '}';
    }
}

