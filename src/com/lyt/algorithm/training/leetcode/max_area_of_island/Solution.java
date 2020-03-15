package com.lyt.algorithm.training.leetcode.max_area_of_island;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int maxAreas = 0;
        int rowIndex = 0;
        for (int[] lines : grid) {
            int lineIndex = 0;
            for (int item : lines) {
                if (item == 0) {
                    lineIndex++;
                    continue;
                }
                int areas = find(grid, rowIndex, lineIndex);
                if (maxAreas < areas) {
                    maxAreas = areas;
                }
                lineIndex++;
            }
            rowIndex++;
        }
        return maxAreas;
    }

    private int find(int[][] grid, int rowIndex, int lineIndex) {
        if (rowIndex < 0 || rowIndex >= grid.length) {
            return 0;
        }
        if (lineIndex < 0 || lineIndex >= grid[rowIndex].length) {
            return 0;
        }
        if (grid[rowIndex][lineIndex] == 0) {
            return 0;
        }
        grid[rowIndex][lineIndex] = 0;
        int count = 1;
        count += find(grid, rowIndex - 1, lineIndex);
        count += find(grid, rowIndex + 1, lineIndex);
        count += find(grid, rowIndex, lineIndex - 1);
        count += find(grid, rowIndex, lineIndex + 1);
        return count;
    }
}
