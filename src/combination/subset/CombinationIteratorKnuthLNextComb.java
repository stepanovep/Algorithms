package combination.subset;

public class CombinationIteratorKnuthLNextComb implements CombinationIterator {

    private final int[] nums;
    private final int n;
    private final int k;
    private final String chars;
    private boolean hasNext;

    public CombinationIteratorKnuthLNextComb(String characters, int combinationLength) {
        this.n = characters.length();
        this.k = combinationLength;
        this.chars = characters;

        this.hasNext = true;
        this.nums = new int[k];
        for (int i = 0; i < k; i++) {
            nums[i] = i;
        }
    }

    @Override
    public String next() {
        StringBuilder curr = new StringBuilder();
        for (int j: nums) {
            curr.append(chars.charAt(j));
        }

        // Generate next combination.
        // Find the first j such that nums[j] != n - k + j.
        // Increase nums[j] by one.
        int j = k - 1;
        while (j >= 0 && nums[j] == n - k + j) {
            j--;
        }

        if (j >= 0) {
            nums[j]++;
            for (int i = j+1; i < k; i++) {
                nums[i] = nums[j] + i - j;
            }
        } else {
            hasNext = false;
        }

        return curr.toString();
    }

    @Override
    public boolean hasNext() {
        return hasNext;
    }
}
