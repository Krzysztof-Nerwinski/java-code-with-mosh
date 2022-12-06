package generics;

public class Utils {
    public static <T extends Comparable<T>> T max(T first, T second) {
        return (first.compareTo(second) > 0) ? first : second;
    }

    public static <K, V> void print(K key, V value) {
        System.out.println(key + "=" + value);
    }

    public static void printUser(User user) {
        System.out.println(user);
    }

    public static void printUsers(GenericList<? extends User> users) {
        // to read from list use extends keyword ? extends User
        // to add to list use super keyword ? super User
        User x = users.get(0);
//        users.add(new User(10));
        System.out.println(users);
    }
}
