package unit_tests;

import org.junit.jupiter.api.Test;
import tirepressuremonitoringsystem.Alarm;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

class AlarmTest {

    private AlarmForTesting alarm;

    @Test
    void alarm_activates_when_pressure_is_too_low() {
        alarm = alarmSampling(10.0);

        alarm.check();

        checkShownMessagesWere("Alarm activated!");
    }

    private void checkShownMessagesWere(String... expectedMessages) {
        assertThat(alarm.shownMessages).isEqualTo(Arrays.asList(expectedMessages));
    }

    private AlarmForTesting alarmSampling(Double... values) {
        return new AlarmForTesting(values);
    }

    static class AlarmForTesting extends Alarm {

        private final Queue<Double> sampledValues;
        public List<String> shownMessages;

        public AlarmForTesting(Double... values) {
            this.shownMessages = new ArrayList<>();
            this.sampledValues = new ArrayDeque<>(Arrays.asList(values));
        }

        @Override
        protected void notify(String message) {
            shownMessages.add(message);
        }

        @Override
        protected double sampleValue() {
            return sampledValues.remove();
        }
    }
}

