package nl.eonics.java17preview.sealedclasses;

/**
 * The sealing initiated by Shape is ended by this subclass being final.
 */
public final class Triangle extends Shape {

    public Triangle(int sideLength) {
        super(sideLength);
    }

    @Override
    public double area() {
        return Math.sqrt(3) * sideLength * sideLength / 4;
    }

}
