package lambas;

public class LambdasDemo {
    public static String prefix = "-";

    public LambdasDemo() {}

    public LambdasDemo(String message) {
    }

    public static void print(String message) {
        System.out.println(message);
    }

    public void instancePrint(String message) {
        System.out.println(message);
    }


    public static void show() {
        // anonymous inner class
        greet(new Printer() {
            @Override
            public void print(String message) {
                System.out.println(message);
            }
        });

        // lambda expression
        greet(message -> System.out.println(message));

        // lambda expression as a variable
        Printer printer = message -> System.out.println(message);
        greet(printer);

        // lambdas can use variables and fields
        greet(message -> System.out.println(prefix + message));

        // method reference
        greet(System.out::println);
        greet(LambdasDemo::print);
        greet(LambdasDemo::new);

        var demo = new LambdasDemo();
        greet(demo::instancePrint);


    }

    public static void greet(Printer printer) {
        printer.print("Hello World");

    }
}
