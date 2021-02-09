//import day08.bank.Account;
//import day08.bank.Banker;
//import day08.bank.Paper;
//import day08.bank.User;
import day08.bank.*;
import day08.fruit.Apple;

/**
 * API 문서 주석
 *
 * @author Mr. Hong
 * @version 1.1.3
 * @email hsg9984@kitt.co.kr
 * @since 2021.01.29 ~
 */


public class Hello {

    /*
      메인 함수는 프로그램이 실행되는 영역입니다.
      모든 자바 프로그램은 메인 함수에서 시작됩니다.
     */
    public static void main(String[] args) {

//        //이 코드는 콘솔에 데이터를 출력하는 코드입니다.
//        System.out.println("안녕하세요!");
//        System.out.println("메롱메롱~");
//        day08.fruit.Apple apple1 = new day08.fruit.Apple();
//        day08.fruit.Apple apple = new day08.fruit.Apple();
        Apple apple = new day08.fruit.Apple();
        new day08.juice.Apple();

        Banker kim = new Banker("김철수");
        Account acc = new Account();
        User park = new User("박영희");

        //사용자의 계좌 생성 요청
//        park.requestMakeAccount(kim, new Paper(park.name,"1234"));

//        System.out.println("고길동 통장 비밀번호: " + park.account.password);
    }
}
