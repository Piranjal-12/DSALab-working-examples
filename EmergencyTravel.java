import java.util.*;

public class EmergencyTravel {

    // This class represents a node in the graph.
    // Each node has a city and the number of days it takes to reach that city.
    static class Node {
        int city;
        int days;

        Node(int city, int days) {
            this.city = city;
            this.days = days;
        }
    }

    // This method finds the minimum number of days to travel from city 0 to city (numCities - 1)
    // considering both aerial routes (cost 0) and step-based travel (cost 1).
    public static int findMinimumDays(int numCities, List<int[]> aerialRoutes) {

        // Create an adjacency list representation of the graph.
        // graph[i] will store a list of routes (city, travelCost) that can be taken from city i.
        List<int[]>[] graph = new ArrayList[numCities];
        for (int i = 0; i < numCities; i++) {
            graph[i] = new ArrayList<>();
        }

        // Add step-based travel routes (cost 1) to the graph.
        // A city can travel to any city within 6 steps (excluding itself) with a cost of 1 day.
        for (int i = 0; i < numCities; i++) {
            for (int j = 1; j <= 6 && i + j < numCities; j++) {
                graph[i].add(new int[]{i + j, 1});
            }
        }

        // Add aerial routes (cost 0) to the graph.
        // These routes allow for instant travel between two cities.
        for (int[] route : aerialRoutes) {
            int from = route[0];
            int to = route[1];
            graph[from].add(new int[]{to, 0});
        }

        // Use a Breadth-First Search (BFS) algorithm to explore the graph.
        Queue<Node> queue = new LinkedList<>();
        boolean[] visited = new boolean[numCities];  // Keeps track of visited cities
        int[] minDays = new int[numCities];  // Stores the minimum number of days to reach each city

        // Initialize minDays array with a large value (Integer.MAX_VALUE) to identify unvisited cities.
        Arrays.fill(minDays, Integer.MAX_VALUE);
        minDays[0] = 0;  // Set the starting city (city 0) to have 0 days to reach itself.

        // Add the starting city (city 0) with 0 days to the queue.
        queue.add(new Node(0, 0));

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            int currentCity = current.city;
            int currentDays = current.days;

            // If a shorter path to the current city has already been found, skip it.
            if (currentDays > minDays[currentCity]) continue;

            // Explore each neighbor (city) connected to the current city.
            for (int[] neighbor : graph[currentCity]) {
                int nextCity = neighbor[0];
                int travelCost = neighbor[1];

                // Calculate the total number of days to reach the neighbor city.
                int newDays = currentDays + travelCost;
                // If a shorter path to the neighbor city is found, update the minDays array and add it to
                // the queue for further exploration.
                if (newDays < minDays[nextCity]) {
                    minDays[nextCity] = newDays;
                    queue.add(new Node(nextCity, newDays));
                }
            }
        }

        // Return -1 if no path is found from city 0 to city (numCities - 1), otherwise return the minimum number of days to reach city (numCities - 1).
        return minDays[numCities - 1] == Integer.MAX_VALUE ? -1 : minDays[numCities - 1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of test cases: ");
        int testCases = scanner.nextInt();
        for (int t = 0; t < testCases; t++) {
            System.out.print("Enter the number of cities: ");
            int numCities = scanner.nextInt();
            System.out.println("Enter the number of Arial routes: ");
            int numAerialRoutes = scanner.nextInt();

            List<int[]> aerialRoutes = new ArrayList<>();
            System.out.println("Enter each aerial route as 'source destination': ");
            for (int i = 0; i < numAerialRoutes; i++) {
                int from = scanner.nextInt();
                int to = scanner.nextInt();
                aerialRoutes.add(new int[]{from, to});
            }

            int result = findMinimumDays(numCities, aerialRoutes);
            System.out.println("Minimum days to reach the city 1 to cit 30: " + result);
        }
    }
}