package MoneyCalculator_13112020.persistence;

import MoneyCalculator_13112020.model.Currency;
import MoneyCalculator_13112020.model.ExchangeRate;

public interface ExchangeRateLoader {
    public ExchangeRate load(Currency from, Currency to);
}
