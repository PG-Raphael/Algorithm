package Dec2;

import Nov28.BinaryTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Raphael Yun on 12/2/2019
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

    @Override
    public void add(E el) {
        root = add(root, el);
        count++;
    }

    @Override
    public void remove(E el) {
        root = remove(el, root);
    }

    @Override
    public E max() {
        return max(root).item;
    }

    private TreeNode max(TreeNode node) {
        if (node.right == null) return node;
        return max(node.right);
    }

    @Override
    public E min() {
        return min(root).item;
    }

    private TreeNode min(TreeNode node) {
        if(node.left == null) return node;
        return min(node.left);
    }

    private TreeNode remove(E el, TreeNode node) {
        if (node == null)
            return null;
        if (el == node.item) {
            if (node.left == null)
                node = node.right;
            else if (node.right == null)
                node = node.left;
            else {
                node.item = max(node.left).item;
                node.left = remove(node.item, node.left);
            }
        }
        else if (el.compareTo(node.item) > 0) {
            node.right = remove(el, node.right);
        } else {
            node.left = remove(el, node.left);
        }

        return node;
    }

    private TreeNode add(TreeNode node, E item) {
        if (node == null)
            return new TreeNode(item);
        int comp = item.compareTo(node.item);
        if (comp == 0)
            throw new IllegalStateException("Duplicated");
        else if (comp < 0)
            node.left = add(node.left, item);
        else
            node.right = add(node.right, item);

        return node;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public E[] arrays() {
        List<E> list = new ArrayList<>();
        arrays(root, list);
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
        traverse(root);
    }

    private void traverse(TreeNode node) {
        if (node == null) return;
        traverse(node.left);
        traverse(node.right);
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
        treeSetTest.remove(20);
        System.out.println(Arrays.toString(treeSetTest.arrays()));

    }
}
