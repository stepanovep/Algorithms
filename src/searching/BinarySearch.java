package searching;

/**
 * Sources:
 *
 * - Errichto video tutorial https://www.youtube.com/watch?v=GU7DpgHINWQ
 */
public class BinarySearch {

    /**
     * Returns the index of element == target,
     * -1 otherwise
     */
    private int binarySearch(int[] a, int target) {
        int left = 0;
        int right = a.length - 1;

        while (left <= right) {
            int mid = left + (right-left)/2;
            if (a[mid] == target) {
                return mid;
            }
            if (a[mid] < target) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }

        return -1;
    }

    /**
     * Returns index of first element >= target
     *
     * Template for case: [F F F T T T T] - find first True
     */
    private int lowerBound(int[] a, int target) {
        int left = 0;
        int right = a.length - 1;
        int ans = -1;
        while (left <= right) {
            int mid = left + (right-left)/2;
            if (a[mid] >= target) {
                ans = mid;
                right = mid-1;
            } else {
                left = mid+1;
            }
        }

        return ans;
    }

    /**
     * Returns index of first element > target
     */
    private int upperBound(int[] a, int target) {
        int left = 0;
        int right = a.length - 1;
        int ans = -1;
        while (left <= right) {
            int mid = left + (right-left)/2;
            if (a[mid] > target) {
                ans = mid;
                right = mid-1;
            } else {
                left = mid+1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();

        System.out.println(binarySearch.upperBound(new int[]{1, 2, 4, 7, 9}, 2));
        System.out.println(binarySearch.upperBound(new int[]{1, 2, 2, 2, 2, 4, 7, 9}, 2));
        System.out.println(binarySearch.upperBound(new int[]{1, 4, 7, 9}, 2));
    }
}
