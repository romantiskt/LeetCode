package com.rolan.leetcode.tasks;

import com.rolan.leetcode.IEngine;

/**
 * Created by wangyang on 2019-06-05.19:02
 */
public class Chapter344 implements IEngine {


    @Override
    public void doMath() {
        char[] arr = {'a', 'd', 'i', 'd', 'a', 's','n'};
        String input = charArrayToStr(arr);
        char[] result = solution(arr);
        showResultDialg(getQuestion(), input, charArrayToStr(result));
    }

    @Override
    public String getQuestion() {
        return "编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题";
    }

    /**
     * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题
     * <p>
     * 原理：头尾开始交换数值，length单数时判断 i！=j,偶数时判断i<j;
     *
     * @return
     */
    private char[] solution(char[] arr) {
        int i = 0;
        int j = arr.length - 1;
        while (i < j && i != j) {//这里交换两个数还可以使用异或运算来进行
            char temp = arr[i];
            arr[i++] = arr[j];
            arr[j--] = temp;
        }
        return arr;
    }

}
