package model.types;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import model.types.numbers.ScrabbleBinary;
import model.types.numbers.ScrabbleFloat;
import model.types.numbers.ScrabbleInt;

import java.util.Random;
import static org.junit.jupiter.api.Assertions.*;

class ScrabbleIntTest extends AbstractScrabbleVariableTest {
    // Testing values
    private int value;
    private ScrabbleInt tester;

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
     * ScrabbleInt -> ScrabbleBinary
     */
    @RepeatedTest(20) void conversionTest() {
        assertEquals(tester, tester.toScrabbleInt(), "Non identical copy. seed = " + seed);
        assertEquals(tester.toScrabbleString(), new ScrabbleString(Integer.toString(value)), "Wrong conversion to string. seed = " + seed);
        assertEquals(tester.toScrabbleFloat(), new ScrabbleFloat(value), "Wrong conversion to string. seed = " + seed);

        // Hand crafted binary tests
        ScrabbleInt binaryTesterA = new ScrabbleInt(123456);
        ScrabbleInt binaryTesterB = new ScrabbleInt(-123456);
        ScrabbleInt binaryTesterC = new ScrabbleInt(0);
        assertEquals(binaryTesterA.toScrabbleBinary(), new ScrabbleBinary("00000000000000011110001001000000"));
        assertEquals(binaryTesterB.toScrabbleBinary(), new ScrabbleBinary("11111111111111100001110111000000"));
        assertEquals(binaryTesterC.toScrabbleBinary(), new ScrabbleBinary("0"));
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