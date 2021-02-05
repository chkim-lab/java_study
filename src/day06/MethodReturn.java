package day06;

public class MethodReturn {

    static int add(int n1, int n2) {
        return n1 + n2;
    }
    static void printMulti(int n1, int n2) {
        System.out.printf("%d x %d = %d\n", n1, n2, n1 * n2);
    }

    static void greeting(String nickName) {
        if (nickName.equals("멍청이")) {
            System.out.println("부를 수 없는 별명입니다.");
            return;
        }
        System.out.println(nickName + "님 안녕하세요!");
    }

    // 모든 메서드는 리턴값을 하나만 리턴할 수 있습니다.

    static int[] operateAll(int n1, int n2) {
        return new int[]{n1 + n2, n1 - n2, n1 * n1, n1 / n2};
    }
    public static void main(String[] args) {

        int result = add(10, 20);

        //리턴 타입이 void인 메서드는 변수에 저장 불간으.
        //반드시 단독 호춯해서 사용할 것!
        printMulti(5, 6);
        System.out.println();
        Math.random();

        printMulti(add(5,3), add(10,2));

//        add(printMulti(2, 2),22);

        greeting("홍길동");
        greeting("박영희");
        greeting("멍청이");

        int[] datas = operateAll(20,5);
        System.out.println("덧셋결과: " + datas[0]);
        System.out.println("곱셋결과: " + datas[2]);
    }
}
