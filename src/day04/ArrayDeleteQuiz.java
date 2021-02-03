package day04;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayDeleteQuiz {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        String[] students = {"영웅재중", "최강창민", "시아준수", "믹키유천", "유노윤호"};
        System.out.println("* 우리반 학생들의 별명: " + Arrays.toString(students));


        while(true) {
            System.out.println("- 삭제할 학생의 별명을 입력하세요! ");
            System.out.print("> ");
            String name = sc.next();

            //탐색 알고리즘
            int idx;
            for (idx=0; idx<students.length; idx++) {
                if(name.equals(students[idx])) {
                    break;
                }
            }
            //데이터가 탐색되었는지 조건 판단!
            if(idx != students.length) {
                System.out.println(students[idx] + "의 별명을 삭제합니다.");

                //삭제 알고리즘
                for(int i=idx; i<students.length-1; i++) {
                    students[i] = students[i+1];
                }

                //배열 복사 알고리즘
                String[] temp = new String[students.length-1];
                for(int i=0; i<temp.length; i++) {
                    temp[i] = students[i];
                }
                students = temp; temp = null;
                System.out.print("* 삭제 후 정보: "+ Arrays.toString(students));
                break;
            }else {
                System.out.printf("해당 별명(%s)은 존재하지 않습니다.\n", name);
                continue;
            }
        }
        sc.close();

    }
}
