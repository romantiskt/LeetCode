package com.rolan.leetcode.tasks;

import com.rolan.leetcode.IEngine;

/**
 * Created by wangyang on 2019-06-12.15:01
 */
public class ChapterZ002 implements IEngine {
    @Override
    public void doMath() {
        int[] input = new int[]{7, 3, 5, 6, 1, 3, 2, 4, 9, 8};
        String inputStr = intArrayToStr(input);
        int[] out = solution(input);
        showResultDialg(getQuestion(), inputStr, intArrayToStr(out));
    }

    private int[] solution(int[] input) {

        for (int i = 0; i < input.length; i++) {
            int min = i;
            for (int j = i + 1; j < input.length; j++) {
                if (input[min] > input[j]) {
                    min = j;
                }
            }
            int temp = input[i];
            input[i] = input[min];
            input[min] = temp;
        }
        return input;
    }

    @Override
    public String getQuestion() {
        return "选择排序";
    }
}
