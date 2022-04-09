import collaborator.AmountSystem;
import model.Coin;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class AmountSystemTest {

    private AmountSystem amountSystem;
    private Coin fiveCentsCoin;
    private Coin tenCentsCoin;
    private Coin twentyCentsCoin;
    private Coin fiftyCentsCoin;
    private Coin oneEuroCoin;
    private Coin TwoEurosCoin;

    @Before
    public void setUp() {
        amountSystem = new AmountSystem();
        fiveCentsCoin = new Coin(21.25, 3.9);
        tenCentsCoin = new Coin(19.75, 4.1);
        twentyCentsCoin = new Coin(22.25, 5.7);
        fiftyCentsCoin = new Coin(24.25, 7.8);
        oneEuroCoin = new Coin(23.25, 7.5);
        TwoEurosCoin = new Coin(25.25, 8.5);
    }

    @Test
    public void add_the_amount_of_a_coin_if_is_accepted(){
        double expectedAmount = 1.00;

        amountSystem.addAmountFrom(oneEuroCoin);

        assertEquals(amountSystem.getCurrentAmount(), expectedAmount, 0.0);
    }

    @Test
    public void add_the_amount_of_all_accepted_coins(){
        double expectedAmount = 3.85;

        amountSystem.addAmountFrom(fiveCentsCoin);
        amountSystem.addAmountFrom(tenCentsCoin);
        amountSystem.addAmountFrom(twentyCentsCoin);
        amountSystem.addAmountFrom(fiftyCentsCoin);
        amountSystem.addAmountFrom(oneEuroCoin);
        amountSystem.addAmountFrom(TwoEurosCoin);

        assertEquals(amountSystem.getCurrentAmount(), expectedAmount, 0.0);
    }

    @Test
    public void verify_amount_added(){
        AmountSystem mockAmountSystem = mock(AmountSystem.class);

        mockAmountSystem.addAmountFrom(fiveCentsCoin);
        mockAmountSystem.addAmountFrom(tenCentsCoin);
        mockAmountSystem.addAmountFrom(twentyCentsCoin);
        mockAmountSystem.addAmountFrom(fiftyCentsCoin);

        verify(mockAmountSystem, atLeast(1)).addAmountFrom(fiveCentsCoin);
        verify(mockAmountSystem, atLeast(1)).addAmountFrom(tenCentsCoin);
        verify(mockAmountSystem, atLeast(1)).addAmountFrom(twentyCentsCoin);
        verify(mockAmountSystem, atLeast(1)).addAmountFrom(fiftyCentsCoin);
    }
}
