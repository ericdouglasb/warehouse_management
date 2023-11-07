import org.example.DataObjectManager;
import org.example.data_objects.Product;
import org.example.data_objects.Warehouse;
import org.junit.Test;
import org.junit.Assert;

public class DataObjectManagerTests {
    @Test
    public void testAddNewObject(){
        Warehouse warehouse = new Warehouse("kista");
        DataObjectManager<Warehouse> warehouseDataObjectManager = new DataObjectManager<>();

        warehouseDataObjectManager.addNewObject(warehouse);

        Assert.assertEquals(1, warehouseDataObjectManager.getAllObjects().size());


    }
    @Test
    public void testAddObjectWithIdNoId(){
        DataObjectManager<Product> productDataObjectManager = new DataObjectManager<>();
        Product product1 = new Product(200,"iphone", 100, "An exclusive phone");
        Product product2 = new Product("usb-c charger",1000,"Charge your phone or computer");

        productDataObjectManager.addNewObject(product1);
        productDataObjectManager.addNewObject(product2);

        Assert.assertEquals(201,product2.getId());
    }
    @Test
    public void testGetObjectById(){
        DataObjectManager<Product> productDataObjectManager = new DataObjectManager<>();
        Product product1 = new Product(200,"iphone", 100, "An exclusive phone");
        Product product2 = new Product("usb-c charger",1000,"Charge your phone or computer");

        productDataObjectManager.addNewObject(product1);
        productDataObjectManager.addNewObject(product2);

        Assert.assertEquals("iphone", productDataObjectManager.getObjectById(200).getProductName());
        Assert.assertEquals("usb-c charger", productDataObjectManager.getObjectById(201).getProductName());
    }
}
