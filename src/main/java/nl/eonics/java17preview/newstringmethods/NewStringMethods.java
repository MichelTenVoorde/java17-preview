package nl.eonics.java17preview.newstringmethods;

public class NewStringMethods {

    public static void main(String[] args) {
        testIndent();
    }

    private static void testIndent() {
        String text = "I'd like to be indented by 5 spaces, please.";
        System.out.println(text.indent(5));

        String multiLineText = "Awesome, but does\nit work with\nmultiple lines in\na string as well?";
        System.out.println(multiLineText.indent(5));
    }
}
