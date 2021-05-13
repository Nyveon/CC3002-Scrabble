package types;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.*;

class ScrabbleBinaryTest extends AbstractScrabbleVariableTest {
    // Testing values
    private String value;
    private ScrabbleBinary tester;

    /**
     * Generates a random value
     * @return String of 0s an 1s (random, 0 to 20 long)
     */
    private String generateValue() {
        int binarySize = rng.nextInt(20);

        // Loop for making a random string of 0s and 1s of length binarySize.
        String generated = ""; //todo: figure out what convert to string builder means
        for (int i = 0; i < binarySize; i++) {
            if (rng.nextBoolean()) {
                generated = generated + "0";
            } else {
                generated = generated + "1";
            }
        }
        return generated;
    }


    /**
     * Set up necessary for all tests
     */
    @BeforeEach void setUp() {
        // Random
        seed = new Random().nextInt();
        rng = new Random(seed);
        value = generateValue();

        // Testing value
        tester = new ScrabbleBinary(value);
    }


    /**
     * Tests test functions, and the constructor
     */
    @RepeatedTest(20) void constructorTest() {
        // Values for the constructor test
        ScrabbleBinary expected = new ScrabbleBinary(value);
        String differentValue;
        do {
            differentValue = generateValue();
        } while (differentValue.equals(value));
        ScrabbleBinary unexpected = new ScrabbleBinary(differentValue);

        // Standard constructor test
        constructAssert(tester, expected, unexpected);

        // Test toString
        assertEquals(tester.toString(), value, "Does not parse as string properly. seed = " + seed);
    }


    /**
     * Test conversions
     * Tests both toScrabbleBinary() and copy()
     */
    @RepeatedTest(20) void toScrabbleStringTest() {
        // Convert class to same class
        assertEquals(tester, tester.toScrabbleBinary(), "Non identical copy. seed = " + seed);
        assertEquals(tester.toScrabbleString(), new ScrabbleString(value), "Wrong conversion to string. seed = " + seed);
    }
}