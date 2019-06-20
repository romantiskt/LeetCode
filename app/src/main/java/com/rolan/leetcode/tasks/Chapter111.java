package com.rolan.leetcode.tasks;

import com.rolan.leetcode.IEngine;

/**
 * Created by wangyang on 2019-06-20.15:24
 */
public class Chapter111 implements IEngine {
    @Override
    public void doMath() {
        int[] arr = new int[]{3, 9, -1};
        TreeNode tree = createTree(arr);
        int solution = solution(tree);
        showResultDialg(getQuestion(), intArrayToStr(arr), String.valueOf(solution));
    }

    private int solution(TreeNode tree) {
        return minDepth(tree);
    }

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if(root.left==null&&root.right!=null) return 1+minDepth(root.right);
        if(root.left!=null&&root.right==null) return 1+minDepth(root.left);
        return Math.min(minDepth(root.left) + 1, minDepth(root.right) + 1);
    }

    /**
     * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
     * <p>
     * 说明: 叶子节点是指没有子节点的节点。
     * <p>
     * 示例:
     * <p>
     * 给定二叉树 [3,9,20,null,null,15,7],
     * <p>
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * 返回它的最小深度  2.
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @return
     */
    @Override
    public String getQuestion() {
        return "二叉树的最小深度";
    }
}
