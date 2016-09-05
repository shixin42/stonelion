package com.stonelion.algorithm;

import java.util.Stack;

/**
 * Created by shixin on 8/16/16.
 */
public class BinaryTree {
    private TreeNode root;

    public BinaryTree(TreeNode root) {
        this.root = root;
    }

    public TreeNode getRoot() {
        return root;
    }

    /**
     * 递归前序遍历
     */
    public void preOrderRecursion() {
        System.out.println("递归前序遍历:");
        preOrderRecursion(getRoot());
        System.out.println();
    }

    private void preOrderRecursion(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.getData() + " ");
        preOrderRecursion(node.getLeftChild());
        preOrderRecursion(node.getRightChild());
    }

    /**
     * 非递归前序遍历
     */
    public void preOrderNoRecursion() {
        System.out.println("非递归前序遍历:");
        if (getRoot() == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(getRoot());

        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.pop();
            System.out.print(treeNode.getData() + " ");

            if (treeNode.getRightChild() != null) {
                stack.push(treeNode.getRightChild());
            }
            if (treeNode.getLeftChild() != null) {
                stack.push(treeNode.getLeftChild());
            }
        }
        System.out.println();
    }

    /**
     * 递归中序遍历
     */
    public void inOrderRecursion() {
        System.out.println("递归中序遍历:");
        inOrderRecursion(getRoot());
        System.out.println();
    }

    private void inOrderRecursion(TreeNode node) {
        if (node == null) {
            return;
        }

        inOrderRecursion(node.getLeftChild());
        System.out.print(node.getData() + " ");
        inOrderRecursion(node.getRightChild());
    }

    /**
     * 非递归中序遍历
     */
    public void inOrderNoRecursion() {
        System.out.println("非递归前序遍历:");
        if (getRoot() == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode currentNode = getRoot();

        while (currentNode != null || !stack.isEmpty()) {
            while (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.getLeftChild();
            }

            if (!stack.isEmpty()) {
                currentNode = stack.pop();
                System.out.print(currentNode.getData() + " ");

                currentNode = currentNode.getRightChild();
            }
        }
        System.out.println();
    }

    /**
     * 递归后序遍历
     */
    public void postOrderRecursion() {
        System.out.println("递归后序遍历:");
        postOrderRecursion(getRoot());
        System.out.println();
    }

    private void postOrderRecursion(TreeNode node) {
        if (node == null) {
            return;
        }

        postOrderRecursion(node.getLeftChild());
        postOrderRecursion(node.getRightChild());
        System.out.print(node.getData() + " ");
    }

    /**
     * 二叉树非递归后序遍历
     */
    public void postOrderNoRecursion() {
        System.out.println("非递归后序遍历:");
        if (getRoot() == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode currentNode = getRoot();
        TreeNode lastNode = getRoot();

        while (currentNode != null || !stack.isEmpty()) {
            while (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.getLeftChild();
            }

            currentNode = stack.pop();
            while (currentNode != null && (currentNode.getRightChild() == null || currentNode.getRightChild() == lastNode)) {
                lastNode = currentNode;
                System.out.print(currentNode.getData() + " ");

                if (stack.isEmpty()) {
                    System.out.println();
                    return;
                }

                currentNode = stack.pop();
            }

            stack.push(currentNode);
            currentNode = currentNode.getRightChild();
        }
    }

    public int getDepth() {
        return getDepth(getRoot());
    }

    public int getDepth(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }

        int leftDepth = getDepth(treeNode.getLeftChild());
        int rightDepth = getDepth(treeNode.getRightChild());
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args) {
        TreeNode treeNode6 = new TreeNode(6, null, null);
        TreeNode treeNode7 = new TreeNode(7, null, null);
        TreeNode treeNode5 = new TreeNode(5, treeNode6, treeNode7);

        TreeNode treeNode4 = new TreeNode(4, null, null);
        TreeNode treeNode2 = new TreeNode(2, treeNode4, treeNode5);

        TreeNode treeNode3 = new TreeNode(3, null, null);
        TreeNode treeNode1 = new TreeNode(1, treeNode2, treeNode3);
        BinaryTree binaryTree = new BinaryTree(treeNode1);

        binaryTree.preOrderRecursion();
        binaryTree.preOrderNoRecursion();

        binaryTree.inOrderRecursion();
        binaryTree.inOrderNoRecursion();

        binaryTree.postOrderRecursion();
        binaryTree.postOrderNoRecursion();

        System.out.println(binaryTree.getDepth());
    }

    private static class TreeNode {
        private int data;
        private TreeNode leftChild;
        private TreeNode rightChild;

        public TreeNode(int data, TreeNode leftChild, TreeNode rightChild) {
            this.data = data;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public TreeNode getLeftChild() {
            return leftChild;
        }

        public TreeNode getRightChild() {
            return rightChild;
        }
    }
}
