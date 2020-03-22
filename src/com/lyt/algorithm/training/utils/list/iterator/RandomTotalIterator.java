package com.lyt.algorithm.training.utils.list.iterator;

import java.util.ArrayList;
import java.util.List;

public class RandomTotalIterator {

    private final int totalNum;
    private List<Integer> listNum;


    public RandomTotalIterator(int totalNum) {
        this.totalNum = totalNum;
    }

    private List<Integer> init(int totalNum) {
        List<Integer> listNums = new ArrayList<>(totalNum);
        for (int index = 0; index < totalNum; index++) {
            listNums.add(1);
        }
        return listNums;
    }

    public List<Integer> next() {
        if (null == listNum) {
            listNum = init(totalNum);
            return listNum;
        }
        if (listNum.isEmpty()) {
            return listNum;
        }
        if (listNum.size() <= 1) {
            listNum.clear();
            return listNum;
        }
        int sum = listNum.get(listNum.size() - 1);
        listNum.remove(listNum.size() - 1);
        for (int index = listNum.size() - 1; index >= 0; index--) {
            Integer item = listNum.get(index);
            if (index == 0 || (listNum.get(index) < listNum.get(index - 1))) {
                listNum.set(index, item + 1);
                sum--;
                while (sum > 0) {
                    listNum.add(1);
                    sum--;
                }
                return listNum;
            }
            sum += item;
            listNum.remove(index);
        }
        return listNum;
    }


}
