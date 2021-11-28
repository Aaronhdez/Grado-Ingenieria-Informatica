/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observer_e2;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.observer.Bidder;
import model.observer.Observer;
import view.BidderDisplay;

/**
 *
 * @author Usuario
 */
public class BidderDialog extends JDialog implements BidderDisplay{
    private final Observer obs;
    private JPanel panel;
    private JTextField texto;
    private JTextField texto2;
    
    BidderDialog(Observer obs) {
        this.obs=obs;
    }
    
    private void init(){
        this.setTitle("BidderDialog");
        this.setSize(300,250);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        loadPanel();
    }
    
    private void loadPanel(){
        Container contentPane = this.getContentPane();
        this.panel = new JPanel();
        this.texto = new JTextField(this.obs.toString());
        this.texto2 = new JTextField("Sin apuestas realizadas");
        contentPane.setLayout(new BorderLayout());
        contentPane.add(panel.add(texto), BorderLayout.CENTER);
        contentPane.add(panel.add(texto2), BorderLayout.SOUTH);
    }
    
    @Override
    public void execute() {
        init();
        this.setVisible(true);
    }
    
    @Override
    public void refresh() {
        this.texto2.setText(((Bidder) this.obs).getStatus());
    }

}
