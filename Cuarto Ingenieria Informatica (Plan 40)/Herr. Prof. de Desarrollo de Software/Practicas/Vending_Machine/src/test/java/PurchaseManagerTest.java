import collaborator.AmountSystem;
import collaborator.ProductManager;
import collaborator.PurchaseManager;
import model.Coin;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class PurchaseManagerTest {

    private Coin fiveCentsCoin;
    private Coin tenCentsCoin;
    private Coin twentyCentsCoin;
    private Coin fiftyCentsCoin;
    private Coin oneEuroCoin;
    private Coin twoEurosCoin;

    @Before
    public void setUp() {
        fiveCentsCoin = new Coin(21.25, 3.9);
        tenCentsCoin = new Coin(19.75, 4.1);
        twentyCentsCoin = new Coin(22.25, 5.7);
        fiftyCentsCoin = new Coin(24.25, 7.8);
        oneEuroCoin = new Coin(23.25, 7.5);
        twoEurosCoin = new Coin(25.25, 8.5);
    }

    @Test
    public void product_can_not_be_purchased_if_price_is_lower_than_current_amount(){
        AmountSystem mockAmountSystem = mock(AmountSystem.class);
        ProductManager mockProductSystem = mock(ProductManager.class);
        String productToPurchase = "A1";
        PurchaseManager purchaseManagerToTest = new PurchaseManager(0.00, mockProductSystem,mockAmountSystem);

        doReturn(true).when(mockProductSystem).isRegistered(productToPurchase);
        doReturn(0.50).when(mockAmountSystem).getCurrentAmount();

        boolean result = purchaseManagerToTest.purchaseProduct(productToPurchase);

        assertFalse(result);
    }

    @Test
    public void product_can_be_purchased_if_price_is_equal_or_higher_than_current_amount(){
        AmountSystem AmountSystem = new AmountSystem();
        ProductManager mockProductSystem = mock(ProductManager.class);
        String productToPurchase = "A1";
        PurchaseManager purchaseManagerToTest = new PurchaseManager(0.00, mockProductSystem,AmountSystem);
        double expectedChange = 1.35;

        doReturn(true).when(mockProductSystem).isRegistered(productToPurchase);
        doReturn(0.65).when(mockProductSystem).getPriceOf(productToPurchase);

        purchaseManagerToTest.insertCoins(
                new ArrayList<Coin>() {
                    { add(twoEurosCoin); }
                });

        boolean result = purchaseManagerToTest.purchaseProduct(productToPurchase);

        assertTrue(result);
        assertEquals(expectedChange, purchaseManagerToTest.getCurrentAmount(), 0.0);
    }
}
