package day08;

public class PhoneMain {

    public static void main(String[] args) {

        //객체 생성 방법
        Phone myPhone = new Phone();

        myPhone.powerOn();
        myPhone.showSpec();

        System.out.println("========================");

        Phone galaxy = new Phone("갤럭시 S20");
        galaxy.powerOn();
        galaxy.showSpec();

        System.out.println("========================");

        Phone iPhone = new Phone("아이폰 X", "스노우 화이트");
        iPhone.powerOn();
        iPhone.showSpec();

        System.out.println("========================");

        Phone xhaomi = new Phone("샤오미", "에메랄드", 250000);
        xhaomi.powerOn();
        xhaomi.showSpec();


    }
}