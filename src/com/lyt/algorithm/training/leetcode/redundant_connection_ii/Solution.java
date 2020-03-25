package com.lyt.algorithm.training.leetcode.redundant_connection_ii;

import java.util.*;

class Solution {
    class Uf {
        int val;
        Uf parent;
        List<Uf> sons = new ArrayList<>();
    }

    public int[] findRedundantDirectedConnection(int[][] edges) {
        Map<Integer, Uf> ufMap = new HashMap<>();
        Map<String, Integer> edgeIndexMap = new HashMap<>();
        int[] twoParentUfEdge = null;
        int index = 0;
        for (int[] edge : edges) {
            edgeIndexMap.put(edge[0] + "-" + edge[1], index++);
            Uf parent = initUfMap(ufMap, edge[0]);
            Uf son = initUfMap(ufMap, edge[1]);
            if (son.parent != null) {
                twoParentUfEdge = edge;
                continue;
            }
            parent.sons.add(son);
            son.parent = parent;
        }

        List<Uf> ufs = new ArrayList<>(ufMap.values());
        if (twoParentUfEdge != null) {
            if (null == getCircleNode(ufs)) {
                return twoParentUfEdge;
            }
            Uf errorSon = ufMap.get(twoParentUfEdge[1]);
            return new int[]{errorSon.parent.val, errorSon.val};
        }
        Uf circleNode = getCircleNode(ufs);
        if (null == circleNode) {
            return null;
        }
        Uf parent = circleNode.parent;
        int maxIndex = edgeIndexMap.get(parent.val + "-" + circleNode.val);
        while (parent != circleNode) {
            Integer edgeindex = edgeIndexMap.get(parent.parent.val + "-" + parent.val);
            if (edgeindex > maxIndex) {
                maxIndex = edgeindex;
            }
            parent = parent.parent;
        }
        return edges[maxIndex];
    }

    private Uf getCircleNode(List<Uf> ufs) {
        for (Uf uf : ufs) {
            if (isInCircle(uf, ufs.size())) {
                return uf;
            }
        }
        return null;
    }

    private boolean isInCircle(Uf uf, int size) {
        Uf parent = uf.parent;
        size--;
        while (size > 0 && parent != null && parent != uf) {
            parent = parent.parent;
            size--;
        }
        return parent == uf;
    }

    private Uf initUfMap(Map<Integer, Uf> ufMap, int point) {
        Uf uf = ufMap.get(point);
        if (null != uf) {
            return uf;
        }
        uf = new Uf();
        uf.val = point;
        ufMap.put(point, uf);
        return uf;
    }
}
