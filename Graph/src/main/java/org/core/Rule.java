package org.core;

import java.util.List;

public class Rule {
    private final List<Integer> expansion;

    public Rule(List<Integer> expansion) {
        this.expansion = expansion;
    }

    public List<Integer> apply() {
        return expansion;
    }
}
