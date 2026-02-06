package tirepressuremonitoringsystem;

public class Alarm {

    private static final int LOW_PRESSURE_THRESHOLD = 17;
    private static final int MAX_PRESSURE_THRESHOLD = 21;
    private final Sensor sensor = new Sensor();

    private boolean alarmOn = false;

    public void check() {
        double psiPressureValue = sensor.popNextPressurePsiValue();

        if (psiPressureValue < (double) LOW_PRESSURE_THRESHOLD || (double) MAX_PRESSURE_THRESHOLD < psiPressureValue) {
            if(!isAlarmOn()) {
                alarmOn = true;
                System.out.println("Alarm activated!");
            }
        } else {
            if(isAlarmOn()) {
                alarmOn = false;
                System.out.println("Alarm deactivated!");
            }
        }
    }

    private boolean isAlarmOn() {
        return alarmOn;
    }
}
