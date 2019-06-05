package com.rolan.leetcode.tasks;

import android.util.Log;

import com.rolan.leetcode.IEngine;

/**
 * Created by wangyang on 2019-06-04.17:21
 */
public class Chapter268 implements IEngine {

    /**
     * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数
     * <p>
     * 原理：异或运算 x^y^y=x ,  x^x=0;
     */

    public static int solution(int[] source) {
        int result = 0;
        int i;
        for (i = 0; i < source.length; i++) {
            result = result ^ source[i] ^ i;
        }
        result ^= i;//因为source是缺失了一个长度的数组，所以这里再合缺失的数字异或
        return result;
    }

    @Override
    public void doMath() {
        int[] arr = {0, 1, 2, 4, 5, 6};
        int result = solution(arr);
        Log.d("wang", String.valueOf(result));
        showResultDialg("给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数"
                , intArrayToStr(arr), String.valueOf(result));
    }

    @Override
    public String getQuestion() {
        return "给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数";
    }
}
