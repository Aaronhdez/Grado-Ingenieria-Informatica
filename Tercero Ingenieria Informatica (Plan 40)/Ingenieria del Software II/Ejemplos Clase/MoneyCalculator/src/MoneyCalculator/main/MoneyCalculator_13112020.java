
package MoneyCalculator_13112020.main;

import MoneyCalculator_13112020.control.CalculateCommand;
import MoneyCalculator_13112020.persistence.CurrencyListLoader;
import MoneyCalculator_13112020.persistence.ExchangeRateLoader;
import MoneyCalculator_13112020.persistence.file.FileCurrencyListLoader;
import MoneyCalculator_13112020.persistence.rest.RestExchangeRateLoader;


public class MoneyCalculator_13112020 {
    public static void main(String[] args) {
        CurrencyListLoader cLLoader = new FileCurrencyListLoader("currencies");
        ExchangeRateLoader eRLoader = new RestExchangeRateLoader();
        MoneyCalculatorFrame moneyCalculatorFrame = new MoneyCalculatorFrame(cLLoader.currencies());
        moneyCalculatorFrame.add(new CalculateCommand(moneyCalculatorFrame.getMoneyDialog(),moneyCalculatorFrame.getMoneyDisplay(), eRLoader));
    }
}
