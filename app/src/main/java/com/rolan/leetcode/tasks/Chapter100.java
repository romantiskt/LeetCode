package com.rolan.leetcode.tasks;

import com.rolan.leetcode.IEngine;

/**
 * Created by wangyang on 2019-06-18.09:47
 */
public class Chapter100 implements IEngine {
    @Override
    public void doMath() {
        int[] arr1=new int[]{1,2,3,4,5,6};
        int[] arr2=new int[]{1,2,3,4,5,6};
        TreeNode tree1 = createTree(arr1);
        TreeNode tree2 = createTree(arr2);
        boolean result = isSameTree(tree1, tree2);
        showResultDialg(getQuestion(),LINE_FEED+intArrayToStr(arr1)+LINE_FEED+intArrayToStr(arr2)+LINE_FEED,result+"");
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&&q==null)return true;
        if(p!=null&&q!=null&&p.val==q.val){
            return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
        }else {
            return false;
        }
    }

    /**
     * 给定两个二叉树，编写一个函数来检验它们是否相同。
     *
     * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
     *
     * 示例 1:
     *
     * 输入:       1         1
     *           / \       / \
     *          2   3     2   3
     *
     *         [1,2,3],   [1,2,3]
     *
     * 输出: true
     * 示例 2:
     *
     * 输入:      1          1
     *           /           \
     *          2             2
     *
     *         [1,2],     [1,null,2]
     *
     * 输出: false
     * 示例 3:
     *
     * 输入:       1         1
     *           / \       / \
     *          2   1     1   2
     *
     *         [1,2,1],   [1,1,2]
     *
     * 输出: false
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/same-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @return
     */
    @Override
    public String getQuestion() {
        return "相同的树";
    }
}
