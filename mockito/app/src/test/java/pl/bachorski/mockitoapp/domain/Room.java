package pl.bachorski.mockitoapp.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Room {

    private String name;
    private List<Device> devices = new ArrayList<>();

    public Room(String name) {
        this.name = name;
    }

    public List<Device> getDevices() {
        return devices;
    }

    public void setDevices(final List<Device> devices) {
        this.devices.clear();
        this.devices.addAll(devices);
    }

    public List<Device> getLights() {
        return devices.stream()
                      .filter(device -> device.getType().equals(DeviceType.SWITCH))
                      .collect(Collectors.toList());
    }

    public List<Device> getBlinds() {
        return devices.stream()
                      .filter(device -> device.getType().equals(DeviceType.BLIND))
                      .collect(Collectors.toList());
    }
}
