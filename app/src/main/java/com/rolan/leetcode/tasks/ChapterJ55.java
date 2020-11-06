package com.rolan.leetcode.tasks;

import com.rolan.leetcode.IEngine;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Rolan on 2020/11/4.17:21
 */
public class ChapterJ55 implements IEngine {
    @Override
    public void doMath() {
        int arr[]={1,2,3,4,5,6,7,8};
        TreeNode tree = createTree(arr);
        int result = solution1(tree);

        showResultDialg(getQuestion(),intArrayToStr(arr),String.valueOf(result));
    }

    /**
     * 递归
     * @param tree
     * @return
     */
    private int solution1(TreeNode tree) {
        if(tree==null)return 0;
        return Math.max(solution1(tree.left),solution1(tree.right))+1;
    }

    /**
     * 非递归
     * @param root
     * @return
     */
    private int solution2(TreeNode root) {
        if(root==null)return 0;
        Queue<TreeNode> queue=new LinkedList();
        queue.add(root);
        int result=0;
        while (!queue.isEmpty()){
            result++;
            int size = queue.size();
            for (int i=0;i<size;i++){
                TreeNode poll = queue.poll();
                if(poll.left!=null) queue.add(poll.left);
                if (poll.right!=null) queue.add(poll.right);
            }
        }
        return result;

    }

    /**
     * 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
     *
     * 例如：
     *
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
     * 链接：https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @return
     */
    @Override
    public String getQuestion() {
        return "二叉树的深度";
    }
}
