package Nov28;

import java.util.*;

/**
 * Created by Raphael Yun on 11/28/2019
 */

public class TreeSetTest<E extends Comparable<E>> implements BinaryTree<E> {
    private TreeNode root;
    private int count;

    private class TreeNode {
        TreeNode left;
        E item;
        TreeNode right;

        TreeNode(E item) {
            this.item = item;
        }
    }

    public TreeNode add(E el, TreeNode node) {
        if (node == null)
            return new TreeNode(el);
        int cmp = el.compareTo(node.item);
        if (cmp == 0)
            throw new IllegalStateException("No duplication in tree.");
        else if (cmp < 0) {
            node.left = add(el, node.left);
        }
        else {
            node.right = add(el, node.right);
        }
        return node;
    }

    @Override
    public void add(E el) {
        root = add(el, root);
        count++;
    }

    @Override
    public int size() {
        return count;
    }


    @Override
    public E[] arrays() {
        List<E> list = new ArrayList<>();
        arrays(root,  list);
        return (E[]) list.toArray(new Comparable[0]);
    }

    private void arrays(TreeNode root, List<E> list) {
        if (root == null) return;
        arrays(root.left, list);
        list.add(root.item);
        arrays(root.right, list);
    }

    @Override
    public void traverse() {
        if(root == null) return;
        traverse(root);
    }


    private void traverse(TreeNode node) {
        if(node == null) return;
        traverse(node.left);
        traverse(node.right);
        System.out.print(" " + node.item);
    }

    public static void main(String[] args) {
        int[] nums = {3, 10, 2, 1, 50, 20, 34, 11};
        TreeSetTest<Integer> treeSetTest = new TreeSetTest<>();
        for (int num : nums) {
            treeSetTest.add(num);
        }

        treeSetTest.traverse();
        System.out.println();
        System.out.println(Arrays.toString(treeSetTest.arrays()));
    }
}
