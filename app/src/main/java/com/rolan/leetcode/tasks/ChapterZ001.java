package com.rolan.leetcode.tasks;

import com.rolan.leetcode.IEngine;

/**
 * Created by wangyang on 2019-06-12.14:33
 */
public class ChapterZ001 implements IEngine {
    @Override
    public void doMath() {
        int[] input=new int[]{7,3,5,6,1,3,2,4,9,8};
        String inputStr = intArrayToStr(input);
        int[] out = solution(input);
        showResultDialg(getQuestion(),inputStr,intArrayToStr(out));
    }

    /**
     * 时间复杂度 O(n2)
     * @param input
     * @return
     */
    private int[] solution(int[] input) {
        for (int i=0;i<input.length;i++){
            for(int j=0;j<input.length-1-i;j++){
                if(input[j]>input[j+1]){
                    int temp=input[j];
                    input[j]=input[j+1];
                    input[j+1]=temp;
                }
            }
        }
        return input;
    }

    /**
     * 冒泡优化
     * 设置一个标志位，来第一遍循环可得出数组是否已经有序
     * @param input
     * @return
     */
    private int[] solution2(int[] input) {
        for (int i=0;i<input.length;i++){
            boolean isSort=false;
            for(int j=0;j<input.length-1-i;j++){
                if(input[j]>input[j+1]){
                    isSort=true;
                    int temp=input[j];
                    input[j]=input[j+1];
                    input[j+1]=temp;
                }
            }
            if(!isSort)return input;
        }
        return input;
    }

    /**
     * 从左至右比较相邻两数大小，然后根据大小交换两数位置
     * @return
     */
    @Override
    public String getQuestion() {
        return "冒泡排序";
    }
}
