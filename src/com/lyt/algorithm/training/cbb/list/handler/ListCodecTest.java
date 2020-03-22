package com.lyt.algorithm.training.cbb.list.handler;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListCodecTest {

    @Test
    void deserialize2v() {
        Assertions.assertEquals("[[1],[2]]", new ListCodec().serializev2(new ListCodec().deserialize2v("[[1],[2]]")));
        Assertions.assertEquals("[null,[2]]", new ListCodec().serializev2(new ListCodec().deserialize2v("[null,[2]]")));
        Assertions.assertEquals("[null,[1,null,2]]", new ListCodec().serializev2(new ListCodec().deserialize2v("[null,[1,null,2]]")));
    }

    @Test
    void deserialize1v() {
        Assertions.assertEquals("[1,2]", new ListCodec().serializev1(new ListCodec().deserialize1v("[1,2]")));
        Assertions.assertEquals("[null]", new ListCodec().serializev1(new ListCodec().deserialize1v("[null]")));
        Assertions.assertEquals("[1]", new ListCodec().serializev1(new ListCodec().deserialize1v("[1]")));
    }

}