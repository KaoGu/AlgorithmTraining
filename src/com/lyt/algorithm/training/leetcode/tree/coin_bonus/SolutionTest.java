package com.lyt.algorithm.training.leetcode.tree.coin_bonus;

import com.lyt.algorithm.training.cbb.list.handler.ArraysCodec;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void bonus() {
        Assertions.assertEquals("[650,665]", new ArraysCodec().serializev1(new Solution().bonus(
                6, new ArraysCodec().deserialize2v("[[1, 2], [1, 6], [2, 3], [2, 5], [1, 4]]"),
                new ArraysCodec().deserialize2v("[[1, 1, 500], [2, 2, 50], [3, 1], [2, 6, 15], [3, 1]]")
        )));
    }
}