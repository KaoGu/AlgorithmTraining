package com.lyt.algorithm.training.utils.iterator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RandomSortIterator<T> {
    private List<T> iteratorList;
    private Comparator<? super T> comparable;

    public boolean hasInit;

    public RandomSortIterator(List<T> iteratorList, Comparator<? super T> comparable) {
        this.iteratorList = new ArrayList<>(iteratorList);
        this.comparable = comparable;
    }

    public List<T> next() {
        if (!hasInit) {
            hasInit = true;
            iteratorList.sort(comparable);
            return iteratorList;
        }
        int leftIndex = iteratorList.size() - 2;
        while (leftIndex >= 0) {
            if (comparable.compare(iteratorList.get(leftIndex), iteratorList.get(leftIndex + 1)) < 0) {
                break;
            }
            leftIndex--;
        }
        if (leftIndex < 0) {
            return null;
        }
        T leftItem = iteratorList.get(leftIndex);
        int rightIndex = iteratorList.size() - 1;
        while (rightIndex > leftIndex) {
            if (comparable.compare(leftItem, iteratorList.get(rightIndex)) < 0) {
                break;
            }
            rightIndex--;
        }
        swap(leftIndex, rightIndex);

        leftIndex++;
        rightIndex = iteratorList.size() - 1;
        while (leftIndex < rightIndex) {
            swap(leftIndex, rightIndex);
            leftIndex++;
            rightIndex--;
        }
        return iteratorList;
    }

    private void swap(int leftIndex, int rightIndex) {
        T leftTmp = iteratorList.get(leftIndex);
        iteratorList.set(leftIndex, iteratorList.get(rightIndex));
        iteratorList.set(rightIndex, leftTmp);
    }

}
