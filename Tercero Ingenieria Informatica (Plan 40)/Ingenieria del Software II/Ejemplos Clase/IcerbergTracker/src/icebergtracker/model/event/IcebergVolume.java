package icebergtracker.model.event;

import icebergtracker.persistence.IcebergEvent;

public class IcebergVolume implements IcebergEvent{
    private final int volume;

    public IcebergVolume(int volume) {
        this.volume = volume;
    }

    public int getVolume() {
        return volume;
    }

    @Override
    public String toString() {
        return "IcebergVolume{" + "volume=" + volume + '}';
    }
    
}
