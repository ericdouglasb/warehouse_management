import org.example.Product;
import org.example.Warehouse;
import org.example.WarehouseManager;
import org.junit.Assert;
import org.junit.Test;

public class WarehousemanagerTests {
    @Test
    public void testAddNewWarehouse(){
        var warehouseManager = new WarehouseManager();

        var warehouse = new Warehouse(1,"kista");

        warehouseManager.addNewWarehouse(warehouse);

        assert warehouseManager.getAllWarehouses().size() == 1;
    }
    @Test
    public void testAddProductToWarehouse(){
        var warehouseManager = new WarehouseManager();
        var warehouse = new Warehouse(1,"kista");
        var product = new Product(1,"iphone",10,"An exclusive phone");
        warehouseManager.addNewWarehouse(warehouse);
        warehouseManager.addProductToWarehouse(1,product);

        warehouse = warehouseManager.getWarehouseById(1);

        assert warehouse.getAllProducts().size() == 1;

    }
    @Test
    public void testAddWarehouseNoId(){
        var warehouseManager = new WarehouseManager();
        var warehouse1 = new Warehouse(1,"Sergelstorg");
        var warehouse2 = new Warehouse("Falun");

        warehouseManager.addNewWarehouse(warehouse1);
        warehouseManager.addNewWarehouse(warehouse2);


        Assert.assertEquals(1, warehouse1.getWarehouseId());
        Assert.assertEquals(2, warehouse2.getWarehouseId());

    }

    @Test
    public void testAddWarehousesIdAndNoId(){

        var warehouseManager = new WarehouseManager();
        var warehouse1 = new Warehouse(200,"Sergelstorg");
        var warehouse2 = new Warehouse("Falun");

        warehouseManager.addNewWarehouse(warehouse1);
        warehouseManager.addNewWarehouse(warehouse2);


        Assert.assertEquals(200, warehouse1.getWarehouseId());
        Assert.assertEquals(201, warehouse2.getWarehouseId());

    }
}
