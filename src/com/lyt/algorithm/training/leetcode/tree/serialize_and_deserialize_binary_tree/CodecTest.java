package com.lyt.algorithm.training.leetcode.tree.serialize_and_deserialize_binary_tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CodecTest {

    @Test
    void serialize() {
        Assertions.assertEquals("1", new Codec().serialize(new Codec().deserialize("1")));
        Assertions.assertEquals("1,2,3", new Codec().serialize(new Codec().deserialize("1,2,3")));
        Assertions.assertEquals("1,null,2,null,3", new Codec().serialize(new Codec().deserialize("1,null,2,null,3")));
    }
}