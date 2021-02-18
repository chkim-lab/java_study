package day13.exception;

public class FinallyExample {
    public static void main(String[] args) {
        String[] pets = {"강아지", "거북이", "소라게"};

        for (int i = 0; i < 4; i++) {
            try {
                System.out.println(pets[i] + " 키울래요!!");
            } catch (Exception e) {
                System.out.println("더 이상 데이터가 없습니다.");
            } finally {
                //메모리 자원 해제 코드
                System.out.println("이 코드는 항상 실행됩니다!!");
            }
        }
        System.out.println("프로그램 정상 종료!");
    }
}
