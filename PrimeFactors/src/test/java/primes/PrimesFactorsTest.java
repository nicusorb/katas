package primes;

import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static primes.PrimesFactors.generate;

/**
 * Created with IntelliJ IDEA.
 * User: nicubucalaete
 * Date: 9/10/13
 * Time: 11:39 AM
 */
public class PrimesFactorsTest {
    @Test
    public void primeFactorOfTwoIsTwo() throws Exception {
        assertThat(generate(2), hasItems(2));
    }

    @Test
    public void primeFactorOfThreeIsThree() throws Exception {
        assertThat(generate(3), contains(3));
    }

    @Test
    public void primeFactorOfFour_isTwo() throws Exception {
        assertThat(generate(4), contains(2, 2));
    }

    @Test
    public void primeFactorsOfSix_is2And3() throws Exception {
        assertThat(generate(6), contains(2, 3));
    }

    @Test
    public void primeFactorsOfTen_is2And5() throws Exception {
        assertThat(generate(10), contains(2, 5));
    }

    @Test
    public void primeFactorsOfTwelve_is2And3() throws Exception {
        assertThat(generate(12), contains(2, 2, 3));
    }
}
