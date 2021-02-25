package day18.api.io.stream;

import java.io.*;
import java.util.Scanner;

public class OutputStreamExample {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("파일명을 입력: ");
        String fileName = sc.next();

        String filePath = "D:\\developing_hsg\\iotest\\"
                + fileName + ".txt";

        OutputStream fos = null;
        try {
            fos = new FileOutputStream(filePath);

            System.out.print("문장 입력: ");
            sc.nextLine();
            String str = sc.nextLine();

            //write메서드는 오직 바이트데이터만 쓸 수 있습니다.
            //따라서 String을 파일에 쓸려면 바이트로 변환해야 합니다.
            fos.write(str.getBytes());

            System.out.println("파일이 정상 저장되었습니다.");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}