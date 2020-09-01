package combination.nextpermutation;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Generates all permutations of array
 *
 * If array contains duplicates then permutations also contain duplicates
 */
public class NextPermutationGenerateAll {

    private static void generatePermutations(int[] a, int start) {
        if (start == a.length) {
            System.out.println(Arrays.stream(a).boxed().collect(Collectors.toList()));
            return;
        }
        for (int i = start; i < a.length; ++i) {
            swap(a, i, start);
            generatePermutations(a, start + 1);
            swap(a, i, start);
        }
    }

    private static void swap(int[] a, int i, int j) {
        if (i != j) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }

    public static void main(String[] args) {
        int[] a = {1,2,2};
        NextPermutationGenerateAll.generatePermutations(a, 0);
    }
}
