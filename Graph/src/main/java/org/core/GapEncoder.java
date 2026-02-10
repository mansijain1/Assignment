package org.core;

import java.util.ArrayList;
import java.util.List;

public class GapEncoder {

    public static List<Integer> encode(List<Integer> neighbors) {
        System.out.println("\n[GapEncoder] Original neighbors: " + neighbors);

        List<Integer> gaps = new ArrayList<>();
        int prev = 0;

        for (int n : neighbors) {
            gaps.add(n - prev);
            prev = n;
        }

        System.out.println("[GapEncoder] Compressed gaps: " + gaps);
        return gaps;
    }

    public static List<Integer> decode(List<Integer> gaps) {
        System.out.println("[GapEncoder] Decoding gaps: " + gaps);

        List<Integer> neighbors = new ArrayList<>();
        int current = 0;

        for (int gap : gaps) {
            current += gap;
            neighbors.add(current);
        }

        System.out.println("[GapEncoder] Decoded neighbors: " + neighbors);
        return neighbors;
    }
}
