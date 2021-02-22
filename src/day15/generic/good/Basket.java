package day15.generic.good;

public class Basket<F extends Fruits> {

    //제네릭 타입 이용
    private F fruit;

    public void setFruit(F fruit) {
        this.fruit = fruit;
    }

    public F getFruit() {
        return fruit;
    }
}
