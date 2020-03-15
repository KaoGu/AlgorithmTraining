package com.lyt.algorithm.training.leetcode.longest_valid_parentheses.solution2;

class Solution {
    public int longestValidParentheses(String parentheses) {
        int maxCount = 0;
        int[] leftFlags = new int[parentheses.length()];
        int stackIndex = 0;
        for (char item : parentheses.toCharArray()) {
            if (item == '(') {
                leftFlags[stackIndex] = 1;
                stackIndex++;
                continue;
            }
            if (stackIndex <= 0) {
                continue;
            }
            boolean flag = false;
            for (int index = stackIndex - 1; index >= 0; index--) {
                if (leftFlags[index] == 1) {
                    leftFlags[index]++;
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                maxCount = getMaxCount(maxCount, leftFlags, stackIndex);
                stackIndex = 0;
            }
        }
        maxCount = getMaxCount(maxCount, leftFlags, stackIndex);
        return maxCount;
    }

    private int getMaxCount(int maxCount, int[] stackLeft, int stackIndex) {
        int sum = 0;
        for (int index = 0; index < stackIndex; index++) {
            if (stackLeft[index] == 2) {
                sum += stackLeft[index];
                if (sum > maxCount) {
                    maxCount = sum;
                }
                continue;
            }
            sum = 0;
        }
        return maxCount;
    }

}
