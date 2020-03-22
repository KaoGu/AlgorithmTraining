package com.lyt.algorithm.training.cbb.list.handler;

import java.util.ArrayList;
import java.util.List;

public class ListCodec {

    public String serializev1(List<Integer> list) {
        if (null == list) {
            return "";
        }
        return list.toString().replaceAll(" ", "");
    }

    public String serializev2(List<List<Integer>> list) {
        if (null == list) {
            return "";
        }
        return list.toString().replaceAll(" ", "");
    }

    public List<Integer> deserialize1v(String data) {
        if (null == data || data.isEmpty() || data.equals("null")) {
            return null;
        }
        String trimData = data.replaceAll(" ", "");
        if (trimData.isEmpty()) {
            return null;
        }
        trimData = trimData.substring(1, trimData.length() - 1);
        String[] splitArrays = trimData.split(",");
        List<Integer> resultList = new ArrayList<>(splitArrays.length);
        for (String item : splitArrays) {
            if (item.equals("null")) {
                resultList.add(null);
            } else {
                resultList.add(Integer.parseInt(item));
            }
        }
        return resultList;
    }

    public List<List<Integer>> deserialize2v(String data) {
        if (null == data || data.isEmpty() || data.equals("null")) {
            return null;
        }
        List<List<Integer>> resultList2v = new ArrayList<>();
        String trimData = data.replaceAll(" ", "");
        if (trimData.isEmpty()) {
            return null;
        }
        trimData = trimData.substring(1, trimData.length() - 1);
        while (!trimData.isEmpty()) {
            int endIndex;
            if (trimData.startsWith("[")) {
                endIndex = trimData.indexOf("]") + 1;
            } else {
                int indexSplit = trimData.indexOf(',');
                endIndex = indexSplit < 0 ? trimData.length() : indexSplit;
            }
            resultList2v.add(deserialize1v(trimData.substring(0, endIndex)));
            if (endIndex >= trimData.length()) {
                break;
            }
            trimData = trimData.substring(endIndex + 1);
        }
        return resultList2v;
    }
}
