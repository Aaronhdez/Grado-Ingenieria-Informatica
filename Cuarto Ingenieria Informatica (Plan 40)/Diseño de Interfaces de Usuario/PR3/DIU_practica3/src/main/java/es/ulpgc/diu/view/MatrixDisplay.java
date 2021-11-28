/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ulpgc.diu.view;

import es.ulpgc.diu.model.MatrixFilter;

/**
 *
 * @author Usuario
 */
public interface MatrixDisplay extends MatrixFilter.Observer{
    void display(MatrixFilter matrixFilter);
}
