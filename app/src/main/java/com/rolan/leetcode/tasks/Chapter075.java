package com.rolan.leetcode.tasks;

import com.rolan.leetcode.IEngine;

/**
 * Created by wangyang on 2019-06-11.10:48
 */
public class Chapter075 implements IEngine {
    @Override
    public void doMath() {
        int[] input=new int[]{1,2,0,2,1,1,0,1,0,0,1,0,2,1};
        String inputStr = intArrayToStr(input);
        int[] end = solution(input);
        showResultDialg(getQuestion(),inputStr,intArrayToStr(end));
    }

    private int[] solution(int[] input) {
        int start=0;
        int end=input.length;
        int i=0;
        while (i<end){
            if(input[i]==1){
                i++;
            }else if(input[i]==2){
                end--;
                int temp = input[i];
                input[i]=input[end];
                input[end]=temp;
            }else {
                int temp=input[start];
                input[start]=input[i];
                input[i]=temp;
                start++;
                i++;
            }
        }
        return input;

    }

    /**
     * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
     * <p>
     * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
     * <p>
     * 注意:
     * 不能使用代码库中的排序函数来解决这道题。
     * <p>
     * 示例:
     * <p>
     * 输入: [2,0,2,1,1,0]
     * 输出: [0,0,1,1,2,2]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/sort-colors
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @return
     */
    @Override
    public String getQuestion() {
        return "颜色分类";
    }
}
