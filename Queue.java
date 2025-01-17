 class Vertex {
        String label;
        boolean isVisited = false;
        Vertex[] neighbours;

        public Vertex(String label) {
            this.label = label;
            neighbours = new Vertex[0];
        }

        public void addNeighbours(Vertex[] v) {
            neighbours = new Vertex[v.length];
            for (int i = 0; i < v.length; i++) {
                neighbours[i] = v[i];
            }
        }
    }

    class LinkedList {
        Node front;

        public LinkedList() {
            front = null;
        }

        public boolean isEmpty() {
            return front == null;
        }

        public void insertFirst(Vertex data) {
            Node newNode = new Node(data);
            newNode.next = front;
            front = newNode;
        }

        public Node deleteFirst() {
            Node temp = front;
            front = front.next;
            return temp;
        }

        public void displayList() {
            Node current = front;
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }

        public void insertLast(Vertex new_data) {
            Node new_node = new Node(new_data);
            if (front == null) {
                front = new_node;
                return;
            }
            Node last = front;
            while (last.next != null) {
                last = last.next;
            }
            last.next = new_node;
        }

        public Vertex deleteLast() {
            Vertex temp = null;
            Node current = front;

            if (current == null) {
                return null;
            }

            if (current.next == null) {
                temp = front.data;
                front = null;
                return temp;
            }

            while (current.next.next != null) {
                current = current.next;
            }

            temp = current.next.data;
            current.next = null;
            return temp;
        }

        static class Node {
            Vertex data;
            Node next;

            public Node(Vertex data) {
                this.data = data;
                this.next = null;
            }
        }
    }

    class Queue {
        LinkedList list;

        public Queue() {
            list = new LinkedList();
        }

        public boolean isEmpty() {
            return list.isEmpty();
        }

        public void enqueue(Vertex new_data) {
            list.insertLast(new_data);
        }

        public Vertex dequeue() {
            return list.deleteFirst().data;
        }

        public Vertex front() {
            if (list.front == null) {
                return null;
            } else {
                return list.front.data;
            }
        }
    }

    class Graph {
        int V; // Number of vertices
        LinkedList[] adjList; // Adjacency list

        Graph(int v) {
            V = v;
            adjList = new LinkedList[v];
            for (int i = 0; i < v; ++i) {
                adjList[i] = new LinkedList();
            }
        }

        void createVertex(String label) {
            // You'll need to manage vertex objects and their labels here
            // For simplicity, let's assume a vertex is represented by its index in the adjacency list
            // You might need to create a separate Vertex class to store label and other information
        }

        void createEdge(int src, int dest) {
            adjList[src].insertLast(new Vertex("Vertex " + dest)); // Assuming vertex labels are simple strings
            // If the graph is undirected, add an edge in the reverse direction as well
            // adjList[dest].insertLast(new Vertex("Vertex " + src));
        }

        void printGraph() {
            for (int v = 0; v < V; ++v) {
                System.out.println("Adjacency list of vertex " + v);
                adjList[v].displayList();
            }
        }

        public void printGraphBF(Queue queue) {
            if (queue.front() == null) {
                return;
            }

            Vertex current = queue.dequeue();
            current.isVisited = true;
            System.out.println(current.label);

            for (int i = 0; i < current.neighbours.length; i++) {
                if (!current.neighbours[i].isVisited) {
                    queue.enqueue(current.neighbours[i]);
                }
            }

            printGraphBF(queue);
        }
    }

    class GraphDriver2 {
        public static void main(String[] args) {
            Graph graph = new Graph(5);
            Vertex a = new Vertex("A");
            Vertex b = new Vertex("B");
            Vertex c = new Vertex("C");
            Vertex d = new Vertex("D");
            Vertex e = new Vertex("E");

            graph.createVertex("A");
            graph.createVertex("B");
            graph.createVertex("C");
            graph.createVertex("D");
            graph.createVertex("E");

            a.addNeighbours(new Vertex[]{b, d});
            b.addNeighbours(new Vertex[]{a, c});
            c.addNeighbours(new Vertex[]{b});
            d.addNeighbours(new Vertex[]{a, e});
            e.addNeighbours(new Vertex[]{d});

            // Create a queue for BFS
            System.out.println("Printing graph bfs: ");
            Queue queue = new Queue();
            queue.enqueue(a); // Start BFS from vertex A

            graph.printGraphBF(queue);
        }
    }

