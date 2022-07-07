package com.xpinjection.java8.good.visitor;

/**
 * @author Alimenkou Mikalai
 * 访客
 * 园 -- 半径
 */
class Circle {
    private final double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    double getRadius() {
        return radius;
    }
}
