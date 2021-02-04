package day05;

import day02.StdOutput;

import java.util.Arrays;
import java.util.Scanner;

public class Roulette {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("게임 인원 (2 ~4명) ==> ");

        //playerNum은 게임 참여 인원 수를 저장.
        int playerNum = sc.nextInt();

        //게임 인원 수 검증
        if (playerNum < 2 || playerNum > 4) {
            System.out.println("인원 수가 올바르지 않습니다.");
            return; //메인 함수 탈출! 프로그램 종료
        }

        System.out.println("\n플레이어 이름을 등록합니다.");

        //플레이어의 이름들을 저장할 배열
        String[] players = new String[playerNum];
        for (int i = 0; i < playerNum; i++) {
            System.out.printf("%d번 플레이어 이름:", i+1);
            players[i] = sc.next();
        }
        System.out.println(Arrays.toString(players)+ " 참가!");

        System.out.print("\n실탄 개수 (6 미만)==> ");
        int bulletNum = sc.nextInt();
        sc.nextLine();

        System.out.println("실탄을 넣고 탄창을 무작위로 돌립니다.");

        //탄창 생성
        boolean[] maganine = new boolean[6];

        //실탄 무작위로 셋팅

        //실탄을 중복없이 정확히 장전한 횟수
        int checkCount = 0;

        //랜덤 총알 위치 결정
        while (checkCount < bulletNum) {
            int position = (int) (Math.random() * maganine.length);

            if (maganine[position]) {
                continue;
            } else {
                maganine[position] = true;
                checkCount++;
            }
        }
        //System.out.println("탄창: " + Arrays.toString(maganine));

        //== 게임 시작 == //

        //선턴 플레이어 랜덤 결정
        int startIndx =(int)(Math.random()*playerNum);
        System.out.printf("\n총을 돌렸습니다. %s 부터 시작합니다.\n",players[startIndx]);

        while (true) {
            System.out.printf("\n\n[%s의 턴!] 탄창을 돌립니다.\n",players[startIndx]);
            int bulletPos =(int)(Math.random() * maganine.length);

            System.out.println("# 엔터를 누르면 격발합니다.");
            //엔터만을 입력받고 끝내려면 nextLine()을 단독으로 사용
            sc.nextLine();

            //사망한 경우
            if (maganine[bulletPos]) {
                //실탄 격발
                System.out.printf("\n 빵!!! [%s] 사망...\n", players[startIndx]);
                break;
            } else {
                System.out.println("휴.... 살았습니다.");
                
                //인덱스 조정
                if (startIndx != playerNum-1) { //현재 마지막 인덱스가 아니라면
                    startIndx++;
                } else {                      //현재 마지막 인덱스라면
                    startIndx=0;
                }
            }
        }
    }
}
