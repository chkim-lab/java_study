package day13.exception;

public class Main {
    public static void main(String[] args) {

        Account myAcc = new Account(5000);
        try {
            myAcc.withDraw(13000);
        } catch (BalanceInsufficientException e) {
            e.printStackTrace();
        }
    }
}
