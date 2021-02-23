package day16.collection.list;

import java.util.*;

public class ListModify {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> tvxq = new ArrayList<>(Arrays.asList("영웅재중", "최강창민", "시아준수", "믹키유천", "유노윤호")); //변동형 리스트
        System.out.println("* 변경 전 정보: " + tvxq);

        while (true) {
            System.out.println("- 수정할 멤버의 이름을 입력하세요.");
            System.out.print("> ");
            String name = sc.next();

            if(tvxq.contains(name)) {
                System.out.println(name + "의 별명을 변경합니다.");
                System.out.print("> ");

                tvxq.set(tvxq.indexOf(name), sc.next());

                System.out.println("변경 완료!");
                System.out.println("* 변경 후 정보: " + tvxq);
                break;
            } else {
                System.out.printf("해당 이름(%s)은 존재하지 않습니다.", name);
                continue;
            }
        }
        sc.close();
    }
}
