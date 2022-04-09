package icebergtracker.model.event;

import icebergtracker.persistence.IcebergEvent;

public class IcebergLocation implements IcebergEvent {
    private final double latitude ;
    private final double longitude;

    public IcebergLocation(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    @Override
    public String toString() {
        return "IcebergLocation {" + "latitude=" + latitude + ", longitude=" + longitude + " Date=" + date + '}';
    }
    
}
