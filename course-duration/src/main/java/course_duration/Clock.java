package course_duration;

import java.time.Instant;

public interface Clock {
    Instant now();
}
