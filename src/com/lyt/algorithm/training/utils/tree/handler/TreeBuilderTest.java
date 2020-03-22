package com.lyt.algorithm.training.utils.tree.handler;

import com.lyt.algorithm.training.utils.tree.iterator.TreeIterator;
import com.lyt.algorithm.training.utils.tree.model.TreeNode;
import com.lyt.algorithm.training.utils.list.iterator.RandomSortIterator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

class TreeBuilderTest {

    @Test
    void buildSortTree() {
        List<Integer> values = List.of(1, 2, 3, 4, 5);
        String valuesString = values.toString().replaceAll(" ", "");
        RandomSortIterator<Integer> integerRandomSortIterator = new RandomSortIterator<>(values, Integer::compareTo);
        List<Integer> next = integerRandomSortIterator.next();
        Set<String> treeSet = new HashSet<>();
        int count = 0;
        while (null != next && !next.isEmpty()) {
            TreeNode treeNode = new TreeBuilder().buildSortTree(next);
            String treeeSerialized = new TreeCodec().serialize(treeNode);
            if (treeSet.contains(treeeSerialized)) {
                next = integerRandomSortIterator.next();
                continue;
            }
            treeSet.add(treeeSerialized);
            System.out.println(treeeSerialized);
            List<TreeNode> treeNodes = new TreeIterator().inorderTraversal(treeNode);
            Assertions.assertEquals(valuesString, new TreeListCodec().serialize(treeNodes));
            next = integerRandomSortIterator.next();
            count++;
        }
        System.out.println("total " + count);
    }
}