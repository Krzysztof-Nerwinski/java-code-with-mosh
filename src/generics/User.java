package generics;

public class User implements Comparable<User> {
    private int points;

    public User(int points) {
        this.points = points;
    }

    @Override
    public int compareTo(User other) {
        // this < o -> return negative value
        // this == -> return 0
        // this > -> return positive value
        return points - other.points;
    }

    @Override
    public String toString() {
        return "User points = " + points;
    }
}
