package com.lyt.algorithm.training.leetcode.longest_valid_parentheses;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void longestValidParentheses() {
        Assertions.assertEquals(2, new Solution().longestValidParentheses("(()"));
        Assertions.assertEquals(2, new Solution().longestValidParentheses("()"));
        Assertions.assertEquals(0, new Solution().longestValidParentheses("("));
        Assertions.assertEquals(4, new Solution().longestValidParentheses(")()())"));
        Assertions.assertEquals(4, new Solution().longestValidParentheses("(()()"));
        Assertions.assertEquals(2, new Solution().longestValidParentheses("()(()"));
    }
}