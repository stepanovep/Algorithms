package combination.nextpermutation;

import java.util.Arrays;
import java.util.stream.Collectors;

public class NextPermutationComparable {

    /**
     * modifies array 'a' to next permutation or returns null if such permutation does not exist
     */
    private static <T extends Comparable<T>> Comparable<T>[] nextPermutation(T[] a) {
        // 1. finds the largest k, that c[k] < c[k+1]
        int first = getFirst(a);
        if (first == -1) {
            return null;
        }
        // 2. find last index toSwap, that c[k] < c[toSwap]
        int toSwap = a.length - 1;
        while (a[first].compareTo(a[toSwap]) >= 0) {
            --toSwap;
        }
        // 3. swap elements with indexes first and last
        swap(a, first++, toSwap);
        // 4. reverse sequence from k+1 to n (inclusive)
        toSwap = a.length - 1;
        while (first < toSwap) {
            swap(a, first++, toSwap--);
        }

        return a;
    }

    /**
     * finds the largest k, that c[k] < c[k+1]
     * if no such k exists (there is not greater permutation), return -1
     */
    private static <T extends Comparable<T>> int getFirst(T[] c) {
        for (int i = c.length - 2; i >= 0; --i)
            if (c[i].compareTo(c[i+1]) < 0)
                return i;
        return -1;
    }

    private static <T extends Comparable<T>> void swap(T[] c, int i, int j) {
        T tmp = c[i];
        c[i] = c[j];
        c[j] = tmp;
    }

    public static void main(String[] args) {
        Comparable[] a = new String[] {"abc", "ab", "cc", "asdf23"};
        while (a != null) {
            System.out.println(Arrays.stream(a).collect(Collectors.toList()));
            a = nextPermutation(a);
        }
    }
}
