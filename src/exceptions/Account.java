package exceptions;

import java.io.IOException;

public class Account {
    private float balance;
    public void deposit(float value) throws IOException {

//        if (value <= 0)
//            throw new IllegalArgumentException("Provided have to be higher than 0");
        if (value <= 0) {
            throw new IOException("Provided have to be higher than 0");
        }

        System.out.printf("Deposit of %,.2f has been made", value);
    }

    public void withdraw(float value) throws AccountException {
        if (value > balance) {
//            var fundsException = new InsufficientFundsException();
//            var accountsException = new AccountException();
//            accountsException.initCause(fundsException);
            throw new AccountException(new InsufficientFundsException());
        }
    }
}
