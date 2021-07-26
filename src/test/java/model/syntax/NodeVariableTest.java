package model.syntax;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import model.syntax.endnodes.*;
import model.types.ScrabbleBool;
import model.types.ScrabbleString;
import model.types.numbers.ScrabbleBinary;
import model.types.numbers.ScrabbleFloat;
import model.types.numbers.ScrabbleInt;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NodeVariableTest {
    protected int seed;
    protected Random rng;

    @BeforeEach
    void setUp() {
        seed = new Random().nextInt();
        rng = new Random(seed);
    }

    // Test that each variable node, when evaluated, returns the proper scrabble variable
    @RepeatedTest(20) void evaluateTest() {
        // --Generating values for all different model.types--
        int stringSize = rng.nextInt(20);
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
        generated.toString();

        var a = RandomStringUtils.random(stringSize, 0, Character.MAX_CODE_POINT, true, false, null, rng);;
        var b = rng.nextBoolean();;
        var c = rng.nextInt();
        var d = rng.nextDouble();
        var e = generated.toString();;

        // --Scrabble Variables with generated values--
        var sa = new ScrabbleString(a);
        var sb = new ScrabbleBool(b);
        var sc = new ScrabbleInt(c);
        var sd = new ScrabbleFloat(d);
        var se = new ScrabbleBinary(e);

        // --Scrabble variable Nodes with generated values--
        var ta = new NodeString(a);
        var tb = new NodeBool(b);
        var tc = new NodeInt(c);
        var td = new NodeFloat(d);
        var te = new NodeBinary(e);

        // Test equivalency
        assertEquals(sa, ta.evaluate());
        assertEquals(sb, tb.evaluate());
        assertEquals(sc, tc.evaluate());
        assertEquals(sd, td.evaluate());
        assertEquals(se, te.evaluate());

        // Get Label tests
        assertEquals(sa.toString(), ta.get_label());
        assertEquals(sb.toString(), tb.get_label());
        assertEquals(sc.toString(), tc.get_label());
        assertEquals(sd.toString(), td.get_label());
        assertEquals(se.toString(), te.get_label());

        // Get  children tests
        assertEquals(0, ta.get_children());
        assertEquals(0, tb.get_children());
        assertEquals(0, tc.get_children());
        assertEquals(0, td.get_children());
        assertEquals(0, te.get_children());
    }
}
