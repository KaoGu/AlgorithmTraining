package com.lyt.algorithm.training.leetcode.median_of_two_sorted_arrays.solution1;

class Solution {
    private int leftIndex = 0;
    private int rightIndex = 0;

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLen = nums1.length + nums2.length;
        if (totalLen == 0) {
            return 0;
        }
        int num = 0;
        int midIndex = totalLen / 2;
        while (midIndex > 0) {
            num = nextNum(nums1, nums2);
            midIndex--;
        }
        if (totalLen % 2 == 0) {
            num += nextNum(nums1, nums2);
            return num / 2.0f;
        }
        return nextNum(nums1, nums2);
    }

    private int nextNum(int[] nums1, int[] nums2) {
        int left = Integer.MAX_VALUE;
        if (leftIndex < nums1.length) {
            left = nums1[leftIndex];
        }
        int right = Integer.MAX_VALUE;
        if (rightIndex < nums2.length) {
            right = nums2[rightIndex];
        }
        if (left < right) {
            leftIndex++;
            return left;
        } else {
            rightIndex++;
            return right;
        }
    }
}
