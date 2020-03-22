package com.lyt.algorithm.training.leetcode.tree.util.iterator;

import com.lyt.algorithm.training.leetcode.tree.util.handler.TreeCodec;
import com.lyt.algorithm.training.leetcode.tree.util.handler.TreeListCodec;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreeIteratorTest {

    @Test
    void inorderTraversal() {
        Assertions.assertEquals("[]", new TreeListCodec().serialize(new TreeIterator().inorderTraversal(
                new TreeCodec().deserialize(""))));
        Assertions.assertEquals("[1]", new TreeListCodec().serialize(new TreeIterator().inorderTraversal(
                new TreeCodec().deserialize("1"))));
        Assertions.assertEquals("[1,2,3]", new TreeListCodec().serialize(new TreeIterator().inorderTraversal(
                new TreeCodec().deserialize("2,1,3"))));
        Assertions.assertEquals("[1,2,3]", new TreeListCodec().serialize(new TreeIterator().inorderTraversal(
                new TreeCodec().deserialize("1,null,2,null,3"))));
        Assertions.assertEquals("[1,2,3]", new TreeListCodec().serialize(new TreeIterator().inorderTraversal(
                new TreeCodec().deserialize("3,2,null,1"))));
        Assertions.assertEquals("[1,2]", new TreeListCodec().serialize(new TreeIterator().inorderTraversal(
                new TreeCodec().deserialize("2,1"))));
        Assertions.assertEquals("[1,2]", new TreeListCodec().serialize(new TreeIterator().inorderTraversal(
                new TreeCodec().deserialize("1,null,2"))));
    }

    @Test
    void preorderTraversal() {
        Assertions.assertEquals("[]", new TreeListCodec().serialize(new TreeIterator().preorderTraversal(
                new TreeCodec().deserialize(""))));
        Assertions.assertEquals("[1]", new TreeListCodec().serialize(new TreeIterator().preorderTraversal(
                new TreeCodec().deserialize("1"))));
        Assertions.assertEquals("[2,1,3]", new TreeListCodec().serialize(new TreeIterator().preorderTraversal(
                new TreeCodec().deserialize("2,1,3"))));
        Assertions.assertEquals("[1,2,3]", new TreeListCodec().serialize(new TreeIterator().preorderTraversal(
                new TreeCodec().deserialize("1,null,2,null,3"))));
        Assertions.assertEquals("[3,2,1]", new TreeListCodec().serialize(new TreeIterator().preorderTraversal(
                new TreeCodec().deserialize("3,2,null,1"))));
        Assertions.assertEquals("[2,1]", new TreeListCodec().serialize(new TreeIterator().preorderTraversal(
                new TreeCodec().deserialize("2,1"))));
        Assertions.assertEquals("[1,2]", new TreeListCodec().serialize(new TreeIterator().preorderTraversal(
                new TreeCodec().deserialize("1,null,2"))));
    }

    @Test
    void postorderTraversal() {
        Assertions.assertEquals("[]", new TreeListCodec().serialize(new TreeIterator().postorderTraversal(
                new TreeCodec().deserialize(""))));
        Assertions.assertEquals("[1]", new TreeListCodec().serialize(new TreeIterator().postorderTraversal(
                new TreeCodec().deserialize("1"))));
        Assertions.assertEquals("[1,3,2]", new TreeListCodec().serialize(new TreeIterator().postorderTraversal(
                new TreeCodec().deserialize("2,1,3"))));
        Assertions.assertEquals("[3,2,1]", new TreeListCodec().serialize(new TreeIterator().postorderTraversal(
                new TreeCodec().deserialize("1,null,2,null,3"))));
        Assertions.assertEquals("[1,2,3]", new TreeListCodec().serialize(new TreeIterator().postorderTraversal(
                new TreeCodec().deserialize("3,2,null,1"))));
        Assertions.assertEquals("[1,2]", new TreeListCodec().serialize(new TreeIterator().postorderTraversal(
                new TreeCodec().deserialize("2,1"))));
        Assertions.assertEquals("[2,1]", new TreeListCodec().serialize(new TreeIterator().postorderTraversal(
                new TreeCodec().deserialize("1,null,2"))));
    }


    @Test
    void levelorderTraversal() {
        Assertions.assertEquals("[]", new TreeListCodec().serialize(new TreeIterator().levelorderTraversal(
                new TreeCodec().deserialize(""))));
        Assertions.assertEquals("[1,null]", new TreeListCodec().serialize(new TreeIterator().levelorderTraversal(
                new TreeCodec().deserialize("1"))));
        Assertions.assertEquals("[2,null,1,3,null]", new TreeListCodec().serialize(new TreeIterator().levelorderTraversal(
                new TreeCodec().deserialize("2,1,3"))));
        Assertions.assertEquals("[1,null,2,null,3,null]", new TreeListCodec().serialize(new TreeIterator().levelorderTraversal(
                new TreeCodec().deserialize("1,null,2,null,3"))));
        Assertions.assertEquals("[3,null,2,null,1,null]", new TreeListCodec().serialize(new TreeIterator().levelorderTraversal(
                new TreeCodec().deserialize("3,2,null,1"))));
        Assertions.assertEquals("[2,null,1,null]", new TreeListCodec().serialize(new TreeIterator().levelorderTraversal(
                new TreeCodec().deserialize("2,1"))));
        Assertions.assertEquals("[1,null,2,null]", new TreeListCodec().serialize(new TreeIterator().levelorderTraversal(
                new TreeCodec().deserialize("1,null,2"))));
    }
}