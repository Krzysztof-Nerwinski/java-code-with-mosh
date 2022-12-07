package streams;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsDemo {
    public static void show() {
        List<Movie> movies = List.of(
                new Movie("a", 10, Genre.THRILLER),
                new Movie("b", 15, Genre.ACTION),
                new Movie("c", 20, Genre.COMEDY)
        );

        // imperative programming - code describes how something should be one
        int count = 0;
        for (var movie : movies) {
            if (movie.getLikes() > 10)
                count++;
        }

        // declarative programming - code describes what should be done
        var count2 = movies.stream()
                .filter(movie -> movie.getLikes() > 10)
                .count();

        System.out.printf("imperative count: %d, declarative count: %d\n", count, count2);

        movies.stream()
                .map(movie -> movie.getTitle())
                .forEach(System.out::println);

        movies.stream()
                .mapToInt(movie -> movie.getLikes())
                .forEach(System.out::println);

        var intStream = Stream.of(List.of(1, 2, 3), List.of(4, 5, 6));
        intStream.forEach(System.out::println);
        var intStreamToFlat = Stream.of(List.of(1, 2, 3), List.of(4, 5, 6));
        intStreamToFlat.flatMap(list -> list.stream())
                .forEach(n -> System.out.println(n));

        Predicate<Movie> isPopular = m -> m.getLikes() > 10;
        Function<Movie, String> getTitle = m -> m.getTitle();
        Function<Movie, Integer> getLikes = m -> m.getLikes();

        movies.stream()
                .filter(isPopular)
                .map(getLikes)
                .forEach(System.out::println);

        // slicing streams: limit, skip, takeWhile(predicate), dropWhile(predicate)
        System.out.println("limit");
        movies.stream()
                .limit(2)
                .map(getTitle)
                .forEach(System.out::println);

        System.out.println("skip");
        movies.stream()
                .skip(2)
                .map(getTitle)
                .forEach(System.out::println);

        System.out.println("take while likes < 20");
        movies.stream()
                .takeWhile(movie -> movie.getLikes() < 20)
                .forEach(movie -> System.out.println(movie.getLikes()));

        System.out.println("drop while likes < 20");
        movies.stream()
                .dropWhile(movie -> movie.getLikes() < 20)
                .forEach(movie -> System.out.println(movie.getLikes()));

        System.out.println("Sorting");

        movies.stream()
                .sorted((movie1, movie2) -> movie1.getTitle().compareTo(movie2.getTitle()))
                // this is the same
                .sorted(Comparator.comparing(Movie::getTitle))
                .forEach(movie -> System.out.println(movie.getTitle()));

        System.out.println("reverse Sorting");
        movies.stream()
                .sorted((movie1, movie2) -> movie2.getTitle().compareTo(movie1.getTitle()))
                // this is the same
                .sorted(Comparator.comparing(Movie::getTitle).reversed())
                .forEach(movie -> System.out.println(movie.getTitle()));

        System.out.println("Unique elements");
        var repeatedMovies = List.of(
                new Movie("a", 10, Genre.THRILLER),
                new Movie("a", 10, Genre.ACTION),
                new Movie("b", 15, Genre.COMEDY),
                new Movie("c", 20, Genre.THRILLER)
        );

        repeatedMovies.stream()
                .map(m -> m.getLikes())
                .distinct()
                .forEach(System.out::println);

        System.out.println("Peeking elements");
        movies.stream()
                .filter(isPopular)
                .peek(m -> System.out.println("filtered: " + m.getTitle()))
                .map(Movie::getTitle)
                .peek(t -> System.out.println("mapped title: " + t))
                .forEach(System.out::println);

        System.out.println("Reducers");
        // count, anyMatch, allMatch, noneMatch, findFirst, findAny, max, min

        var anyIsPopular = movies.stream()
                .anyMatch(isPopular);
        System.out.println("anyIsPopular " + anyIsPopular);

        var allArePopular = movies.stream()
                .allMatch(isPopular);
        System.out.println("allArePopular " + allArePopular);

        var noPopular = movies.stream()
                .noneMatch(isPopular);
        System.out.println("noPopular " + noPopular);

        var firstPopular = movies.stream()
                .filter(isPopular)
                .findFirst()
                .get();
        System.out.println("firstPopular " + firstPopular.getTitle());

        var anyPopular = movies.stream()
                .filter(isPopular)
                .findAny()
                .get();
        System.out.println("anyPopular " + anyPopular.getTitle());

        var maxLikes = movies.stream()
                .max(Comparator.comparing(Movie::getLikes))
                .get();
        System.out.println("maxLikes " + maxLikes.getTitle() + " " + maxLikes.getLikes());

        var minLikes = movies.stream()
                .min(Comparator.comparing(Movie::getLikes))
                .get();
        System.out.println("minLikes " + minLikes.getTitle() + " " + minLikes.getLikes());

        // general purpose reducers
        System.out.println("general purpose reducers");

        var totalLikes = movies.stream()
                .map(getLikes)
                .reduce(0, Integer::sum);
        System.out.println("totalLikes " + totalLikes);

        // collectors
        System.out.println("Collectors");
        var popularMovies = movies.stream()
                .filter(isPopular)
                .collect(Collectors.toList());
        System.out.println("popularMovies " + popularMovies);

        var titleLikesMap = movies.stream()
                .filter(isPopular)
                .collect(Collectors.toMap(getTitle, getLikes));
        System.out.println("movieLikesMap " + titleLikesMap);

        var titleMovieMap = movies.stream()
                .filter(isPopular)
                .collect(Collectors.toMap(getTitle, m -> m));
//        var titleMovieMap = movies.stream()
//                .filter(isPopular)
//                .collect(Collectors.toMap(getTitle, Function.identity()));
        System.out.println("titleMovieMap " + titleMovieMap);

        var popularMoviesLikes = movies.stream()
                .filter(isPopular)
                .collect(Collectors.summingInt(Movie::getLikes));
        System.out.println("popularMoviesLikes " + popularMoviesLikes);

        var popularMoviesLikesAsDouble = movies.stream()
                .filter(isPopular)
                .collect(Collectors.summingDouble(Movie::getLikes));
        System.out.println("popularMoviesLikesAsDouble " + popularMoviesLikesAsDouble);

        var popularLikesStatistics = movies.stream()
                .filter(isPopular)
                .collect(Collectors.summarizingInt(Movie::getLikes));
        System.out.println("popularLikesStatistics " + popularLikesStatistics);

        var popularMoviesTitles = movies.stream()
                .filter(isPopular)
                .map(getTitle)
                .collect(Collectors.joining(", "));
        System.out.println("popularMoviesTitles " + popularMoviesTitles);


        // grouping elements
        System.out.println("Grouping elements");

        var genreMoviesListMap = movies.stream()
                .collect(Collectors.groupingBy(Movie::getGenre));
        System.out.println("genreMoviesMap " + genreMoviesListMap);

        var genreMoviesSetMap = movies.stream()
                .collect(Collectors.groupingBy(Movie::getGenre, Collectors.toSet()));
        System.out.println("genreMoviesSetMap " + genreMoviesSetMap);

        var genreMoviesCountMap = movies.stream()
                .collect(Collectors.groupingBy(Movie::getGenre, Collectors.counting()));
        System.out.println("genreMoviesCountMap " + genreMoviesCountMap);

        var genreMovieTitlesMap = repeatedMovies.stream()
                .collect(Collectors.groupingBy(Movie::getGenre,
                        Collectors.mapping(Movie::getTitle, Collectors.joining(", "))));
        System.out.println("genreMovieTitlesMap " + genreMovieTitlesMap);


        // partitioning
        System.out.println("Partitioning");

        var moviesPartitionedByLikes = movies.stream()
                .collect(Collectors.partitioningBy(
                        m -> m.getLikes() > 15,
                        Collectors.mapping(Movie::getTitle,
                                Collectors.joining(", "))
                ));
        System.out.println("moviesPartitionedByLikes " + moviesPartitionedByLikes);

        // primitive type streams
        System.out.println("Primitive type streams");

        System.out.println("exclusiveRange ");
        IntStream.range(0, 5).forEach(System.out::println);
        System.out.println("inclusiveRange");
        IntStream.rangeClosed(0, 5).forEach(System.out::println);
    }
}
