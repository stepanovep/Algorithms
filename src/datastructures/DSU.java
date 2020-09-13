package datastructures;

/**
 * Disjoint union set - Система непересекающихся множеств
 *
 * https://e-maxx.ru/algo/dsu
 */
public class DSU {
    private final int[] parent;
    private final int[] size;

    public DSU(int n) {
        this.parent = new int[n];
        this.size = new int[n];
    }

    void makeSet(int v) {
        parent[v] = v;
        size[v] = 1;
    }

    int findSet(int v) {
        if (v == parent[v]) {
            return v;
        }
        return parent[v] = findSet(parent[v]);
    }

    void unionSet(int a, int b) {
        a = findSet(a);
        b = findSet(b);

        if (a != b) {
            if (size[a] < size[b]) {
                int tmp = a;
                a = b;
                b = tmp;
            }
            parent[b] = a;
            size[a] += size[b];
        }
    }

    public static void main(String[] args) {
        int n = 10;
        DSU dsu = new DSU(n);
        for (int i = 0; i < n; i++) {
            dsu.makeSet(i);
        }

        dsu.unionSet(1, 2);
        dsu.unionSet(3, 4);
        dsu.unionSet(6, 7);
        dsu.unionSet(2, 4);
        System.out.println("asdf");
    }
}

// https://codeforces.com/contest/25/problem/D
