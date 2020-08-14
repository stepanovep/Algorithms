package combination.subset;

public class CombinationIteratorBitmaskingNextComb implements CombinationIterator {

    private final String characters;
    private final int n;
    private final int k;
    private int bitmask;

    public CombinationIteratorBitmaskingNextComb(String characters, int combinationLength) {
        this.characters = characters;
        this.n = characters.length();
        this.k = combinationLength;
        this.bitmask = (1 << n) - (1 << n - k);
    }

    @Override
    public String next() {
        StringBuilder curr = new StringBuilder();
        for (int j = 0; j < n; j++) {
            if ((bitmask & (1 << n-1-j)) != 0) {
                curr.append(characters.charAt(j));
            }
        }

        bitmask--;
        while (bitmask > 0 && Integer.bitCount(bitmask) != k) {
            bitmask--;
        }

        return curr.toString();
    }

    @Override
    public boolean hasNext() {
        return bitmask > 0;
    }
}
