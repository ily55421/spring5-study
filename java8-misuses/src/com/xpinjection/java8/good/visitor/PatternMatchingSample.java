package com.xpinjection.java8.good.visitor;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;

/**
 * @author Alimenkou Mikalai
 * 模式匹配示例
 */
public class PatternMatchingSample {
    /**
     * AREA_CALCULATOR 面积计算
     */
    private final static Function<Object, Double> AREA_CALCULATOR = new LambdaVisitor<Double>()
            .on(Square.class).then(s -> s.getSide() * s.getSide())
            .on(Circle.class).then(c -> Math.PI * c.getRadius() * c.getRadius())
            .on(Rectangle.class).then(r -> r.getHeight() * r.getWidth());

    /**
     * PERIMETER_CALCULATOR 周长计算
     */
    private final static Function<Object, Double> PERIMETER_CALCULATOR = new LambdaVisitor<Double>()
            .on(Square.class).then(s -> 4 * s.getSide())
            .on(Circle.class).then(c -> 2 * Math.PI * c.getRadius())
            .on(Rectangle.class).then(r -> 2 * r.getHeight() + 2 * r.getWidth());

    public static void main(String[] args) {
        // 构建平面图形对象
        List<Object> figures = Arrays.asList(new Circle(4), new Square(5), new Rectangle(6, 7));

        // 计算总面积
        double totalArea = figures.stream()
                .map(AREA_CALCULATOR)
                .reduce(0.0, Double::sum);
        System.out.println("Total area = " + totalArea);
        // 计算总周长
        double totalPerimeter = figures.stream()
                .map(PERIMETER_CALCULATOR)
                .reduce(0.0, Double::sum);
        System.out.println("Total perimeter = " + totalPerimeter);
    }
}
