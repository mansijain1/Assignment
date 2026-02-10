package org.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SupernodeGraph implements Graph {

    private final Map<Integer, List<Integer>> adj;
    private final Map<Integer, Supernode> supernodes;

    public SupernodeGraph(Map<Integer, List<Integer>> adj,
                          Map<Integer, Supernode> supernodes) {
        this.adj = adj;
        this.supernodes = supernodes;
    }

    @Override
    public List<Integer> neighbors(int node) {
        System.out.println("[SupernodeGraph] Fetching neighbors for node: " + node);

        List<Integer> result = new ArrayList<>();
        for (int n : adj.getOrDefault(node, List.of())) {
            if (supernodes.containsKey(n)) {
                System.out.println("[SupernodeGraph] Found supernode: " + n);
                result.addAll(supernodes.get(n).expand());
            } else {
                System.out.println("[SupernodeGraph] Normal neighbor: " + n);
                result.add(n);
            }
        }
        return result;
    }
}
