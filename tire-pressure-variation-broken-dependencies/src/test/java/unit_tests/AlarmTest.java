package unit_tests;

import org.junit.jupiter.api.Test;
import tirepressuremonitoringsystem.Alarm;

import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

public class AlarmTest {

    @Test
    public void alarm_activates_when_pressure_is_too_low() {
        var alarm = alarmSampling(10.0);
        
        alarm.check();
        
        assertThat(alarm.shownMessages).isEqualTo(List.of("Alarm activated!"));
    }

    static class AlarmForTesting extends Alarm {

        private final Queue<Double> sampledValues;
        public List<String> shownMessages;

        public AlarmForTesting(Double... values) {
            this.shownMessages = new ArrayList<>();
            this.sampledValues = new ArrayDeque<>(Arrays.asList(values));
        }

        @Override
        protected void showMessage(String message) {
            shownMessages.add(message);
        }

        @Override
        protected double sampleValue() {
            return sampledValues.remove();
        }
    }

    private AlarmForTesting alarmSampling(Double... values) {
        return new AlarmForTesting(values);
    }
}

