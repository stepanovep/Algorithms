package datastructures;

import static java.lang.Math.max;
import static java.lang.Math.min;

/**
 * Classic segment tree implementation
 *
 * http://e-maxx.ru/algo/segment_tree
 */
public class SegmentTree {

    private static final int MAX_VAL = 100_001;

    private final int[] t;
    private final int n;

    public SegmentTree(int[] a) {
        this.n = a.length;
        this.t = new int[4*n];
        build(a, 1, 0, n-1);
    }

    public SegmentTree(int n) {
        this.n = n;
        this.t = new int[4*n];
    }

    public void build(int[] a, int v, int tl, int tr) {
        if (tl == tr) {
            t[v] = a[tl];
        } else {
            int mid = (tl + tr) / 2;
            build(a, v*2, tl, mid);
            build(a, v*2+1, mid+1, tr);
            t[v] = t[v*2] + t[v*2+1];
        }
    }

    public int query(int left, int right) {
        return query(1, 0, n-1, left, right);
    }

    private int query(int v, int tl, int tr, int l, int r) {
        if (l > r) {
            return 0;
        }
        if (l == tl && r == tr) {
            return t[v];
        }

        int tm = (tl + tr) / 2;
        int leftQuery = query(v*2, tl, tm, l, min(r, tm));
        int rightQuery = query(v*2+1, tm+1, tr, max(l, tm+1), r);
        return leftQuery + rightQuery;
    }

    public void update(int pos, int newVal) {
        update(1, 0, n-1, pos, newVal);
    }

    private void update(int v, int tl, int tr, int pos, int newVal) {
        if (tl == tr) {
            t[v] = newVal;
        } else {
            int tm = (tl + tr) / 2;
            if (pos <= tm) {
                update(v*2, tl, tm, pos, newVal);
            } else {
                update(v*2+1, tm+1, tr, pos, newVal);
            }
            t[v] = t[v*2] + t[v*2+1];
        }
    }

    public static void main(String[] args) {
        int[] a = new int[] {1, 4, -3};
        int n = a.length;
        SegmentTree st = new SegmentTree(a);

        System.out.println(st.query(1, 2));
        st.update(0, 10);
        System.out.println(st.query(0, 2));
    }

}
