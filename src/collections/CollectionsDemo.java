package collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class CollectionsDemo {
    public static void show() {
        Collection<String> collection = new ArrayList<>();
        Collections.addAll(collection, "a", "b", "c", "d");
        System.out.println(collection);
        collection.clear();
        System.out.println("cleared collection");
        collection.add("a");
        collection.add("b");
        collection.add("c");
        collection.add("d");
        System.out.println(collection);
        System.out.println("contains A = " + collection.contains("a"));

        var objectArray = collection.toArray();
        var stringArray = collection.toArray(new String[0]);

        Collection<String> other = new ArrayList<>();
        other.addAll(collection);

        // check if objects are different
        System.out.println(collection == other);
        // check contents is the same
        System.out.println(collection.equals(other));
    }
}
