package org.core;

import java.util.*;

public class DemoTest {

    public static void main(String[] args) {

        System.out.println("=== COMPRESSED GRAPH DEMO ===");

        // Create a tiny graph
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(1, List.of(2, 3, 4));
        graph.put(2, List.of(5,6,3));
        graph.put(3, List.of(5));
        graph.put(4, List.of(5));
        graph.put(5, List.of());

        System.out.println("\nOriginal Graph:");
        for (var e : graph.entrySet()) {
            System.out.println(e.getKey() + " -> " + e.getValue());
        }

        // Compress the graph
        Graph compressedGraph = new CompressedAdjacencyGraph(graph);

        // Interactive Traversal
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("\nEnter a node to see its neighbors (or -1 to exit): ");
            int node = scanner.nextInt();

            if (node == -1) {
                System.out.println("Exiting demo.");
                break;
            }

            List<Integer> neighbors = compressedGraph.neighbors(node);
            System.out.println("Final neighbors of node " + node + ": " + neighbors);
        }

        scanner.close();
    }
}
