package nl.eonics.java17preview.helpfulnpes;

import java.util.ArrayList;
import java.util.List;

/**
 * Note: to enable Helpful NullPointerExceptions, you may have to add the -XX:+ShowCodeDetailsInExceptionMessages
 * parameter to the Java compiler. In IntelliJ, this is done at Settings -> Build, Execution, Deployment -> Compiler
 * -> Java Compiler -> Additional command line parameters.
 */
public class HelpfulNPEs {
    public static void main(String[] args) {
//        demo1();
        demo2();
    }

    /**
     * You try to call a function that expects an int. You pass the first element of a List<Integer> variable, by
     * using List.get(index), with index == 0 (supposedly).
     *
     * However, you end up with a NullPointerException:
     *
     * Exception in thread "main" java.lang.NullPointerException
     * at nl.eonics.java17preview.helpfulnpes.HelpfulNPEs.demo1(HelpfulNPEs.java:39)
     * at nl.eonics.java17preview.helpfulnpes.HelpfulNPEs.main(HelpfulNPEs.java:13)
     *
     * There are 3 things that could have gone wrong:
     * - The first element of the list was null, and the function couldn't convert it into an int.
     * - The index used to refer to an element of the list was null.
     * - The reference to the list was null itself.
     *
     * The stacktrace won't help you decide which of these three was the culprit.
     *
     * Try for yourself how things are looking now though!
     */
    private static void demo1() {
        List<Integer> intList1 = new ArrayList<>();
        intList1.add(null);
        intList1.add(0);

        List<Integer> intList2 = null;

        Integer index = null;

        // Of course, you'll have to enable these one by one.
        gimmeThatInt(intList1.get(0));
//        gimmeThatInt(intList1.get(index));
//        gimmeThatInt(intList2.get(0));
    }

    private static void gimmeThatInt(int a) {
        // do interesting things
    }


    /**
     * A very common use case: an NPE right in the middle of a nice, long method chain.
     */
    private static void demo2() {
        A a = new A();
        B b = new B();
        C c = new C();

        a.b = b;
        c.d = "Hi!";

        System.out.println(a.b.c.d);
    }

}

class A {
    B b;
}
class B {
    C c;
}
class C {
    String d;
}
