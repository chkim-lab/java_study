package day13.test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class ArrayExample {

    public static void main(String[] args) {

        char[] arr1 = {'J','A','V','A'};
//        char[] arr2 = arr1; //주소값 복사

        char[] arr2 = Arrays.copyOf(arr1,arr1.length);

        char[] arr3 = Arrays.copyOfRange(arr1, 1, 3);

        arr1[2] = 'F';
        System.out.println("arr1: " + Arrays.toString(arr1));
        System.out.println("arr2: " + Arrays.toString(arr2));
        System.out.println("arr3: " + Arrays.toString(arr3));

        //배열 정렬
        int[] numbers = {99, 84, 100, 12, 23, 18, 35 };
        System.out.println("정렬 전: " + Arrays.toString(numbers));

        //오름차 정렬
        Arrays.sort(numbers);
        System.out.println("정렬 후: " + Arrays.toString(numbers));

        //내림차 정렬1
        int[] numbersCopy = Arrays.copyOf(numbers,numbers.length);
        for (int i = 0; i < numbers.length; i++) {
            numbersCopy[i] = numbers[numbers.length - (i+1)];
        }
        System.out.println("내림차 정렬1: " + Arrays.toString(numbersCopy));

        //내림차 정렬2
        Integer[] numbers2 = {99, 84, 100, 12, 23, 18, 35 };
        Arrays.sort(numbers2, Collections.reverseOrder());
        System.out.println("내림차 정렬2: " + Arrays.toString(numbers2));
    }
}
