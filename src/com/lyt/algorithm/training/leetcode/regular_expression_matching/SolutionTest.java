package com.lyt.algorithm.training.leetcode.regular_expression_matching;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void isMatch() {
        Assertions.assertFalse(new Solution().isMatch("aa", "a"));
        Assertions.assertTrue(new Solution().isMatch("aa", "a*"));
        Assertions.assertTrue(new Solution().isMatch("ab", ".*"));
        Assertions.assertTrue(new Solution().isMatch("aab", "c*a*b"));
        Assertions.assertFalse(new Solution().isMatch("mississippi", "mis*is*p*."));
        Assertions.assertTrue(new Solution().isMatch("abcb", ".*b"));
        Assertions.assertTrue(new Solution().isMatch("abcb", ".*b*b"));
        Assertions.assertTrue(new Solution().isMatch("abcb", ".*b*c."));
        Assertions.assertFalse(new Solution().isMatch("abcb", ".*b*c"));
        Assertions.assertFalse(new Solution().isMatch("aaaaaaaaaaaaab",
                "a*a*a*a*a*a*a*a*a*a*c"));
    }
}