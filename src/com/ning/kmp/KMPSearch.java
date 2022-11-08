package com.ning.kmp;

/**
 * KMP 算法
 */
public class KMPSearch {

    private static final String STRING = "ABAABABCAA";

    private static final String PATTERN = "ABABC";


    public static void main(String[] args) {
        System.out.println(kmp(STRING, PATTERN));
    }


    public static int kmp(String string, String pattern) {
        int[] next = getNext(string);
        for (int i = 1, j = 0; i < string.length(); i++) {
            while (j > 0 && string.charAt(i) != pattern.charAt(j)) {
                j = next[j - 1];
            }
            if (string.charAt(i) == pattern.charAt(j)) {
                j++;
            }
            if (j == pattern.length()) {
                return i - j + 1;
            }
        }
        return -1;
    }

    public static int[] getNext(String pattern) {
        int[] next = new int[pattern.length()];
        //i从1开始是因为，第一个字符没有前后缀，因此相同前后缀最大长度=0
        //j：当前共同前后缀长度
        for (int i = 1, j = 0; i < pattern.length(); i++) {
            //不匹配时，回溯已知信息。不断的判断是否有更小的相同前后缀子串。
            if (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = next[j - 1];
            }
            //匹配成功，共同前后缀长度+1
            if (pattern.charAt(i) == pattern.charAt(j)) {
                j++;
            }
            //记录结果
            next[i] = j;
        }
        return next;
    }


}
