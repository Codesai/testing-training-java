package tirepressuremonitoringsystem;

public class Alarm {

    private static final double LOW_PRESSURE_THRESHOLD = 17;
    private static final double MAX_PRESSURE_THRESHOLD = 21;
    private final Sensor sensor = new Sensor();

    private boolean alarmOn = false;

    public void check() {
        double psiPressureValue = sampleValue();

        if (psiPressureValue < LOW_PRESSURE_THRESHOLD || MAX_PRESSURE_THRESHOLD < psiPressureValue) {
            if (!isAlarmOn()) {
                alarmOn = true;
                notify("Alarm activated!");
            }
        } else {
            if (isAlarmOn()) {
                alarmOn = false;
                notify("Alarm deactivated!");
            }
        }
    }

    protected void notify(String message) {
        System.out.println(message);
    }

    protected double sampleValue() {
        return sensor.popNextPressurePsiValue();
    }

    private boolean isAlarmOn() {
        return alarmOn;
    }
}
