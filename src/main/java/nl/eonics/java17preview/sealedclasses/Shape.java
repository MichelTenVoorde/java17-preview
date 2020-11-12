package nl.eonics.java17preview.sealedclasses;

/**
 * Sealed superclass. Only Triangle, Square and Pentagon can extend it.
 */
public abstract sealed class Shape
permits Triangle, Square, Pentagon {

    protected int sideLength;
    protected String name;

    public abstract double area();

    protected Shape(int sideLength) {
        this.sideLength = sideLength;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
