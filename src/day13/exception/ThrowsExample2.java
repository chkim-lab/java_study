package day13.exception;

public class ThrowsExample2 {
    public static void main(String[] args) {

        try {
            new Test();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
