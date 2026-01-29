package course_duration.domain;

import java.time.Instant;

public interface Clock {
    Instant now();
}
