package com.lyt.algorithm.training.leetcode.regular_expression_matching.di_gui;

class Solution {
    private int[][] resultArray;
    private char[] str;
    private char[] paternStr;

    public boolean isMatch(String s, String p) {
        if (null == p || p.isEmpty()) {
            return null == s || s.isEmpty();
        }
        if (p.charAt(0) == '*') {
            return false;
        }
        paternStr = p.toCharArray();
        if (null == s || s.isEmpty()) {
            return isEmptyPatern(paternStr, 0, paternStr.length);
        }
        resultArray = new int[s.length() + 1][p.length() + 1];
        str = s.toCharArray();
        return match(0, 0, '-');
    }

    private boolean isEmptyPatern(char[] paternStr, int beginIndex, int endIndex) {
        boolean empty = true;
        for (int i = beginIndex; i < endIndex; i++) {
            if (paternStr[i] == '*') {
                empty = true;
            } else {
                if (!empty) {
                    return false;
                }
                empty = false;
            }
        }
        return empty;
    }

    private boolean match(int strIndex, int paternIndex, char prePaternChar) {
//        System.out.println("index " + strIndex + " " + paternIndex);
        if (resultArray[strIndex][paternIndex] != 0) {
            return resultArray[strIndex][paternIndex] == 1;
        }
        boolean result = matchRun(str, strIndex, paternStr, paternIndex, prePaternChar);
        resultArray[strIndex][paternIndex] = result ? 1 : 2;
        return result;
    }

    private boolean matchRun(char[] str, int strIndex, char[] paternStr, int paternIndex, char prePaternChar) {
        if (strIndex >= str.length) {
            return isEmptyPatern(paternStr, paternIndex, paternStr.length);
        }
        if (paternIndex >= paternStr.length) {
            return false;
        }
        char charIterm = str[strIndex];
        boolean isEmpty = true;
        for (int i = paternIndex; i < paternStr.length; i++) {
            if (paternStr[i] == '*') {
                if (isEqualsChar(prePaternChar, charIterm)) {
                    if (match(strIndex + 1, i + 1, prePaternChar)
                            || match(strIndex + 1, i, prePaternChar)) {
                        return true;
                    }
                }
                isEmpty = true;
            } else {
                if (!isEmpty) {
                    return false;
                }
                prePaternChar = paternStr[i];
                if (isEqualsChar(paternStr[i], charIterm)) {
                    if (match(strIndex + 1, i + 1, prePaternChar)) {
                        return true;
                    }
                }
                isEmpty = false;
            }
        }
        return false;
    }

    private boolean isEqualsChar(char paternChar, char item) {
        return paternChar == item || paternChar == '.';
    }
}
