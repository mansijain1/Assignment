import org.core.CompressedAdjacencyGraph;
import org.core.Graph;
import org.testng.annotations.Test;
import java.util.*;

public class GraphLoadTest {

    @Test
    public void loadTestCompressedGraph() {
        int nodes = 100_000;
        int edgesPerNode = 10;

        Map<Integer, List<Integer>> rawAdj = new HashMap<>();

        for (int i = 0; i < nodes; i++) {
            List<Integer> neighbors = new ArrayList<>();
            for (int j = 1; j <= edgesPerNode; j++) {
                neighbors.add(i + j);
            }
            rawAdj.put(i, neighbors);
        }

        long start = System.currentTimeMillis();
        Graph graph = new CompressedAdjacencyGraph(rawAdj);
        long buildTime = System.currentTimeMillis() - start;

        start = System.currentTimeMillis();
        for (int i = 0; i < nodes; i++) {
            graph.neighbors(i);
        }
        long queryTime = System.currentTimeMillis() - start;

        System.out.println("Build time(ms): " + buildTime);
        System.out.println("Query time(ms): " + queryTime);
    }
}
