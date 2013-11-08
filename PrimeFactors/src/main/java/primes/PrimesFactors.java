package primes;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: nicubucalaete
 * Date: 9/10/13
 * Time: 11:41 AM
 */
public class PrimesFactors {
    public static List<Integer> generate(int n) {
        List<Integer> primes = new ArrayList<>();

        for (int factor = 2; factor <= n; factor++)
            for (; n % factor == 0; n /= factor)
                primes.add(factor);

        return primes;
    }
}
