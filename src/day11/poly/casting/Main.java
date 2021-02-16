package day11.poly.casting;

public class Main {
    public static void main(String[] args) {

        Parent p = new Parent();
        p.method1();
        p.method2();
//        p.method3();

        System.out.println("============================");

        Parent c = new Child();
        c.method1();
        c.method2();
        ((Child)c).method3();       // (캐스팅) > . > 단항 > 이항 > 3항  단항으로된걸 캐스팅으로 하기위해...
    }
}
