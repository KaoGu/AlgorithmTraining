package com.lyt.algorithm.training.leetcode.longest_substring_without_repeating_characters;

import java.util.Arrays;

class Solution {
    public int lengthOfLongestSubstring(String str) {
        if (null == str) {
            return 0;
        }
        byte[] bytes = str.getBytes();
        int[] flags = new int[260];
        int maxLength = 0;
        int startIndex = 0;
        while (startIndex + maxLength < bytes.length) {
            Arrays.fill(flags, -1);
            int index = startIndex;
            while (index < bytes.length) {
                int flagIndex = bytes[index] + 128;
                if (flags[flagIndex] >= 0) {
                    // 发现重复元素
                    maxLength = Math.max(maxLength, index - startIndex);
                    startIndex = flags[flagIndex] + 1;
                    break;
                }
                flags[flagIndex] = index;
                index++;
            }
            if (index >= bytes.length) {
                maxLength = Math.max(maxLength, bytes.length - startIndex);
                break;
            }
        }
        return maxLength;
    }
}
