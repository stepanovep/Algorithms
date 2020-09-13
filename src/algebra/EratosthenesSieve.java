package algebra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EratosthenesSieve {

    private final int n;
    public final boolean[] isPrime;
    public final List<Integer> primes;

    public EratosthenesSieve(int n) {
        this.n = n;
        isPrime = new boolean[n+1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        primes = new ArrayList<>();
    }

    void initializePrimeNumbers() {
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                primes.add(i);
                if (i *1L * i <= n) {
                    for (int j = i*i; j <= n; j+=i) {
                        isPrime[j] = false;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        EratosthenesSieve sieve = new EratosthenesSieve(100000);
        sieve.initializePrimeNumbers();

        int i = 1;
    }
}
