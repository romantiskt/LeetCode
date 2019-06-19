package com.rolan.leetcode.tasks;

import com.rolan.leetcode.IEngine;

/**
 * Created by wangyang on 2019-06-19.17:57
 */
public class ChapterZ007 implements IEngine {
    @Override
    public void doMath() {
        int[] input = new int[]{7, 3, 5, 10, 1, 3, 4, 4, 5, 8};
        String inputStr = intArrayToStr(input);
        solution(input);
        showResultDialg(getQuestion(),inputStr,intArrayToStr(input));
    }

    private void solution(int[] input) {
        //先找出数组最大值
        int max = input[0];
        for(int v:input){
            if(v>max)max=v;
        }

        int[] countArr=new int[max+1];//创建一个以最大值为数组长度的数组

        for(int i=0;i<input.length;i++){
            countArr[input[i]]++;//每个出现的数进行计算，
            input[i]=0;
        }
        //从新赋值
        int start=0;
        for(int j=0;j<countArr.length;j++){
            while (countArr[j]-->0){
                input[start++]=j;
            }
        }


    }

    @Override
    public String getQuestion() {
        return "计数排序";
    }
}
