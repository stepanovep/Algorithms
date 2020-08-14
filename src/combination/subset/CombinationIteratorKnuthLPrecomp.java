package combination.subset;

import java.util.ArrayDeque;
import java.util.Deque;

public class CombinationIteratorKnuthLPrecomp implements CombinationIterator {

    private final Deque<String> combinations;
    private final String characters;
    private final int n;
    private final int k;

    public CombinationIteratorKnuthLPrecomp(String characters, int combinationLength) {
        this.combinations = new ArrayDeque<>();
        this.characters = characters;
        this.n = characters.length();
        this.k = combinationLength;
        precompile();
    }

    private void precompile() {
        int[] nums = new int[k+1];
        for (int i = 0; i < k; i++) {
            nums[i] = i;
        }
        nums[k] = n;

        int j = 0;
        while (j < k) {
            StringBuilder curr = new StringBuilder();
            for (int i = k-1; i >= 0; i--) {
                curr.append(characters.charAt(n-1-nums[i]));
            }
            combinations.push(curr.toString());
            j = 0;
            while ((j < k) && (nums[j+1] == nums[j] + 1)) {
                nums[j] = j;
                j++;
            }
            nums[j]++;
        }
    }

    @Override
    public String next() {
        return combinations.pop();
    }

    @Override
    public boolean hasNext() {
        return !combinations.isEmpty();
    }
}
