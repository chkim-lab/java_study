package day11.poly.player;

public class Main {

    public static void main(String[] args) {
        Warrior w = new Warrior("돌진왕김파파");
        Mage m = new Mage("번개왕김썬더");
        Hunter h = new Hunter("멍멍이죠아요");

        m.meteo(w, h,
                new Warrior("말썽쟁이전사"),
                new Mage("블리자드왕"));
        System.out.println("==============================");

        m.meteo(w, m, h);

    }
}
