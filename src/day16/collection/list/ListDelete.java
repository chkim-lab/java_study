package day16.collection.list;

import java.util.*;

public class ListDelete {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<String> students = new ArrayList<>(Arrays.asList("영웅재중", "최강창민", "시아준수", "믹키유천", "유노윤호")); //변동형 리스트
        System.out.println("* 변경 전 정보: " + students);

        while(true) {
            System.out.println("- 삭제할 학생의 별명을 입력하세요! ");
            System.out.print("> ");
            String name = sc.next();

            //데이터가 탐색되었는지 조건 판단!
            if(students.contains(name)) {
                System.out.println(name + "의 별명을 삭제합니다.");
                students.remove(name);
                System.out.print("* 삭제 후 정보: "+ students);
                break;
            }else {
                System.out.printf("해당 별명(%s)은 존재하지 않습니다.\n", name);
                continue;
            }
        }
        sc.close();
    }
}
