package org.core;

import java.util.List;

public interface Rule {
    List<Integer> apply(int node);
}
