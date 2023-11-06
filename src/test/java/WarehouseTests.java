import org.example.Product;
import org.example.Warehouse;
import org.junit.Test;


public class WarehouseTests {
    @Test
    public void testSetLocationConstructor(){
        var warehouse = new Warehouse(1, "kista");

        assert warehouse.getLocation().equals("Kista");

    }


    @Test
    public void testSetLocation(){
        var warehouse = new Warehouse(1,"kista");

        warehouse.setLocation("kista");

        assert warehouse.getLocation().equals("Kista");
    }

    @Test
    public void testAddProduct(){
        var warehouse = new Warehouse(1,"Kista");

        var product = new Product(1,"iphone",10,"An exclusive phone");

        warehouse.addProduct(product);

        assert warehouse.getAllProducts().size() == 1;
        assert warehouse.getAllProducts().getFirst().getProductId() == 1;
    }




    @Test
    public void testRemoveProductById(){

        var warehouse = new Warehouse(1,"Kista");

        var product1 = new Product(1,"iphone",10,"An exclusive phone");
        var product2 = new Product(2,"juice",5,"Something to drink");
        var product3 = new Product(1,"iphone",10,"An exclusive phone");

        warehouse.addProduct(product1);
        warehouse.addProduct(product2);
        warehouse.addProduct(product3);

        warehouse.removeProductById(1);

        assert warehouse.getAllProducts().size() == 2;
        assert warehouse.getAllProducts().getFirst().getProductId() == 2;

    }

}
