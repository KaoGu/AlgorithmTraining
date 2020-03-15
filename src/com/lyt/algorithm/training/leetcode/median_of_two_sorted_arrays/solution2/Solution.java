package com.lyt.algorithm.training.leetcode.median_of_two_sorted_arrays.solution2;

class Solution {
    private int leftIndex = 0;
    private int rightIndex = 0;

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLen = nums1.length + nums2.length;
        if (totalLen == 0) {
            return 0;
        }
        if (totalLen % 2 == 0) {
            int num = getNumInSort(nums1, nums2, totalLen / 2);
            num += getNumInSort(nums1, nums2, 1);
            return num / 2.0f;
        }
        return getNumInSort(nums1, nums2, (totalLen + 1) / 2);
    }

    private int getNumInSort(int[] nums1, int[] nums2, int sortNum) {
        if (sortNum == 1) {
            return nextNum(nums1, nums2);
        }
        if (leftIndex >= nums1.length) {
            rightIndex += sortNum;
            return nums2[rightIndex - 1];
        }
        if (rightIndex >= nums2.length) {
            leftIndex += sortNum;
            return nums1[leftIndex - 1];
        }
        int mid = sortNum / 2 - 1;
        int tmpLeftIndex = nums1.length - 1;
        if (leftIndex + mid < nums1.length) {
            tmpLeftIndex = leftIndex + mid;
        }
        int tmpRightIndex = nums2.length - 1;
        if (rightIndex + mid < nums2.length) {
            tmpRightIndex = rightIndex + mid;
        }
        if (nums1[tmpLeftIndex] < nums2[tmpRightIndex]) {
            sortNum -= tmpLeftIndex + 1 - leftIndex;
            leftIndex = tmpLeftIndex + 1;
        } else {
            sortNum -= tmpRightIndex + 1 - rightIndex;
            rightIndex = tmpRightIndex + 1;
        }
        return getNumInSort(nums1, nums2, sortNum);
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
