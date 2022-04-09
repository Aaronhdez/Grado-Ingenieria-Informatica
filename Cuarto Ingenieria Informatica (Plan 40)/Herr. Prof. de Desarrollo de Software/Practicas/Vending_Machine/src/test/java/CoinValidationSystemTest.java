import collaborator.CoinValidationSystem;
import model.Coin;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CoinValidationSystemTest {

    private CoinValidationSystem coinValidationSystem;
    private Coin coinToTest;

    @Before
    public void setUp() {
        this.coinValidationSystem = new CoinValidationSystem();
    }

    @Test
    public void accept_five_cents_coin(){
        this.coinToTest = new Coin(21.25, 3.9);

        assertTrue(coinValidationSystem.validate(coinToTest));
    }

    @Test
    public void accept_ten_cents_coin(){
        this.coinToTest = new Coin(19.75, 4.1);

        assertTrue(coinValidationSystem.validate(coinToTest));
    }

    @Test
    public void accept_twenty_cents_coin(){
        this.coinToTest = new Coin(22.25, 5.7);

        assertTrue(coinValidationSystem.validate(coinToTest));
    }

    @Test
    public void accept_fifty_cents_coin(){
        this.coinToTest = new Coin(24.25, 7.8);

        assertTrue(coinValidationSystem.validate(coinToTest));
    }

    @Test
    public void accept_one_euro_coin(){
        this.coinToTest = new Coin(23.25, 7.5);

        assertTrue(coinValidationSystem.validate(coinToTest));
    }

    @Test
    public void accept_two_euros_coin(){
        this.coinToTest = new Coin(25.25, 8.5);

        assertTrue(coinValidationSystem.validate(coinToTest));
    }
}
