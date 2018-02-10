package com.codecool.krk.binary.tree;

public class TreeNode {

    public int data;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return Integer.toString(data);
    }

    public void removeChild(TreeNode child) {
        if (left == child) {
            left = null;
        }
        else if (right == child) {
            right = null;
        }
        else {
            throw new IllegalArgumentException("Tried to remove non existing child");
        }
    }
}
