package microwavecc;

public class ManualMicrowave extends DeviceFunction {
    @Override
    void deviceOff() {
        System.out.println("Waiting for new task");
    }
}
