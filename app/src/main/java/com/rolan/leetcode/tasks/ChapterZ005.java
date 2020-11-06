package com.rolan.leetcode.tasks;

import com.rolan.leetcode.IEngine;

/**
 * Created by wangyang on 2019-06-18.17:13
 */
public class ChapterZ005 implements IEngine {


    @Override
    public void doMath() {
        int[] input = new int[]{7, 3, 5, 6, 1, 3, 2, 4, 9, 8};
        String inputStr = intArrayToStr(input);
        int[] temp=new int[input.length];
        solution(input,0,input.length-1,temp);
        showResultDialg(getQuestion(),inputStr,intArrayToStr(input));
    }

    /**
     * 时间复杂度永远是 nLogn
     * @param input
     * @param start
     * @param end
     * @param temp
     */
    private void solution(int[] input, int start, int end, int[] temp) {
        if(start>=end)return;
        int mid=start+(end-start)/2;
        solution(input,start,mid, temp);
        solution(input,mid+1,end, temp);
        merge(input,start,mid,end,temp);

    }

    private void merge(int[] input, int start, int mid, int end,int []temp) {
        for(int i=start;i<=end;i++){//先copy到临时数组
            temp[i]=input[i];
        }
        int left=start;
        int right=mid+1;
        for(int j=start;j<=end;j++){
            if(left>mid){//为了解决两边数据长度不一样，多出来的直接放后面
                input[j]=temp[right++];
            }else if(right>end){//为了解决两边数据长度不一样，多出来的直接放后面
                input[j]=temp[left++];
            }else if(temp[left]>temp[right]){
                input[j]=temp[right++];
            }else {
                input[j]=temp[left++];
            }
        }
    }

    @Override
    public String getQuestion() {
        return "归并排序";
    }
}
