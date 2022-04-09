package icebergtracker.model.entity;

import icebergtracker.persistence.IcebergEvent;
import java.time.LocalDate;

public class Iceberg {
    private final String id;
    private final LocalDate spawnDate;
    private final IcebergOrigin origin;
    private final IcebergEvent event; 

    public Iceberg(String id, LocalDate spawnDate, IcebergOrigin origin, IcebergEvent event) {
        this.id = id;
        this.spawnDate = spawnDate;
        this.origin = origin;
        this.event = event;
    }

    public String getId() {
        return id;
    }

    public LocalDate getSpawnDate() {
        return spawnDate;
    }

    public IcebergOrigin getOrigin() {
        return origin;
    }

    public IcebergEvent getEvent() {
        return event;
    }

    @Override
    public String toString() {
        return "Iceberg{" + "id=" + id + ", spawnDate=" + spawnDate + ", origin=" + origin + ", event=" + event + '}';
    }
}
