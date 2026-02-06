package tirepressuremonitoringsystem;

public class Alarm {

    private static final int LOW_PRESSURE_THRESHOLD = 17;
    private static final int MAX_PRESSURE_THRESHOLD = 21;
    private final Sensor sensor = new Sensor();

    private boolean alarmOn = false;

    public void check() {
        double psiPressureValue = sampleValue();

        if (psiPressureValue < (double) LOW_PRESSURE_THRESHOLD || (double) MAX_PRESSURE_THRESHOLD < psiPressureValue) {
            if(!isAlarmOn()) {
                alarmOn = true;
                showMessage("Alarm activated!");
            }
        } else {
            if(isAlarmOn()) {
                alarmOn = false;
                showMessage("Alarm deactivated!");
            }
        }
    }

    protected void showMessage(String message) {
        System.out.println(message);
    }

    protected double sampleValue() {
        return sensor.popNextPressurePsiValue();
    }

    private boolean isAlarmOn() {
        return alarmOn;
    }
}
