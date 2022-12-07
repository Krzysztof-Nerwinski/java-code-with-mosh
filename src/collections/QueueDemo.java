package collections;

import java.util.ArrayDeque;
import java.util.Queue;

public class QueueDemo {
    public static void show() {
        Queue<String> queue = new ArrayDeque<>();
        queue.add("c");
        queue.add("a");
        queue.add("b");
        System.out.println(queue);
        var elementOrNull = queue.peek();
        System.out.println(elementOrNull);

        var elementOrExc = queue.element();

        var removedElementOrExc = queue.remove();
        System.out.println(queue);
        System.out.println(removedElementOrExc);
        queue.clear();
        var removedElementOrNull = queue.poll();
        System.out.println(removedElementOrNull);



    }
}
