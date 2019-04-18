package main;
import java.util.ArrayList;
import java.util.List;
public class BinaryTree<T extends Comparable<T>> {
    private T val;
    private BinaryTree left;
    private BinaryTree right;
    private BinaryTree parent;
    private List<T> listForPrint = new ArrayList<>();

    public T val() {
        return val;
    }

    public BinaryTree left() {
        return left;
    }

    public BinaryTree right() {
        return right;
    }

    public BinaryTree parent() {
        return parent;
    }

    public BinaryTree(T val, BinaryTree parent) {
        this.val = val;
        this.parent = parent;
    }

    public void add(T... vals) {
        for (T v : vals) {
            add(v);
        }
    }

    public void add(T val) {
        if (val.compareTo(this.val) < 0) {
            if (this.left == null) {
                this.left = new BinaryTree(val, this);
            } else if (this.left != null)
                this.left.add(val);
        } else {
            if (this.right == null) {
                this.right = new BinaryTree(val, this);
            } else if (this.right != null)
                this.right.add(val);
        }
    }
}