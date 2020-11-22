import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 * This static class provides a function for creating a page reference string of a specified length for page replacement algorithms.
 * 
 * @author Kwinton Dropps
 * @author Jacob Hopkins
 * 
 * @version 1.0
 * @since 1.0
 */
public class PageGenerator {

    /** Floor for the random page number. */
    private static int min = 0;

    /** Ceiling for the random page number. */
    private static int max = 9;

    /** Wrapper for the public constructor. */
    private PageGenerator(){}

    /**
     * This is a static function to return a page reference string to be used in a page replacement algorithm.
     * 
     * @param referenceStringLength - the length of the page reference string to be returned.
     * @return int[] - An array of integers that represents the page reference string.
     */
    public static ArrayList<Integer> getPageReferenceString(int referenceStringLength) {

        ArrayList<Integer> referenceString = new ArrayList<>(referenceStringLength);

        for (int i = 0; i < referenceStringLength; i++) {
            referenceString.add(getRandomNumber());
        }

        return referenceString;
    }

    /** This is wrapper function for returning random numbers. */
    private static int getRandomNumber() {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
	}

}