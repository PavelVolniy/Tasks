package microwavecc;

abstract public class DeviceFunction implements DeviceMode {
    @Override
    public void printHeatingMode() {
        System.out.println("The device is in heating mode");
    }

    void deviceOn() {
        System.out.println("Device is ON");
    }

    abstract void deviceOff();
}
