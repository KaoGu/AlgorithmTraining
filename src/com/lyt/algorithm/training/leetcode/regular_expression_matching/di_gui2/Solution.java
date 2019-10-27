package com.lyt.algorithm.training.leetcode.regular_expression_matching.di_gui2;

class Solution {

    public static final int STACK_DEEP = 1000;
    /**
     * resultArray[i][j] 表示str第i个位置开始，和pattern第j个位置开始，是否匹配
     * 匹配结果，0表示未计算，1表示成功，2表示失败
     */
    private byte[][] resultArray;
    private char[] strArray;
    private char[] patternArray;

    public boolean isMatch(String text, String pattern) {
        pattern = pattern.replaceAll("\\*\\*", "*");
        resultArray = new byte[text.length() + 1][pattern.length() + 1];
        resultArray[text.length()][pattern.length()] = 1;
        strArray = text.toCharArray();
        patternArray = pattern.toCharArray();
        initResult();
        for (int strIndex = strArray.length - STACK_DEEP; strIndex > 0; strIndex -= STACK_DEEP) {
            for (int patternIndex = patternArray.length; patternIndex > 0; patternIndex -= STACK_DEEP) {
                deepMatch(strIndex, patternIndex);
            }
        }
        return deepMatch(0, 0);
    }

    private void initResult() {
        int patternIndex = patternArray.length - 1;
        for (; patternIndex > 0; patternIndex -= 2) {
            if (patternArray[patternIndex] != '*') {
                break;
            }
            resultArray[strArray.length][patternIndex] = 2;
            resultArray[strArray.length][patternIndex - 1] = 1;
        }
        while (patternIndex >= 0) {
            resultArray[strArray.length][patternIndex] = 2;
            patternIndex--;
        }
    }

    private boolean deepMatch(int strIndex, int patternIndex) {
        if (resultArray[strIndex][patternIndex] != 0) {
            return resultArray[strIndex][patternIndex] == 1;
        }
        if (patternIndex == patternArray.length) {
            boolean result = strIndex == strArray.length;
            resultArray[strIndex][patternIndex] = (byte) (result ? 1 : 2);
            return result;
        }
        boolean isMath = patternArray[patternIndex] == '.' || strArray[strIndex] == patternArray[patternIndex];
        if (((patternIndex + 1) < patternArray.length) && patternArray[patternIndex + 1] == '*') {
            isMath = deepMatch(strIndex, patternIndex + 2) || (isMath && deepMatch(strIndex + 1, patternIndex));
        } else {
            isMath = isMath && deepMatch(strIndex + 1, patternIndex + 1);
        }
        resultArray[strIndex][patternIndex] = (byte) (isMath ? 1 : 2);
        return isMath;
    }


}
