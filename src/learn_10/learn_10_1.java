package learn_10;

import java.util.Scanner;
    // GeometricObject class
    class GeometricObject {
        String color;
        boolean filled;
        public GeometricObject() { //无参构造初始化成员。
            color = "white";
            filled = false;
        }
    }

    // Computable interface
    interface Computable {
        double PI = 3.14;

        double getArea();

        double getPerimeter();
    }

    // Triangle class
    class Triangle extends GeometricObject implements Computable {
        double side1 = 1.0;
        double side2 = 1.0;
        double side3 = 1.0;
        public Triangle() {
        }

        public Triangle(double side1, double side2, double side3) {
            this.side1 = side1;
            this.side2 = side2;
            this.side3 = side3;
        }

        public double getArea() { //海伦公式，s为半周长
            double s = (side1 + side2 + side3) / 2;
            return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
        }

        public double getPerimeter() {
            return side1 + side2 + side3;
        }
    }

    // Circle class
    class Circle extends GeometricObject implements Computable {
        double radius;
        public Circle(double radius) {
            this.radius = radius;
        }

        public double getArea() {
            return PI * radius * radius;
        }

        public double getPerimeter() {
            return 2 * PI * radius;
        }
    }
    // Factory class
    class Factory {
        Computable getComputableShapeInstance(int shape, Scanner reader) {
            if (shape == 1) {
                double radius = reader.nextDouble();
                return new Circle(radius);
            } else if (shape == 2) {
                double side1 = reader.nextDouble();
                double side2 = reader.nextDouble();
                double side3 = reader.nextDouble();
                return new Triangle(side1, side2, side3);
            }
            return null;
        }
    }

// Test class

    public class learn_10_1 {
        public static void main(String[] args) {
            Scanner reader = new Scanner(System.in);
            Computable shape;
            Factory shapeFactory = new Factory();

            shape = shapeFactory.getComputableShapeInstance(1, reader);
            System.out.printf("Circle area:%.2f%n", shape.getArea());

            shape = shapeFactory.getComputableShapeInstance(2, reader);
            System.out.printf("Triangle area:%.1f%n", shape.getArea());
        }
    }


