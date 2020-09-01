package combination.nextpermutation;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Modifies and return {@code true} the given array to its nextPermutation (lexicographically)
 *
 * If next permutation does not exist, {@code false} will be returned
 */
public class NextPermutation {

    private boolean nextPermutation(int[] a) {
        // 1. finds the largest k, that c[k] < c[k+1]
        int first = getFirst(a);
        if (first == -1) {
            return false;
        }
        // 2. find last index toSwap, that c[k] < c[toSwap]
        int toSwap = a.length - 1;
        while (a[first] >= a[toSwap]) {
            --toSwap;
        }
        // 3. swap elements with indexes first and last
        swap(a, first++, toSwap);
        // 4. reverse sequence from k+1 to n (inclusive)
        toSwap = a.length - 1;
        while (first < toSwap) {
            swap(a, first++, toSwap--);
        }

        return true;
    }

    /**
     * finds the largest k, that c[k] < c[k+1]
     * if no such k exists (there is not greater permutation), return -1
     */
    private int getFirst(int[] c) {
        for (int i = c.length - 2; i >= 0; --i)
            if (c[i] < c[i+1])
                return i;
        return -1;
    }

    private void swap(int[] c, int i, int j) {
        int tmp = c[i];
        c[i] = c[j];
        c[j] = tmp;
    }

    public static void main(String[] args) {
        NextPermutation nextPermutation = new NextPermutation();
        int[] a = new int[] {2, 2, 3, 4};

        do {
            System.out.println(Arrays.stream(a).boxed().collect(Collectors.toList()));
        } while (nextPermutation.nextPermutation(a));
    }
}
