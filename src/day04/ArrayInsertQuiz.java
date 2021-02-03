package day04;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayInsertQuiz {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int count = 0;
        String[] foods = new String[count];

        System.out.println("# 먹고 싶은 음식을 입력하세요!!");
        System.out.println("# 입력을 중지하려면 <그만>이라고 입력하세요.");

        while (true) {
            System.out.print("> ");
            String answer = sc.nextLine();
            if(answer.equals("그만")) {
                System.out.println("입력 종료!!");
                sc.close();
                break;
            }
            String[] temp = new String[count + 1];
            for (int i = 0; i < count; i++) {
                temp[i] = foods[i];
            }
            temp[temp.length - 1] = answer;
            foods = temp; temp = null;
            count++;
        }
        System.out.print("내가 먹고싶은 음식들: " + Arrays.toString(foods));

    }
}