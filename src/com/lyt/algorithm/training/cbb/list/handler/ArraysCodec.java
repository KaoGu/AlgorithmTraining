package com.lyt.algorithm.training.cbb.list.handler;

import java.util.Arrays;
import java.util.List;

public class ArraysCodec {

    public String serializev1(int[] arrays) {
        if (null == arrays) {
            return "";
        }
        return Arrays.toString(arrays).replaceAll(" ", "");
    }

    public String serializev2(int[][] array) {
        if (null == array) {
            return "";
        }
        return Arrays.deepToString(array).replaceAll(" ", "");
    }

    public int[] deserialize1v(String data) {
        List<Integer> list = new ListCodec().deserialize1v(data);
        if (null == list) {
            return null;
        }
        int[] arrays = new int[list.size()];
        initArrays(list, arrays);
        return arrays;
    }

    public int[][] deserialize2v(String data) {
        List<List<Integer>> listV2 = new ListCodec().deserialize2v(data);
        if (null == listV2) {
            return null;
        }
        int[][] arrays = new int[listV2.size()][];
        int lineIndex = -1;
        for (List<Integer> list : listV2) {
            lineIndex++;
            if (null == list) {
                continue;
            }
            arrays[lineIndex] = new int[list.size()];
            initArrays(list, arrays[lineIndex]);
        }
        return arrays;
    }

    private void initArrays(List<Integer> list, int[] array) {
        int colIndex = -1;
        for (Integer item : list) {
            ++colIndex;
            if (null == item) {
                continue;
            }
            array[colIndex] = item;
        }
    }
}
