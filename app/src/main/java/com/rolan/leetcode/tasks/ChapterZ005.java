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



    static void merge_sort_recursive(int[] arr, int[] result, int start, int end) {
        if (start >= end)
            return;
        int len = end - start, mid = (len >> 1) + start;
        int start1 = start, end1 = mid;
        int start2 = mid + 1, end2 = end;
        merge_sort_recursive(arr, result, start1, end1);
        merge_sort_recursive(arr, result, start2, end2);
        int k = start;
        while (start1 <= end1 && start2 <= end2)
            result[k++] = arr[start1] < arr[start2] ? arr[start1++] : arr[start2++];
        while (start1 <= end1)
            result[k++] = arr[start1++];
        while (start2 <= end2)
            result[k++] = arr[start2++];
        for (k = start; k <= end; k++)
            arr[k] = result[k];
    }

    public static void merge_sort(int[] arr) {
        int len = arr.length;
        int[] result = new int[len];
        merge_sort_recursive(arr, result, 0, len - 1);
    }

    @Override
    public String getQuestion() {
        return "归并排序";
    }
}
