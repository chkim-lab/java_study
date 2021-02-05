package day06;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class EmployeeManager {

    //모든 메서드에서 사용하기 위한 변수 선언
    static Scanner sc = new Scanner(System.in);

    //현재 저장된 사원 수
    static int count = 0;

    //사원 정보를 저장할 배열들
    static String[] empNumbers = new String[count];
    static String[] names = new String[count];
    static String[] ages = new String[count];
    static String[] departments = new String[count];

    //메뉴를 출력해주는 메서드
    static void showMenu() {
        System.out.println("\n====== 사원 관리 프로그램 ======");
        System.out.println("# 1. 사원정보 신규등록");
        System.out.println("# 2. 모든 사원정보 보기");
        System.out.println("# 3. 사원정보 검색");
        System.out.println("# 4. 사원정보 수정");
        System.out.println("# 5. 사원정보 삭제");
        System.out.println("# 6. 프로그램 종료");
        System.out.println("=================================");
    }

    //프로그램을 종료하는 메서드
    static void exitProgram() {
        System.out.println("프로그램을 종료합니까? [y/n]");
        System.out.print("> ");
        String answer = sc.next();

        switch (answer) {
            case "Y": case "y": case "ㅛ":
                sc.close();
                System.exit(0); //프로그램 종료 메서드
            case "N": case "n": case "ㅜ":
                System.out.println("프로그램 종료를 취소합니다.");
                return;
            default:
                System.out.println("잘못 입력하셨습니다.");
        }
    }

    //배열 추가 기능을 수행하는 메서드
    static String[] append(String[] arr, String data) {
        //배열의 사이즈를 1 증가시킴
        String[] temp = new String[count + 1];
        for (int i=0; i < count; i++) {
            temp[i] = arr[i];
        }
        //새로운 데이터를 추가
        temp[temp.length - 1] = data;
        return temp;
    }

    //사원 정보 등록을 위한 메서드
    static void insertEmpData() {

        System.out.println("\n# 사원정보 등록을 시작합니다.");
        System.out.print("- 사번: ");
        String empNum = sc.next();

        System.out.print("- 이름: ");
        String name = sc.next();

        System.out.print("- 나이: ");
        String age = sc.next();

        System.out.print("- 부서: ");
        String dep = sc.next();

        //배열 사이즈를 증가시키고 데이터를 추가하는 함수
        empNumbers = append(empNumbers, empNum);
        names = append(names, name);
        ages = append(ages, age);
        departments = append(departments, dep);
        count++;

        System.out.println(Arrays.toString(empNumbers));
        System.out.println(Arrays.toString(departments));
        System.out.println("사원수 : " + count);
    }

    public static void main(String[] args) {

        while (true) {

            showMenu();
            System.out.print("> ");
            int menuNum = sc.nextInt();

            if (menuNum == 1) {
                insertEmpData();
            } else if (menuNum == 2) {

            } else if (menuNum == 3) {

            } else if (menuNum == 4) {

            } else if (menuNum == 5) {

            } else if (menuNum == 6) {
                //프로그램 종료 코드
                exitProgram();
            } else {
                System.out.println("메뉴를 잘못 입력했습니다.");
            }
        }
    }

}
