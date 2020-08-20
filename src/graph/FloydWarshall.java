package graph;

/**
 * Algorithm of Floyd-Warshall for finding
 * the shortest paths between all pairs in graph
 *
 * Graph is given by adjacency matrix.
 *
 * Key point: before k-th phase the current shortest path between any (i) and (j)
 * contains only vertexes from {0, 1, .. k-1} (exclusive for i and j)
 *
 * Sources:
 * - https://e-maxx.ru/algo/floyd_warshall_algorithm
 */
public class FloydWarshall {

    private static final int INF = 100_000;

    private void floydWarshall(int[][] d) {
        int n = d.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (d[i][j] == -1) {
                    d[i][j] = INF;
                }
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (d[i][k] < INF && d[k][j] < INF) {
                        d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        FloydWarshall floydWarshall = new FloydWarshall();
        int[][] d = new int[][] {
                {0, 5, 9, -1},
                {-1, 0, 2, 8},
                {-1, -1, 0, 7},
                {4, -1, -1, 0}
        };

        floydWarshall.floydWarshall(d);
    }
}


// https://acmp.ru/index.asp?main=task&id_task=136