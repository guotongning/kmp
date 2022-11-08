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
        int i = 0, j = 0;
        int[] next = getNext(pattern);
        while (i < string.length() && j < pattern.length()) {
            if (j == -1 || string.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j == pattern.length())
            return i - j;
        else
            return -1;
    }

    private static int[] getNext(String sub) {
        int[] next = new int[sub.length() + 1];
        int i = 0;
        int j = -1;
        next[0] = -1;
        while (i < sub.length()) {
            if (j == -1 || sub.charAt(i) == sub.charAt(j)) {
                next[++i] = ++j;
            } else {
                j = next[j];
            }
        }
        return next;
    }


}
