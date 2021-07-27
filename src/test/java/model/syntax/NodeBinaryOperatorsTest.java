package model.syntax;

import model.syntax.unarynodes.operators.NodeNot;
import model.types.ScrabbleNull;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import model.syntax.binarynodes.operators.*;
import model.syntax.endnodes.*;
import model.types.IScrabbleVariable;
import model.types.ScrabbleBool;
import model.types.ScrabbleString;
import model.types.numbers.ScrabbleBinary;
import model.types.numbers.ScrabbleFloat;
import model.types.numbers.ScrabbleInt;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class NodeBinaryOperatorsTest {
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
        generated.append("1");

        StringBuilder generated2 = new StringBuilder();
        for (int i = 0; i < binarySize; i++) {
            if (rng.nextBoolean()) {
                generated.append("0");
            } else {
                generated.append("1");
            }
        }
        generated.append("1");

        var a = RandomStringUtils.random(stringSize, 0, Character.MAX_CODE_POINT, true, false, null, rng);;
        var b = rng.nextBoolean();
        var c = rng.nextInt();
        var d = rng.nextDouble();
        var e = generated.toString();

        var a2 = RandomStringUtils.random(stringSize, 0, Character.MAX_CODE_POINT, true, false, null, rng);;
        var b2 = rng.nextBoolean();
        var c2 = rng.nextInt();
        var d2 = rng.nextDouble();
        var e2 = generated2.toString();;

        // --Scrabble Variables with generated values--
        IScrabbleVariable sa = new ScrabbleString(a);
        IScrabbleVariable sb = new ScrabbleBool(b);
        IScrabbleVariable sc = new ScrabbleInt(c);
        IScrabbleVariable sd = new ScrabbleFloat(d);
        IScrabbleVariable se = new ScrabbleBinary(e);

        IScrabbleVariable sa2 = new ScrabbleString(a2);
        IScrabbleVariable sb2 = new ScrabbleBool(b2);
        IScrabbleVariable sc2 = new ScrabbleInt(c2);
        IScrabbleVariable sd2 = new ScrabbleFloat(d2);
        IScrabbleVariable se2 = new ScrabbleBinary(e2);

        // --Scrabble variable Nodes with generated values--
        var ta = new NodeString(a);
        var tb = new NodeBool(b);
        var tc = new NodeInt(c);
        var td = new NodeFloat(d);
        var te = new NodeBinary(e);
        var ta2 = new NodeString(a2);
        var tb2 = new NodeBool(b2);
        var tc2 = new NodeInt(c2);
        var td2 = new NodeFloat(d2);
        var te2 = new NodeBinary(e2);

        // Deletion test
        var deltest = new NodeAnd(ta,ta2);
        deltest.delete(ta);
        deltest.delete(tb);
        deltest.delete(tc);
        var deltest2 = new NodeAnd(ta,ta2);
        deltest2.delete(ta2);
        assertNotEquals(new NodeAnd(ta,ta2), deltest);
        assertNotEquals(new NodeAnd(ta,ta2), deltest2);

        // Insertion test
        var inserttest = new NodeAnd(ta,ta2);
        deltest.insert(ta, ta2);
        var inserttest2 = new NodeAnd(ta,ta2);
        deltest.insert(ta2, ta);
        //assertEquals(new NodeAnd(ta,ta), inserttest);
        //assertEquals(new NodeAnd(ta,ta), inserttest2);


        // Getters tests
        var gettest = new NodeAnd(ta,ta2);
        assertEquals(ta, gettest.get_child_a());
        assertEquals(ta2, gettest.get_child_b());


        // --Test nodeAnd--
        assertEquals("AND", new NodeAnd(ta,ta2).get_label()); // get label
        assertEquals(2, new NodeAnd(ta,ta2).get_children()); // get children

        assertEquals(ScrabbleNull.getInstance(), new NodeAnd(ta,ta2).evaluate()); // String String
        assertEquals(ScrabbleNull.getInstance(), new NodeAnd(ta,tb).evaluate()); // String Bool
        assertEquals(ScrabbleNull.getInstance(), new NodeAnd(ta,tc).evaluate()); // String Float
        assertEquals(ScrabbleNull.getInstance(), new NodeAnd(ta,td).evaluate()); // String Int
        assertEquals(ScrabbleNull.getInstance(), new NodeAnd(ta,te).evaluate()); // String Binary

        assertEquals(ScrabbleNull.getInstance(), new NodeAnd(tb,ta).evaluate()); // Bool String
        assertEquals(sb.and(sb2), new NodeAnd(tb,tb2).evaluate()); // Bool Bool
        assertEquals(ScrabbleNull.getInstance(), new NodeAnd(tb,tc).evaluate()); // Bool Float
        assertEquals(ScrabbleNull.getInstance(), new NodeAnd(tb,td).evaluate()); // Bool Int
        assertEquals(sb.and(se), new NodeAnd(tb,te).evaluate()); // Bool Binary

        assertEquals(ScrabbleNull.getInstance(), new NodeAnd(tc,ta).evaluate()); // Int String
        assertEquals(ScrabbleNull.getInstance(), new NodeAnd(tc,tb).evaluate()); // Int Bool
        assertEquals(ScrabbleNull.getInstance(), new NodeAnd(tc,tc2).evaluate()); // Int Float
        assertEquals(ScrabbleNull.getInstance(), new NodeAnd(tc,td).evaluate()); // Int Int
        assertEquals(ScrabbleNull.getInstance(), new NodeAnd(tc,te).evaluate()); // Int Binary

        assertEquals(ScrabbleNull.getInstance(), new NodeAnd(td,ta).evaluate()); // Float String
        assertEquals(ScrabbleNull.getInstance(), new NodeAnd(td,tb).evaluate()); // Float Bool
        assertEquals(ScrabbleNull.getInstance(), new NodeAnd(td,tc).evaluate()); // Float Float
        assertEquals(ScrabbleNull.getInstance(), new NodeAnd(td,td2).evaluate()); // Float Int
        assertEquals(ScrabbleNull.getInstance(), new NodeAnd(td,te).evaluate()); // Float Binary

        assertEquals(ScrabbleNull.getInstance(), new NodeAnd(te,ta).evaluate()); // Binary String
        assertEquals(se.and(sb), new NodeAnd(te,tb).evaluate()); // Binary Bool
        assertEquals(ScrabbleNull.getInstance(), new NodeAnd(te,tc).evaluate()); // Binary Float
        assertEquals(ScrabbleNull.getInstance(), new NodeAnd(te,td).evaluate()); // Binary Int
        assertEquals(se.and(se2), new NodeAnd(te,te2).evaluate()); // Binary Binary

        // --Test nodeOr--
        assertEquals("OR", new NodeOr(ta,ta2).get_label()); // get label
        assertEquals(2, new NodeOr(ta,ta2).get_children()); // get children

        assertEquals(ScrabbleNull.getInstance(), new NodeOr(ta,ta2).evaluate()); // String String
        assertEquals(ScrabbleNull.getInstance(), new NodeOr(ta,tb).evaluate()); // String Bool
        assertEquals(ScrabbleNull.getInstance(), new NodeOr(ta,tc).evaluate()); // String Float
        assertEquals(ScrabbleNull.getInstance(), new NodeOr(ta,td).evaluate()); // String Int
        assertEquals(ScrabbleNull.getInstance(), new NodeOr(ta,te).evaluate()); // String Binary

        assertEquals(ScrabbleNull.getInstance(), new NodeOr(tb,ta).evaluate()); // Bool String
        assertEquals(sb.or(sb2), new NodeOr(tb,tb2).evaluate()); // Bool Bool
        assertEquals(ScrabbleNull.getInstance(), new NodeOr(tb,tc).evaluate()); // Bool Float
        assertEquals(ScrabbleNull.getInstance(), new NodeOr(tb,td).evaluate()); // Bool Int
        assertEquals(sb.or(se), new NodeOr(tb,te).evaluate()); // Bool Binary

        assertEquals(ScrabbleNull.getInstance(), new NodeOr(tc,ta).evaluate()); // Int String
        assertEquals(ScrabbleNull.getInstance(), new NodeOr(tc,tb).evaluate()); // Int Bool
        assertEquals(ScrabbleNull.getInstance(), new NodeOr(tc,tc2).evaluate()); // Int Float
        assertEquals(ScrabbleNull.getInstance(), new NodeOr(tc,td).evaluate()); // Int Int
        assertEquals(ScrabbleNull.getInstance(), new NodeOr(tc,te).evaluate()); // Int Binary

        assertEquals(ScrabbleNull.getInstance(), new NodeOr(td,ta).evaluate()); // Float String
        assertEquals(ScrabbleNull.getInstance(), new NodeOr(td,tb).evaluate()); // Float Bool
        assertEquals(ScrabbleNull.getInstance(), new NodeOr(td,tc).evaluate()); // Float Float
        assertEquals(ScrabbleNull.getInstance(), new NodeOr(td,td2).evaluate()); // Float Int
        assertEquals(ScrabbleNull.getInstance(), new NodeOr(td,te).evaluate()); // Float Binary

        assertEquals(ScrabbleNull.getInstance(), new NodeOr(te,ta).evaluate()); // Binary String
        assertEquals(se.or(sb), new NodeOr(te,tb).evaluate()); // Binary Bool
        assertEquals(ScrabbleNull.getInstance(), new NodeOr(te,tc).evaluate()); // Binary Float
        assertEquals(ScrabbleNull.getInstance(), new NodeOr(te,td).evaluate()); // Binary Int
        assertEquals(se.or(se2), new NodeOr(te,te2).evaluate()); // Binary Binary


        // Test nodeDiv
        assertEquals("/", new NodeDiv(ta,ta2).get_label()); // get label
        assertEquals(2, new NodeDiv(ta,ta2).get_children()); // get children

        assertEquals(ScrabbleNull.getInstance(), new NodeDiv(ta,ta2).evaluate()); // String String
        assertEquals(ScrabbleNull.getInstance(), new NodeDiv(ta,tb).evaluate()); // String Bool
        assertEquals(ScrabbleNull.getInstance(), new NodeDiv(ta,tc).evaluate()); // String Float
        assertEquals(ScrabbleNull.getInstance(), new NodeDiv(ta,td).evaluate()); // String Int
        assertEquals(ScrabbleNull.getInstance(), new NodeDiv(ta,te).evaluate()); // String Binary

        assertEquals(ScrabbleNull.getInstance(), new NodeDiv(tb,ta).evaluate()); // Bool String
        assertEquals(ScrabbleNull.getInstance(), new NodeDiv(tb,tb2).evaluate()); // Bool Bool
        assertEquals(ScrabbleNull.getInstance(), new NodeDiv(tb,tc).evaluate()); // Bool Float
        assertEquals(ScrabbleNull.getInstance(), new NodeDiv(tb,td).evaluate()); // Bool Int
        assertEquals(ScrabbleNull.getInstance(), new NodeDiv(tb,te).evaluate()); // Bool Binary

        assertEquals(ScrabbleNull.getInstance(), new NodeDiv(tc,ta).evaluate()); // Int String
        assertEquals(ScrabbleNull.getInstance(), new NodeDiv(tc,tb).evaluate()); // Int Bool
        assertEquals(sc.div(sc2), new NodeDiv(tc,tc2).evaluate()); // Int Float
        assertEquals(sc.div(sd), new NodeDiv(tc,td).evaluate()); // Int Int
        assertEquals(sc.div(se), new NodeDiv(tc,te).evaluate()); // Int Binary


        assertEquals(ScrabbleNull.getInstance(), new NodeDiv(td,ta).evaluate()); // Float String
        assertEquals(ScrabbleNull.getInstance(), new NodeDiv(td,tb).evaluate()); // Float Bool
        assertEquals(sd.div(sc), new NodeDiv(td,tc).evaluate()); // Float Float
        assertEquals(sd.div(sd2), new NodeDiv(td,td2).evaluate()); // Float Int
        assertEquals(sd.div(se), new NodeDiv(td,te).evaluate()); // Float Binary

        assertEquals(ScrabbleNull.getInstance(), new NodeDiv(te,ta).evaluate()); // Binary String
        assertEquals(ScrabbleNull.getInstance(), new NodeDiv(te,tb).evaluate()); // Binary Bool
        assertEquals(se.div(sc), new NodeDiv(te,tc).evaluate()); // Binary Int
        assertEquals(ScrabbleNull.getInstance(), new NodeDiv(te,td).evaluate()); // Binary Float
        //assertEquals(se.div(se2), new NodeDiv(te,te2).evaluate()); // Binary Binary


        // Test nodeMinus
        assertEquals("-", new NodeMinus(ta,ta2).get_label()); // get label
        assertEquals(2, new NodeMinus(ta,ta2).get_children()); // get children

        assertEquals(ScrabbleNull.getInstance(), new NodeMinus(ta,ta2).evaluate()); // String String
        assertEquals(ScrabbleNull.getInstance(), new NodeMinus(ta,tb).evaluate()); // String Bool
        assertEquals(ScrabbleNull.getInstance(), new NodeMinus(ta,tc).evaluate()); // String Float
        assertEquals(ScrabbleNull.getInstance(), new NodeMinus(ta,td).evaluate()); // String Int
        assertEquals(ScrabbleNull.getInstance(), new NodeMinus(ta,te).evaluate()); // String Binary

        assertEquals(ScrabbleNull.getInstance(), new NodeMinus(tb,ta).evaluate()); // Bool String
        assertEquals(ScrabbleNull.getInstance(), new NodeMinus(tb,tb2).evaluate()); // Bool Bool
        assertEquals(ScrabbleNull.getInstance(), new NodeMinus(tb,tc).evaluate()); // Bool Float
        assertEquals(ScrabbleNull.getInstance(), new NodeMinus(tb,td).evaluate()); // Bool Int
        assertEquals(ScrabbleNull.getInstance(), new NodeMinus(tb,te).evaluate()); // Bool Binary

        assertEquals(ScrabbleNull.getInstance(), new NodeMinus(tc,ta).evaluate()); // Int String
        assertEquals(ScrabbleNull.getInstance(), new NodeMinus(tc,tb).evaluate()); // Int Bool
        assertEquals(sc.minus(sc2), new NodeMinus(tc,tc2).evaluate()); // Int Float
        assertEquals(sc.minus(sd), new NodeMinus(tc,td).evaluate()); // Int Int
        assertEquals(sc.minus(se), new NodeMinus(tc,te).evaluate()); // Int Binary


        assertEquals(ScrabbleNull.getInstance(), new NodeMinus(td,ta).evaluate()); // Float String
        assertEquals(ScrabbleNull.getInstance(), new NodeMinus(td,tb).evaluate()); // Float Bool
        assertEquals(sd.minus(sc), new NodeMinus(td,tc).evaluate()); // Float Float
        assertEquals(sd.minus(sd2), new NodeMinus(td,td2).evaluate()); // Float Int
        assertEquals(sd.minus(se), new NodeMinus(td,te).evaluate()); // Float Binary

        assertEquals(ScrabbleNull.getInstance(), new NodeMinus(te,ta).evaluate()); // Binary String
        assertEquals(ScrabbleNull.getInstance(), new NodeMinus(te,tb).evaluate()); // Binary Bool
        assertEquals(se.minus(sc), new NodeMinus(te,tc).evaluate()); // Binary Int
        assertEquals(ScrabbleNull.getInstance(), new NodeMinus(te,td).evaluate()); // Binary Float
        assertEquals(se.minus(se2), new NodeMinus(te,te2).evaluate()); // Binary Binary


        // Test nodePlus
        assertEquals("+", new NodePlus(ta,ta2).get_label()); // get label
        assertEquals(2, new NodePlus(ta,ta2).get_children()); // get children

        assertEquals(ScrabbleNull.getInstance(), new NodePlus(tb,ta).evaluate()); // Bool String
        assertEquals(ScrabbleNull.getInstance(), new NodePlus(tb,tb2).evaluate()); // Bool Bool
        assertEquals(ScrabbleNull.getInstance(), new NodePlus(tb,tc).evaluate()); // Bool Float
        assertEquals(ScrabbleNull.getInstance(), new NodePlus(tb,td).evaluate()); // Bool Int
        assertEquals(ScrabbleNull.getInstance(), new NodePlus(tb,te).evaluate()); // Bool Binary

        assertEquals(ScrabbleNull.getInstance(), new NodePlus(tc,ta).evaluate()); // Int String
        assertEquals(ScrabbleNull.getInstance(), new NodePlus(tc,tb).evaluate()); // Int Bool
        assertEquals(sc.plus(sc2), new NodePlus(tc,tc2).evaluate()); // Int Float
        assertEquals(sc.plus(sd), new NodePlus(tc,td).evaluate()); // Int Int
        assertEquals(sc.plus(se), new NodePlus(tc,te).evaluate()); // Int Binary


        assertEquals(ScrabbleNull.getInstance(), new NodePlus(td,ta).evaluate()); // Float String
        assertEquals(ScrabbleNull.getInstance(), new NodePlus(td,tb).evaluate()); // Float Bool
        assertEquals(sd.plus(sc), new NodePlus(td,tc).evaluate()); // Float Float
        assertEquals(sd.plus(sd2), new NodePlus(td,td2).evaluate()); // Float Int
        assertEquals(sd.plus(se), new NodePlus(td,te).evaluate()); // Float Binary

        assertEquals(ScrabbleNull.getInstance(), new NodePlus(te,ta).evaluate()); // Binary String
        assertEquals(ScrabbleNull.getInstance(), new NodePlus(te,tb).evaluate()); // Binary Bool
        assertEquals(se.plus(sc), new NodePlus(te,tc).evaluate()); // Binary Int
        assertEquals(ScrabbleNull.getInstance(), new NodePlus(te,td).evaluate()); // Binary Float
        assertEquals(se.plus(se2), new NodePlus(te, te2).evaluate()); // Binary Binary


        // Test nodeTimes
        assertEquals("*", new NodeTimes(ta,ta2).get_label()); // get label
        assertEquals(2, new NodeTimes(ta,ta2).get_children()); // get children

        assertEquals(ScrabbleNull.getInstance(), new NodeTimes(ta,ta2).evaluate()); // String String
        assertEquals(ScrabbleNull.getInstance(), new NodeTimes(ta,tb).evaluate()); // String Bool
        assertEquals(ScrabbleNull.getInstance(), new NodeTimes(ta,tc).evaluate()); // String Float
        assertEquals(ScrabbleNull.getInstance(), new NodeTimes(ta,td).evaluate()); // String Int
        assertEquals(ScrabbleNull.getInstance(), new NodeTimes(ta,te).evaluate()); // String Binary

        assertEquals(ScrabbleNull.getInstance(), new NodeTimes(tb,ta).evaluate()); // Bool String
        assertEquals(ScrabbleNull.getInstance(), new NodeTimes(tb,tb2).evaluate()); // Bool Bool
        assertEquals(ScrabbleNull.getInstance(), new NodeTimes(tb,tc).evaluate()); // Bool Float
        assertEquals(ScrabbleNull.getInstance(), new NodeTimes(tb,td).evaluate()); // Bool Int
        assertEquals(ScrabbleNull.getInstance(), new NodeTimes(tb,te).evaluate()); // Bool Binary

        assertEquals(ScrabbleNull.getInstance(), new NodeTimes(tc,ta).evaluate()); // Int String
        assertEquals(ScrabbleNull.getInstance(), new NodeTimes(tc,tb).evaluate()); // Int Bool
        assertEquals(sc.times(sc2), new NodeTimes(tc,tc2).evaluate()); // Int Float
        assertEquals(sc.times(sd), new NodeTimes(tc,td).evaluate()); // Int Int
        assertEquals(sc.times(se), new NodeTimes(tc,te).evaluate()); // Int Binary


        assertEquals(ScrabbleNull.getInstance(), new NodeTimes(td,ta).evaluate()); // Float String
        assertEquals(ScrabbleNull.getInstance(), new NodeTimes(td,tb).evaluate()); // Float Bool
        assertEquals(sd.times(sc), new NodeTimes(td,tc).evaluate()); // Float Float
        assertEquals(sd.times(sd2), new NodeTimes(td,td2).evaluate()); // Float Int
        assertEquals(sd.times(se), new NodeTimes(td,te).evaluate()); // Float Binary

        assertEquals(ScrabbleNull.getInstance(), new NodeTimes(te,ta).evaluate()); // Binary String
        assertEquals(ScrabbleNull.getInstance(), new NodeTimes(te,tb).evaluate()); // Binary Bool
        assertEquals(se.times(sc), new NodeTimes(te,tc).evaluate()); // Binary Int
        assertEquals(ScrabbleNull.getInstance(), new NodeTimes(te,td).evaluate()); // Binary Float
        assertEquals(se.times(se2), new NodeTimes(te,te2).evaluate()); // Binary Binary

    }
}
