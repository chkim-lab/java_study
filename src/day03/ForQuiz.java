package day03;

public class ForQuiz {

    public static void main(String[] args) {

        //2 ~ 9 난수 생성
        int level = (int) (Math.random() * 8) + 2;

        System.out.printf("랜덤 구구단 %d단\n", level);
        System.out.println("-------------------------");
        for (int i = 1; i <= 9; i++) {
            System.out.printf("%d x %d = %d\n", level, i, level * i);
        }

    }
}
