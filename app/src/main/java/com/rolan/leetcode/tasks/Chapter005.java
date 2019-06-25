package com.rolan.leetcode.tasks;

import com.rolan.leetcode.IEngine;

/**
 * Created by wangyang on 2019-06-25.10:09
 */
public class Chapter005 implements IEngine {
    @Override
    public void doMath() {
        String input = "ac";
        String out = longestPalindrome(input);
        showResultDialg(getQuestion(), input, out);
    }

    /**
     * Manacher算法，对于中心扩散法的升级版本，通过插入字符，去抽中心扩散法的奇偶性判断
     * @param s
     * @return
     */
    public String longestPalindrome2(String s) {
        // TODO: 2019-06-25  Manacher算法
        return null;
    }


    /**
     * 中心扩散法
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if(s==null||s.length()==0)return "";
        String longestStr=s.substring(0,1);//默认第一个字符串为回文字符串
        int len = s.length();
        for(int i=0;i<len;i++){
            String longestOdd = longestPalindromeOddOrEven(s, len, i, i);
            String longestEven = longestPalindromeOddOrEven(s, len, i, i + 1);
            String maxLongest=longestOdd.length()>=longestEven.length()?longestOdd:longestEven;
            if(maxLongest.length()>longestStr.length()){
                longestStr=maxLongest;
            }
        }
        return longestStr;

    }

    private String longestPalindromeOddOrEven(String s, int len, int i, int j) {
        int start=i;
        int end=j;
        while (start>=0&&end<len&&s.charAt(start)==s.charAt(end)){
            start--;
            end++;
        }
        return s.substring(start+1,end);
    }

    /**
     * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
     * <p>
     * 示例 1：
     * <p>
     * 输入: "babad"
     * 输出: "bab"
     * 注意: "aba" 也是一个有效答案。
     * 示例 2：
     * <p>
     * 输入: "cbbd"
     * 输出: "bb"
     * <p>
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @return
     */
    @Override
    public String getQuestion() {
        return "最长回文子串";
    }
}
