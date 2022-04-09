package icebergtracer.main;

import icebergtracker.model.entity.Iceberg;
import icebergtracker.model.entity.IcebergOrigin;
import icebergtracker.model.event.IcebergLocation;
import icebergtracker.model.event.IcebergVolume;
import icebergtracker.persistence.IcebergEvent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class IcebergTracker {
    
    public static void main(String[] args) {
        List<Iceberg> icebergs = new ArrayList<>();
        List<IcebergEvent> icebergsEvents = new ArrayList<>();

        icebergs.add(new Iceberg("ICE01", LocalDate.now(), IcebergOrigin.GLACIAR, new IcebergVolume(400)));
        icebergs.add(new Iceberg("ICE01", LocalDate.now(), IcebergOrigin.GLACIAR, new IcebergLocation(15,23)));
        
        for(Iceberg i: icebergs){
            System.out.println(i.toString());
        }
    }
}
