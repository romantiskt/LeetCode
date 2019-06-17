package com.rolan.leetcode.tasks;

import com.google.gson.Gson;
import com.rolan.leetcode.IEngine;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by wangyang on 2019-06-17.16:48
 */
public class Chapter102 implements IEngine {
    @Override
    public void doMath() {
        int[] arr = new int[]{3, 9, 20, -1, -1, 15, 7};

        TreeNode tree = createTree(arr);

        List<List<Integer>> solution = solution(tree);
        showResultDialg(getQuestion(), intArrayToStr(arr), new Gson().toJson(solution));
    }

    private List<List<Integer>> solution(TreeNode tree) {
        return levelOrder(tree);
    }

    /**
     * 利用队列的先进先出机制来替代递归
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelList = new ArrayList<>();
        if (root == null) return levelList;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int levels = 0;
        while (!queue.isEmpty()) {
            levelList.add(new ArrayList<>());
            int listSize = queue.size();
            for (int i = 0; i < listSize; i++) {
                TreeNode node = queue.remove();
                if (node.val != null)
                    levelList.get(levels).add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            levels++;

        }
        return levelList;
    }

    /**
     * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
     * <p>
     * 例如:
     * 给定二叉树: [3,9,20,null,null,15,7],
     * <p>
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * 返回其层次遍历结果：
     * <p>
     * [
     * [3],
     * [9,20],
     * [15,7]
     * ]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @return
     */
    @Override
    public String getQuestion() {
        return "二叉树的层次遍历";
    }
}
