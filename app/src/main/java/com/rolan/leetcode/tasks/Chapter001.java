package com.rolan.leetcode.tasks;

import com.rolan.leetcode.IEngine;

import java.util.HashMap;

/**
 * Created by wangyang on 2019-06-11.11:17
 */
public class Chapter001 implements IEngine {
    @Override
    public void doMath() {
        int[] input = new int[]{1, 3, 4, 5, 6, 7, 9, 10};
        int target = 7;

        int[] result = solution(input, target);
        showResultDialg(getQuestion(), String.format("%s  target=%d", intArrayToStr(input), target),intArrayToStr(result));

    }

    private int[] solution(int[] input, int target) {
        int start = 0;
        int end = input.length;
        HashMap<Integer, Integer> map = new HashMap();
        int[] result = new int[2];
        for (; start < end; start++) {
            if (map.containsKey(target - input[start])) {
                result[0] = map.get(target - input[start]);
                result[1] = start;
                continue;
            }
            map.put(input[start], start);
        }
        return result;
    }

    /**
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     * <p>
     * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     * <p>
     * 示例:
     * <p>
     * 给定 nums = [2, 7, 11, 15], target = 9
     * <p>
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/two-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @return
     */

    @Override
    public String getQuestion() {
        return "两数之和";
    }
}
