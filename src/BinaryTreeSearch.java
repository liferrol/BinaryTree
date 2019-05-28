class BinaryTreeSearch {
    class Node {
        int value;
        Node left;
        Node right;
        Node parent;

        Node(int value) {
            this.value = value;
            right = null;
            left = null;
            parent = null;
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
            if (current.left != null) {
                current = current.left;
            }
            if (current.left == null && current.right != null) {
                current = current.right;
            }
            if (current.left == null && current.right == null) {
                current = null;
            }
        }
        return current;
    }

    public void Delete(int value) {
        root = deleteNode(root, value);
    }


    private boolean findNode(Node root, int value) {
        if (root == null)
            return false;
        return root.value == value;
    }

    public boolean Find(int value) {
        return findNode(root, value);
    }

    private int findNeighbourhoodleft(Node current, int value, Node answer) {
        if (current == null) {
            return 0;
        }
        if (current.left != null) {
            answer = current.left;
        }
        return answer.value;
    }

    public int FindNeighbourhoodLeft(int value) {
        return findNeighbourhoodleft(root, value, null);
    }


    private int findNeighbourhoodRight(Node current, int value, Node answer) {
        if (current == null) {
            return 0;
        }
        if (current.right != null) {
            answer = current.right;
        }
        return answer.value;
    }

    public int FindNeighbourhoodRight(int value) {
        return findNeighbourhoodRight(root, value, null);
    }


    private int findParent(Node current, Node parent, int value) {
        if (current == null) {
            return 0;
        }
        if (current.value == root.left.value) {
            parent = root;
        }
        return parent.value;
    }

    public int FindNeighbourhoodParent(int value) {
        return findParent(root, null, value);
    }
}



