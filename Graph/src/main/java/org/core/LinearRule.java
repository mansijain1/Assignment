package org.core;

import java.util.List;

public class LinearRule implements Rule {

    @Override
    public List<Integer> apply(int node) {
        return List.of(node - 1, node + 1);
    }
}
