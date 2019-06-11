package com.rolan.leetcode.tasks;

import com.rolan.leetcode.IEngine;

/**
 * Created by wangyang on 2019-06-11.14:35
 */
public class Chapter326 implements IEngine {
    @Override
    public void doMath() {
        int[] input = new int[]{1, 9,142, 169, 507};
        int[] out = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            out[i] =solution(input[i])?1:0;
        }
        showResultDialg(getQuestion(),intArrayToStr(input),intArrayToStr(out));

    }

    private boolean solution(int n) {
        return n > 0 && Math.pow(3, 19) % n == 0;
    }

    /**
     * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。
     * <p>
     * 示例 1:
     * <p>
     * 输入: 27
     * 输出: true
     * 示例 2:
     * <p>
     * 输入: 0
     * 输出: false
     * 示例 3:
     * <p>
     * 输入: 9
     * 输出: true
     * 示例 4:
     * <p>
     * 输入: 45
     * 输出: false
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/power-of-three
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @return
     */
    @Override
    public String getQuestion() {
        return "3的幂";
    }
}
