package exceptions;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ExceptionsDemo {

    public static void show() {
        //        FileReader reader = null;

        try (
                var reader = new FileReader("file.txt");
                var writer = new FileWriter("...")
        ) {
            var value = reader.read();
        } catch (IOException e) {
            System.out.println("Could not read data.");
        }


        var account = new Account();
//        account.deposit(-10);
        try {
            account.deposit(-1);
        } catch (IOException e) {
            System.out.println("Logging");
//            throw e;
        }

        try {
            account.withdraw(10);
        } catch (AccountException e) {
            System.out.println(e.getMessage());
            var cause = e.getCause();
            System.out.println(cause.getMessage());
            e.printStackTrace();
        }
    }

}
