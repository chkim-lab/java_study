
package day12.abs.good;

public class Main {

    public static void main(String[] args) {

        //추상클래스의 객체는 생성 불가능능
        Juicy juicy = new JuicySeoul();
        juicy.orderSnack();
        juicy.orderIce();
        juicy.orderAppleJuice();
    }
}