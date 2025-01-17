public class vertex {
    // Vertex Class
    class Vertex {
        String label;
        boolean isVisited;
        Vertex[] neighbours;

        public Vertex(String label) {
            this.label = label;
            this.isVisited = false;
        }

        public void addNeighbours(Vertex[] v) {
            neighbours = new Vertex[v.length];
            for (int i = 0; i < v.length; i++) {
                neighbours[i] = v[i];
            }
        }
    }

    // LinkedList Class
    class LinkedList {
        Node front;
        Node rear;

        static class Node {
            Vertex data;
            Node next;

            public Node(Vertex data) {
                this.data = data;
                this.next = null;
            }
        }

        public boolean isEmpty() {
            return front == null;
        }

        public void insertFirst(Vertex newData) {
            Node newNode = new Node(newData);
            if (isEmpty()) {
                front = newNode;
                rear = newNode;
            } else {
                newNode.next = front;
                front = newNode;
            }
        }

        public void insertLast(Vertex newData) {
            Node newNode = new Node(newData);
            if (isEmpty()) {
                front = newNode;
                rear = newNode;
            } else {
                rear.next = newNode;
                rear = newNode;
            }
        }

        public Vertex deleteFirst() {
            if (front == null) {
                return null;
            } else {
                Vertex temp = front.data;
                front = front.next;
                if (front.next == null) {
                    rear = null;
                    front = front.next;
                }
                return temp;
            }
        }

        public void displayList() {
            Node current = front;
            while (current != null) {
                System.out.print(current.data.label + " ");
                current = current.next;
            }
            System.out.println();
        }
    }

    // LinkedListStack Class (Stack Implementation)
    class LinkedListStack {
        LinkedList ll = new LinkedList();

        public void push(Vertex element) {
            ll.insertFirst(element);
        }

        public void pop() {
            ll.deleteFirst();
        }

        public void displayStack() {
            System.out.print("   ");
            ll.displayList();
        }

        public Vertex peek() {
            return ll.front.data;
        }
    }

    // Edge Class (For Representation of an Edge)
    class Edge {
        Vertex start;
        Vertex end;

        public Edge(Vertex start, Vertex end) {
            this.start = start;
            this.end = end;
        }
    }

    // Graph Class
    class Graph {
        private int v;
        Edge[] edgeList;

        public Graph(int v) {
            this.v = v;
        }

        public Vertex createVertex(String label) {
            return new Vertex(label);
        }

        public Edge createEdge(Vertex start, Vertex end) {
            return new Edge(start, end);
        }

        public void createEdgeList(Edge[] edges) {
            edgeList = new Edge[edges.length];
            for (int i = 0; i < edges.length; i++) {
                edgeList[i] = edges[i];
            }
        }

        public void printGraphDF(LinkedListStack s) {
            s.peek().isVisited = true;
            Vertex current = s.peek();
            if(current == null) return;
            System.out.println(""+current.label);
            s.pop();

            for (int i = 0; i < current.neighbours.length; i++) {
                if (current.neighbours[i].isVisited != true) {
                    s.push(current.neighbours[i]);
                    printGraphDF(s);
                }
            }

        }
    }

    // GraphDriver Class (Main Method to Drive the Program)
    public class GraphDriver {
        public static void main(String[] args) {
            // Create a graph with 5 vertices
            Graph graph = new Graph(5);

            Vertex a = graph.createVertex("A");
            Vertex b = graph.createVertex("B");
            Vertex c = graph.createVertex("C");
            Vertex d = graph.createVertex("D");
            Vertex e = graph.createVertex("E");

            // Add neighbours for each vertex
            a.addNeighbours(new Vertex[]{b, d});
            b.addNeighbours(new Vertex[]{a, c});
            c.addNeighbours(new Vertex[]{b});
            d.addNeighbours(new Vertex[]{a});
            e.addNeighbours(new Vertex[]{d});

            // Create stack for DFS
            LinkedListStack ls = new LinkedListStack();
            ls.push(a);

            // Print graph using DFS traversal
            System.out.println("Printing Graph Depth First Traversal:");
            graph.printGraphDF(ls);
        }
    }

}
