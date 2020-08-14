package combination.subset;

/**
 * Iterator for combination
 *
 * A function next() that returns the next combination of length combinationLength in lexicographical order.
 * A function hasNext() that returns True if and only if there exists a next combination.
 *
 * Implementation with Bitmasking and Knuth's Algorithm L
 *
 * https://leetcode.com/problems/iterator-for-combination/
 */
public interface CombinationIterator {

    public String next();

    public boolean hasNext();
}
