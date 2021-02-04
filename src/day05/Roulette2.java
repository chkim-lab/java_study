package day05;

import java.util.Arrays;
import java.util.Scanner;

public class Roulette2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("게임 인원 (2 ~ 4명) ==> ");

        //playerNum은 게임 참여 인원 수를 저장.
        int playerNum = sc.nextInt();

        //게임 인원 수 검증
        if (playerNum < 2 || playerNum > 4) {
            System.out.println("인원 수가 올바르지 않습니다. GAME OVER!");
            return; //메인 함수 탈출! 프로그램 종료
        }

        System.out.println("\n플레이어 이름을 등록합니다.");

        //플레이어의 이름들을 저장할 배열
        String[] players = new String[playerNum];

        //플레이어의 이름을 반복해서 입력받고
        //배열에 차례로 저장
        for (int i=0; i < playerNum; i++) {
            System.out.printf("%d번 플레이어 이름: ", i+1);
            players[i] = sc.next();
        }
        System.out.println(Arrays.toString(players)
                + " 참가!");

        System.out.print("\n실탄 개수 (6 미만) ==> ");
        int bulletNum = sc.nextInt();
        sc.nextLine();

        System.out.println("실탄을 넣고 탄창을 무작위로 돌립니다.");

        //탄창 생성
        boolean[] magazine = new boolean[6];

        //실탄 무작위로 셋팅

        //실탄을 중복없이 정확히 장전한 횟수
        int checkCount = 0;

        //랜덤 총알 위치 결정
        while (checkCount < bulletNum) {
            int position = (int) (Math.random() * magazine.length);

            if (magazine[position]) {
                continue;
            } else {
                magazine[position] = true;
                checkCount++;
            }
        }
        //System.out.println("탄창: " + Arrays.toString(magazine));

        //== 게임 시작 == //

        //선턴 플레이어 랜덤 결정
        int startIdx = (int)(Math.random() * playerNum);
        System.out.printf("\n총을 돌렸습니다. %s부터 시작합니다.\n"
                , players[startIdx]);

        while (true) {

            System.out.printf("\n\n[%s의 턴!] 탄창을 돌립니다.\n", players[startIdx]);

            //격발 전 총알 위치를 랜덤 결정
            int bulletPos = (int)(Math.random() * magazine.length);

            System.out.println("# 엔터를 누르면 격발합니다.");

            // 엔터만을 입력받고 끝내려면 nextLine()을 단독으로 사용
            sc.nextLine();

            //사망한 경우
            if (magazine[bulletPos]) {
                //실탄 격발
                System.out.printf("\n빵!!! [%s] 사망...\n"
                        , players[startIdx]);

                //사망 인원 제거
                for (int i = startIdx; i < playerNum - 1; i++) {
                    players[i] = players[i + 1];
                }
                String[] temp = new String[playerNum - 1];
                for (int i = 0; i < temp.length; i++) {
                    temp[i] = players[i];
                }
                players = temp; temp = null;
                playerNum--;

//                System.out.println(Arrays.toString(players));

                //사용한 실탄 true ->  false
                magazine[bulletPos] = false;
                bulletNum--;

                //게임 종료 조건 판단
                if (playerNum == 1) {
                    System.out.println("단 한명만 살아남았습니다. 게임을 종료합니다.");
                    System.out.println("최후 생존자: " + Arrays.toString(players));
                    break;
                } else if (bulletNum == 0) {
                    System.out.println("총알이 모두 소진되었습니다. 게임을 종료합니다.");
                    System.out.println("최후 생존자: " + Arrays.toString(players));
                    break;
                } else {
                    System.out.println("\n남은 인원으로 게임을 진행합니다.");
                    System.out.println("남은 인원: " + Arrays.toString(players));
                    continue;
                }
            } else { //생존한 경우
                System.out.println("휴.... 살았습니다.");
            }
            //인덱스 조정
            if (startIdx != playerNum - 1) { //현재 마지막 인덱스가 아니라면
                startIdx++;
            } else { //현재 마지막 인덱스라면
                startIdx = 0;
            }
        }
    }
}
