package model.types;

import java.util.Random;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public abstract class AbstractScrabbleVariableTest {
    // ------<Random values>------
    protected int seed;
    protected Random rng;

    // ------<Constructor Test>------
    /**
     * Test for the class against a different class.
     * @param a Object to be tested
     */
    protected void classClassTest(Object a) {
        assertNotEquals(a, new Object(), "Object classes asserted as matching." + seed);
        assertNotEquals(a, null, "Not null." + seed);
    }

    /**
     * Test identical objects values and hash codes for equality
     * @param a Object to be tested
     * @param b Object to be tested against
     */
    protected void equalsTest(Object a, Object b) {
        assertEquals(a, b, "Object properties do not match. seed = " + seed);
    }


    /**
     * Test different objects values and hash codes for inequality
     * @param a Object to be tested
     * @param b Object to be tested against
     */
    protected void unequalTest(Object a, Object b) {
        assertNotEquals(a, b, "Different objects considered identical. seed = " + seed);
    }

    /**
     * Test different objects hash codes for inequality
     * Test same objects hash codes for equality
     * @param a Object to be tested
     * @param b Object to be tested against
     */
    protected void hashTest(Object a, Object b) {
        assertEquals(a.hashCode(), a.hashCode(), "Hash test A. seed = " + seed);
        assertEquals(b.hashCode(), b.hashCode(), "Hash test B. seed = " + seed);
        assertNotEquals(a.hashCode(), b.hashCode(), "Hash test C. seed = " + seed);
    }

    /**
     * Checks that the copy method works as intended.
     * @param a Object to copy.
     */
    protected void copyTest(IScrabbleVariable a) {
        assertEquals(a, a.copy());
    }

    /**
     * Bundle of all the shared tests for the constructor
     * @param tester        ScrabbleVariable to be tested.
     * @param expected      A newly generated expected Object.
     * @param unexpected    A newly generated unexpected Object.
     */
    protected void constructAssert(IScrabbleVariable tester, Object expected, Object unexpected) {
        classClassTest(tester);
        equalsTest(tester, expected);
        hashTest(tester, expected);
        hashTest(tester, unexpected);
        unequalTest(tester, unexpected);
        copyTest(tester);
    }
}
