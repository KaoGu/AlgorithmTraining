package com.lyt.algorithm.training.leetcode.redundant_connection_ii;

import com.lyt.algorithm.training.cbb.list.handler.ArraysCodec;
import com.lyt.algorithm.training.cbb.list.handler.ListCodec;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void findRedundantDirectedConnection() {
        Assertions.assertEquals("", new ArraysCodec().serializev1(new Solution().findRedundantDirectedConnection(new ArraysCodec().deserialize2v(
                "[[1,2], [1,3], [1,4], [2,5], [3,7], [4,8], [5,6], [7,9]]"))));

        Assertions.assertEquals("[1,5]", new ArraysCodec().serializev1(new Solution().findRedundantDirectedConnection(new ArraysCodec().deserialize2v(
                "[[1,2], [1,3], [1,4], [2,5], [3,7], [4,8], [5,6], [7,9],[1,5]]"))));

        Assertions.assertEquals("[6,5]", new ArraysCodec().serializev1(new Solution().findRedundantDirectedConnection(new ArraysCodec().deserialize2v(
                "[[1,2], [1,3], [1,4], [2,5], [3,7], [4,8], [5,6], [7,9],[6,5]]"))));

        Assertions.assertEquals("[3,6]", new ArraysCodec().serializev1(new Solution().findRedundantDirectedConnection(new ArraysCodec().deserialize2v(
                "[[1,2], [1,3], [1,4], [2,5], [3,7], [4,8], [5,6], [7,9],[3,6]]"))));

        Assertions.assertEquals("[9,5]", new ArraysCodec().serializev1(new Solution().findRedundantDirectedConnection(new ArraysCodec().deserialize2v(
                "[[1,2], [1,3], [1,4], [2,5], [3,7], [4,8], [5,6], [7,9],[9,5]]"))));

        Assertions.assertEquals("[9,3]", new ArraysCodec().serializev1(new Solution().findRedundantDirectedConnection(new ArraysCodec().deserialize2v(
                "[[1,2], [1,3], [1,4], [2,5], [3,7], [4,8], [5,6], [7,9],[9,3]]"))));

        Assertions.assertEquals("[8,1]", new ArraysCodec().serializev1(new Solution().findRedundantDirectedConnection(new ArraysCodec().deserialize2v(
                "[[1,2], [1,3], [1,4], [2,5], [3,7], [4,8], [5,6], [7,9],[8,1]]"))));
    }
}