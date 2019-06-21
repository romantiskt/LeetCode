package com.rolan.leetcode.tasks;

import com.rolan.leetcode.IEngine;

/**
 * Created by wangyang on 2019-06-21.15:25
 */
public class Chapter231 implements IEngine {
    @Override
    public void doMath() {
        int input1=64;
        int input2=53;
        boolean result1 = isPowerOfTwo(input1);
        boolean result2 = isPowerOfTwo(input2);
        showResultDialg(getQuestion(),input1+"  , "+input2,result1+"  , "+result2);
    }

    public boolean isPowerOfTwo(int n) {
        return (n>0)&&(1<<30)%n==0;
    }

    /**
     * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
     *
     * 示例 1:
     *
     * 输入: 1
     * 输出: true
     * 解释: 20 = 1
     * 示例 2:
     *
     * 输入: 16
     * 输出: true
     * 解释: 24 = 16
     * 示例 3:
     *
     * 输入: 218
     * 输出: false
     *
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/power-of-two
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @return
     */
    @Override
    public String getQuestion() {
        return "2的幂";
    }
}
