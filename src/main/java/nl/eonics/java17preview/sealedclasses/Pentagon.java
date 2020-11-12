package nl.eonics.java17preview.sealedclasses;

/**
 * Pentagon is open for subclassing by unknown classes by being declared non-sealed.
 */
public non-sealed class Pentagon extends Shape {

    public Pentagon(int sideLength) {
        super(sideLength);
    }

    @Override
    public double area() {
        return Math.sqrt(5 * (5 + 2 * Math.sqrt(5))) * sideLength * sideLength / 4;
    }
}
