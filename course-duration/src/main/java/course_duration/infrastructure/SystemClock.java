package course_duration.infrastructure;

import course_duration.domain.Clock;

import java.time.Instant;

public class SystemClock implements Clock {
    @Override
    public Instant now() {
        return Instant.now();
    }
}
