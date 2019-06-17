package com.rolan.leetcode.tasks;

import com.google.gson.Gson;
import com.rolan.leetcode.IEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by wangyang on 2019-06-17.18:10
 */
public class Chapter094 implements IEngine {
    @Override
    public void doMath() {
        int[] arr = new int[]{3, 9, 20, 12, 52, 15, 7};
        TreeNode root = createTree(arr);
        List<Integer> out=new ArrayList<>();
        solution2(root,out);
        showResultDialg(getQuestion(),intArrayToStr(arr),new Gson().toJson(out));
    }

    /**
     * 递归实现
     * @param root
     * @param out
     */
    private List<Integer> solution(TreeNode root, List<Integer> out) {
        if(root==null)return out;
        solution(root.left,out);
        out.add(root.val);
        solution(root.right,out);
        return out;
    }

    /**
     * 迭代实现
     * @param root
     */
    private List<Integer> solution2(TreeNode root, List<Integer> out){
        Stack<TreeNode> stack=new Stack<>();
        TreeNode current=root;
        while (current!=null||!stack.isEmpty()){
            if(current!=null){
                stack.push(current);
                current=current.left;
            }else {
                current = stack.pop();
                out.add(current.val);
                current=current.right;
            }
        }
        return out;

    }

    /**
     * 给定一个二叉树，返回它的中序 遍历。
     *
     * 示例:
     *
     * 输入: [1,null,2,3]
     *    1
     *     \
     *      2
     *     /
     *    3
     *
     * 输出: [1,3,2]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @return
     */
    @Override
    public String getQuestion() {
        return "二叉树的中序遍历";
    }
}
