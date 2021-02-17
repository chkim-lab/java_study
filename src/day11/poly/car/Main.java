package day11.poly.car;

import day10.modi.protec.pac2.D;

public class Main {

    public static void main(String[] args) {

        Car myCar = new Car();

        myCar.frontLeft = new NexenTire();
        myCar.frontRight = new KumhoTire();

        Car s1 = new Sonata();
        Sonata s2 = new Sonata();
        Car s3 = new Sonata();

//        Sonata[] sonatas = {s1, s2, s3};

        Car k1 = new K5();
        Car k2 = new K5();
        Car k3 = new K5();

        Car m1 = new Malibu();
        Car m2 = new Malibu();
        Malibu m3 = new Malibu();
        Car m4 = new Malibu();

        Car[] cars = {s1, s2, s3, k1, k2, k3, m1, m2, m3, m4};

        for (Car c : cars) {
            c.run();
        }

        Object[] oArr = {100, "33", 3.5, true, new Car(), new Sonata(), cars};

        System.out.println("========================================");

        Driver kim = new Driver();
        kim.drive(m4);

        System.out.println("=========================================");

        Sonata newCar = (Sonata) kim.buyCar("소나타");     //방법2 Sonata로 쓸일이 많을때...
        kim.drive(newCar);
//        ((Sonata)newCar).joinMembership();    //방법1 일시적...
        newCar.joinMembership();

        System.out.println("==========================================");

        CarShop shop = new CarShop();
        int money = shop.sellCar(new Sonata());
        System.out.println("차 판매 수령액: " + money + "만원");
        int money2 = shop.sellCar(k2);
        System.out.println("차 판매 수령액: " + money2 + "만원");
    }
}
