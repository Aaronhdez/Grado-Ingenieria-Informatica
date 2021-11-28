/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class UsersData {
    
    private ArrayList<Observer> observers;
    private ArrayList<User> users;
    private User currentUser;
    private int index;

    public UsersData() {
        this.observers = new ArrayList();
        this.users = new ArrayList();
        this.index = 0;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public String[] getUsers() {
        String[] res = new String[this.users.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = this.users.get(i).getNid() +" | "+  this.users.get(i).getName();
        }
        return res;
    }
    
    public void addUser(User user){
        this.users.add(user);
        this.currentUser = this.users.get(index);
    }
    
    public void setCurrentIndex(int newIndex){
        this.index = newIndex;
        this.currentUser = this.users.get(this.index);
        this.changeStatus();
    }
    
    public void next() {
        this.index = (this.index == this.users.size()-1)? 0: this.index+1;
        this.currentUser = this.users.get(this.index);
        this.changeStatus();
    }

    public void prev() {
        this.index = (this.index == 0)? this.users.size()-1: this.index-1;
        this.currentUser = this.users.get(this.index);
        this.changeStatus();
    }
    
    public void registerObservers(Observer obs){
        this.observers.add(obs);
    }
    
    public void changeStatus(){
        for (Observer observer : observers) {
            observer.change();
        }
    }
    
    public static interface Observer{
        void change();
    }
}
