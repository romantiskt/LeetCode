package com.rolan.leetcode.tasks;

import com.rolan.leetcode.IEngine;

/**
 * Created by wangyang on 2019-07-15.17:08
 */
public class Chapter033 implements IEngine {
    @Override
    public void doMath() {
        int[] input = new int[]{5,1,3};
        int result = search(input, 5);
        showResultDialg(getQuestion(), intArrayToStr(input), String.valueOf(result));
    }


    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < nums[end]) {//中点落在旋转点的后半段
                if (nums[mid] < target&&target<=nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }

            } else {//中点落在了被旋转的前半段
                if ((nums[start] <= target) && (target < nums[mid])) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }

            }
        }
        return -1;
    }


    /**
     * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
     * <p>
     * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
     * <p>
     * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
     * <p>
     * 你可以假设数组中不存在重复的元素。
     * <p>
     * 你的算法时间复杂度必须是 O(log n) 级别。
     * <p>
     * 示例 1:
     * <p>
     * 输入: nums = [4,5,6,7,0,1,2], target = 0
     * 输出: 4
     * 示例 2:
     * <p>
     * 输入: nums = [4,5,6,7,0,1,2], target = 3
     * 输出: -1
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @return
     */
    @Override
    public String getQuestion() {
        return "搜索旋转排序数组";
    }
}
