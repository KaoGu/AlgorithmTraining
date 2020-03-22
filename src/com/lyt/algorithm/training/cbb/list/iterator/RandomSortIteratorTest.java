package com.lyt.algorithm.training.cbb.list.iterator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class RandomSortIteratorTest {

    @Test
    void next3() {
        Integer[] integers = new Integer[]{2,1,3};
        Assertions.assertEquals(6, getCount(integers));
    }

    @Test
    void next3_1() {
        Integer[] integers = new Integer[]{1,1,3};
        Assertions.assertEquals(3, getCount(integers));
    }


    @Test
    void next5() {
        Integer[] integers = new Integer[]{2,5,1,3,4};
        Assertions.assertEquals(120, getCount(integers));
    }

    @Test
    void next5_3_1() {
        Integer[] integers = new Integer[]{1,3,1,3,5};
        Assertions.assertEquals(30, getCount(integers));
    }

    private int getCount(Integer[] integers) {
        ArrayList<Integer> integerArrayList = new ArrayList<Integer>();
        for (Integer integer:integers) {
            integerArrayList.add(integer);
        }
        RandomSortIterator<Integer> integerRandomSortIterator = new RandomSortIterator<>(integerArrayList, Comparator.comparingInt(o -> o));
        List<Integer> list = integerRandomSortIterator.next();
        int count = 0;
        while (null != list && !list.isEmpty()) {
            System.out.println(Arrays.toString(list.toArray()));
            count++;
            list = integerRandomSortIterator.next();
        }
        System.out.println("count " + count);
        return count;
    }
}