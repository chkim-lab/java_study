package day04;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayModifyQuiz {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] tvxq = {"영웅재중", "최강창민", "시아준수", "믹키유천", "유노윤호"};
        System.out.println("* 변경 전 정보: " + Arrays.toString(tvxq));

        while (true) {
            System.out.println("- 수정할 멤버의 이름을 입력하세요.");
            System.out.print("> ");
            String name = sc.next();

            int i;
            for (i = 0; i < tvxq.length; i++)
                if (name.equals(tvxq[i])) break;

            if (i == tvxq.length) {
                System.out.println("해당 이름은 존재하지 않습니다.");
                continue;
            } else {
                System.out.println(tvxq[i] + "의 별명을 변경합니다.");
                System.out.print("> ");
                tvxq[i] = sc.next();
                System.out.println("변경 완료!");
                System.out.println("* 변경 후 정보: " + Arrays.toString(tvxq));
                break;
            }
        }

        sc.close();

    }
}
