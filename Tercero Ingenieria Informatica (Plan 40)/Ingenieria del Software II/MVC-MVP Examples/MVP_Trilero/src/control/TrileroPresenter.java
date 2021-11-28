/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import model.Ball;
import view.TrileroDisplay;
import view.TrileroDisplay.Touch;

/**
 *
 * @author Usuario
 */
public class TrileroPresenter implements Ball.Observer{
    
    private TrileroDisplay trileroGamePanel;
    private TrileroDisplay trileroResetPanel;
    private Ball ball;

    public TrileroPresenter(TrileroDisplay trileroGamePanel, TrileroDisplay trileroResetPanel) {
        this.trileroGamePanel = trileroGamePanel;
        this.trileroResetPanel = trileroResetPanel;
        this.ball = new Ball();
        this.ball.registerObservers(this);
        this.trileroGamePanel.on(new Touch(){
            @Override
            public void doAction(int i) {
                ball.checkPosition(i);
                trileroGamePanel.lock();
                trileroResetPanel.unlock();
            }
        });
        this.trileroResetPanel.on(new Touch(){
            @Override
            public void doAction(int i) {
                ball.shuffle(i);
                trileroGamePanel.unlock();
                trileroResetPanel.lock();
            }
        });
    }
    
    @Override
    public void changed() {
        this.refresh();
    }
    
    public void refresh(){
        this.trileroGamePanel.reload(this.ball);
    }
}
