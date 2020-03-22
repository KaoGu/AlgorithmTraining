package com.lyt.algorithm.training.utils.tree.handler;

import com.lyt.algorithm.training.utils.tree.model.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class TreeListCodec {

    public String serialize(List<TreeNode> nodeList) {
        if (null == nodeList) {
            return "";
        }
        StringJoiner result = new StringJoiner(",");
        for (TreeNode treeNode : nodeList) {
            if (null != treeNode) {
                result.add(String.valueOf(treeNode.val));
            } else {
                result.add("null");
            }
        }
        return "[" + result.toString() + "]";
    }

    public List<TreeNode> deserialize(String serializeStr) {
        if (null == serializeStr || serializeStr.length() < 2) {
            return null;
        }
        String arrayString = serializeStr.substring(1, serializeStr.length() - 1);
        if (arrayString.isEmpty()) {
            return new ArrayList<>(0);
        }
        String[] splitNodes = arrayString.split(",");
        List<TreeNode> nodeList = new ArrayList<>(splitNodes.length);
        for (String nodeStr : splitNodes) {
            if ("null".equals(nodeStr)) {
                nodeList.add(null);
            } else {
                nodeList.add(new TreeNode(Integer.parseInt(nodeStr)));
            }
        }
        return nodeList;
    }
}
