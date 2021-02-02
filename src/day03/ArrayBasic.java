package day03;

import java.util.Arrays;

public class ArrayBasic {

    public static void main(String[] args) {
        //1. 배열 변수 선언
        int[] points;
//        int points[]; - C언어 스타일

        //2. 배열 객체의 생성.
        points = new int[5];
        System.out.println("points = " + points);

        //3. 배열 값 초기화
        points[0] = 87;
        points[1] = 95;
        points[2] = points[0];
        points[3] = (int) 33.145;
        points[4] = 100;
//        points[5] = 300;

        //4. 배열의 데이터 참조
        System.out.println(points[1]);

        //5. 배열의 길이
        System.out.println("배열의 길이: " + points.length);

        //6. 배열 내부 값들 한번에 확인하기
        System.out.println(Arrays.toString(points));

        //7. 배열의 반복문 처리
        int total = 0;
        for (int i = 0; i < points.length; i++) {
            System.out.println(points[i]);
            total += points[i];
        }
        System.out.println("총점: " + total);

        System.out.println("=====================");

        double[] dArr = new double[3];

//        int[] numbers = new int[] {1, 3, 5, 7};
        int[] numbers = {1, 3, 5, 7}; //new int[] 생략 가능
        System.out.println(Arrays.toString(numbers));

        //배열의 기본값
        System.out.println(Arrays.toString(dArr));

        int[] iArr = new int[10];
        System.out.println(Arrays.toString(iArr));

        boolean[] bArr = new boolean[4];
        System.out.println(Arrays.toString(bArr));

        String[] sArr = new String[5];
        System.out.println(Arrays.toString(sArr));
    }
}
