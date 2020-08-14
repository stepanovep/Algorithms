package combination.subset;

import java.util.ArrayDeque;
import java.util.Deque;

public class CombinationIteratorBitmaskingPrecomp implements CombinationIterator {

    private final Deque<String> combinations;
    private final String characters;
    private final int n;
    private final int k;

    public CombinationIteratorBitmaskingPrecomp(String characters, int combinationLength) {
        this.combinations = new ArrayDeque<>();
        this.characters = characters;
        this.n = characters.length();
        this.k = combinationLength;
        precompile();
    }

    private void precompile() {
        for (int bitmask = 0; bitmask < 1 << n; bitmask++) {
            if (Integer.bitCount(bitmask) == k) {
                StringBuilder curr = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if ((bitmask & (1 << n-j-1)) != 0) {
                        curr.append(characters.charAt(j));
                    }
                }
                combinations.push(curr.toString());
            }
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
