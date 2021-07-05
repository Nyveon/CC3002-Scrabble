package syntax;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import syntax.unarynodes.operators.*;
import syntax.unarynodes.variables.*;
import types.IScrabbleVariable;
import types.ScrabbleBool;
import types.ScrabbleString;
import types.numbers.ScrabbleBinary;
import types.numbers.ScrabbleFloat;
import types.numbers.ScrabbleInt;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class NodeUnaryOperatorsTest {
    protected int seed;
    protected Random rng;

    @BeforeEach
    void setUp() {
        seed = new Random().nextInt();
        rng = new Random(seed);
    }

    // Test that each variable node, when evaluated, returns the proper scrabble variable
    @RepeatedTest(20) void evaluateTest() {
        // --Generating values for all different types--
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
        IScrabbleVariable sa = new ScrabbleString(a);
        IScrabbleVariable sb = new ScrabbleBool(b);
        IScrabbleVariable sc = new ScrabbleInt(c);
        IScrabbleVariable sd = new ScrabbleFloat(d);
        IScrabbleVariable se = new ScrabbleBinary(e);

        // --Scrabble variable Nodes with generated values--
        var ta = new NodeString(a);
        var tb = new NodeBool(b);
        var tc = new NodeInt(c);
        var td = new NodeFloat(d);
        var te = new NodeBinary(e);

        // Test nodeNot
        assertEquals(null, new NodeNot(ta).evaluate()); // String
        assertEquals(sb.not(), new NodeNot(tb).evaluate()); // Boolean
        assertEquals(null, new NodeNot(tc).evaluate()); // FInt
        assertEquals(null, new NodeNot(td).evaluate()); // Float
        assertEquals(se.not(), new NodeNot(te).evaluate()); // Binary

        // Test nodetoBinary
        assertEquals(null, new NodetoBinary(ta).evaluate()); // String
        assertEquals(null, new NodetoBinary(tb).evaluate()); // Boolean
        assertEquals(sc.toScrabbleBinary(), new NodetoBinary(tc).evaluate()); // Int
        assertEquals(null, new NodetoBinary(td).evaluate()); // Float
        assertEquals(se.toScrabbleBinary(), new NodetoBinary(te).evaluate()); // Binary

        // Test nodetoBool
        assertEquals(null, new NodetoBool(ta).evaluate()); // String
        assertEquals(sb.toScrabbleBool(), new NodetoBool(tb).evaluate()); // Boolean
        assertEquals(null, new NodetoBool(tc).evaluate()); // Int
        assertEquals(null, new NodetoBool(td).evaluate()); // Float
        assertEquals(null, new NodetoBool(te).evaluate()); // Binary

        // Test nodetoFloat
        assertEquals(null, new NodetoFloat(ta).evaluate()); // String
        assertEquals(null, new NodetoFloat(tb).evaluate()); // Boolean
        assertEquals(sc.toScrabbleFloat(), new NodetoFloat(tc).evaluate()); // Int
        assertEquals(sd.toScrabbleFloat(), new NodetoFloat(td).evaluate()); // Float
        assertEquals(se.toScrabbleFloat(), new NodetoFloat(te).evaluate()); // Binary


        // Test nodetoInt
        assertEquals(null, new NodetoInt(ta).evaluate()); // String
        assertEquals(null, new NodetoInt(tb).evaluate()); // Boolean
        assertEquals(sc.toScrabbleInt(), new NodetoInt(tc).evaluate()); // Int
        assertEquals(null, new NodetoInt(td).evaluate()); // Float
        assertEquals(se.toScrabbleInt(), new NodetoInt(te).evaluate()); // Binary


        // Test nodetoString
        assertEquals(sa.toScrabbleString(), new NodetoString(ta).evaluate()); // String
        assertEquals(sb.toScrabbleString(), new NodetoString(tb).evaluate()); // Boolean
        assertEquals(sc.toScrabbleString(), new NodetoString(tc).evaluate()); // Int
        assertEquals(sd.toScrabbleString(), new NodetoString(td).evaluate()); // Float
        assertEquals(se.toScrabbleString(), new NodetoString(te).evaluate()); // Binary
    }
}
