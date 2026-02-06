package unit_tests;

import java.util.List;
import java.util.StringJoiner;
import java.util.function.Function;

public class SamplingHelper {
    public static <T> void printValues(List<T> values, Function<? super T, String> formatter) {
        var joiner = new StringJoiner(", ");
        values.stream()
                .map(formatter)
                .forEach(joiner::add);

        System.out.println("Arrays.asList(" + joiner + ");");
    }
}
