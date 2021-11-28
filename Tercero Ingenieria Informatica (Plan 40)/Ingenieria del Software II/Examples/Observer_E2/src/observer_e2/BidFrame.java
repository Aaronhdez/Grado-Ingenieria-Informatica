/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observer_e2;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.observer.Bidder;
import model.observer.Observer;
import model.subject.Product;
import view.BidderDisplay;

/**
 *
 * @author Usuario
 */
public class BidFrame extends JFrame implements BidderDisplay{
    private ArrayList<BidderDialog> bidderDialogs;
    private Product currentProduct;
    private JPanel panel;
    private JTextField texto;
    private int pujador = 0;

    public BidFrame(Product currentProduct) {
        this.bidderDialogs = new ArrayList<BidderDialog>();
        this.currentProduct = currentProduct;
    }
    
    private void loadBidders(){
        for (Observer obs : currentProduct.currentObservers()) {
            bidderDialogs.add(new BidderDialog(obs));
        }
        for (BidderDialog bidderDialog : bidderDialogs) {
            bidderDialog.execute();
        }
    }
    
    private void init(){
        this.setTitle("BidderFrame");
        this.setSize(600,150);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        loadPanel();
    }
    
    private void loadPanel(){
        Container contentPane = this.getContentPane();
        this.panel = new JPanel();
        this.texto = new JTextField(this.currentProduct.toString());
        contentPane.setLayout(new BorderLayout());
        contentPane.add(panel.add(texto), BorderLayout.CENTER);
        JButton btn = new JButton("Pujar");
        initBtn(btn);
        contentPane.add(btn, BorderLayout.EAST);   
    }
    
    private void initBtn(JButton btn){
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evn){
                int newAmount = (int) (Math.random()*1000 / Math.random()*13);
                int bidderActor = pujador%bidderDialogs.size();
                pujador++;
                currentProduct.setBidAmount((Observer) currentProduct.currentObservers().get(bidderActor), newAmount);
                currentProduct.notifyObservers();
                for (BidderDialog bidderDialog : bidderDialogs) {
                    bidderDialog.refresh();
                }
                refresh();
            }
        });
    }

    @Override
    public void refresh() {
        this.texto.setText(this.currentProduct.toString());
    }
    
    @Override
    public void execute() {
        loadBidders();
        init();
        this.setVisible(true);
    }
    
}
