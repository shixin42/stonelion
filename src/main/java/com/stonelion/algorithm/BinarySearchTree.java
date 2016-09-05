package com.stonelion.algorithm;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉查找树(Binary Search Tree)
 *
 * (01) 若任意节点的左子树不空，则左子树上所有结点的值均小于它的根结点的值；
 * (02) 任意节点的右子树不空，则右子树上所有结点的值均大于它的根结点的值；
 * (03) 任意节点的左、右子树也分别为二叉查找树。
 * (04) 没有键值相等的节点（no duplicate nodes）。
 *
 * Created by shixin on 8/16/16.
 */
public class BinarySearchTree {
    private TreeNode root;

    public BinarySearchTree(TreeNode root) {
        this.root = root;
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    /**
     * 插入数据
     *
     * @param data
     */
    public void insert(int data) {
        if (getRoot() == null) {
            setRoot(new TreeNode(data, null, null, null));
            return;
        }

        insert(data, getRoot());
    }

    public void insert(int data, TreeNode treeNode) {
        if (data == treeNode.getData()) {
            return;
        }

        if (treeNode.getData() > data) {
            if (treeNode.getLeftChild() != null) {
                insert(data, treeNode.getLeftChild());
            } else {
                TreeNode newNode = new TreeNode(data, treeNode, null, null);
                treeNode.setLeftChild(newNode);
            }
        } else {
            if (treeNode.getRightChild() != null) {
                insert(data, treeNode.getRightChild());
            } else {
                TreeNode newNode = new TreeNode(data, treeNode, null, null);
                treeNode.setRightChild(newNode);
            }
        }
    }

    public void delete(int data) {
    }

    public void delete(int data, TreeNode treeNode) {
    }

    /**
     * 广度遍历.
     */
    public void scopeOrder() {
        System.out.println("广度优先遍历");
        if (getRoot() == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(getRoot());

        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.remove();
            System.out.print(treeNode.getData() + " ");
            if (treeNode.getLeftChild() != null) {
                queue.add(treeNode.getLeftChild());
            }
            if (treeNode.getRightChild() != null) {
                queue.add(treeNode.getRightChild());
            }
        }
    }

    /**
     * 递归中序遍历
     */
    public void inOrderRecursion() {
        System.out.println("递归中序遍历");
        inOrderRecursion(getRoot());
        System.out.println();
    }

    private void inOrderRecursion(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }

        inOrderRecursion(treeNode.getLeftChild());
        System.out.print(treeNode.getData() + " ");
        inOrderRecursion(treeNode.getRightChild());
    }

    public static void main(String[] args) {
        // 构建二叉排序树
        int[] array = new int[] {9, 5, 3, 7, 6, 1, 2, 10, 8, 4};
        BinarySearchTree tree = new BinarySearchTree(null);
        for (int value : array) {
            tree.insert(value);
        }

        // 按照中序遍历可以得到从小到大的排列
        tree.inOrderRecursion();

        tree.scopeOrder();
    }

    private static class TreeNode {
        private int data;
        private TreeNode parent;
        private TreeNode leftChild;
        private TreeNode rightChild;

        public TreeNode(int data, TreeNode parent, TreeNode leftChild, TreeNode rightChild) {
            this.data = data;
            this.parent = parent;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }

        public TreeNode getParent() {
            return parent;
        }

        public void setParent(TreeNode parent) {
            this.parent = parent;
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

        public void setLeftChild(TreeNode leftChild) {
            this.leftChild = leftChild;
        }

        public TreeNode getRightChild() {
            return rightChild;
        }

        public void setRightChild(TreeNode rightChild) {
            this.rightChild = rightChild;
        }
    }
}
