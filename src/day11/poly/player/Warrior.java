package day11.poly.player;

public class Warrior extends Player {

    int rage;

    //생성자
    public Warrior(String name) {
        super("전사", 1, 50);
//        System.out.println("Warrior 객체 생성!");
    }

    void rush() {
        System.out.println(this.name + "님이 돌진합니다.");
    }

    //메서드 오버라이딩
    @Override
    //오버라이딩 검증 아노테이션
    void info() {
        super.info();
        System.out.println("# 분노: " + this.rage);
    }

    void fireSlash(Player target) {

        System.out.printf("%s님이 %s님에게 FireSlash를 시전했습니다!\n"
                , this.name, target.name);
        int damage;
        String job;
        if (target instanceof Warrior) {
            damage = 10;
            job = "전사";
        } else if (target instanceof Mage) {
            damage = 20;
            job = "마법사";
        } else if (target instanceof Hunter) {
            damage = 15;
            job = "사냥꾼";
        } else {
            damage = 0;
            job = "미확인";
        }
        target.hp -= damage;
        System.out.printf("%s(%s)님이 %d의 피해를 입었습니다.\n"
                , target.name, job, damage);
        System.out.printf("%s님의 현재 체력: %d\n"
                , target.name, target.hp);
        System.out.println();
    }
}
