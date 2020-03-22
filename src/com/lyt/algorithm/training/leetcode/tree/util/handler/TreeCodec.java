package com.lyt.algorithm.training.leetcode.tree.util.handler;


import com.lyt.algorithm.training.leetcode.tree.util.model.TreeNode;

import java.util.*;

public class TreeCodec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (null == root) {
            return "";
        }
        int length = 0;
        List<String> resultList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            if (null == treeNode) {
                resultList.add("null");
            } else {
                resultList.add(String.valueOf(treeNode.val));
                queue.offer(treeNode.left);
                queue.offer(treeNode.right);
                length = resultList.size();
            }
        }
        StringBuffer resultBuffer = new StringBuffer();
        for (int index = 0; index < length; index++) {
            resultBuffer.append(",").append(resultList.get(index));
        }
        return resultBuffer.toString().substring(1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (null == data || data.isEmpty()) {
            return null;
        }
        TreeNode fackRoot = new TreeNode(0);
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.offer(fackRoot);
        boolean rightFlag = true;
        String[] nodes = data.split(",");
        for (String node : nodes) {
            TreeNode treeNode = null;
            if (!node.equals("null")) {
                treeNode = new TreeNode(Integer.parseInt(node));
            }
            if (treeNodeQueue.isEmpty()) {
                return null;
            }
            TreeNode parentTree = treeNodeQueue.poll();
            if (rightFlag) {
                parentTree.right = treeNode;
            } else {
                parentTree.left = treeNode;
            }
            if (null != treeNode) {
                treeNodeQueue.offer(treeNode);
                treeNodeQueue.offer(treeNode);
            }
            rightFlag = !rightFlag;
        }
        return fackRoot.right;
    }
}
