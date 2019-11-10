package com.lyt.algorithm.training.utils.iterator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class RandomTotalIteratorTest {

    @Test
    void next30() {
        Assertions.assertEquals(5604, getCount(30));
    }

    @Test
    void next5() {
        Assertions.assertEquals(7, getCount(5));
    }

    private int getCount(int totalNum) {
        RandomTotalIterator randomTotalIterator = new RandomTotalIterator(totalNum);
        List<Integer> list = randomTotalIterator.next();
        int count = 0;
        while (null != list && !list.isEmpty()) {
            System.out.println(Arrays.toString(list.toArray()));
            int sum = getSum(list);
            Assertions.assertEquals(totalNum, sum);
            count++;
            list = randomTotalIterator.next();
        }
        System.out.println("count " + count);
        return count;
    }
    private int getSum(List<Integer> list) {
        int sum = 0;
        for (Integer item:list){
            sum+=item;
        }
        return sum;
    }
}