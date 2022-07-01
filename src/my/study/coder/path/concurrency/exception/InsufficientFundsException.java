package my.study.coder.path.concurrency.exception;

public class InsufficientFundsException extends RuntimeException {
    public InsufficientFundsException() {
        super("Not enough money in the account");
    }
}
