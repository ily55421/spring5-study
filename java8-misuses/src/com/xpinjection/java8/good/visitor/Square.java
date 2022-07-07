package com.xpinjection.java8.good.visitor;

/**
 * @author Alimenkou Mikalai
 * 正方形
 */
class Square {
    private final double side;

    Square(double side) {
        this.side = side;
    }

    double getSide() {
        return side;
    }
}
