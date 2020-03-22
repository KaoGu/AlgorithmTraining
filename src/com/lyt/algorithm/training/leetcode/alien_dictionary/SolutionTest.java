package com.lyt.algorithm.training.leetcode.alien_dictionary;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void alienOrder() {

        Assertions.assertEquals("abzc", new Solution().alienOrder(new String[]{
                "za", "zb", "ca", "cb"}));

        Assertions.assertEquals("z", new Solution().alienOrder(new String[]{
                "z", "z"}));

        Assertions.assertEquals("", new Solution().alienOrder(new String[]{
                "abc", "ab"}));



        Assertions.assertEquals("abc", new Solution().alienOrder(new String[]{
                "a", "b", "c"}));

        Assertions.assertEquals("wertf", new Solution().alienOrder(new String[]{
                "wrt", "wrf", "er", "ett", "rftt"}));

        Assertions.assertEquals("zx", new Solution().alienOrder(new String[]{
                "z", "x"}));

        Assertions.assertEquals("", new Solution().alienOrder(new String[]{
                "z", "x", "z"}));
    }
}