package types;

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
        int binarySize = 32;

        // Loop for making a random string of 0s and 1s of length binarySize.
        StringBuilder generated = new StringBuilder();
        for (int i = 0; i < binarySize; i++) {
            if (rng.nextBoolean()) {
                generated.append("0");
            } else {
                generated.append("1");
            }
        }
        return generated.toString();
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
     * ScrabbleBinary -> ScrabbleBinary (and copy)
     * ScrabbleBinary -> ScrabbleString
     * ScrabbleBinary -> ScrabbleFloat
     * ScrabbleBinary -> ScrabbleInt
     */
    @RepeatedTest(20) void conversionTest() {
        // Convert class to same class
        assertEquals(tester, tester.toScrabbleBinary(), "Non identical copy. seed = " + seed);
        assertEquals(tester.toScrabbleString(), new ScrabbleString(value), "Wrong conversion to string. seed = " + seed);

        // Hand crafted int tests
        ScrabbleBinary intTesterA = new ScrabbleBinary("00000000000000011110001001000000");
        ScrabbleBinary intTesterB = new ScrabbleBinary("11111111111111100001110111000000");
        ScrabbleBinary intTesterC = new ScrabbleBinary("0");
        assertEquals(intTesterA.toScrabbleInt(), new ScrabbleInt(123456));
        assertEquals(intTesterB.toScrabbleInt(), new ScrabbleInt(-123456));
        assertEquals(intTesterC.toScrabbleInt(), new ScrabbleInt(0));

        // Hand crafted float tests
        assertEquals(intTesterA.toScrabbleFloat(), new ScrabbleFloat(123456.0));
        assertEquals(intTesterB.toScrabbleFloat(), new ScrabbleFloat(-123456.0));
        assertEquals(intTesterC.toScrabbleFloat(), new ScrabbleFloat(0.0));

        assertEquals(intTesterA.getValue(), intTesterA.toString());
    }

    /**
     * Test operations
     * (+, -, x, /) with float
     * (+, -, x, /) with int
     * (+, -, x, /) with binary
     */
    @RepeatedTest(100) void operationTest() {
        int int_value = rng.nextInt();
        String binary_value = new ScrabbleInt(int_value).toScrabbleBinary().getValue();
        int bin_int = new ScrabbleBinary(value).toScrabbleInt().getValue();

        // Test against ints
        assertEquals(new ScrabbleInt(bin_int + int_value).toScrabbleBinary().getValue(), tester.plus(new ScrabbleInt(int_value)).getValue());
        assertEquals(new ScrabbleInt(bin_int - int_value).toScrabbleBinary().getValue(), tester.minus(new ScrabbleInt(int_value)).getValue());
        assertEquals(new ScrabbleInt(bin_int * int_value).toScrabbleBinary().getValue(), tester.times(new ScrabbleInt(int_value)).getValue());
        assertEquals(new ScrabbleInt(bin_int / int_value).toScrabbleBinary().getValue(), tester.div(new ScrabbleInt(int_value)).getValue());


        // Test against binaries
        assertEquals(new ScrabbleInt(bin_int + int_value).toScrabbleBinary().getValue(), tester.plus(new ScrabbleBinary(binary_value)).getValue());
        assertEquals(new ScrabbleInt(bin_int - int_value).toScrabbleBinary().getValue(), tester.minus(new ScrabbleBinary(binary_value)).getValue());
        assertEquals(new ScrabbleInt(bin_int * int_value).toScrabbleBinary().getValue(), tester.times(new ScrabbleBinary(binary_value)).getValue());
        assertEquals(new ScrabbleInt(bin_int / int_value).toScrabbleBinary().getValue(), tester.div(new ScrabbleBinary(binary_value)).getValue());

        // -Logic tests-
        String all_one =    "11111111111111111111111111111111";
        String all_zero =   "00000000000000000000000000000000";
        String half_zero =  "11111111111111110000000000000000";
        String half_one =   "00000000000000001111111111111111";
        String bar_code =   "10101010101010101010101010101010";
        String code_bar =   "01010101010101010101010101010101";
        String i_left =     "11111111111111111000000000000000";
        String i_right =    "00000000000000001111111111111111";
        String i_mid =      "00000000000000001000000000000000";
        ScrabbleBool true_bool = new ScrabbleBool(true);
        ScrabbleBool false_bool = new ScrabbleBool(false);

        // Logical not
        assertEquals(new ScrabbleBinary(all_one), new ScrabbleBinary(all_zero).not());
        assertEquals(new ScrabbleBinary(all_zero), new ScrabbleBinary(all_one).not());
        assertNotEquals(new ScrabbleBinary(all_zero), new ScrabbleBinary(all_zero).not());
        assertNotEquals(new ScrabbleBinary(all_one), new ScrabbleBinary(all_one).not());
        assertEquals(new ScrabbleBinary(half_zero), new ScrabbleBinary(half_one).not());

        // With scrabble binary
        // Logical and
        assertEquals(new ScrabbleBinary(all_zero), new ScrabbleBinary(all_zero).and(new ScrabbleBinary(all_one)));
        assertEquals(new ScrabbleBinary(all_zero), new ScrabbleBinary(all_one).and(new ScrabbleBinary(all_zero)));
        assertEquals(new ScrabbleBinary(all_zero), new ScrabbleBinary(all_zero).and(new ScrabbleBinary(all_zero)));
        assertEquals(new ScrabbleBinary(all_one), new ScrabbleBinary(all_one).and(new ScrabbleBinary(all_one)));
        assertEquals(new ScrabbleBinary(i_mid), new ScrabbleBinary(i_left).and(new ScrabbleBinary(i_right)));
        assertEquals(new ScrabbleBinary(i_mid), new ScrabbleBinary(i_right).and(new ScrabbleBinary(i_left)));
        assertEquals(new ScrabbleBinary(all_zero), new ScrabbleBinary(code_bar).and(new ScrabbleBinary(bar_code)));
        assertEquals(new ScrabbleBinary(half_zero), (new ScrabbleBinary(i_left).and(new ScrabbleBinary(all_one))).and(new ScrabbleBinary(i_mid).not()));

        // Logical or
        assertEquals(new ScrabbleBinary(all_one), new ScrabbleBinary(all_zero).or(new ScrabbleBinary(all_one)));
        assertEquals(new ScrabbleBinary(all_one), new ScrabbleBinary(all_one).or(new ScrabbleBinary(all_zero)));
        assertEquals(new ScrabbleBinary(all_zero), new ScrabbleBinary(all_zero).or(new ScrabbleBinary(all_zero)));
        assertEquals(new ScrabbleBinary(all_one), new ScrabbleBinary(all_one).or(new ScrabbleBinary(all_one)));
        assertEquals(new ScrabbleBinary(all_one), new ScrabbleBinary(i_left).or(new ScrabbleBinary(i_right)));
        assertEquals(new ScrabbleBinary(all_one), new ScrabbleBinary(i_right).or(new ScrabbleBinary(i_left)));
        assertEquals(new ScrabbleBinary(all_one), new ScrabbleBinary(code_bar).or(new ScrabbleBinary(bar_code)));
        assertEquals(new ScrabbleBinary(i_left), new ScrabbleBinary(i_mid).or(new ScrabbleBinary(i_left)));

        // With scrabble bool
        // Logical and
        assertEquals(tester, tester.and(true_bool));
        assertEquals(new ScrabbleBinary(all_zero), tester.and(false_bool));

        // Logical or
        assertEquals(tester, tester.or(false_bool));
        assertEquals(new ScrabbleBinary(all_one), tester.or(true_bool));

    }

}