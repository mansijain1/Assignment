package org.core;

import java.util.List;

public class FixedExpansionRule implements Rule {

    private final List<Integer> expansion;

    public FixedExpansionRule(List<Integer> expansion) {
        this.expansion = expansion;
    }

    @Override
    public List<Integer> apply(int node) {
        return expansion;
    }
}
