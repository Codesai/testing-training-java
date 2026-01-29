package course_duration.domain;

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
    private final CourseView courseView;

    public Course(String name, Configuration configuration, Clock clock, CourseView courseView) {
        this.name = name;
        this.configuration = configuration;
        this.clock = clock;
        this.courseView = courseView;
        durationInMinutes = Duration.ofMinutes(0);
    }

    public void showDetails() {
        this.courseView.displayLine("Title: " + getTitle());
        this.courseView.displayLine("Duration: " + durationInMinutes.toMinutes() + " minutes");
        this.courseView.displayLine("Type: " + (isShort() ? "short" : "long"));
    }

    public void start() {
        startTime = clock.now();
    }

    public void end() {
        var endTime = clock.now();
        durationInMinutes = computeMinutesBetween(startTime, endTime);
        System.out.println(durationInMinutes);
    }

    private boolean isShort() {
        return durationInMinutes.compareTo(MAX_MINUTES_SHORT_COURSES) < 0;
    }

    private String getTitle() {
        return name + " course in " + getCollege() + " college";
    }

    private Duration computeMinutesBetween(Instant startTime, Instant endTime) {
        return Duration.ofMinutes(ChronoUnit.MINUTES.between(startTime, endTime));
    }

    private String getCollege() {
        String college = configuration.getValue("COLLEGE");
        if (college == null) {
            return "not found";
        }
        return college;
    }
}