package com.codecool.krk.binary.tree;

import java.util.List;


public class BinarySearchTree {

    private TreeNode root;

    public static BinarySearchTree build(List<Integer> elements) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.root = tree.buildTree(elements);
        return tree;
    }

    private TreeNode buildTree(List<Integer> elems) {
        if (elems.size() > 0) {
            int middle = (int) Math.floor(elems.size() / 2);
            TreeNode newNode = new TreeNode(elems.get(middle));
            newNode.left = buildTree(elems.subList(0, middle));
            if (elems.size() > 2) {
                newNode.right = buildTree(elems.subList(middle + 1, elems.size()));
            }
            return newNode;
        }
        return null;
    }

    public boolean search(Integer toFind) {
        TreeNode current = root;
        while (current != null) {
            if (toFind == current.data) {
                return true;
            }
            else if (toFind < current.data) {
                current = current.left;
            }
            else {
                current = current.right;
            }
        }
        return false;
    }

    public void add(Integer toAdd) {
        TreeNode current = root;
        while (true) {
            if (toAdd == current.data) {
                throw new IllegalArgumentException("Element already in the tree");
            }
            else if (toAdd < current.data) {
                if (current.left != null) {
                    current = current.left;
                }
                else {
                    current.left = new TreeNode(toAdd);
                    return;
                }
            }
            else {
                if (current.right != null) {
                    current = current.right;
                }
                else {
                    current.right = new TreeNode(toAdd);
                    return;
                }
            }
        }
    }

    public void remove(Integer toRemove) {
        if (root.data == toRemove) {
            root = null;
            return;
        }
        TreeNode current = root;
        TreeNode parent = root;
        while (current != null) {
            if (toRemove == current.data) {
                parent.removeChild(current);
                return;
            }
            else if (toRemove < current.data) {
                parent = current;
                current = current.left;
            }
            else {
                parent = current;
                current = current.right;
            }
        }
        throw new IllegalArgumentException("Element not in the tree");
    }

}
