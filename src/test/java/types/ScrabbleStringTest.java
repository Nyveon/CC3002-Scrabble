package types;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.*;

class ScrabbleStringTest extends AbstractScrabbleVariableTest {
    // Testing values
    private String value;
    private ScrabbleString  tester;

    /**
     * Generates a random value
     * @return String (random, 0 to 20 long)
     */
    private String generateValue() {
        int stringSize = rng.nextInt(20);
        return RandomStringUtils.random(stringSize, 0, Character.MAX_CODE_POINT, true, false, null, rng);
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
        tester = new ScrabbleString(value);
    }


    /**
     * Tests test functions, and the constructor
     */
    @RepeatedTest(20) void constructorTest() {
        // Values for the constructor test
        ScrabbleString expected = new ScrabbleString(value);
        String differentValue;
        do {
            differentValue = generateValue();
        } while (differentValue.equals(value));
        ScrabbleString unexpected = new ScrabbleString(differentValue);

        // Standard constructor test
        constructAssert(tester, expected, unexpected);

        // Test toString
        assertEquals(tester.toString(), value, "Does not parse as string properly. seed = " + seed);
    }


    /**
     * Test conversions
     * Tests both toScrabbleString() and copy()
     */
    @RepeatedTest(20) void toScrabbleStringTest() {
        // Convert class to same class
        assertEquals(tester, tester.toScrabbleString(), "Non identical copy. seed = " + seed);
    }
}