package com.rolan.leetcode.tasks;

import com.rolan.leetcode.IEngine;

import java.util.LinkedHashMap;

/**
 * Created by Rolan on 2020/11/4.10:24
 */
public class ChapterJ07 implements IEngine {
    @Override
    public void doMath() {
        int[] preorder={3,9,20,15,7};
        int[] inorder={9,3,15,20,7};
        TreeNode result = solution(preorder, inorder);
        String input=intArrayToStr(preorder)+"\n"+intArrayToStr(inorder);
        showResultDialg(getQuestion(),input,treeToStr(result));
    }

    public TreeNode solution(int[] preorder, int[] inorder) {
        if(preorder==null||preorder.length==0)return null;
        int length=preorder.length;
        LinkedHashMap<Integer,Integer> map=new LinkedHashMap<>();
        for (int i=0;i<length;i++){
            map.put(inorder[i],i);
        }
       return buildTree(preorder,0,length-1,inorder,0,length-1,map);
    }

    private TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, LinkedHashMap<Integer, Integer> map) {
        if(preStart>preEnd){
            return null;
        }
        int rootVal=preorder[preStart];
        TreeNode root=new TreeNode(rootVal);
        if(preStart==preEnd){
            return root;
        }else {
            Integer rootIndex = map.get(rootVal);
            int leftNode=rootIndex-inStart;
            int rightNode=inEnd-rootIndex;
            TreeNode leftTree=buildTree(preorder,preStart+1,preStart+leftNode,inorder,inStart,rootIndex-1,map);
            TreeNode rightTree=buildTree(inorder,preEnd-rightNode+1,preEnd,inorder,rootIndex+1,inEnd,map);
            root.left=leftTree;
            root.right=rightTree;
            return root;
        }
    }

    /**
     * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     *
     *  
     *
     * 例如，给出
     *
     * 前序遍历 preorder = [3,9,20,15,7]
     * 中序遍历 inorder = [9,3,15,20,7]
     * 返回如下的二叉树：
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     *  
     *
     * 限制：
     *
     * 0 <= 节点个数 <= 5000
     *
     *
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @return
     */
    @Override
    public String getQuestion() {
        return "重建二叉树";
    }
}
