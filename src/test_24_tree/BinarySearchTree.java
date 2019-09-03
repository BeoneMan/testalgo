package test_24_tree;

import javax.swing.tree.TreeNode;

/**
 * 查找二叉树
 */
public class BinarySearchTree {
    private Node tree;

    public Node getTree() {
        return tree;
    }

    //查询
    public Node find(int value) {
        Node p = tree;
        if (tree == null) return null;
        while (p != null) {
            if (value > p.data) p = p.right;
            else if (value < p.data) p = p.left;
            else return p;
        }
        return null;
    }

    //插入
    public void insert(int value) {
        if (tree == null) {
            tree = new Node(value);
            return;
        }
        Node p = tree;
        while (p != null) {
            if (value < p.data) {
                if (p.left == null) {
                    p.left = new Node(value);
                    return;
                }
                p = p.left;

            } else {
                if (p.right == null) {
                    p.right = new Node(value);
                    return;
                }
                p = p.right;

            }
        }
    }

    //删除
    public Node delete(int value) {
        if (tree == null) return null;
        //删除的节点有左节点和右节点
        Node p = tree;//要删除的节点，先从根点开始
        Node pp = null;//要删除节点的父节点
        while (p != null) {
            if (value > p.data) {
                pp = p;
                p = p.right;
            } else if (value < p.data) {
                pp = p;
                p = p.left;
            } else {
                break;
            }
        }
        if (p == null) return null;
        if (p.left != null && p.right != null) {
            Node minp = p.right;
            Node minpp = p;
            if (minp.left != null) {
                minpp = minp;
                minp = minp.left;
            }
            p.data = minp.data;

            p = minp;
            pp = minpp;
        }

        //删除的节点有一个节点或者无节点
        Node child;
        if (p.left != null) child = p.left;
        else if (p.right != null) child = p.right;
        else child = null;

        if (pp == null) tree = child;
        else if (pp.left == p) pp.left = child;
        else pp.right = child;
        return null;
    }


    public static class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void preOrderTraveral(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preOrderTraveral(node.left);
        preOrderTraveral(node.right);
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(5);
        bst.insert(8);
        bst.insert(4);
        bst.insert(6);
        bst.insert(2);
        bst.insert(9);
        bst.preOrderTraveral(bst.getTree());

        Node node = bst.find(2);
        System.out.println();
        System.out.println("find的值：" + node.data);

        System.out.println();
        bst.delete(5);
        bst.preOrderTraveral(bst.getTree());
    }
}
