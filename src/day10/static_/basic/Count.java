package day10.static_.basic;

public class Count {

    //인스턴스 필드:  객체당 하나
    public int num1;

    //정적 필드:  클래스당 하나
    public static int num2;

    public Count() {
        System.out.println("생성자 호출!");
        num1 = 100;
        num2 = 200;
    }

    //정적 초기화 블럭
    static {
        num2 = 200;
    }
    //인스턴스메서드ㅖ: 객체 소속 기능
    public int method1() {
        System.out.println("this: " + this);
        return this.num1 + num2;
    }
    //정적 메서드: 클래스 소속 기능
    public static int method2() {
        //static 블록에서는 this 사용 불가
//        System.out.println("this: " + this);

        //static 블록에서는 인스턴스 멤버를 직적 참조 불가!
        Count c = new Count();    //또는 public static int method2(Count c) { 로 받아서 처리
        c.method1();
//        method2();
//        return num1 + num2;
        return num2;
    }
}
