package com.lyt.algorithm.training.leetcode.tree.util.handler;

import com.lyt.algorithm.training.leetcode.tree.util.model.TreeNode;

import java.util.List;

public class TreeBuilder {

    public TreeNode buildSortTree(List<Integer> values) {
        if (null == values || values.isEmpty()) {
            return null;
        }
        TreeNode root = null;
        for (Integer value : values) {
            root = insert(root, value);
        }
        return root;
    }

    private TreeNode insert(TreeNode root, Integer value) {
        if (null == root) {
            return new TreeNode(value);
        }
        if (value <= root.val) {
            root.left = insert(root.left, value);
        } else {
            root.right = insert(root.right, value);
        }
        return root;
    }
}
