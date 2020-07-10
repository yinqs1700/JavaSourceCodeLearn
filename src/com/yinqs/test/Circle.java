package com.yinqs.test;

import java.util.function.Function;

public class Circle {

    private Double radius;

    public Circle(Double radius){
        this.radius = radius;
    }

    public double area(Function<Double,Double> op){
       return op.apply(radius);
    }

}
class Test{
    public static void main(String[] args) {
        Circle circle = new Circle(1.0);
        double area = circle.area(radius -> radius * radius * Math.PI);
        System.out.println(area);
    }
}
