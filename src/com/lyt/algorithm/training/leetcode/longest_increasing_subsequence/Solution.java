package com.lyt.algorithm.training.leetcode.longest_increasing_subsequence;

class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int maxLengthOflis = 1;
        int[] lengthOflis = new int[nums.length];
        lengthOflis[nums.length - 1] = 1;
        for (int index = nums.length - 2; index >= 0; index--) {
            int value = nums[index];
            int tmpMaxLengthOflis = 1;
            for (int findIndex = index + 1; findIndex < nums.length; findIndex++) {
                if (nums[findIndex] > value) {
                    if (lengthOflis[findIndex] + 1 > tmpMaxLengthOflis) {
                        tmpMaxLengthOflis = lengthOflis[findIndex] + 1;
                    }
                }
            }
            lengthOflis[index] = tmpMaxLengthOflis;
            if (tmpMaxLengthOflis > maxLengthOflis) {
                maxLengthOflis = tmpMaxLengthOflis;
            }
        }
        return maxLengthOflis;
    }
}
