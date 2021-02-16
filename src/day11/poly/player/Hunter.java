package day11.poly.player;

public class Hunter extends Player {

    int arrow;

    public Hunter(String name, int level, int hp) {
        super(name, level, hp);
    }

    public Hunter(String name) {
        this.name = name;
        this.hp = 60;
    }

    void multiShot() {}

    @Override
    void info() {
        System.out.println("\n====== 캐리터 정보 ======");
        System.out.println("# 이름: " + this.name);
        System.out.println("# 레벨: " + this.level);
        System.out.println("# 체력: " + this.hp);
        System.out.println("# 화살: " + this.arrow);
    }
}
