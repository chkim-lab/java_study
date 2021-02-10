package day09.encap.good;

public class Main {

    public static void main(String[] args) {

        Cat nabi = new Cat();

//        nabi.weight = 30;   (X)
        nabi.setWeight(13);
        nabi.printWeight();

//        double nabiWeight = nabi.weight;
        double nabiWeightForPound = nabi.getWeight(true);
        double nabiWeightForKg = nabi.getWeight(false);
        System.out.println("nabiWeightForPound = " + nabiWeightForPound);
        System.out.println("nabiWeightForKg = " + nabiWeightForKg);

        nabi.printWeight();
    }
}
