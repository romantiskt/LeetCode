package com.rolan.leetcode.tasks;

import com.rolan.leetcode.IEngine;

/**
 * Created by wangyang on 2019-07-08.14:52
 */
public class Chapter445 implements IEngine {
    @Override
    public void doMath() {
        ListNode node1 = createLink(1, 3);
        ListNode node2 = createLink(5, 8);
        String input = LINE_FEED + linkToStr(node1) + LINE_FEED + linkToStr(node2);
        ListNode result = addTwoNumbers(node1,node2);
        showResultDialg(getQuestion(), input, linkToStr(result));
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode reverse1 = reverse(l1);
        ListNode reverse2 = reverse(l2);
        ListNode result=new ListNode(Integer.MIN_VALUE);
        ListNode cur=result;
        int preFix=0;
        while (reverse1!=null||reverse2!=null){
            int sum=0;
            if(reverse1==null){
                sum=reverse2.value+preFix;
                reverse2=reverse2.next;
            }else if(reverse2==null){
                sum=reverse1.value+preFix;
                reverse1=reverse1.next;
            }else {
                sum=reverse1.value+reverse2.value+preFix;
                reverse2=reverse2.next;
                reverse1=reverse1.next;
            }
            preFix=sum/10;
            cur.next=new ListNode(sum%10);
            cur=cur.next;
        }
        if(preFix!=0){
            cur.next=new ListNode(preFix);
        }
        return result.next;

    }

    public ListNode reverse(ListNode node) {
        ListNode last = null;
        ListNode cur = node;
        while (cur!=null){
            ListNode next = cur.next;
            cur.next=last;
            last=cur;
            cur=next;
        }

        return last;
    }

    /**
     * 给定两个非空链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储单个数字。将这两数相加会返回一个新的链表。
     * <p>
     *  
     * <p>
     * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
     * <p>
     * 进阶:
     * <p>
     * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
     * <p>
     * 示例:
     * <p>
     * 输入: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出: 7 -> 8 -> 0 -> 7
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/add-two-numbers-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @return
     */
    @Override
    public String getQuestion() {
        return "两数相加 II";
    }
}
