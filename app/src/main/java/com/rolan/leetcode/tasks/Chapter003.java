package com.rolan.leetcode.tasks;

import com.rolan.leetcode.IEngine;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by wangyang on 2019-07-12.18:02
 */
public class Chapter003 implements IEngine {
    @Override
    public void doMath() {
        String input = "abcabcbb";
        int result = lengthOfLongestSubstring(input);
        showResultDialg(getQuestion(), input, String.valueOf(result));
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null) return 0;
        int i = 0, j = 0;
        int length = s.length();
        int maxLen = 0;
        Set set = new HashSet();
        while (i < length && j < length) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                maxLen = Math.max(maxLen, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }

        return maxLen;
    }

    /**
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     * <p>
     * 示例 1:
     * <p>
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 示例 2:
     * <p>
     * 输入: "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * 示例 3:
     * <p>
     * 输入: "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @return
     */
    @Override
    public String getQuestion() {
        return "无重复字符的最长子串";
    }
}
