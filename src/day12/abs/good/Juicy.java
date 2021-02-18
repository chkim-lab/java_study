package day12.abs.good;

//추상 클래스
public abstract class Juicy {

    public Juicy() {
        System.out.println("추상 클래스의 생성자 호출!");
    }

    //추상 메서드 선언
    public abstract void orderAppleJuice();
    public abstract void orderGrapeJuice();

    public void orderSnack() {
        System.out.println("과자는 3000원입니다.");
    }
    public final void orderIce() {
        System.out.println("아이스크림은 500원입니다.");
    }
}