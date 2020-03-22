package com.lyt.algorithm.training.cbb.list.handler;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArraysCodecTest {

    @Test
    void deserialize2v() {
        Assertions.assertEquals("[[1],[2]]", new ArraysCodec().serializev2(new ArraysCodec().deserialize2v("[[1],[2]]")));
        Assertions.assertEquals("[[0],[2]]", new ArraysCodec().serializev2(new ArraysCodec().deserialize2v("[null,[2]]")));
        Assertions.assertEquals("[[0,0,0],[1,0,2]]", new ArraysCodec().serializev2(new ArraysCodec().deserialize2v("[null,[1,null,2]]")));
    }

    @Test
    void deserialize1v() {
        Assertions.assertEquals("[1,2]", new ArraysCodec().serializev1(new ArraysCodec().deserialize1v("[1,2]")));
        Assertions.assertEquals("[0]", new ArraysCodec().serializev1(new ArraysCodec().deserialize1v("[null]")));
        Assertions.assertEquals("[1]", new ArraysCodec().serializev1(new ArraysCodec().deserialize1v("[1]")));
    }
}