package types;

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
    }

    /**
     * Test identical objects values and hash codes for equality
     * @param a Object to be tested
     * @param b Object to be tested against
     */
    protected void equalsHashTest(Object a, Object b) {
        assertEquals(a, b, "Object properties do not match. seed = " + seed);
        assertEquals(a.hashCode(), b.hashCode(), "Hash codes do not match. seed = " + seed);
    }

    /**
     * Test different objects values and hash codes for inequality
     * @param a Object to be tested
     * @param b Object to be tested against
     */
    protected void unequalTest(Object a, Object b) {
        assertNotEquals(a, b, "Different objects considered identical. seed = " + seed);
        assertEquals(a.hashCode(), b.hashCode(), "Hash codes match erroneously. seed = " + seed);
    }

    /**
     * Bundle of all the shared tests for the constructor
     * @param tester        Object to be tested
     * @param expected      A newly generated expected Object
     * @param unexpected    A newly generated unexpected Object
     */
    protected void constructAssert(Object tester, Object expected, Object unexpected) {
        classClassTest(tester);
        equalsHashTest(tester, expected);
        unequalTest(tester, unexpected);
    }
}
