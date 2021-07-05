package syntax;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import syntax.binarynodes.operators.*;
import syntax.endnodes.*;
import types.IScrabbleVariable;
import types.ScrabbleBool;
import types.ScrabbleString;
import types.numbers.ScrabbleBinary;
import types.numbers.ScrabbleFloat;
import types.numbers.ScrabbleInt;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

        // --Test nodeAnd--
        assertEquals(null, new NodeAnd(ta,ta2).evaluate()); // String String
        assertEquals(null, new NodeAnd(ta,tb).evaluate()); // String Bool
        assertEquals(null, new NodeAnd(ta,tc).evaluate()); // String Float
        assertEquals(null, new NodeAnd(ta,td).evaluate()); // String Int
        assertEquals(null, new NodeAnd(ta,te).evaluate()); // String Binary

        assertEquals(null, new NodeAnd(tb,ta).evaluate()); // Bool String
        assertEquals(sb.and(sb2), new NodeAnd(tb,tb2).evaluate()); // Bool Bool
        assertEquals(null, new NodeAnd(tb,tc).evaluate()); // Bool Float
        assertEquals(null, new NodeAnd(tb,td).evaluate()); // Bool Int
        assertEquals(sb.and(se), new NodeAnd(tb,te).evaluate()); // Bool Binary

        assertEquals(null, new NodeAnd(tc,ta).evaluate()); // Int String
        assertEquals(null, new NodeAnd(tc,tb).evaluate()); // Int Bool
        assertEquals(null, new NodeAnd(tc,tc2).evaluate()); // Int Float
        assertEquals(null, new NodeAnd(tc,td).evaluate()); // Int Int
        assertEquals(null, new NodeAnd(tc,te).evaluate()); // Int Binary

        assertEquals(null, new NodeAnd(td,ta).evaluate()); // Float String
        assertEquals(null, new NodeAnd(td,tb).evaluate()); // Float Bool
        assertEquals(null, new NodeAnd(td,tc).evaluate()); // Float Float
        assertEquals(null, new NodeAnd(td,td2).evaluate()); // Float Int
        assertEquals(null, new NodeAnd(td,te).evaluate()); // Float Binary

        assertEquals(null, new NodeAnd(te,ta).evaluate()); // Binary String
        assertEquals(se.and(sb), new NodeAnd(te,tb).evaluate()); // Binary Bool
        assertEquals(null, new NodeAnd(te,tc).evaluate()); // Binary Float
        assertEquals(null, new NodeAnd(te,td).evaluate()); // Binary Int
        assertEquals(se.and(se2), new NodeAnd(te,te2).evaluate()); // Binary Binary

        // --Test nodeOr--
        assertEquals(null, new NodeOr(ta,ta2).evaluate()); // String String
        assertEquals(null, new NodeOr(ta,tb).evaluate()); // String Bool
        assertEquals(null, new NodeOr(ta,tc).evaluate()); // String Float
        assertEquals(null, new NodeOr(ta,td).evaluate()); // String Int
        assertEquals(null, new NodeOr(ta,te).evaluate()); // String Binary

        assertEquals(null, new NodeOr(tb,ta).evaluate()); // Bool String
        assertEquals(sb.or(sb2), new NodeOr(tb,tb2).evaluate()); // Bool Bool
        assertEquals(null, new NodeOr(tb,tc).evaluate()); // Bool Float
        assertEquals(null, new NodeOr(tb,td).evaluate()); // Bool Int
        assertEquals(sb.or(se), new NodeOr(tb,te).evaluate()); // Bool Binary

        assertEquals(null, new NodeOr(tc,ta).evaluate()); // Int String
        assertEquals(null, new NodeOr(tc,tb).evaluate()); // Int Bool
        assertEquals(null, new NodeOr(tc,tc2).evaluate()); // Int Float
        assertEquals(null, new NodeOr(tc,td).evaluate()); // Int Int
        assertEquals(null, new NodeOr(tc,te).evaluate()); // Int Binary

        assertEquals(null, new NodeOr(td,ta).evaluate()); // Float String
        assertEquals(null, new NodeOr(td,tb).evaluate()); // Float Bool
        assertEquals(null, new NodeOr(td,tc).evaluate()); // Float Float
        assertEquals(null, new NodeOr(td,td2).evaluate()); // Float Int
        assertEquals(null, new NodeOr(td,te).evaluate()); // Float Binary

        assertEquals(null, new NodeOr(te,ta).evaluate()); // Binary String
        assertEquals(se.or(sb), new NodeOr(te,tb).evaluate()); // Binary Bool
        assertEquals(null, new NodeOr(te,tc).evaluate()); // Binary Float
        assertEquals(null, new NodeOr(te,td).evaluate()); // Binary Int
        assertEquals(se.or(se2), new NodeOr(te,te2).evaluate()); // Binary Binary


        // Test nodeDiv
        assertEquals(null, new NodeDiv(ta,ta2).evaluate()); // String String
        assertEquals(null, new NodeDiv(ta,tb).evaluate()); // String Bool
        assertEquals(null, new NodeDiv(ta,tc).evaluate()); // String Float
        assertEquals(null, new NodeDiv(ta,td).evaluate()); // String Int
        assertEquals(null, new NodeDiv(ta,te).evaluate()); // String Binary

        assertEquals(null, new NodeDiv(tb,ta).evaluate()); // Bool String
        assertEquals(null, new NodeDiv(tb,tb2).evaluate()); // Bool Bool
        assertEquals(null, new NodeDiv(tb,tc).evaluate()); // Bool Float
        assertEquals(null, new NodeDiv(tb,td).evaluate()); // Bool Int
        assertEquals(null, new NodeDiv(tb,te).evaluate()); // Bool Binary

        assertEquals(null, new NodeDiv(tc,ta).evaluate()); // Int String
        assertEquals(null, new NodeDiv(tc,tb).evaluate()); // Int Bool
        assertEquals(sc.div(sc2), new NodeDiv(tc,tc2).evaluate()); // Int Float
        assertEquals(sc.div(sd), new NodeDiv(tc,td).evaluate()); // Int Int
        assertEquals(sc.div(se), new NodeDiv(tc,te).evaluate()); // Int Binary


        assertEquals(null, new NodeDiv(td,ta).evaluate()); // Float String
        assertEquals(null, new NodeDiv(td,tb).evaluate()); // Float Bool
        assertEquals(sd.div(sc), new NodeDiv(td,tc).evaluate()); // Float Float
        assertEquals(sd.div(sd2), new NodeDiv(td,td2).evaluate()); // Float Int
        assertEquals(sd.div(se), new NodeDiv(td,te).evaluate()); // Float Binary

        assertEquals(null, new NodeDiv(te,ta).evaluate()); // Binary String
        assertEquals(null, new NodeDiv(te,tb).evaluate()); // Binary Bool
        assertEquals(se.div(sc), new NodeDiv(te,tc).evaluate()); // Binary Int
        assertEquals(null, new NodeDiv(te,td).evaluate()); // Binary Float
        //assertEquals(se.div(se2), new NodeDiv(te,te2).evaluate()); // Binary Binary


        // Test nodeMinus
        assertEquals(null, new NodeMinus(ta,ta2).evaluate()); // String String
        assertEquals(null, new NodeMinus(ta,tb).evaluate()); // String Bool
        assertEquals(null, new NodeMinus(ta,tc).evaluate()); // String Float
        assertEquals(null, new NodeMinus(ta,td).evaluate()); // String Int
        assertEquals(null, new NodeMinus(ta,te).evaluate()); // String Binary

        assertEquals(null, new NodeMinus(tb,ta).evaluate()); // Bool String
        assertEquals(null, new NodeMinus(tb,tb2).evaluate()); // Bool Bool
        assertEquals(null, new NodeMinus(tb,tc).evaluate()); // Bool Float
        assertEquals(null, new NodeMinus(tb,td).evaluate()); // Bool Int
        assertEquals(null, new NodeMinus(tb,te).evaluate()); // Bool Binary

        assertEquals(null, new NodeMinus(tc,ta).evaluate()); // Int String
        assertEquals(null, new NodeMinus(tc,tb).evaluate()); // Int Bool
        assertEquals(sc.minus(sc2), new NodeMinus(tc,tc2).evaluate()); // Int Float
        assertEquals(sc.minus(sd), new NodeMinus(tc,td).evaluate()); // Int Int
        assertEquals(sc.minus(se), new NodeMinus(tc,te).evaluate()); // Int Binary


        assertEquals(null, new NodeMinus(td,ta).evaluate()); // Float String
        assertEquals(null, new NodeMinus(td,tb).evaluate()); // Float Bool
        assertEquals(sd.minus(sc), new NodeMinus(td,tc).evaluate()); // Float Float
        assertEquals(sd.minus(sd2), new NodeMinus(td,td2).evaluate()); // Float Int
        assertEquals(sd.minus(se), new NodeMinus(td,te).evaluate()); // Float Binary

        assertEquals(null, new NodeMinus(te,ta).evaluate()); // Binary String
        assertEquals(null, new NodeMinus(te,tb).evaluate()); // Binary Bool
        assertEquals(se.minus(sc), new NodeMinus(te,tc).evaluate()); // Binary Int
        assertEquals(null, new NodeMinus(te,td).evaluate()); // Binary Float
        assertEquals(se.minus(se2), new NodeMinus(te,te2).evaluate()); // Binary Binary


        // Test nodePlus
        assertEquals(null, new NodePlus(tb,ta).evaluate()); // Bool String
        assertEquals(null, new NodePlus(tb,tb2).evaluate()); // Bool Bool
        assertEquals(null, new NodePlus(tb,tc).evaluate()); // Bool Float
        assertEquals(null, new NodePlus(tb,td).evaluate()); // Bool Int
        assertEquals(null, new NodePlus(tb,te).evaluate()); // Bool Binary

        assertEquals(null, new NodePlus(tc,ta).evaluate()); // Int String
        assertEquals(null, new NodePlus(tc,tb).evaluate()); // Int Bool
        assertEquals(sc.plus(sc2), new NodePlus(tc,tc2).evaluate()); // Int Float
        assertEquals(sc.plus(sd), new NodePlus(tc,td).evaluate()); // Int Int
        assertEquals(sc.plus(se), new NodePlus(tc,te).evaluate()); // Int Binary


        assertEquals(null, new NodePlus(td,ta).evaluate()); // Float String
        assertEquals(null, new NodePlus(td,tb).evaluate()); // Float Bool
        assertEquals(sd.plus(sc), new NodePlus(td,tc).evaluate()); // Float Float
        assertEquals(sd.plus(sd2), new NodePlus(td,td2).evaluate()); // Float Int
        assertEquals(sd.plus(se), new NodePlus(td,te).evaluate()); // Float Binary

        assertEquals(null, new NodePlus(te,ta).evaluate()); // Binary String
        assertEquals(null, new NodePlus(te,tb).evaluate()); // Binary Bool
        assertEquals(se.plus(sc), new NodePlus(te,tc).evaluate()); // Binary Int
        assertEquals(null, new NodePlus(te,td).evaluate()); // Binary Float
        assertEquals(se.plus(se2), new NodePlus(te, te2).evaluate()); // Binary Binary


        // Test nodeTimes
        assertEquals(null, new NodeTimes(ta,ta2).evaluate()); // String String
        assertEquals(null, new NodeTimes(ta,tb).evaluate()); // String Bool
        assertEquals(null, new NodeTimes(ta,tc).evaluate()); // String Float
        assertEquals(null, new NodeTimes(ta,td).evaluate()); // String Int
        assertEquals(null, new NodeTimes(ta,te).evaluate()); // String Binary

        assertEquals(null, new NodeTimes(tb,ta).evaluate()); // Bool String
        assertEquals(null, new NodeTimes(tb,tb2).evaluate()); // Bool Bool
        assertEquals(null, new NodeTimes(tb,tc).evaluate()); // Bool Float
        assertEquals(null, new NodeTimes(tb,td).evaluate()); // Bool Int
        assertEquals(null, new NodeTimes(tb,te).evaluate()); // Bool Binary

        assertEquals(null, new NodeTimes(tc,ta).evaluate()); // Int String
        assertEquals(null, new NodeTimes(tc,tb).evaluate()); // Int Bool
        assertEquals(sc.times(sc2), new NodeTimes(tc,tc2).evaluate()); // Int Float
        assertEquals(sc.times(sd), new NodeTimes(tc,td).evaluate()); // Int Int
        assertEquals(sc.times(se), new NodeTimes(tc,te).evaluate()); // Int Binary


        assertEquals(null, new NodeTimes(td,ta).evaluate()); // Float String
        assertEquals(null, new NodeTimes(td,tb).evaluate()); // Float Bool
        assertEquals(sd.times(sc), new NodeTimes(td,tc).evaluate()); // Float Float
        assertEquals(sd.times(sd2), new NodeTimes(td,td2).evaluate()); // Float Int
        assertEquals(sd.times(se), new NodeTimes(td,te).evaluate()); // Float Binary

        assertEquals(null, new NodeTimes(te,ta).evaluate()); // Binary String
        assertEquals(null, new NodeTimes(te,tb).evaluate()); // Binary Bool
        assertEquals(se.times(sc), new NodeTimes(te,tc).evaluate()); // Binary Int
        assertEquals(null, new NodeTimes(te,td).evaluate()); // Binary Float
        assertEquals(se.times(se2), new NodeTimes(te,te2).evaluate()); // Binary Binary

    }
}
