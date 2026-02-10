package org.core;

import java.util.List;

public class Supernode {
    private final List<Integer> expandedNodes;

    public Supernode(List<Integer> expandedNodes) {
        this.expandedNodes = expandedNodes;
    }

    public List<Integer> expand() {
        System.out.println("[Supernode] Expanding → " + expandedNodes);
        return expandedNodes;
    }
}
