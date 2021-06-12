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
    @RepeatedTest(20) void conversionTest() {
        // Convert class to same class
        assertEquals(tester, tester.toScrabbleString(), "Non identical copy. seed = " + seed);
    }

    /**
     * Test concatenations
     * Tests sum
     */
    @RepeatedTest(100) void operationTest() {
        double value_float = rng.nextDouble();
        int value_int = rng.nextInt();
        String value_binary = new ScrabbleInt(value_int).toScrabbleBinary().getValue();
        boolean value_bool = rng.nextBoolean();
        String value_string = generateValue();

        var test_float = new ScrabbleFloat(value_float);
        var test_int = new ScrabbleInt(value_int);
        var test_binary = new ScrabbleBinary(value_binary);
        var test_bool = new ScrabbleBool(value_bool);
        var test_string = new ScrabbleString(value_string);

        // Tests
        assertEquals(value + value_float, tester.plus(test_float).getValue());
        assertEquals(value + value_int, tester.plus(test_int).getValue());
        assertEquals(value + value_binary, tester.plus(test_binary).getValue());
        assertEquals(value + value_bool, tester.plus(test_bool).getValue());
        assertEquals(value + value_string, tester.plus(test_string).getValue());
    }
}