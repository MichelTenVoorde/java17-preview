package nl.eonics.java17preview.compactnumberformatting;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class CompactNumberFormatting {
    public static void main(String[] args) {
        formatForLocale(Locale.US);
        formatForLocale(new Locale("nl", "NL"));
    }

    private static void formatForLocale(Locale locale) {
        List<Integer> numbers = List.of(1000, 1000000, 1000000000, 123456789);

        System.out.printf("-- SHORT format for locale=%s --%n", locale);

        numbers.stream().forEach((num) -> {
            NumberFormat nf = NumberFormat.getCompactNumberInstance(locale, NumberFormat.Style.SHORT);
            String format = nf.format(num);
            System.out.println(format);
        });

        System.out.printf("-- LONG format for locale=%s --%n", locale);

        numbers.stream().forEach((num) -> {
            NumberFormat nf = NumberFormat.getCompactNumberInstance(locale, NumberFormat.Style.LONG);
            String format = nf.format(num);
            System.out.println(format);
        });
    }

}