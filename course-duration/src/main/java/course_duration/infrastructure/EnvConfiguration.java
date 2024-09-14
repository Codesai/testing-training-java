package course_duration.infrastructure;

import course_duration.Configuration;

public class EnvConfiguration implements Configuration {
    @Override
    public String getValue(String key) {
        return System.getenv(key);
    }
}
