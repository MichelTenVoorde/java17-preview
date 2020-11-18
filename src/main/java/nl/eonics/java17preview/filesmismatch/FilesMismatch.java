package nl.eonics.java17preview.filesmismatch;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class FilesMismatch {

    /**
     * Java 9 introduced the Arrays.mismatch method, which compares 2 arrays and returns the first position
     * at which the arrays have a mismatch.
     *
     * The new Files.mismatch, introduced in Java 12, has pretty much the same thing going for files.
     */

    public static void main(String[] args) throws Exception {
        testArraysMismatch();
        testFilesMismatch();
    }

    private static void testArraysMismatch() {

        int[] intArray1 = {1, 2, 4, 7, 12};
        int[] intArray2 = {1, 2, 5, 8, 14};

        int differAt = Arrays.mismatch(intArray1, intArray2);

        System.out.print(Arrays.toString(intArray1) + " and " + Arrays.toString(intArray2));

        if (differAt == -1) {
            System.out.println(" have the same content");
        } else {
            System.out.println(" differ at position " + differAt);
        }
    }

    private static void testFilesMismatch() throws Exception {

        Path path1 = Paths.get(ClassLoader.getSystemResource("filemismatch/manifesto1").toURI());
        Path path2 = Paths.get(ClassLoader.getSystemResource("filemismatch/manifesto2").toURI());

        long differAt = Files.mismatch(path1, path2);

        System.out.print(path1 + " and " + path2);

        if (differAt == -1) {
            System.out.println(" have the same content");
        } else {
            System.out.println(" differ at position " + differAt);
        }
    }
}
