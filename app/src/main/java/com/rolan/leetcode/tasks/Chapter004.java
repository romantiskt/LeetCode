package com.rolan.leetcode.tasks;

import com.rolan.leetcode.IEngine;

/**
 * Created by wangyang on 2019-06-20.16:46
 */
public class Chapter004 implements IEngine {
    @Override
    public void doMath() {
        int[] num1=new int[]{1,2};
        int[] num2=new int[]{3,4};

        String input="\n"+intArrayToStr(num1)+"\n"+intArrayToStr(num2);
        double medianSortedArrays = findMedianSortedArrays(num1, num2);
        showResultDialg(getQuestion(),input, "这题有点难，先放着");
    }


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // TODO: 2019-06-20  寻找两个有序数组的中位数
        return 0;
    }

    /**
     * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
     *
     * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
     *
     * 你可以假设 nums1 和 nums2 不会同时为空。
     *
     * 示例 1:
     *
     * nums1 = [1, 3]
     * nums2 = [2]
     *
     * 则中位数是 2.0
     * 示例 2:
     *
     * nums1 = [1, 2]
     * nums2 = [3, 4]
     *
     * 则中位数是 (2 + 3)/2 = 2.5
     *
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @return
     */
    @Override
    public String getQuestion() {
        return "寻找两个有序数组的中位数";
    }
}
