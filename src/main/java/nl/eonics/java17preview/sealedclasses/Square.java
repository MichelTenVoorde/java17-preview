package nl.eonics.java17preview.sealedclasses;

/**
 * Square extends the sealing by permitting a subclass to extend it.
 */
public sealed class Square extends Shape permits Demo.SpecialSquare {

    public Square(int sideLength) {
        super(sideLength);
    }

    @Override
    public double area() {
        return sideLength * sideLength;
    }

    public static void main(String[] args) {
        Square s = new Square(6);
        System.out.println(s.area());
    }
}
