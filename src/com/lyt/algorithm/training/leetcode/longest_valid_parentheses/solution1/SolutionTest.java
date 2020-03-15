package com.lyt.algorithm.training.leetcode.longest_valid_parentheses.solution1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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