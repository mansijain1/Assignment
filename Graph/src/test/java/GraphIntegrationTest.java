import org.core.*;
import org.testng.annotations.Test;
import static org.testng.Assert.*;
import java.util.*;

public class GraphIntegrationTest {

    @Test
    public void testCompressedAdjacencyGraph() {
        Map<Integer, List<Integer>> rawAdj = Map.of(
                1, List.of(2, 5, 9),
                2, List.of(3, 4)
        );

        Graph graph = new CompressedAdjacencyGraph(rawAdj);

        assertEquals(graph.neighbors(1), List.of(2, 5, 9));
        assertEquals(graph.neighbors(2), List.of(3, 4));
    }

    @Test
    public void testRuleCompressedGraph() {
        Rule ruleA = new Rule(List.of(2, 3, 4));

        Map<Integer, Rule> rules = Map.of(1, ruleA);
        Map<Integer, Integer> nodeToRule = Map.of(10, 1, 11, 1);

        Graph graph = new RuleCompressedGraph(nodeToRule, rules);

        assertEquals(graph.neighbors(10), List.of(2, 3, 4));
        assertEquals(graph.neighbors(11), List.of(2, 3, 4));
    }

    @Test
    public void testSupernodeGraph() {
        Supernode supernode = new Supernode(List.of(7, 8, 9));

        Map<Integer, Supernode> supernodes = Map.of(100, supernode);
        Map<Integer, List<Integer>> adj = Map.of(
                1, List.of(100, 5)
        );

        Graph graph = new SupernodeGraph(adj, supernodes);

        assertEquals(graph.neighbors(1), List.of(7, 8, 9, 5));
    }
}
