package graph;

import java.util.Arrays;

/**
 * Ford Bellman algorithm for finding the shortest paths
 * from a given node {@code src} to all of other nodes
 *
 * Sources:
 * - https://e-maxx.ru/algo/ford_bellman
 *
 */
public class FordBellman {

    private static final int INF = Integer.MAX_VALUE;

    private static class Edge {
        int from;
        int to;
        int cost;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "from=" + from +
                    ", to=" + to +
                    ", cost=" + cost +
                    '}';
        }
    }

    private int[] fordBellman(Edge[] edges, int n, int src) {
        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        dist[src] = 0;

        for (int k = 0; k < n; k++) {
            boolean updated = false;
            for (Edge edge: edges) {
                if (dist[edge.to] > dist[edge.from] + edge.cost) {
                    dist[edge.to] = dist[edge.from] + edge.cost;
                    updated = true;
                }
            }
            if (!updated) {
                break;
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        FordBellman fordBellman = new FordBellman();
        Edge[] edges = new Edge[] {
                new Edge(0, 1, 200),
                new Edge(0, 2, 500),
                new Edge(1, 2, 100),
                new Edge(2, 3, 100),
        };

        fordBellman.fordBellman(edges, 4, 0);
    }
}

// https://leetcode.com/problems/cheapest-flights-within-k-stops/
// https://acmp.ru/index.asp?main=task&id_task=138