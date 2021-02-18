package day13.exception;

public class BalanceInsufficientException extends Exception{

    //에러 메시지를 전달하는 생성자
    public BalanceInsufficientException(String message) {
        super(message);
    }
}
