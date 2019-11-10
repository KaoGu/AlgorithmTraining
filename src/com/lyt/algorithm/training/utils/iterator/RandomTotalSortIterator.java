package com.lyt.algorithm.training.utils.iterator;

import java.util.Comparator;
import java.util.List;

public class RandomTotalSortIterator {
    private RandomSortIterator<Integer> integerRandomSortIterator;
    private final RandomTotalIterator randomTotalIterator;

    public RandomTotalSortIterator(int totalSum) {
        this.randomTotalIterator = new RandomTotalIterator(totalSum);
        this.integerRandomSortIterator = new RandomSortIterator<>(randomTotalIterator.next(), Comparator.comparingInt(o -> o));
    }

    public List<Integer> next() {
        if (null == this.integerRandomSortIterator) {
            return null;
        }
        List<Integer> integerList = this.integerRandomSortIterator.next();
        if (null != integerList && !integerList.isEmpty()) {
            return integerList;
        }
        this.integerRandomSortIterator = null;
        List<Integer> nextTotalList = randomTotalIterator.next();
        if (null == nextTotalList || nextTotalList.isEmpty()) {
            return null;
        }
        this.integerRandomSortIterator = new RandomSortIterator<>(nextTotalList, Comparator.comparingInt(o -> o));
        return this.integerRandomSortIterator.next();
    }
}
