package collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapDemo {
    public static void show() {
        // looking through the list without Maps O(n)
        List<Customer> customerList = new ArrayList<>();
        for (var customer : customerList) {
            if (customer.getEmail() == "email@email.com") {
                System.out.println("Found");
            }
        }

        // how to implement this in maps
        var c1 = new Customer("a", "e1");
        var c2 = new Customer("b", "e2");
        Map<String, Customer> map = new HashMap<>();
        map.put(c1.getEmail(), c1);
        map.put(c2.getEmail(), c2);

        var customer = map.get("e1");
        System.out.println(customer);

        var customerOrNull = map.get("e10");
        System.out.println(customerOrNull);

        var unknown = new Customer("unknown", "");
        var customerOrDefault = map.getOrDefault("e10", unknown);
        System.out.println(customerOrDefault);

        var exists = map.containsKey("e10");
        System.out.println(exists);

        var replaced = map.replace("e1", new Customer("a++", "e1"));
        System.out.println(replaced);
        System.out.println(map);

        for (var key : map.keySet()) {
            System.out.println(key);
        }

        for (var entry : map.entrySet()) {
            System.out.println(entry);
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
        for (var customerFromList : map.values()) {
            System.out.println(customerFromList);
        }
    }
}
