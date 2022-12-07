package streams;

import java.util.Arrays;
import java.util.stream.Stream;

public class CreatingStreamsDemo {
    public static void show() {
        int[] numbers = {1, 2, 3};
        Arrays.stream(numbers)
                .forEach(n -> System.out.println(n));

        // finite streams
        var finiteStream = Stream.of(1, 2, 3, 4);

        // infinite streams
        var infiniteStream = Stream.generate(Math::random);
        infiniteStream.limit(1).forEach(n -> System.out.println(n));

        Stream.iterate(1, n -> n + 1)
                .limit(10)
                .forEach(System.out::println);

    }
}
