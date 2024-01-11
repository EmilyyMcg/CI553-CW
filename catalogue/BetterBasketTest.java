package catalogue;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BetterBasketTest {
    @Test
    public void testMergeAddProduct(){
        BetterBasket b = new BetterBasket();
        Product p1 = new Product("0001","Toaster",10.00,1);
        Product p2 = new Product("0001","Toaster",10.00,1);
        Product p3 = new Product("0002","Kettle",15.00,1);
        Product p4 = new Product("0002","Kettle",15.00,2);

        b.add(p1);
        b.add(p2);
        assertEquals(1, b.size());
        assertEquals(2, b.get(0).getQuantity());

        b.add(p3);
        assertEquals(1, b.get(1).getQuantity());
    }

    @Test
    public void testSortAddProduct(){
        BetterBasket b = new BetterBasket();
        Product p1 = new Product ("0001","Toaster",10.00,1);
        Product p2 = new Product ("0002","Microwave", 50.00,1);
        Product p3 = new Product ("0003","Kettle",15.00,1);

        b.add(p3);
        b.add(p1);
        assertEquals("0001", b.get(0).getProductNum());
        assertEquals("0003", b.get(1).getProductNum());

        b.add(p2);
        assertEquals("0001", b.get(0).getProductNum());
        assertEquals("0002", b.get(1).getProductNum());
        assertEquals("0003", b.get(2).getProductNum());
    }
}