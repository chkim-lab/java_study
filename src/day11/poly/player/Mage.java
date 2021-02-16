package day11.poly.player;

public class Mage extends Player {

    int mana;

    public Mage() {
        super("마법사", 1, 50);
    }

    public Mage(String name) {
        this.name = name;
        this.hp = 50;
    }

    public void meteo(Player... players) {

        if (players.length > 0) {

            System.out.printf("# %s님이 메테오 시전!!!\n", this.name);
            System.out.println("------------------------------------");

            for (Player p : players) {
                // 타겟팅된 객체가 자기 자신일 경우 스킵
                if (p == this) continue;

                //10 ~ 15 무작위 피해를 주어야 함
                int damage = (int) (Math.random() * 6) + 10;
                p.hp -= damage;
                System.out.printf("%s님이 %d의 피해를 입었습니다. (남은 체력: %d)\n",
                        p.name, damage, p.hp);
            }

        } else {
            System.out.println("타겟된 플레이어가 없습니다.");
        }
    }

    @Override
    void info() {
        System.out.println("\n====== 캐리터 정보 ======");
        System.out.println("# 이름: " + this.name);
        System.out.println("# 레벨: " + this.level);
        System.out.println("# 체력: " + this.hp);
        System.out.println("# 마력: " + this.mana);
    }
}
