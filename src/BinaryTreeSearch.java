import java.util.LinkedList;
import java.util.Queue;

class BinaryTreeSearch {
    class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
            right = null;
            left = null;
        }
    }

    Node root;

    private Node add(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }

        if (value < current.value) {
            current.left = add(current.left, value);
        } else if (value > current.value) {
            current.right = add(current.right, value);
        } else {
            return current;
        }

        return current;
    }

    public void Add(int value) {
        root = add(root, value);
    }


    private Node deleteNode(Node current, int value) {
        if (current == null) {
            return null;
        }
        if (value == current.value) {
            if (current.left == null && current.right == null) {
                return null;
            }
        }
        return current;
    }

    public void Delete(int value) {
        root = deleteNode(root, value);
    }


    private Node findNode(Node root, int value) {
        if (this.root == null) {
            return null;
        }
        Queue<Node> Nodes = new LinkedList<>();
        Nodes.add(this.root);

        while (!Nodes.isEmpty()) {

            Node nodex = Nodes.remove();

            System.out.print(" " + nodex.value);

            if (nodex.left != null) {
                Nodes.add(nodex.left);
            }

            if (nodex.right != null) {
                Nodes.add(nodex.right);
            }
        }
        return root;
    }

    public void Find(int value) {
        root = findNode(root, value);
    }

    private Node findNeighbourhoodleft(Node current, int value) {
        if (current == null) {
            return null;
        }
        Node root = null;
        if (current.left != null) {
            assert root != null;
            root = (current.left);
        }
        return root;
    }

    public void FindNeighbourhoodLeft(Node current, int value) {
        root = findNeighbourhoodleft(root, value);
    }


    private Node findNeighbourhoodRight(Node current, int value) {
        if (current == null) {
            return null;
        }
        Node root = null;
        if (current.right != null) {
            assert root != null;
            root = (current.right);
        }
        return root;
    }

    public void FindNeighbourhoodRight(Node current, int value) {
        root = findNeighbourhoodRight(root, value);
    }


    private Node findParent(Node current, Node parent, int value) {
        if (current == null) {
            return null;
        }
            Node root = null;
            if (current == parent.left) {
                root = parent;
            }
            return root;
    }

    public void FindNeighbourhoodParent(int value) {
        root = findParent(root, value);
    }
}

