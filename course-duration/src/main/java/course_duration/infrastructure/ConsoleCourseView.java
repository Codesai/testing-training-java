package course_duration.infrastructure;

import course_duration.CourseView;

public class ConsoleCourseView implements CourseView {
    @Override
    public void displayLine(String line) {
        System.out.println(line);
    }
}
