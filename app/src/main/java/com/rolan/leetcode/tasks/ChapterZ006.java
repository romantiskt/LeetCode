package com.rolan.leetcode.tasks;

import com.rolan.leetcode.IEngine;

/**
 * Created by wangyang on 2019-06-19.16:42
 */
public class ChapterZ006 implements IEngine {
    @Override
    public void doMath() {
        int[] input = new int[]{7, 3, 5, 10, 1, 3, 2, 4, 9, 8};
        String inputStr = intArrayToStr(input);
        solution(input);
        showResultDialg(getQuestion(),inputStr,intArrayToStr(input));
    }

    private void solution(int[] input) {
        sort(input, 0, input.length - 1);
    }

    private void sort(int[] input, int start, int end) {
        if (start >= end) return;
        int mid = sortByTarget(input, start, end);
        sort(input, start, mid - 1);
        sort(input, mid + 1, end);
    }

    private int sortByTarget(int[] input, int startIndex, int endIndex) {
        int pivot = input[startIndex];//取基准值
        int mark = startIndex;//Mark初始化为起始下标

        for(int i=startIndex+1; i<=endIndex; i++){
            if(input[i]<pivot){
                //小于基准值 则mark+1，并交换位置。
                mark ++;
                int p = input[mark];
                input[mark] = input[i];
                input[i] = p;
            }
        }
        //基准值与mark对应元素调换位置
        input[startIndex] = input[mark];
        input[mark] = pivot;
        return mark;
    }

    @Override
    public String getQuestion() {
        return "快速排序";
    }
}
