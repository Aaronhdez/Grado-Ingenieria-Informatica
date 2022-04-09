/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MoneyCalculator_13112020.ui.swing;

import MoneyCalculator_13112020.model.Currency;
import MoneyCalculator_13112020.model.Money;
import MoneyCalculator_13112020.ui.MoneyDialog;
import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

public class SwingMoneyDialog extends JPanel implements MoneyDialog {
    private final Currency[] currencies;
    private String amount;
    private Currency currency;

    public SwingMoneyDialog(List<Currency> currencies) {
        this.currencies = currencies.toArray(new Currency[0]);
        this.add(amount());
        this.add(currency());
    }
    
    @Override
    public Money get() {
        return new Money(Double.parseDouble(amount), currency);
    }

    private Component amount() {
        JTextField textField = new JTextField("0");
        textField.setColumns(10);
        textField.getDocument().addDocumentListener(amountChanged());
        amount = textField.getText();
        return textField;
    }

    private Component currency() {
        JComboBox combo = new JComboBox(currencies);
        combo.addItemListener(currencyChanged());
        currency = (Currency) combo.getSelectedItem();
        return combo;
    }
    
    private DocumentListener amountChanged() {
        return new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent de) {
                amountChanged(de.getDocument());
            }

            @Override
            public void removeUpdate(DocumentEvent de) {
                amountChanged(de.getDocument());
            }

            @Override
            public void changedUpdate(DocumentEvent de) {
                amountChanged(de.getDocument());
            }
            
            private void amountChanged(Document document){
                try {
                    amount = document.getText(0, document.getLength());
                } catch (BadLocationException ex) {
                    Logger.getLogger(SwingMoneyDialog.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        };
    }

    private ItemListener currencyChanged() {
        return new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                if(ie.getStateChange() == ie.DESELECTED) return;
                currency = (Currency) ie.getItem();
            }
        };
    }
}
