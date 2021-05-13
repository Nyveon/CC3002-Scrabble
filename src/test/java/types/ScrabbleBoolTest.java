package types;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.*;

class ScrabbleBoolTest extends AbstractScrabbleVariableTest {
    // Testing values
    private boolean value;
    private ScrabbleBool  tester;

    /**
     * Generates a random value
     * @return boolean (random 0 or 1)
     */
    private boolean generateValue() {
        return rng.nextBoolean();
    }

    /**
     * Set up necessary for all tests
     */
    @BeforeEach
    void setUp() {
        // Random
        seed = new Random().nextInt();
        rng = new Random(seed);
        value = generateValue();

        // Testing value
        tester = new ScrabbleBool(value);
    }

    /**
     * Tests test functions, and the constructor
     */
    @RepeatedTest(20) void constructorTest() {
        // Values for the constructor test
        ScrabbleBool expected = new ScrabbleBool(value);
        boolean differentValue;
        do {
            differentValue = generateValue();
        } while (differentValue == value);
        ScrabbleBool unexpected = new ScrabbleBool(differentValue);

        // Standard constructor test
        constructAssert(tester, expected, unexpected);

        // Test toString
        assertEquals(tester.toString(), Boolean.toString(value));
    }


    /**
     * Test conversions
     * ScrabbleBool -> ScrabbleBool (and copy)
     * ScrabbleBool -> ScrabbleString
     */
    @RepeatedTest(20) void toScrabbleStringTest() {
        assertEquals(tester, tester.toScrabbleBool(), "Non identical copy. seed = " + seed);
        assertEquals(tester.toScrabbleString(), new ScrabbleString(Boolean.toString(value)), "Wrong conversion to string. seed = " + seed);
    }
}