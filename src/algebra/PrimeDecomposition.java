package algebra;

import java.util.ArrayList;
import java.util.List;

/**
 * Decomposition a number into a series of prime factors
 *
 * Partial problem of Eratosthenes Sieve
 */
public class PrimeDecomposition {

    List<Integer> primeDecompose(int n) {
        List<Integer> primeFactors = new ArrayList<>();
        int factor = 2;
        while (factor * factor <= n) {
            if (n % factor == 0) {
                primeFactors.add(factor);
                n = n / factor;
            } else {
                factor++;
            }
        }
        primeFactors.add(n);
        return primeFactors;
    }

    public static void main(String[] args) {
        PrimeDecomposition primeDecomposition = new PrimeDecomposition();
        List<Integer> factors = primeDecomposition.primeDecompose(256);
        System.out.println(factors);
    }
}
