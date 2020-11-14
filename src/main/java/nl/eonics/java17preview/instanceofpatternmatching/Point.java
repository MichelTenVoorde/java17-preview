package nl.eonics.java17preview.instanceofpatternmatching;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
class Point {
    private int x;
    private int y;

    // Examine these 3 equals implementations.
    // First, one with the classic instanceof syntax.

//    @Override
//    public boolean equals(Object obj) {
//        if (obj instanceof Point) {
//            Point p = (Point) obj;
//            return (x == p.x && y == p.y);
//        } else {
//            return false;
//        }
//    }

    // Secondly, we use the new pattern matching capabilities.
    //

//    @Override
//    public boolean equals(Object obj) {
//        if (obj instanceof Point p) {
//            return x == p.x && y == p.y;
//        } else { // note that p is not in scope here.
//            return false;
//        }
//    }

    // However, we can shorten things even more. Due to the short circuiting of the && operator,
    // there's no possibility of p not being in scope on the right hand side of it, so the following compiles!

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Point p && x == p.x && y == p.y);
    }
}