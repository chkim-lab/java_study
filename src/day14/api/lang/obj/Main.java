package day14.api.lang.obj;

import day08.modi.cls.pac2.C;

public class Main {

    public static void main(String[] args)  throws CloneNotSupportedException{

        Person p1 = new Person("홍길동", 25);
        Person p2 = new Person("김철수", 30);
        Person p3 = new Person("홍길동", 25);

        // equals()
        System.out.println("p1 == p3: " + p1.equals(p3));

        System.out.println(p1);
        System.out.println(p1.toString());
        System.out.println(p2);

//        Person copyPerson = p2; //주소가 서로 같다. 결국 같은객체이다.
        p2.car = new Car("소나타");
        Person copyPerson = p2.makeClone(); //얊은 복사
        p2.name = "고길동";
        copyPerson.car.model = "아반떼";

        System.out.println("=======================");
        System.out.println("copyPerson의 이름: " + copyPerson.name);
        System.out.println("p2의 이름: " + p2.name);

        // 얕은복사
        System.out.println("copyPerson의 자동차: " + copyPerson.car.model);
        System.out.println("p2의 자동차: " + p2.car.model);

        System.out.println("=========================");
        System.out.println("소멸자 테스트");
        Counter c = null;

        for (int i = 0; i < 50; i++) {
            c = new Counter(i+1);
            c = null;
            System.gc(); //객체를 제거하는 기비지 컬렉터 호출문
        }
        System.out.println("-------------------");
        System.gc(); //객체를 제거하는 기비지 컬렉터 호출문
    }
}
