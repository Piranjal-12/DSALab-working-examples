import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    // Method to calculate degree of each node in an undirected graph
    public static Map<Integer, Integer> calculateDegree(Map<Integer, List<Integer>> graph) {
        Map<Integer, Integer> degree = new HashMap<>();

        // Iterate through the graph and calculate the degree for each node
        for (Integer node : graph.keySet()) {
            degree.put(node, graph.get(node).size());
        }

        return degree;
    }

    public static void main(String[] args) {
        // Example of an undirected graph
        Map<Integer, List<Integer>> undirectedGraph = new HashMap<>();
        undirectedGraph.put(1, Arrays.asList(2, 3));
        undirectedGraph.put(2, Arrays.asList(1, 4));
        undirectedGraph.put(3, Arrays.asList(1));
        undirectedGraph.put(4, Arrays.asList(2));

        Map<Integer, Integer> degree = calculateDegree(undirectedGraph);
        System.out.println("Degree of each node: " + degree);
    }
}
