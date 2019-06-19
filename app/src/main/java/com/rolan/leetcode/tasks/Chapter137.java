package com.rolan.leetcode.tasks;

import com.rolan.leetcode.IEngine;

/**
 * Created by wangyang on 2019-06-18.18:40
 */
public class Chapter137 implements IEngine {
    @Override
    public void doMath() {
        int arr[]=new int[]{1,2,1,2,3,3,1,2,3,5};
        String input = intArrayToStr(arr);
        int result = solution(arr);
        showResultDialg(getQuestion(),input, String.valueOf(result));
    }

    private int solution(int[] arr) {
        int len=arr.length;
        int sum=0;
        for(int i=0;i<len;i++){

        }

        return 0;
    }

    /**
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
     *
     * 说明：
     *
     * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
     *
     * 示例 1:
     *
     * 输入: [2,2,3,2]
     * 输出: 3
     * 示例 2:
     *
     * 输入: [0,1,0,1,0,1,99]
     * 输出: 99
     *
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/single-number-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @return
     */
    @Override
    public String getQuestion() {
        return "只出现一次的数字 II";
    }
}
