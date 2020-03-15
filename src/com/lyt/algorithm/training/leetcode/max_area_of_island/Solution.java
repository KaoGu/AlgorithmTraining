package com.lyt.algorithm.training.leetcode.max_area_of_island;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int maxAreas = 0;
        Set<String> vistedSet = new HashSet<>();
        int rowIndex = 0;
        for (int[] lines : grid) {
            int lineIndex = 0;
            for (int item : lines) {
                if (item == 0) {
                    lineIndex++;
                    continue;
                }
                String visitId = getVisitId(rowIndex, lineIndex);
                if (vistedSet.contains(visitId)) {
                    lineIndex++;
                    continue;
                }
                Set<String> newVistSet = new HashSet<>();
                find(grid, rowIndex, lineIndex, newVistSet);
                if (maxAreas < newVistSet.size()) {
                    maxAreas = newVistSet.size();
                }
                vistedSet.addAll(newVistSet);
                lineIndex++;
            }
            rowIndex++;
        }
        return maxAreas;
    }

    private void find(int[][] grid, int rowIndex, int lineIndex, Set<String> vistedSet) {
        if (rowIndex < 0 || rowIndex >= grid.length) {
            return;
        }
        if (lineIndex < 0 || lineIndex >= grid[rowIndex].length) {
            return;
        }
        if (grid[rowIndex][lineIndex] == 0) {
            return;
        }
        String visitId = getVisitId(rowIndex, lineIndex);
        if (!vistedSet.contains(visitId)) {
            vistedSet.add(visitId);
            find(grid, rowIndex - 1, lineIndex, vistedSet);
            find(grid, rowIndex + 1, lineIndex, vistedSet);
            find(grid, rowIndex, lineIndex - 1, vistedSet);
            find(grid, rowIndex, lineIndex + 1, vistedSet);
        }
    }

    private String getVisitId(int rowIndex, int lineIndex) {
        return rowIndex + "-" + lineIndex;
    }
}
