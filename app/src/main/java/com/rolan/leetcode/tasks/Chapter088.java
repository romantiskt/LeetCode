package com.rolan.leetcode.tasks;

import com.rolan.leetcode.IEngine;

/**
 * Created by wangyang on 2019-07-19.11:13
 */
public class Chapter088 implements IEngine {
    @Override
    public void doMath() {
        int[] input = new int[20];
        for (int i = 2; i < 9; i++) {
            input[i - 2] = i;
        }

        int[] num2 = new int[]{4, 5, 7, 8, 9};
        String inputStr = LINE_FEED + intArrayToStr(input) + LINE_FEED + intArrayToStr(num2);
        merge(input, 7, num2, 5);
        showResultDialg(getQuestion(), inputStr, intArrayToStr(input));

    }

    /**
     * 利用num1空间>m+n的特性，将num1和num2从最大的数比较，然后从m+n-1角标开始 从后面往前重新排序数组
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int pos = m + n - 1;
        while (pos>=0&&(i >= 0 || j >= 0)) {
            int tempI = i < 0 ? Integer.MIN_VALUE : nums1[i];
            int tempJ = j < 0 ? Integer.MIN_VALUE : nums2[j];
            if (tempI == tempJ && tempI == Integer.MIN_VALUE) {
                return;
            } else if (tempI >= tempJ) {
                nums1[pos--] = tempI;
                i--;
            } else {
                nums1[pos--] = tempJ;
                j--;
            }
        }
    }

    /**
     * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
     * <p>
     * 说明:
     * <p>
     * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
     * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
     * 示例:
     * <p>
     * 输入:
     * nums1 = [1,2,3,0,0,0], m = 3
     * nums2 = [2,5,6],       n = 3
     * <p>
     * 输出: [1,2,2,3,5,6]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/merge-sorted-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @return
     */
    @Override
    public String getQuestion() {
        return "合并两个有序数组";
    }
}
