package com.lyt.algorithm.training.leetcode.longest_valid_parentheses;

class Solution {
    public int longestValidParentheses(String parentheses) {
        int maxCount = 0;
        maxCount = refreshPositive(maxCount, parentheses.toCharArray());
        maxCount = refreshReverse(maxCount, parentheses.toCharArray());
        return maxCount;
    }

    private int refreshReverse(int maxCount, char[] parenthArray) {
        int rightNum = 0;
        int leftNum = 0;
        for (int index = parenthArray.length - 1; index >= 0; index--) {
            char item = parenthArray[index];
            if (item == ')') {
                rightNum++;
                continue;
            }
            leftNum++;
            if (leftNum <= rightNum) {
                if (rightNum == leftNum) {
                    maxCount = refreshMaxCount(maxCount, leftNum);
                }
                continue;
            }
            rightNum = 0;
            leftNum = 0;
        }
        return maxCount;
    }

    private int refreshMaxCount(int maxCount, int sigleNum) {
        if (sigleNum + sigleNum > maxCount) {
            maxCount = sigleNum + sigleNum;
        }
        return maxCount;
    }

    private int refreshPositive(int maxCount, char[] parenthArray) {
        int leftNum = 0;
        int rightNum = 0;
        for (int index = 0; index < parenthArray.length; index++) {
            char item = parenthArray[index];
            if (item == '(') {
                leftNum++;
                continue;
            }
            rightNum++;
            if (rightNum <= leftNum) {
                if (rightNum == leftNum) {
                    maxCount = refreshMaxCount(maxCount, rightNum);
                }
                continue;
            }
            leftNum = 0;
            rightNum = 0;
        }
        return maxCount;
    }
}
