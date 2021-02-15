package day10.inherit.calculator;

public class Computer extends Calculator{

    @Override
    double calcAreaCircle(double r) {
        return r * r * Math.PI;
    }
}
