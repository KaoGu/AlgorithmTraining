package com.lyt.algorithm.training.leetcode.alien_dictionary;

import java.util.*;

public class Solution {
    public String alienOrder(String[] words) {
        if (words.length == 0) {
            return "";
        }
        Map<Character, List<Character>> smallValueListMap = new HashMap<>();
        char[] preChars = words[0].toCharArray();
        addChars(smallValueListMap, preChars);
        for (int index = 1; index < words.length; index++) {
            char[] curChars = words[index].toCharArray();
            addChars(smallValueListMap, curChars);
            for (int charIndex = 0; charIndex < preChars.length; charIndex++) {
                if (charIndex >= curChars.length) {
                    return "";
                }
                if (curChars[charIndex] != preChars[charIndex]) {
                    smallValueListMap.get(curChars[charIndex]).add(preChars[charIndex]);
                    break;
                }
            }
            preChars = curChars;
        }

        StringBuffer result = new StringBuffer();
        while (!smallValueListMap.isEmpty()) {
            Character parentKey = getParentKey(smallValueListMap);
            if (null == parentKey) {
                return "";
            }
            result.append(parentKey);
            smallValueListMap.remove(parentKey);
        }
        return result.toString();
    }

    private void addChars(Map<Character, List<Character>> parentListMap, char[] chars) {
        for (char ch : chars) {
            if (!parentListMap.containsKey(ch)) {
                parentListMap.put(ch, new LinkedList<>());
            }
        }
    }

    private String getPreWord(String[] words, int index) {
        String preWord = "";
        if (index > 0) {
            preWord = words[index - 1];
        }
        return preWord;
    }

    private String getSubstring(int indexColume, String word) {
        if (indexColume <= word.length()) {
            return word.substring(0, indexColume);
        }
        return "";
    }

    private String getCharAt(int indexColume, String word) {
        if (indexColume < word.length()) {
            return String.valueOf(word.charAt(indexColume));
        }
        return "";
    }

    private Character getParentKey(Map<Character, List<Character>> parentListMap) {
        // 找唯一无父结点的数据，或者当前的所有父结点都已经移到result中。
        for (Map.Entry<Character, List<Character>> entry : parentListMap.entrySet()) {
            if (entry.getValue().isEmpty()) {
                return entry.getKey();
            }
            boolean hasParent = false;
            for (Character parent : entry.getValue()) {
                if (parentListMap.containsKey(parent)) {
                    hasParent = true;
                    break;
                }
            }
            if (!hasParent) {
                return entry.getKey();
            }
        }
        return null;
    }
}
