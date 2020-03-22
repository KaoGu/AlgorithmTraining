package com.lyt.algorithm.training.utils.list.iterator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class RandomTotalSortIteratorTest {

    @Test
    void next28() {
        Assertions.assertEquals(134217728, getCount(28));
    }

    @Test
    void next20() {
        Assertions.assertEquals(524288, getCount(20));
    }

    @Test
    void next5() {
        Assertions.assertEquals(16, getCount(5));
    }


    private long getCount(int totalNum) {
        long beginTime = System.currentTimeMillis();
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
        long timeMillis = System.currentTimeMillis() - beginTime;
        System.out.println("count " + count + " times " + timeMillis/1000 + "." + timeMillis%1000 + "sec");
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