package types;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import types.numbers.ScrabbleBinary;

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
    @RepeatedTest(20) void conversionTest() {
        assertEquals(tester, tester.toScrabbleBool(), "Non identical copy. seed = " + seed);
        assertEquals(tester.toScrabbleString(), new ScrabbleString(Boolean.toString(value)), "Wrong conversion to string. seed = " + seed);
    }


    /**
     * Test operations
     * (not) self
     * (and, or) with ScrabbleBool
     * (and, or) with ScrabbleBInary
     */
    @RepeatedTest(100)
    void operationTest() {
        var true_bool = new ScrabbleBool(true);
        var false_bool = new ScrabbleBool(false);

        //not
        assertEquals(true_bool, false_bool.not());
        assertEquals(false_bool, true_bool.not());

        // Operate with Bool
        // AND
        assertEquals(true_bool, true_bool.and(true_bool));
        assertEquals(false_bool, true_bool.and(false_bool));
        assertEquals(false_bool, false_bool.and(true_bool));
        assertEquals(false_bool, false_bool.and(false_bool));

        // OR
        assertEquals(true_bool, true_bool.or(true_bool));
        assertEquals(true_bool, true_bool.or(false_bool));
        assertEquals(true_bool, false_bool.or(true_bool));
        assertEquals(false_bool, false_bool.or(false_bool));

        // Operate with binary
        // Loop for making a random string of 0s and 1s of length binarySize.
        StringBuilder value_binary = new StringBuilder();
        for (int i = 0; i < 32; i++) {
            if (rng.nextBoolean()) {
                value_binary.append("0");
            } else {
                value_binary.append("1");
            }
        }
        var tester_binary = new ScrabbleBinary(value_binary.toString());
        String all_one =    "11111111111111111111111111111111";
        String all_zero =   "00000000000000000000000000000000";


        // AND
        assertEquals(tester_binary, true_bool.and(tester_binary));
        assertEquals(new ScrabbleBinary(all_zero), false_bool.and(tester_binary));

        // OR
        assertEquals(tester_binary, false_bool.or(tester_binary));
        assertEquals(new ScrabbleBinary(all_one), true_bool.or(tester_binary));

    }
}