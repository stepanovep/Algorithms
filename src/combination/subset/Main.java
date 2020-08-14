package combination.subset;

import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {

        String characters = "abcde";
        int length = 3;
        test(() -> new CombinationIteratorBitmaskingPrecomp(characters, length));
        test(() -> new CombinationIteratorBitmaskingNextComb(characters, length));
        test(() -> new CombinationIteratorKnuthLPrecomp(characters, length));
        test(() -> new CombinationIteratorKnuthLNextComb(characters, length));
    }

    private static void test(Supplier<CombinationIterator> func) {
        long start = System.currentTimeMillis();
        CombinationIterator combinationIterator = func.get();

        while (combinationIterator.hasNext()) {
            combinationIterator.next();
        }

        long end = System.currentTimeMillis();
        System.out.println(combinationIterator.getClass().getSimpleName() + " exec time: " + (end - start));
    }
}
