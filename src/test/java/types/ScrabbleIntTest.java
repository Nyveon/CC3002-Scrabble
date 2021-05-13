package types;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.*;

class ScrabbleIntTest extends AbstractScrabbleVariableTest {
    // Testing values
    private int value;
    private ScrabbleInt  tester;

    /**
     * Generates a random value
     * @return int (random)
     */
    private int generateValue() {
        return rng.nextInt();
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
        tester = new ScrabbleInt(value);
    }

    /**
     * Tests test functions, and the constructor
     */
    @RepeatedTest(20) void constructorTest() {
        // Values for the constructor test
        ScrabbleInt expected = new ScrabbleInt(value);
        int differentValue;
        do {
            differentValue = generateValue();
        } while (differentValue == value);
        ScrabbleInt unexpected = new ScrabbleInt(differentValue);

        // Standard constructor test
        constructAssert(tester, expected, unexpected);

        // Test toString
        assertEquals(tester.toString(), Integer.toString(value));
    }


    /**
     * Test conversions
     * ScrabbleInt -> ScrabbleInt (and copy)
     * ScrabbleInt -> ScrabbleString
     * ScrabbleInt -> ScrabbleFloat
     */
    @RepeatedTest(20) void toScrabbleStringTest() {
        assertEquals(tester, tester.toScrabbleInt(), "Non identical copy. seed = " + seed);
        assertEquals(tester.toScrabbleString(), new ScrabbleString(Integer.toString(value)), "Wrong conversion to string. seed = " + seed);
        assertEquals(tester.toScrabbleFloat(), new ScrabbleFloat((double) value), "Wrong conversion to string. seed = " + seed);
    }
}