package nl.eonics.java17preview.textblocks;

/**
 * There's a LOT more to text blocks than this modest snippet can show.
 * Especially in this case, I advice you to read the JEP if you're interested.
 */
public class TextBlocks {

    public static void main(String[] args) {
        demo1();
        demo2();

        // Worth checking out: additional new string methods
    }

    private static void demo1() {
        String query_traditional = "select c from Customer c " +
                "where c.country = :country " +
                "and c.active = 1 ";

        String query_textblock = """
            select c from Customer c
            where c.country = :country
            and c.active = 1
            """; // Try moving the last line horizontally, and see the effect on the indentation. The IDE might hint you on this.

        String query_textblock_without_newline_at_the_end = """
            select c from Customer c
            where c.country = :country
            and c.active = 1""";

        System.out.println(query_traditional);
        System.out.println();
        System.out.println(query_textblock);
        System.out.println();
        System.out.println(query_textblock_without_newline_at_the_end);
    }

    private static void demo2() {
        String multiLine = """
            The String::formatted method is introduced to
            facilitate easy variable substitution.
            
            Here's a demonstration:
            %s, %d and %b""".formatted("Alice", 41, true);

        System.out.println(multiLine);
        System.out.println();

        String formattedString = "It works on normal strings too. It's actually just a reverse of the old %s method".formatted("String::format");
        System.out.println(formattedString);

    }

}
