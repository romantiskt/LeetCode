package com.rolan.leetcode.tasks;

import com.rolan.leetcode.IEngine;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangyang on 2019-06-28.17:02
 */
public class Chapter078 implements IEngine {
    @Override
    public void doMath() {
        int[] input = new int[]{1, 2, 3, 4, 5};
        List<List<Integer>> subsets = subsets(input);
        showResultDialg(getQuestion(), intArrayToStr(input), toJson(subsets));
    }

    /**
     * 每新增一个数 则与前面所有的数组成新的子集
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            subsets(result, nums[i],result.size());
        }
        result.add(0,new ArrayList<>());
        return result;
    }

    private void subsets(List<List<Integer>> result, int num,int length) {
        for (int j = 0; j <length; j++) {
            List<Integer> integers=new ArrayList<>(result.get(j));
            integers.add(num);
            result.add(integers);
        }
        List<Integer> sub = new ArrayList<>();
        sub.add(num);
        result.add(sub);
    }

    /**
     * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
     * <p>
     * 说明：解集不能包含重复的子集。
     * <p>
     * 示例:
     * <p>
     * 输入: nums = [1,2,3]
     * 输出:
     * [
     * [3],
     *   [1],
     *   [2],
     *   [1,2,3],
     *   [1,3],
     *   [2,3],
     *   [1,2],
     *   []
     * ]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/subsets
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @return
     */
    @Override
    public String getQuestion() {
        return "子集";
    }
}
