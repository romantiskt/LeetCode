package com.rolan.leetcode.tasks;

import com.rolan.leetcode.IEngine;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by wangyang on 2019-07-15.17:47
 */
public class Chapter046 implements IEngine {
    @Override
    public void doMath() {
        int[] input=new int[]{1,2,3};
        List<List<Integer>> permute = permute(input);
        showResultDialg(getQuestion(),intArrayToStr(input),toJson(permute));

    }


    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        int[] visited=new int[nums.length];
        iterat(nums,result,visited,new LinkedList<Integer>());
        return result;
    }

    /**
     * 回溯法：
     * 此问题可以转化为求 数根节点到叶子节点的路径
     *         /   1,2,3   \
     *       /              \
     *      1，      2，      3
     *     /\       /\       /\
     *    2  3     1  3     1  2
     *   /    \   /    \   /    \
     *  3      2 3      1 2      1
     * @param nums
     * @param result
     * @param visited
     * @param temp
     */
    private void iterat(int[] nums, List<List<Integer>> result, int[] visited, LinkedList<Integer> temp) {
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1) continue;
            visited[i] = 1;
            temp.addLast(nums[i]);
            iterat(nums,result,  visited,temp);
            visited[i] = 0;//递归结束，即一轮路径结束则将标志位初始化为初始状态
            temp.removeLast();//递归结束，移除temp数组添加的
        }

    }

    /**
     * 给定一个没有重复数字的序列，返回其所有可能的全排列。
     *
     * 示例:
     *
     * 输入: [1,2,3]
     * 输出:
     * [
     *   [1,2,3],
     *   [1,3,2],
     *   [2,1,3],
     *   [2,3,1],
     *   [3,1,2],
     *   [3,2,1]
     * ]
     *
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/permutations
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @return
     */
    @Override
    public String getQuestion() {
        return "全排列";
    }
}
