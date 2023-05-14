package pl.bachorski.mockitoapp.domain;

public class Device {
    private Integer value;
    private DeviceType type;

    public Device(DeviceType type, Integer value) {
        this.type = type;
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(final Integer value) {
        this.value = value;
    }

    public DeviceType getType() {
        return type;
    }
}
