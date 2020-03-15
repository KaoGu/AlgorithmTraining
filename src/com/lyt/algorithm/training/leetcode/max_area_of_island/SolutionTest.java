package com.lyt.algorithm.training.leetcode.max_area_of_island;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void maxAreaOfIsland() {
        int[][] actual = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        Assertions.assertEquals(6, new Solution().maxAreaOfIsland(actual));
        Assertions.assertEquals(1, new Solution().maxAreaOfIsland(
                new int[][]{{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0}}));
        Assertions.assertEquals(0, new Solution().maxAreaOfIsland(
                new int[][]{{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}}));
        Assertions.assertEquals(3, new Solution().maxAreaOfIsland(
                new int[][]{{1, 1}, {1, 0}}));
    }
}