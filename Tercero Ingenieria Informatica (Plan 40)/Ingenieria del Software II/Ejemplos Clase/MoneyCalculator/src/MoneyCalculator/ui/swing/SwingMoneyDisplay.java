package MoneyCalculator_13112020.ui.swing;

import MoneyCalculator_13112020.model.Money;
import MoneyCalculator_13112020.ui.MoneyDisplay;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SwingMoneyDisplay extends JPanel implements MoneyDisplay{
    private Money money;
    
    @Override
    public void display(Money money) {
        this.money = money;
        this.removeAll();
        this.add(amount());
        this.add(currency());
        this.updateUI();
    }

    private Component amount() {
        return new JLabel(String.valueOf(money.getAmount()));
    }

    private Component currency() {
        return new JLabel(String.valueOf(money.getCurrency().getCode()));
    }
    
}
