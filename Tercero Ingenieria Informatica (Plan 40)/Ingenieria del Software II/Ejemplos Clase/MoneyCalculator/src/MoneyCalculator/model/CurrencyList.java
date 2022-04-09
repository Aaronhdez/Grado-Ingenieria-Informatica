package MoneyCalculator_13112020.model;

import java.util.HashMap;
import java.util.Map;

public class CurrencyList {
    private final Map<String, Currency> currencies = new HashMap<>();

    public CurrencyList() {
        add(new Currency("USD","Dolar americano","$"));
        add(new Currency("EUR","Euro","€"));        
        add(new Currency("GBP","Libra","£"));        
    }

    private void add(Currency currency) {
        currencies.put(currency.getCode(), currency);
    }
    
    public Currency get(String code) {
        return currencies.get(code.toUpperCase());
    }
}
