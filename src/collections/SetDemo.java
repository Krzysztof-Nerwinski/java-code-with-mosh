package collections;

import java.util.*;

public class SetDemo {
    public static void show() {
        Set<String> set = new HashSet<>();
        set.add("sky");
        set.add("is");
        set.add("blue");
        set.add("blue");
        // order is not guaranteed
        System.out.println(set);


        // removing duplicates
        Collection<String> collection = new ArrayList<>();
        Collections.addAll(collection, "a", "b", "c", "c");
        Set<String> setFromArrayList = new HashSet<>(collection);
        System.out.println(collection);
        System.out.println(setFromArrayList);

        // set operations
        Set<String> set1 = new HashSet<>(Arrays.asList("a", "b" ,"c"));
        Set<String> set2 = new HashSet<>(Arrays.asList("b", "c" ,"d"));

        System.out.println("union");
        System.out.println(set1);
        set1.addAll(set2);
        System.out.println(set1);

        System.out.println("intersection");
        System.out.println(set1);
        set1.retainAll(set2);
        System.out.println(set1);

        System.out.println("difference");
        set1.add("X");
        System.out.println(set1);
        set1.removeAll(set2);
        System.out.println(set1);


    }
}
