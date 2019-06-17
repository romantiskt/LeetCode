package com.rolan.leetcode.tasks;

import com.rolan.leetcode.IEngine;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangyang on 2019-06-17.10:53
 */
public class Chapter104 implements IEngine {
    @Override
    public void doMath() {
        int[] arr=new int[]{3,9,20,-1,6,15,7};

        TreeNode tree = createTree(arr);
        int result = solution(tree);
        showResultDialg(getQuestion(),intArrayToStr(arr), String.valueOf(result));

    }

    private int solution(TreeNode tree) {
        if(tree==null)return 0;
        return Math.max(solution(tree.left),solution(tree.right))+1;
    }

    /**
     * 给定一个二叉树，找出其最大深度。
     *
     * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
     *
     * 说明: 叶子节点是指没有子节点的节点。
     *
     * 示例：
     * 给定二叉树 [3,9,20,null,null,15,7]，
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回它的最大深度 3 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @return
     */
    @Override
    public String getQuestion() {
        return "二叉树的最大深度";
    }
}
