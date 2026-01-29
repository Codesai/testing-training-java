package course_duration;

import course_duration.domain.Course;
import course_duration.infrastructure.ConsoleCourseView;
import course_duration.infrastructure.EnvConfiguration;
import course_duration.infrastructure.SystemClock;

import java.lang.Thread;
import java.time.Duration;

public class Main {
    public static void main(String[] args) {
        var courseName = args.length > 0 ? args[0] : "Programming 101";
        var course = startCourse(courseName);
        runCourse();
        endCourse(course);
        course.showDetails();
    }

    private static Course startCourse(String courseName) {
        var configuration = new EnvConfiguration();
        var clock = new SystemClock();
        var courseView = new ConsoleCourseView();
        var course = new Course(courseName, configuration, clock, courseView);
        course.start();
        return course;
    }

    private static void endCourse(Course course) {
        course.end();
    }

    private static void runCourse() {
        try {
            Thread.sleep(Duration.ofMinutes(1).toMillis());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
