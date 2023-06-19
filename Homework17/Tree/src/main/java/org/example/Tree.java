package org.example;

public class Tree {
    private Node root;
    private int size;

    public boolean contains(int value) { // O(log N)
        Node cur = root;
        while (cur != null) {
            if (cur.value == value)
                return true;
            else {
                if (cur.value < value)
                    cur = cur.right;
                else
                    cur = cur.left;
            }
        }
        return false;
    }

    public void print() {
        print(root);
    }

    private void print(Node node) {
        if (node == null)
            return;
        System.out.print(node.value + "  Color:" + node.color);

        System.out.print("\t(");
        if (node.left != null)
            System.out.printf("L:" + node.left.value);
        else
            System.out.print("L:null");
        System.out.print("\t\t");
        if (node.parent != null)
            System.out.printf("P:" + node.parent.value);
        else
            System.out.print("P:null");
        System.out.print("\t\t");
        if (node.right != null)
            System.out.printf("R:" + node.right.value);
        else
            System.out.print("R:null");
        System.out.println(")");

        print(node.left);
        print(node.right);
    }

    public boolean add(int value) {
        if (root != null)
            return add(value, root, null);
        else {
            root = new Node();
            root.value = value;
            root.color = Color.BLACK;
            size = 1;
            return true;
        }
    }

    private boolean add(int value, Node cur, Node par) {
        if (cur == null) {
            cur = new Node();
            cur.value = value;
            cur.color = Color.RED;
            cur.parent = par;
            if (value > par.value)
                par.right = cur;
            else
                par.left = cur;
            size++;
            rebalance();
            return true;
        } else if (cur.value == value) {
            return false;
        } else {
            if (cur.value > value)
                return add(value, cur.left, cur);
            else
                return add(value, cur.right, cur);
        }
    }

    private void rebalance() {
        rebalance(root);
        if (root.color != Color.BLACK)
            root.color = Color.BLACK;
    }

    private void rebalance(Node node) {
        if (node != null) {
            node = swap(node);
            rebalance(node.left);
            rebalance(node.right);
        }
    }

    private Node swap(Node node) {
        Node res = node;
        if (node.left == null && node.right != null && node.right.right != null)
            res = rightSwap(node, node.right);
        if (node.right == null && node.left != null && node.left.left != null)
            res = leftSwap(node, node.left);

        if (node.right != null && node.left != null &&
                node.right.color == Color.RED && node.left.color == Color.BLACK)
            res = rightSwap(node, node.right);
        if (node.left != null && node.left.left != null &&
                node.left.color == Color.RED && node.left.left.color == Color.RED)
            res = leftSwap(node, node.left);
        if (node.right != null && node.right.right != null &&
                node.right.color == Color.RED && node.right.right.color == Color.RED)
            res = rightSwap(node, node.right);
        if (node.left != null && node.right != null &&
                node.left.color == Color.RED && node.right.color == Color.RED)
            colorSwap(node, node.left, node.right);

        if (node.right != null && node.right.color == Color.RED)
            node.right.color = Color.BLACK;
        if (node.left == null && node.right == null)
            node.color = Color.BLACK;
        return res;
    }

    private Node leftSwap(Node par, Node left) {
        if (par == root)
            root = left;
        left.parent = par.parent;
        par.parent = left;
        par.left = left.right;
        left.right = par;
        if (left.parent != null)
            left.parent.left = left;
        left.color = Color.BLACK;
        par.color = Color.RED;
        return left;
    }

    private Node rightSwap(Node par, Node right) {
        if (par == root)
            root = right;
        right.parent = par.parent;
        par.parent = right;
        par.right = right.left;
        right.left = par;
        if (right.parent != null)
            right.parent.right = right;
        par.color = Color.RED;
        right.color = Color.BLACK;
        return right;
    }

    private void colorSwap(Node par, Node left, Node right) {
        par.color = Color.RED;
        left.color = Color.BLACK;
        right.color = Color.BLACK;
    }

    private class Node {
        int value;
        Color color;
        Node left;
        Node right;
        Node parent;
    }

    private enum Color {RED, BLACK}

    public static void main(String[] args) {
        Tree tree = new Tree();
        for (int i = 1; i < 10; i++) {
            tree.add(i);
        }
        tree.print();
    }
}