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

    /**
     * 两端开始扫描，先选取一个基准值，然后从右边开始扫描，当发现一个数值小于基准值，则停下记住此角标。
     * 然后左边开始扫描，当发现一个数值大于基准值，则停下记住此角标。
     * 然后交换上面记住的角标的值。
     * 一轮循环交换后，将基准值与最后角标停留的位置的值 相交换
     *
     * 时间复杂度：
     * 最好的情况是选取的基准值每次都是中位数，这样就类似于归并排序，每个数都会被对比一次，即n次，
     * 需要经过logn次对比， 所以最好情况时时间复杂度是 nLogn
     *
     * 最坏情况是每一次选取的都是最小或者最大的数，这样相当于  n`2的时间复杂度
     * @param input
     * @param startIndex
     * @param endIndex
     * @return
     */
    private int sortByTarget(int[] input, int startIndex, int endIndex) {
        int pivot = input[startIndex];//取基准值
        int left=startIndex;
        int right=endIndex;

        while (left!=right){

            while (left<right&&input[right]>=pivot){
                right--;
            }
            while (left<right&&input[left]<=pivot){
                left++;
            }
            if(left<right){
                int temp = input[left];
                input[left]=input[right];
                input[right]=temp;
            }

        }
        input[startIndex]=input[left];
        input[left]=pivot;

        return left;
    }

    @Override
    public String getQuestion() {
        return "快速排序";
    }
}
