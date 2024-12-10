class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

class BinaryTree {
    Node root;

     BinaryTree(int Key) {
        root = new Node(Key);
    }
    BinaryTree() {
        root = null;
    }

    void printPreorder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.key + " ");
        printPreorder(node.left);
        printPreorder(node.right);
    }

    void printInorder(Node node) {
        if (node == null) {
            return;
        }
        printInorder(node.left);
        System.out.print(node.key + " ");
        printInorder(node.right);
    }

    void printPostorder(Node node) {
        if (node == null) {
            return;
        }
        printPostorder(node.left);
        printPostorder(node.right);
        System.out.print(node.key + " ");
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1); // Create root node

        Node a = new Node(2);
        tree.root.left = a;

        Node b = new Node(3);
        tree.root.right = b;

        a.left = new Node(4);
        a.right = new Node(5);

        System.out.println("Pre-order traversal:");
        tree.printPreorder(tree.root);

        System.out.println("\nIn-order traversal:");
        tree.printInorder(tree.root);

        System.out.println("\nPost-order traversal:");
        tree.printPostorder(tree.root);
    }
}