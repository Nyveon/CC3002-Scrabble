package model.syntax;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import model.syntax.endnodes.*;
import model.types.IScrabbleVariable;
import model.types.ScrabbleBool;
import model.types.ScrabbleString;
import model.types.numbers.ScrabbleBinary;
import model.types.numbers.ScrabbleFloat;
import model.types.numbers.ScrabbleInt;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VariableFlyweightFactoryTest {
    protected int seed;
    protected Random rng;

    @BeforeEach
    void setUp() {
        seed = new Random().nextInt();
        rng = new Random(seed);
    }

    // Cant be repeated because of the hashmap
    @Test
    void createTest() {
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

        // Different type tests
        assertEquals(null, VariableFlyweightFactory.getVariable("a"));
        assertEquals(sa, VariableFlyweightFactory.createScrabbleString("a", a));
        assertEquals(sa, VariableFlyweightFactory.getVariable("a"));
        assertEquals(sb, VariableFlyweightFactory.createScrabbleBool("b", b));
        assertEquals(sb, VariableFlyweightFactory.getVariable("b"));
        assertEquals(sc, VariableFlyweightFactory.createScrabbleInt("c", c));
        assertEquals(sc, VariableFlyweightFactory.getVariable("c"));
        assertEquals(sd, VariableFlyweightFactory.createScrabbleFloat("d", d));
        assertEquals(sd, VariableFlyweightFactory.getVariable("d"));
        assertEquals(se, VariableFlyweightFactory.createScrabbleBinary("e", e));
        assertEquals(se, VariableFlyweightFactory.getVariable("e"));
    }
}
