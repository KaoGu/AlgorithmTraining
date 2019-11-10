package com.lyt.algorithm.training.utils.iterator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class RandomTotalSortIteratorTest {

    @Test
    void next20() {
        Assertions.assertEquals(524288, getCount(20));
    }

    @Test
    void next5() {
        Assertions.assertEquals(16, getCount(5));
    }


    private long getCount(int totalNum) {
        RandomTotalSortIterator randomTotalSortIterator = new RandomTotalSortIterator(totalNum);
        List<Integer> list = randomTotalSortIterator.next();
        long count = 0;
        while (null != list && !list.isEmpty()) {
//            System.out.println(Arrays.toString(list.toArray()));
            int sum = getSum(list);
            Assertions.assertEquals(totalNum, sum);
            count++;
            list = randomTotalSortIterator.next();
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