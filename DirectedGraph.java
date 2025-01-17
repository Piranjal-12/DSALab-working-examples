import java.util.*;

public class DirectedGraph {
    // Method to perform BFS traversal for a directed graph
    public static List<Integer> bfs(Map<Integer, List<Integer>> graph, int startNode) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> traversal = new ArrayList<>();

        // Add the start node to the queue and mark it as visited
        queue.add(startNode);
        visited.add(startNode);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            traversal.add(node);

            // Get neighbors of the node
            for (int neighbor : graph.getOrDefault(node, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }

        return traversal;
    }

    // Method to perform DFS traversal for a directed graph
    public static List<Integer> dfs(Map<Integer, List<Integer>> graph, int startNode) {
        Set<Integer> visited = new HashSet<>();
        List<Integer> traversal = new ArrayList<>();
        dfsHelper(graph, startNode, visited, traversal);
        return traversal;
    }

    // Helper method for DFS
    private static void dfsHelper(Map<Integer, List<Integer>> graph, int node, Set<Integer> visited, List<Integer> traversal) {
        visited.add(node);
        traversal.add(node);

        // Get neighbors of the node
        for (int neighbor : graph.getOrDefault(node, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                dfsHelper(graph, neighbor, visited, traversal);
            }
        }
    }

    public static void main(String[] args) {
        // Example of a directed graph
        Map<Integer, List<Integer>> directedGraph = new HashMap<>();
        directedGraph.put(1, Arrays.asList(2, 3));
        directedGraph.put(2, Arrays.asList(4));
        directedGraph.put(3, Arrays.asList(4));
        directedGraph.put(4, new ArrayList<>());

        List<Integer> bfsResult = bfs(directedGraph, 1);
        System.out.println("BFS traversal: " + bfsResult);

        List<Integer> dfsResult = dfs(directedGraph, 1);
        System.out.println("DFS traversal: " + dfsResult);
    }
}
