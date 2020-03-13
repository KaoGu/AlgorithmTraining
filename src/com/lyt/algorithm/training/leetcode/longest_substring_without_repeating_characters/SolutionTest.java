package com.lyt.algorithm.training.leetcode.longest_substring_without_repeating_characters;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void lengthOfLongestSubstring() {
        Assertions.assertEquals(3, new Solution().lengthOfLongestSubstring("abcabcbb"));
        Assertions.assertEquals(1, new Solution().lengthOfLongestSubstring("bbbbb"));
        Assertions.assertEquals(3, new Solution().lengthOfLongestSubstring("pwwkew"));
        Assertions.assertEquals(2, new Solution().lengthOfLongestSubstring("cdd"));
    }
}