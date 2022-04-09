import collaborator.ProductManager;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ProductManagerTest {
    private ProductManager productManager;
    private final String DEFAULT_PRODUCT = "A1";

    @Before
    public void setUp() {
        this.productManager = new ProductManager();
    }

    @Test
    public void product_is_registered(){
        boolean result = productManager.isRegistered(DEFAULT_PRODUCT);

        assertTrue(result);
    }

    @Test
    public void product_price_is_retrieved(){
        double priceOfProductToTest = 0.65;

        double result = productManager.getPriceOf(DEFAULT_PRODUCT);

        assertEquals(result, priceOfProductToTest, 0.0);
    }

}
