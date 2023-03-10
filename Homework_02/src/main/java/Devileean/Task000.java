package Devileean;

import Devileean.model.Vector;

public class Task000 {
    public static void main(String[] args) {
        Vector vector1 = new Vector(1.8,1.9,2.0);
        Vector vector2 = new Vector(-2.8,2.9,3.0);
        System.out.println(vector1.toString());
        System.out.println(vector2.toString());
        System.out.println("длина: " + vector1.lengthVector());
        System.out.println("скалярное произведение: " + vector1.scalarMulti(vector2));
        System.out.println("векторное произведение: " + vector1.vectorMulti(vector2));
        System.out.println("cos: " + vector1.vectorCos(vector2));
        System.out.println("сумма: " + vector1.plusVector(vector2));
        System.out.println("разность: " + vector1.minusVector(vector2));
    }
}
