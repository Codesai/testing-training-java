package course_duration;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class Course {
    private static final Duration MAX_MINUTES_SHORT_COURSES = Duration.ofMinutes(10);
    private final String name;
    private final Configuration configuration;
    private final Clock clock;
    private Instant startTime;
    private Duration durationInMinutes;

    public Course(String name, Configuration configuration, Clock clock) {
        this.name = name;
        this.configuration = configuration;
        this.clock = clock;
        durationInMinutes = Duration.ofMinutes(0);
    }

    public void start() {
        startTime = clock.now();
    }

    public void end() {
        var endTime = clock.now();
        durationInMinutes = computeMinutesBetween(startTime, endTime);
        System.out.println(durationInMinutes);
    }

    private Duration computeMinutesBetween(Instant startTime, Instant endTime) {
        return Duration.ofMinutes(ChronoUnit.MINUTES.between(startTime, endTime));
    }

    public boolean isShort() {
        return durationInMinutes.compareTo(MAX_MINUTES_SHORT_COURSES) < 0;
    }

    public boolean isLong() {
        return !isShort();
    }

    public String getTitle() {
        return name + " course in " + getCollege() + " college";
    }

    private String getCollege() {
        String college = configuration.getValue("COLLEGE");
        if (college == null) {
            return "not found";
        }
        return college;
    }
}