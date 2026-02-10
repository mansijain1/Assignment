package org.core;

import java.util.List;
import java.util.Map;

public class RuleCompressedGraph implements Graph {

    private final Map<Integer, Integer> nodeToRule;
    private final Map<Integer, Rule> rules;

    public RuleCompressedGraph(Map<Integer, Integer> nodeToRule,
                               Map<Integer, Rule> rules) {
        this.nodeToRule = nodeToRule;
        this.rules = rules;
    }

    @Override
    public List<Integer> neighbors(int node) {
        System.out.println("[RuleGraph] Fetching neighbors for node: " + node);
        return rules.get(nodeToRule.get(node)).apply();
    }
}
