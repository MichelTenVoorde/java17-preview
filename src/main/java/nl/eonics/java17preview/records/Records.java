package nl.eonics.java17preview.records;

public class Records {

    public static void main(String[] args) {

        Point p = new Point(1, 2);
        Circle c = new Circle(5);
        Square s = new Square();

    }
}

record Point(int x, int y) {}

// a record is implicitly final, so adding final is allowed.
final record Circle (int radius) {}

record Square(int side)  {

    // You can add a custom constructor, but it always has to call another constructor.
    // This basically means that eventually, the canonical constructor is called.
    public Square() {
        this(0);
    }

    // A record can have an instance method.
    public int area() {
        return side * side;
    }
}

// A record can implement an Interface. Try for yourself!

// Every record is a subclass of java.lang.Record. If you're feeling nerdy, have a look at it.

// Question: How do you think all this compares to Project Lombok?