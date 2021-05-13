package types;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.*;

class ScrabbleFloatTest extends AbstractScrabbleVariableTest {
    // Testing values
    private double value;
    private ScrabbleFloat  tester;

    /**
     * Generates a random value
     * @return float (random)
     */
    private double generateValue() {
        return rng.nextDouble();
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
        tester = new ScrabbleFloat(value);
    }

    /**
     * Tests test functions, and the constructor
     */
    @RepeatedTest(20) void constructorTest() {
        // Values for the constructor test
        ScrabbleFloat expected = new ScrabbleFloat(value);
        double differentValue;
        do {
            differentValue = generateValue();
        } while (differentValue == value);
        ScrabbleFloat unexpected = new ScrabbleFloat(differentValue);

        // Standard constructor test
        constructAssert(tester, expected, unexpected);

        // Test toString
        assertEquals(tester.toString(), Double.toString(value));
    }


    /**
     * Test conversions
     * ScrabbleInt -> ScrabbleInt (and copy)
     * ScrabbleInt -> ScrabbleString
     * ScrabbleInt -> ScrabbleFloat
     */
    @RepeatedTest(20) void toScrabbleStringTest() {
        assertEquals(tester, tester.toScrabbleFloat(), "Non identical copy. seed = " + seed);
        assertEquals(tester.toScrabbleString(), new ScrabbleString(Double.toString(value)), "Wrong conversion to string. seed = " + seed);
    }
}