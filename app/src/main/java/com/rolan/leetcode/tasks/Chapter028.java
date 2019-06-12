package com.rolan.leetcode.tasks;

import com.rolan.leetcode.IEngine;

/**
 * Created by wangyang on 2019-06-12.10:49
 */
public class Chapter028 implements IEngine {
    @Override
    public void doMath() {
        String input="hello world";
        String target="wo";
        int result = strStr(input, target);
        showResultDialg(getQuestion(),"\n"+input+"\n"+target, String.valueOf(result));
    }

    public int strStr(String haystack, String needle) {
        int targetLength=0;
        if(needle!=null)targetLength=needle.length();
        if(targetLength==0)return targetLength;
        int max=haystack.length()-targetLength;
        char first=needle.charAt(0);
        for(int i=0;i<=max;i++){
            if (haystack.charAt(i)!= first) {
                while (++i <= max && haystack.charAt(i) != first);
            }
            if (i <= max) {
                int j = i + 1;
                int end = j + targetLength - 1;
                for (int k = 1; j < end && haystack.charAt(j)
                        == needle.charAt(k); j++, k++);

                if (j == end) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * 实现 strStr() 函数。
     *
     * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
     *
     * 示例 1:
     *
     * 输入: haystack = "hello", needle = "ll"
     * 输出: 2
     * 示例 2:
     *
     * 输入: haystack = "aaaaa", needle = "bba"
     * 输出: -1
     *
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/implement-strstr
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @return
     */
    @Override
    public String getQuestion() {
        return "实现strStr()";
    }
}
