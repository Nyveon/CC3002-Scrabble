package types;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.*;

class ScrabbleStringTest {
    // Testing values
    private String value;
    private ScrabbleString  tester;

    // Random
    private int seed;
    private Random rng;


    @BeforeEach void setUp() {
        // Random
        seed = new Random().nextInt();
        rng = new Random(seed);
        int stringSize = rng.nextInt(20);
        value = RandomStringUtils.random(stringSize, 0, Character.MAX_CODE_POINT, true, false, null, rng);

        // Testing value
        tester = new ScrabbleString(value);
    }


    /**
     * Tests test functions, and the constructor
     */
    @RepeatedTest(20) void constructorTest() {
        // Value to string
        assertEquals(tester.toString(), value, "Does not parse as string properly. seed = " + seed);

        // Different class, different object
        assertNotEquals(tester, new Object(), "Object classes asserted as matching." + seed);

        // Same object, same class
        ScrabbleString expected = new ScrabbleString(value);
        assertEquals(tester, expected , "Object properties do not match. seed = " + seed);
        assertEquals(tester.hashCode(), expected.hashCode(), "Hash codes do not match. seed = " + seed);

        // Different object, same class
        String differentValue;
        do {
            differentValue = RandomStringUtils.random(20, 0, Character.MAX_CODE_POINT, true, false, null, rng);
        } while (differentValue.equals(value));
        assertNotEquals(tester, new ScrabbleString(differentValue), "Different objects considered identical. seed = " + seed);
    }


    /**
     * Tests both toScrabbleString() and copy()
     */
    @RepeatedTest(20) void toScrabbleStringTest() {
        // Convert class to same class
        assertEquals(tester, tester.toScrabbleString(), "Non identical copy. seed = " + seed);
    }
}