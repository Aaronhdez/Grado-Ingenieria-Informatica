/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icebergtracker.persistence;
 
import icebergtracker.model.entity.Iceberg;
import java.time.LocalDate;

public interface IcebergEvent {
    public final LocalDate date = LocalDate.now();
    public final Iceberg iceberg = null;     
}
