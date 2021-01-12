package datastructures;

/**
 * Classic segment tree implementation
 *
 * http://e-maxx.ru/algo/segment_tree
 */
public class SegmentTree {

    private static final int MAX_VAL = 100_001;
    private final int n;

    private final int[] t = new int[4*MAX_VAL];

    public SegmentTree(int[] a) {
        this.n = a.length;
        build(a, 0, 0, n-1);
    }

    public SegmentTree(int n) {
        this.n = n;
    }

    public void build(int[] a, int v, int tl, int tr) {
        if (tl == tr) {
            t[v] = a[tl];
        } else {
            int mid = (tl + tr) / 2;
            build(a, 2*v+1, tl, mid);
            build(a, 2*v+2, mid+1, tr);
            t[v] = t[2*v+1] + t[2*v+2];
        }
    }

    public int query(int left, int right) {
        return query(0, 0, n-1, left, right);
    }

    private int query(int v, int tl, int tr, int l, int r) {
        if (tr < l || tl > r) {
            return 0;
        }

        if (tl >= l && tr <= r) {
            return t[v];
        }

        int tm = (tl + tr) / 2;
        int leftResult = query(2*v+1, tl, tm, l, r);
        int rightResult = query(2*v+2, tm+1, tr, l, r);

        return leftResult + rightResult;
    }

    public void update(int pos, int newVal) {
        update(0, 0, n-1, pos, newVal);
    }

    private void update(int v, int tl, int tr, int pos, int newVal) {
        if (tl == tr) {
            t[v] = newVal;
            return;
        }

        int tm = (tl + tr) / 2;
        if (pos <= tm) {
            update(2*v+1, tl, tm, pos, newVal);
        } else {
            update(2*v+2, tm+1, tr, pos, newVal);
        }
        t[v] = t[2*v+1] + t[2*v+2];
    }

    public static void main(String[] args) {
        int[] a = new int[] {1, 4, -3, 5};
        SegmentTree st = new SegmentTree(a);

        System.out.println(st.query(1, 2));
        st.update(2, 10);
        System.out.println(st.query(1, 2));
    }

}
