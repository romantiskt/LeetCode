package com.rolan.leetcode.tasks;

import com.rolan.leetcode.IEngine;

/**
 * Created by wangyang on 2019-06-17.15:25
 */
public class Chapter108 implements IEngine {
    @Override
    public void doMath() {
        int[] arr=new int[]{3,9,20,4,6,15,7};
        TreeNode root = solution(arr, 0, arr.length - 1);
        showResultDialg(getQuestion(),intArrayToStr(arr),"暂时不支持树的输出");
    }

    private TreeNode solution(int[] arr,int start,int end) {
        if(arr==null)return null;
        if(start>end)return null;
        int mid = (start + end) / 2;
        TreeNode node=new TreeNode(arr[mid]);
        node.left=solution(arr,start,mid-1);
        node.right=solution(arr,mid+1,end);
        return node;

    }

    /**
     * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
     *
     * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
     *
     * 示例:
     *
     * 给定有序数组: [-10,-3,0,5,9],
     *
     * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
     *
     *       0
     *      / \
     *    -3   9
     *    /   /
     *  -10  5
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @return
     */
    @Override
    public String getQuestion() {
        return "将有序数组转换为二叉搜索树";
    }
}
