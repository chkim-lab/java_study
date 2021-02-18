package day13.exception;

public class Account {

    private int balance; //잔액

    public  Account(int balance) {
        this.balance = balance;
    }
    public int getBalance() {
        return balance;
    }

    //출금 기능
    public void withDraw(int money) throws BalanceInsufficientException{
        if (balance < money) {
            throw new BalanceInsufficientException("잔고 부족 에러: " + (money - balance) + "원 부족!");
//            System.out.println("잔고가 부족합니다.");  //소극적인 대응
//            return;
        }
        this.balance-= money;
    }
}
