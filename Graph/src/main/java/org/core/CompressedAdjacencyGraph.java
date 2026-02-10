package org.core;

import java.util.*;

public class CompressedAdjacencyGraph implements Graph {

    private final Map<Integer, List<Integer>> compressedAdj;

    public CompressedAdjacencyGraph(Map<Integer, List<Integer>> rawAdj) {
        compressedAdj = new HashMap<>();

        System.out.println("\n--- Compressing Graph ---");
        for (var entry : rawAdj.entrySet()) {
            System.out.println("\nCompressing node: " + entry.getKey());
            compressedAdj.put(
                    entry.getKey(),
                    GapEncoder.encode(entry.getValue())
            );
        }
        System.out.println("\n--- Compression Complete ---");
    }

    @Override
    public List<Integer> neighbors(int node) {
        System.out.println("\n[Graph] Fetching neighbors for node: " + node);
        return GapEncoder.decode(compressedAdj.get(node));
    }
}