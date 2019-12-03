package Dec3;

import Nov28.BinaryTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Raphael Yun on 12/3/2019
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
        root = add(el, root);
        count++;
    }

    private TreeNode add(E el, TreeNode node) {
        if (node == null) return new TreeNode(el);
        int comp = el.compareTo(node.item);
        if (comp == 0)
            throw new IllegalArgumentException("Duplicated");
        else if (comp < 0)
            node.left = add(el, node.left);
        else
            node.right = add(el, node.right);

        return node;
    }

    @Override
    public void remove(E el) {
        root = remove(el, root);
        count--;
    }

    private TreeNode remove(E el, TreeNode node) {
        if (node == null) return null;
        int comp = el.compareTo(node.item);
        if (comp == 0) {
            if (node.left == null)
                node = node.right;
            else if (node.right == null)
                node = node.left;
            else {
                node.item = max(node.left).item;
                node.left = remove(node.item, node.left);
            }
        } else if (comp > 0)
            node.right = remove(el, node.right);
        else
            node.left = remove(el, node.left);

        return node;
    }

    private TreeNode max(TreeNode node) {
        if (node.right == null) return node;
        return max(node.right);
    }

    @Override
    public E max() {
        return max(root).item;
    }

    @Override
    public E min() {
        return min(root).item;
    }

    private TreeNode min(TreeNode node) {
        if (root.left == null) return node;
        return min(node.left);
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public E[] arrays() {
        List<E> list = new ArrayList<>();
        inOrderArrays(root, list);
        return (E[]) list.toArray(new Comparable[0]);
    }

//                  f
//            b          g
//         a     d           i
//             c    e       h
    // Tree example

    // a,b,c,d,e,f,g,h,i
    private void inOrderArrays(TreeNode node, List<E> list) {
        if (node == null) return;
        inOrderArrays(node.left, list);
        list.add(node.item);
        inOrderArrays(node.right, list);
    }

    // f,b,a,d,c,e,g,i,h
    private void preOrderArrays(TreeNode node, List<E> list) {
        if (node == null) return;
        list.add(node.item);
        preOrderArrays(node.left, list);
        preOrderArrays(node.right, list);
    }

    // a,c,e,d,b,h,i,g,f
    private void postOrderArrays(TreeNode node, List<E> list) {
        if (node == null) return;
        postOrderArrays(node.left, list);
        postOrderArrays(node.right, list);
        list.add(node.item);
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
        TreeSetTest treeSetTest = new TreeSetTest();
        int[] nums = {3, 10, 2, 1, 50, 20, 34, 11};
        for (int num : nums)
            treeSetTest.add(num);
        treeSetTest.traverse();
        System.out.println(treeSetTest.size());
        System.out.println(Arrays.toString(treeSetTest.arrays()));
        treeSetTest.remove(20);
        System.out.println(Arrays.toString(treeSetTest.arrays()));
        System.out.println(treeSetTest.size());


    }
}
