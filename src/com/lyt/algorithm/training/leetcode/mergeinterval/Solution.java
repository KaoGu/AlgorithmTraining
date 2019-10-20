package com.lyt.algorithm.training.leetcode.mergeinterval;

import java.util.LinkedList;
import java.util.List;

class Solution {

    public int[][] merge(int[][] intervals) {
        if (intervals.length < 1) {
            return new int[0][2];
        }
        List<int[]> mergeList = new LinkedList<>();
        for (int[] pair : intervals) {
            if (null == pair || pair.length != 2) {
                continue;
            }
            addPair(mergeList, pair);
        }
        int[][] merged = new int[mergeList.size()][2];
        int i = 0;
        for (int[] pair : mergeList) {
            merged[i][0] = pair[0];
            merged[i][1] = pair[1];
            i++;
        }
        return merged;
    }

    private void addPair(List<int[]> mergeList, int[] pair) {
        int begin = pair[0];
        int end = pair[1];
        if (begin > end) {
            return;
        }
        if (mergeList.isEmpty()) {
            mergeList.add(new int[]{pair[0], pair[1]});
            return;
        }
        for (int i = 0; i < mergeList.size(); i++) {
            int[] comparePair = mergeList.get(i);
            if (end < comparePair[0]) {
                mergeList.add(i, new int[]{begin, end});
                return;
            }
            if (begin > comparePair[1]) {
                continue;
            }
            if (comparePair[0] <= begin) {
                begin = comparePair[0];
            }
            if (comparePair[1] > end) {
                end = comparePair[1];
            }
            mergeList.remove(i);
            i--;
        }
        mergeList.add(new int[]{begin, end});
    }
}