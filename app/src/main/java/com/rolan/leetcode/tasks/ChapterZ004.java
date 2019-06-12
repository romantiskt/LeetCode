package com.rolan.leetcode.tasks;

import com.rolan.leetcode.IEngine;

/**
 * Created by wangyang on 2019-06-12.16:16
 */
public class ChapterZ004 implements IEngine {
    @Override
    public void doMath() {
        int[] input = new int[]{7, 3, 5, 6, 1, 3, 2, 4, 9, 8};
        String inputStr = intArrayToStr(input);
        int[] out = solution(input);
        showResultDialg(getQuestion(), inputStr, intArrayToStr(out));
    }

    /**
     * 希尔排序就是 插入排序的优化版本 当希尔排序的区间==1时就是插入排序
     * @param input
     * @return
     */
    private int[] solution(int[] input) {
        int cap=1;
        while (cap<input.length){
            cap=cap*3+1;
        }
        while (cap>0){

            for(int i=cap;i<input.length;i++){
                int temp=input[i];
                int j=i-cap;
                while (j>=0&&input[j]>temp){
                    input[j+cap]=input[j];
                    j-=cap;
                }
                input[j+cap]=temp;
            }
            cap=cap/3;
        }
        return input;
    }

    @Override
    public String getQuestion() {
        return "希尔排序";
    }
}
