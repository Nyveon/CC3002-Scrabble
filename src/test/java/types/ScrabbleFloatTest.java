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
     * @return double (random)
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
    @RepeatedTest(20) void conversionTest() {
        assertEquals(tester, tester.toScrabbleFloat(), "Non identical copy. seed = " + seed);
        assertEquals(tester.toScrabbleString(), new ScrabbleString(Double.toString(value)), "Wrong conversion to string. seed = " + seed);
    }

    /**
     * Test operations
     * (+, -, x, /) with float
     * (+, -, x, /) with int
     * (+, -, x, /) with binary
     */
    @RepeatedTest(100) void operationTest() {
        double float_value = rng.nextDouble();
        int int_value = rng.nextInt();
        String binary_value = new ScrabbleInt(int_value).toScrabbleBinary().getValue();

        // Test against floats
        assertEquals(value + float_value, tester.plus(new ScrabbleFloat(float_value)).getValue());
        assertEquals(value - float_value, tester.minus(new ScrabbleFloat(float_value)).getValue());
        assertEquals(value * float_value, tester.times(new ScrabbleFloat(float_value)).getValue());
        assertEquals(value / float_value, tester.div(new ScrabbleFloat(float_value)).getValue());


        // Test against ints
        assertEquals(value + int_value, tester.plus(new ScrabbleInt(int_value)).getValue());
        assertEquals(value - int_value, tester.minus(new ScrabbleInt(int_value)).getValue());
        assertEquals(value * int_value, tester.times(new ScrabbleInt(int_value)).getValue());
        assertEquals(value / int_value, tester.div(new ScrabbleInt(int_value)).getValue());


        // Test against binaries
        assertEquals(value + int_value, tester.plus(new ScrabbleBinary(binary_value)).getValue());
        assertEquals(value - int_value, tester.minus(new ScrabbleBinary(binary_value)).getValue());
        assertEquals(value * int_value, tester.times(new ScrabbleBinary(binary_value)).getValue());
        assertEquals(value / int_value, tester.div(new ScrabbleBinary(binary_value)).getValue());


    }
}