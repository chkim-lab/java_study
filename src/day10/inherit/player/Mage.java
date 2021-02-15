package day10.inherit.player;

public class Mage extends Player{

    int mana;

    public Mage() {
        super("마법사", 1, 50);
    }
    void meteo() {}

    @Override
    void info() {
        System.out.println("\n====== 캐리터 정보 ======");
        System.out.println("# 이름: " + this.name);
        System.out.println("# 레벨: " + this.level);
        System.out.println("# 체력: " + this.hp);
        System.out.println("# 마력: " + this.mana);
    }
}
