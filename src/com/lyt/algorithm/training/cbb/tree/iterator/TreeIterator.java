package com.lyt.algorithm.training.cbb.tree.iterator;

import com.lyt.algorithm.training.cbb.tree.model.TreeNode;

import java.util.*;

/**
 * 二叉树的遍历
 */
public class TreeIterator {

    public List<TreeNode> preorderTraversal(TreeNode root) {
        List<TreeNode> ret = new LinkedList<>();
        if (root == null) return ret;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            ret.add(node);
            // 先右后左，保证左子树先遍历
            if (null != node.right) {
                stack.push(node.right);
            }
            if (null != node.left) {
                stack.push(node.left);
            }
        }
        return ret;
    }

    public List<TreeNode> inorderTraversal(TreeNode root) {
        List<TreeNode> ret = new LinkedList<>();
        if (root == null) return ret;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode node = stack.pop();
            ret.add(node);
            cur = node.right;
        }
        return ret;
    }

    public List<TreeNode> postorderTraversal(TreeNode root) {
        LinkedList<TreeNode> ret = new LinkedList<>();
        if (root == null) return ret;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            ret.addFirst(node);
            if (null != node.left) {
                stack.push(node.left);
            }
            if (null != node.right) {
                stack.push(node.right);
            }
        }
        return ret;
    }

    public List<TreeNode> levelorderTraversal(TreeNode root) {
        List<TreeNode> ret = new LinkedList<>();
        if (root == null) return ret;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int cnt = queue.size();
            double sum = 0;
            for (int index = 0; index < cnt; index++) {
                TreeNode node = queue.poll();
                ret.add(node);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            ret.add(null);
        }
        return ret;
    }
}
