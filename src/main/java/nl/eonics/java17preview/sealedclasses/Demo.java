package nl.eonics.java17preview.sealedclasses;

public class Demo {
    public static void main(String[] args) {
        Triangle triangle = new Triangle(5);
        triangle.setName("Lovely Triangle"); // sealed is not an access modifier, Shape::setName is public, so accessible from here.

        // Sealed classes can't by anonymously instantiated.
//        Shape hexagon = new Shape() {
//            @Override
//            public double area() {
//                return 3 * Math.sqrt(3) * sideLength * sideLength / 2;
//            }
//        };

    }

    // Since Hexagon is not in the list of permitted subclasses, the following won't compile either.
//        class Hexagon extends Shape {
//
//            public Hexagon(int sideLength) {
//                super(sideLength);
//            }
//
//            @Override
//            public double area() {
//                return 3 * Math.sqrt(3) * sideLength * sideLength / 2;
//            }
//        }

    // SpecialSquare was given permission to extend Square, so this works.
    // It wouldn't, however, if Demo were in a different package.
    final class SpecialSquare extends Square {
        public SpecialSquare(int sideLength) {
            super(sideLength);
        }
    }
}
