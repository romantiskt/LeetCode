package com.rolan.leetcode.tasks;

import com.rolan.leetcode.IEngine;

/**
 * Created by wangyang on 2019-06-21.10:50
 */
public class Chapter007 implements IEngine {
    @Override
    public void doMath() {
        int input = -123;
        int result = reverse(input);
        showResultDialg(getQuestion(), String.valueOf(input), String.valueOf(result));
    }


    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int bit = x % 10;
            if (result > Integer.MAX_VALUE / 10 || result == Integer.MAX_VALUE / 10 && bit > 7) {//MAX_VALUE : 2147483647 MIN_VALUE : -2147483648
                return 0;
            } else if (result < Integer.MIN_VALUE / 10 || result == Integer.MIN_VALUE / 10 && bit <-8) {
                return 0;
            } else {
                result = result * 10 + x % 10;
                x = x / 10;
            }
        }
        return result;


    }

    /**
     * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
     * <p>
     * 示例 1:
     * <p>
     * 输入: 123
     * 输出: 321
     *  示例 2:
     * <p>
     * 输入: -123
     * 输出: -321
     * 示例 3:
     * <p>
     * 输入: 120
     * 输出: 21
     * 注意:
     * <p>
     * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/reverse-integer
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @return
     */
    @Override
    public String getQuestion() {
        return "整数反转";
    }
}
