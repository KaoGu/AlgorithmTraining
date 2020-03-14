package com.lyt.algorithm.training.leetcode.longest_increasing_subsequence;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class SolutionTest {

    @Test
    void lengthOfLIS() {
        Assertions.assertEquals(4,
                new Solution().lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        Assertions.assertEquals(1,
                new Solution().lengthOfLIS(new int[]{10, 9}));
        Assertions.assertEquals(1,
                new Solution().lengthOfLIS(new int[]{10}));
        Assertions.assertEquals(2,
                new Solution().lengthOfLIS(new int[]{1, 2}));
    }
}