package com.lyt.algorithm.training.leetcode.regular_expression_matching;

class Solution {
    private boolean[][] boolResultArray;
    private char[] str;
    private char[] paternStr;
    private char[] prePaternCharArray;

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
        boolResultArray = new boolean[s.length() + 1][p.length() + 1];
        str = s.toCharArray();
        initPreChar();

        for (int strIndex = str.length; strIndex >= 0; strIndex--) {
            boolResultArray[strIndex][paternStr.length] = false;
        }
        for (int paternIndex = paternStr.length; paternIndex >= 0; paternIndex--) {
            boolResultArray[str.length][paternIndex] = isEmptyPatern(paternStr, paternIndex, paternStr.length);
        }

        for (int strIndex = str.length - 1; strIndex >= 0; strIndex--) {
            char charIterm = str[strIndex];
            for (int paternIndex = paternStr.length - 1; paternIndex >= 0; paternIndex--) {
                char paternIterm = paternStr[paternIndex];
                if (paternIterm == '*') {
                    if (isEqualsChar(prePaternCharArray[paternIndex], charIterm)) {
                        if (boolResultArray[strIndex + 1][paternIndex + 1]
                                || boolResultArray[strIndex + 1][paternIndex]) {
                            boolResultArray[strIndex][paternIndex] = true;
                        }
                    }
                } else {
                    for (int emptyIndex = paternIndex; emptyIndex < paternStr.length; emptyIndex++) {
                        if (isEmptyPatern(paternStr, paternIndex, emptyIndex + 1) && boolResultArray[strIndex][emptyIndex]) {
                            boolResultArray[strIndex][paternIndex] = true;
                            break;
                        }
                        if (isEmptyPatern(paternStr, paternIndex, emptyIndex) && isEqualsChar(paternStr[emptyIndex], charIterm) && boolResultArray[strIndex + 1][emptyIndex + 1]) {
                            boolResultArray[strIndex][paternIndex] = true;
                            break;
                        }
                    }
                }
            }
        }
        return boolResultArray[0][0];
    }

    private void initPreChar() {
        prePaternCharArray = new char[paternStr.length];
        prePaternCharArray[0] = paternStr[0];
        for (int i = 1; i < paternStr.length; i++) {
            if (paternStr[i] == '*') {
                prePaternCharArray[i] = prePaternCharArray[i - 1];
            } else {
                prePaternCharArray[i] = paternStr[i];
            }
        }
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

    private boolean isEqualsChar(char paternChar, char item) {
        return paternChar == item || paternChar == '.';
    }
}
