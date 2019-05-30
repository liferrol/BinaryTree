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
            current.left.parent = current;
        } else if (value > current.value) {
            current.right = add(current.right, value);
            current.right.parent = current;
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
        if (root.value == value) {
            if (root.left == null && root.right == null) {
                root = null;
            }
            else {
                if (root.left == null && root.right != null) {
                    root = root.right;
                    root.right = null;
                }
                if (root.left != null) {
                    root = root.left;
                    root.left = null;
                }
            }
        }
        return root;
    }

    public void Delete(int value) {
        root = deleteNode(root, value);
    }


    private boolean findNode(int value) {
        if (root == null)
            return false;
        return root.value == value;
    }

    public boolean Find(int value) {
        return findNode(value);
    }

    private int findNeighbourhoodleft(Node current, int value) {
        if (current == null) {
            return 0;
        }
        if (current == root) {
            if (root.left != null) {
                current = current.left;
            }
        }
        return current.value;
    }

    public int FindNeighbourhoodLeft(int value) {
        return findNeighbourhoodleft(root, value);
    }


    private int findNeighbourhoodRight(Node current, int value) {
        if (current == null) {
            return 0;
        }
        if (current == root) {
            if (current.right != null) {
                current = current.right;
            }
        }
        return current.value;
    }

    public int FindNeighbourhoodRight(int value) {
        return findNeighbourhoodRight(root, value);
    }


    private int findParent(Node current, int value) {
        if (current == null) {
            return 0;
        }
        if (root.value == current.value){
            root.parent.value = current.parent.value;
        }
            return root.parent.value;
    }

    public int FindNeighbourhoodParent(int value) {
        return findParent(root, value);
    }
}



