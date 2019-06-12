package com.rolan.leetcode.tasks;

import com.rolan.leetcode.IEngine;

/**
 * Created by wangyang on 2019-06-12.15:14
 */
public class ChapterZ003 implements IEngine {
    @Override
    public void doMath() {
        int[] input = new int[]{7, 3, 5, 6, 1, 3, 2, 4, 9, 8};
        String inputStr = intArrayToStr(input);
        int[] out = solution(input);
        showResultDialg(getQuestion(), inputStr, intArrayToStr(out));
    }

    private int[] solution(int[] input) {
        for (int i = 1; i < input.length; i++) {
            int temp = input[i];
            int j = i - 1;
            while (j >= 0 && input[j] > temp) {
                input[j + 1] = input[j];//移动顺序
                j--;
            }
            input[j+1] = temp;//插入
        }
        return input;
    }

    @Override
    public String getQuestion() {
        return "插入排序";
    }
}
