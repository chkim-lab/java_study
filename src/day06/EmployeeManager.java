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

    //사원 번호 중복을 체크하는 메서드
    static String checkDuplicateEmpNum() {

        //첫 사번 입력
        String empNum = sc.next();

        //중복 검사
        while (true) {
            //flag가 true면 중복되었음을 의미
            boolean flag = false;
            for (int i=0; i < empNumbers.length; i++) {
                if (empNum.equals(empNumbers[i])) {
                    //사번이 중복된 경우
                    flag = true;
                    System.out.println("이미 등록된 사번입니다.");
                    System.out.print("- 사번 재입력: ");
                    empNum = sc.next();
                    break;
                }
            }
            //사번 중복이 안된 경우
            if (!flag) {
                return empNum;
            }
        }
    }

    //사원 정보 등록을 위한 메서드
    static void insertEmpData() {

        System.out.println("\n# 사원정보 등록을 시작합니다.");
        System.out.print("- 사번: ");
        String empNum = checkDuplicateEmpNum();

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

//        System.out.println(Arrays.toString(empNumbers));
//        System.out.println(Arrays.toString(departments));
//        System.out.println("사원수 : " + count);
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

    //모든 사원정보를 출력하는 메서드
    static void showAllEmpData() {

        if (count > 0) {
            System.out.println("====================전체 사원 정보======================");
            System.out.printf("%s%10s%10s%10s\n", "사번", "이름", "나이", "부서");
            System.out.println("========================================================");

            for (int i=0; i < count; i++) {
                System.out.printf("%s%10s%10s세%10s\n",
                        empNumbers[i], names[i], ages[i], departments[i]);
            }

            System.out.println("========================================================");
        } else {
            System.out.println("\n현재 등록된 사원의 정보가 없습니다.");
        }
    }
    // 사원 번호를 입력받아 리턴하는 메서드
    static String inputEmpNumber(String data) {
        System.out.printf("%s하실 사원의 번호를 입력하세요.\n", data);
        System.out.print("> ");
        return sc.next();
    }

    // 사원번호로 데이터배열의 인덱스를 찾아서 리턴하는 메서드
    static int searchIndex(String empNumber) {
        int idx;
        for (idx = 0; idx < count; idx++) {
            if (empNumber.equals(empNumbers[idx])) {
                return idx;
            }
        }
        return -1;
    }

    // 사원 개별 조회를 수행하는 메서드
    static void searchEmpData() {
        int index = searchIndex(inputEmpNumber("조회"));
        if (index >= 0) {
            System.out.println("====== 검색된 정보 ======");
            System.out.println("# 사번: " + empNumbers[index]);
            System.out.println("# 이름: " + names[index]);
            System.out.println("# 나이: " + ages[index] + "세");
            System.out.println("# 부서: " + departments[index]);
            System.out.println("=========================\n");
        } else {
            System.out.println("조회하신 사원정보는 존재하지 않습니다.");
        }
    }

    // 사원 정보 수정의 세부처리 메서드
    static void processModifying(int index) {
        int select = sc.nextInt();
        switch (select) {
            case 1:
                String beforeAge = ages[index];
                System.out.println("- 변경하실 나이를 입력하세요.");
                System.out.print("> ");
                ages[index] = sc.next();
                System.out.printf("나이가 %s세에서 %s세로 변경되었습니다.\n",
                        beforeAge, ages[index]);
                break;
            case 2:
                String beforeDep = departments[index];
                System.out.println("- 변경하실 부서를 입력하세요.");
                System.out.print("> ");
                departments[index] = sc.next();
                System.out.printf("부서가 %s에서 %s로 변경되었습니다.\n",
                        beforeDep, departments[index]);
                break;
            case 3:
                System.out.println("수정을 취소합니다.");
                break;
            default:
                System.out.println("번호를 잘못 입력했습니다.");
        }
    }

    // 사원 정보 수정을 수행하는 메서드
    static void modifyEmpData() {
        String empNumber = inputEmpNumber("수정");
        int index = searchIndex(empNumber);
        if (index >= 0) {
            System.out.printf("# %s님의 정보를 수정합니다.\n", names[index]);
            System.out.println("[ 1. 나이 변경 | 2. 부서 변경 | 3. 취소 ]");
            System.out.print("> ");
            processModifying(index);

        } else {
            System.out.println("조회하신 사원정보는 존재하지 않습니다.");
        }
    }

    // 배열 삭제 메서드
    static String[] remove(String[] arr, int index) {
        for (int i=index; i < count-1; i++) {
            arr[i] = arr[i+1];
        }
        //배열 복사
        String[] temp = new String[arr.length-1];
        for (int i=0; i < temp.length; i++) {
            temp[i] = arr[i];
        }

        return temp;
    }

    // 사원 정보 삭제 세부처리 메서드
    static void processDel(int index) {
        //삭제될 데이터의 이름정보 복사
        String delName = names[index];

        empNumbers = remove(empNumbers, index);
        names = remove(names, index);
        ages = remove(ages, index);
        departments = remove(departments, index);
        count--;

        System.out.printf("# %s님의 정보가 정상 삭제되었습니다.\n", delName);
    }

    // 사원 정보 삭제를 수행하는 메서드
    static void deleteEmpData() {
        String empNumber = inputEmpNumber("삭제");
        int index = searchIndex(empNumber);
        if (index >= 0) {
            System.out.printf("# %s님의 정보를 삭제합니다.[y/n]\n", names[index]);
            System.out.print("> ");
            String trigger = sc.next();
            switch (trigger) {
                case "y": case "Y": case "ㅛ":
                    processDel(index);
                    break;
                case "n": case "N": case "ㅜ":
                    System.out.println("# 정보 삭제를 취소합니다.");
                    break;
            }
        } else {
            System.out.println("조회하신 사원정보는 존재하지 않습니다.");
        }
    }

    public static void main(String[] args) {
        initTest();
        while (true) {

            showMenu();
            System.out.print("> ");
            int menuNum = sc.nextInt();

            if (menuNum == 1) {
                insertEmpData();
            } else if (menuNum == 2) {
                showAllEmpData();
            } else if (menuNum == 3) {
                searchEmpData();
            } else if (menuNum == 4) {
                modifyEmpData();
            } else if (menuNum == 5) {
                deleteEmpData();
            } else if (menuNum == 6) {
                //프로그램 종료 코드
                exitProgram();
            } else {
                System.out.println("메뉴를 잘못 입력했습니다.");
            }
        }
    }


    //테스트 코드
    static void initTest() {
        String empNum;
        String name;
        String age;
        String dep;
        empNum = "001";
        name = "이순신";
        age = "10";
        dep = "영업부";
        empNumbers = append(empNumbers, empNum);
        names = append(names, name);
        ages = append(ages, age);
        departments = append(departments, dep);
        count++;
        empNum = "002";
        name = "강감찬";
        age = "20";
        dep = "총무부";
        empNumbers = append(empNumbers, empNum);
        names = append(names, name);
        ages = append(ages, age);
        departments = append(departments, dep);
        count++;
        empNum = "003";
        name = "유관순";
        age = "30";
        dep = "영업부";
        empNumbers = append(empNumbers, empNum);
        names = append(names, name);
        ages = append(ages, age);
        departments = append(departments, dep);
        count++;
        empNum = "004";
        name = "안중근";
        age = "40";
        dep = "기획부";
        empNumbers = append(empNumbers, empNum);
        names = append(names, name);
        ages = append(ages, age);
        departments = append(departments, dep);
        count++;
        empNum = "005";
        name = "문재인";
        age = "50";
        dep = "개발부";
        empNumbers = append(empNumbers, empNum);
        names = append(names, name);
        ages = append(ages, age);
        departments = append(departments, dep);
        count++;
    }
}
