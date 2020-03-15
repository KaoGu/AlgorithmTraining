package com.lyt.algorithm.training.leetcode.median_of_two_sorted_arrays.solution2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void findMedianSortedArrays() {
        Assertions.assertEquals(2, new Solution().findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
        Assertions.assertEquals(2, new Solution().findMedianSortedArrays(new int[]{2}, new int[]{1, 3}));
        Assertions.assertEquals(2, new Solution().findMedianSortedArrays(new int[]{1, 2}, new int[]{3}));
        Assertions.assertEquals(2.5, new Solution().findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
        Assertions.assertEquals(2.5, new Solution().findMedianSortedArrays(new int[]{1, 3}, new int[]{2, 4}));
        Assertions.assertEquals(2.5, new Solution().findMedianSortedArrays(new int[]{1, 4}, new int[]{2, 3}));
        Assertions.assertEquals(3, new Solution().findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4, 5}));
        Assertions.assertEquals(3, new Solution().findMedianSortedArrays(new int[]{1, 2, 3}, new int[]{4, 5}));
        Assertions.assertEquals(3, new Solution().findMedianSortedArrays(new int[]{1, 4, 5}, new int[]{2, 3}));
        Assertions.assertEquals(3, new Solution().findMedianSortedArrays(new int[]{1, 5}, new int[]{2, 3, 4}));
        Assertions.assertEquals(3, new Solution().findMedianSortedArrays(new int[]{2}, new int[]{1, 3, 4, 5}));
    }
}