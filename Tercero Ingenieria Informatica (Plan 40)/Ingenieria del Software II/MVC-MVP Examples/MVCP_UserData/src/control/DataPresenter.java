/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import view.DataListDisplay;
import model.UsersData;
import view.DataListDisplay.Touch;

/**
 *
 * @author Usuario
 */
public class DataPresenter implements UsersData.Observer {

    private final DataListDisplay dataListDisplay;
    private final UsersData usersData;

    public DataPresenter(DataListDisplay dataListDisplay, UsersData usersData) {
        this.usersData = usersData;
        this.dataListDisplay = dataListDisplay;
        this.usersData.registerObservers(this);
        this.dataListDisplay.on(new Touch(){
            @Override
            public void setCurrent(int i) {
                usersData.setCurrentIndex(i);
            }
        });
    }

    @Override
    public void change() {
        this.refresh();
    }

    private void refresh() {
        this.dataListDisplay.reload(this.usersData);
    }
    
}
