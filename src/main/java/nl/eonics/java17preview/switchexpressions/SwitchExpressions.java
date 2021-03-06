package nl.eonics.java17preview.switchexpressions;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Random;

public class SwitchExpressions {
    public static void main(String[] args) {
        testSwitchStatement();
        testSwitchExpression();
        testSwitchExpressionWithEnum();
    }

    private static void testSwitchStatement() {
        switch (LocalDate.now().getDayOfWeek()) {
            case MONDAY             -> System.out.println("Sigh...");
            case TUESDAY, WEDNESDAY -> System.out.println("Hang in there...");
            case THURSDAY           -> System.out.println("Almost there now..!");
            case FRIDAY             -> System.out.println("Party time!");
            // You can't suddenly change syntax style
//            case SATURDAY:
//                System.out.println("Enjoying the weekend!");
        }
    }

    private static void testSwitchExpression() {
        int interestingInt = new Random().nextInt(4);

        String interestingMessage = switch(interestingInt) {
            case 0 -> "You can just implicitly return a value like this.";
            case 1, 2 -> {
                yield "You can, however, include a code block, in which case you use the new yield keyword to return a value.";
            }
            default -> "Switch expressions must be exhaustive (i.e., cover all possible values).";
        }; // it's easy to forget the semicolon, though of course your IDE will be happy to remind you.

        System.out.println(switch(interestingInt) {
            case 0:
                yield "Another option is to use the traditional switch syntax.";
            case 1:
                yield "There's no need for curly braces, even with multiple statements.";
            case 2:
                yield "Again, you use yield to return a value.";
            default:
                yield "There's no need to break either (in fact, you can't).";
        });
    }

    private static void testSwitchExpressionWithEnum() {
        enum Mood {
            HAPPY, ANGRY, NOSTALGIC
        }

        Mood randomMood = Mood.values()[new Random().nextInt(Mood.values().length)];
        System.out.println(switch(randomMood) {
            case HAPPY -> "Really digging those new Java features. :D";
            case ANGRY -> "I'm switching to Kotlin. So long suckers!";
            case NOSTALGIC -> "Java 4 is still the best. No generics for me!";
            // No default case needed, as all possible values are covered!
        });
    }


}
