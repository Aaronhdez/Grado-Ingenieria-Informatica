/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.Block;

/**
 *
 * @author Usuario
 */
public interface BlockDisplay extends Block.Observer{
    public void display(Block block);
}
