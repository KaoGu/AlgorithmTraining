package com.lyt.algorithm.training.leetcode.merge_interval;

import org.junit.jupiter.api.Assertions;

class SolutionTest {

    /**
     * 输入: [[1,3],[2,6],[8,10],[15,18]]
     * 输出: [[1,6],[8,10],[15,18]]
     * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/merge-intervals
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    @org.junit.jupiter.api.Test
    void mergeChongdie() {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] merged = new Solution().merge(intervals);
        int[][] expectMerged = {{1, 6}, {8, 10},{15,18}};
        Assertions.assertEquals(expectMerged.length, merged.length);
        for (int i = 0; i < expectMerged.length; i++) {
            Assertions.assertArrayEquals(expectMerged[i], merged[i]);
        }
    }

    /**
     * 输入: [[1,4],[4,5]]
     * 输出: [[1,5]]
     * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
     */
    @org.junit.jupiter.api.Test
    void mergeSameBian() {
        int[][] intervals = {{1, 4}, {4, 5}};
        int[][] merged = new Solution().merge(intervals);
        int[][] expectMerged = {{1, 5}};
        Assertions.assertEquals(expectMerged.length, merged.length);
        for (int i = 0; i < expectMerged.length; i++) {
            Assertions.assertArrayEquals(expectMerged[i], merged[i]);
        }
    }

}