package com.lyt.algorithm.training.utils.tree.handler;

import com.lyt.algorithm.training.utils.tree.model.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class TreeListCodecTest {

    @Test
    void serialize() {
        Assertions.assertEquals("", new TreeListCodec().serialize(null));
        Assertions.assertEquals("[]", new TreeListCodec().serialize(new ArrayList<>()));
        List<TreeNode> nodeList = new ArrayList<>();
        nodeList.add(null);
        Assertions.assertEquals("[null]", new TreeListCodec().serialize(nodeList));
        Assertions.assertEquals("[1]", new TreeListCodec().serialize(getTreeNodes(1)));
        Assertions.assertEquals("[1,2]", new TreeListCodec().serialize(getTreeNodes(2)));
        Assertions.assertEquals("[1,2,3]", new TreeListCodec().serialize(getTreeNodes(3)));
    }

    private List<TreeNode> getTreeNodes(int lenth) {
        if (lenth < 0) {
            return null;
        }
        List<TreeNode> nodeList = new ArrayList<>(lenth);
        for (int index = 1; index <= lenth; index++) {
            nodeList.add(new TreeNode(index));
        }
        return nodeList;
    }

    @Test
    void deserialize() {
        Assertions.assertTrue(checkEquals(getTreeNodes(-1), new TreeListCodec().deserialize("")));
        Assertions.assertTrue(checkEquals(getTreeNodes(0), new TreeListCodec().deserialize("[]")));
        Assertions.assertTrue(checkEquals(getTreeNodes(1), new TreeListCodec().deserialize("[1]")));
        Assertions.assertTrue(checkEquals(getTreeNodes(2), new TreeListCodec().deserialize("[1,2]")));
        Assertions.assertTrue(checkEquals(getTreeNodes(2), new TreeListCodec().deserialize("[1,2]")));
        Assertions.assertTrue(checkEquals(getTreeNodes(3), new TreeListCodec().deserialize("[1,2,3]")));
    }

    private boolean checkEquals(List<TreeNode> expected, List<TreeNode> actual) {
        if (null == expected || actual == null) {
            return actual == expected;
        }
        if (expected.size() != actual.size()) {
            return false;
        }
        Iterator<TreeNode> expectedIterator = expected.iterator();
        Iterator<TreeNode> actualIterator = actual.iterator();
        while (expectedIterator.hasNext()) {
            TreeNode expectNext = expectedIterator.next();
            TreeNode actualNext = actualIterator.next();
            if (expectNext == null || actualNext == null) {
                Assertions.assertEquals(expectNext, actualNext);
                continue;
            }
            Assertions.assertEquals(expectNext.val, actualNext.val);
        }
        return true;
    }

    @Test
    void serializeAnddeserialize() {
        Assertions.assertEquals("", new TreeListCodec().serialize(new TreeListCodec().deserialize("")));
        Assertions.assertEquals("[]", new TreeListCodec().serialize(new TreeListCodec().deserialize("[]")));
        Assertions.assertEquals("[1]", new TreeListCodec().serialize(new TreeListCodec().deserialize("[1]")));
        Assertions.assertEquals("[1,2]", new TreeListCodec().serialize(new TreeListCodec().deserialize("[1,2]")));
        Assertions.assertEquals("[1,2,3]", new TreeListCodec().serialize(new TreeListCodec().deserialize("[1,2,3]")));
        Assertions.assertEquals("[1,2,null,3]", new TreeListCodec().serialize(new TreeListCodec().deserialize("[1,2,null,3]")));
    }
}