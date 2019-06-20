package com.rolan.leetcode.tasks;

import com.rolan.leetcode.IEngine;

/**
 * Created by wangyang on 2019-06-20.15:58
 */
public class Chapter002 implements IEngine {
    @Override
    public void doMath() {
        ListNode link1 = createLink(1, 5);//12345
        ListNode link2 = createLink(2, 3);//23
        String input="\n"+linkToStr(link1)+"\n"+linkToStr(link2);
        ListNode resultListNode = addTwoNumbers(link1, link2, 0);
        showResultDialg(getQuestion(),input,linkToStr(resultListNode));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2, int pre) {
        int sum;
        if(l1!=null&&l2!=null){
            sum=l1.value+l2.value;
        }else if(l1==null&&l2!=null){
            sum=l2.value;
        }else if(l2==null&&l1!=null){
            sum=l1.value;
        }else {
            return null;
        }
        ListNode node=new ListNode((sum+pre)%10);
        pre=(sum+pre)/10;
        node.next=addTwoNumbers(l1==null?null:l1.next, l2==null?null:l2.next, pre);
        if(node.next==null&&pre!=0){
            node.next=new ListNode(pre);
        }
        return node;
    }
    /**
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     *
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     *
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     *
     * 示例：
     *
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/add-two-numbers
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @return
     */
    @Override
    public String getQuestion() {
        return "两数相加";
    }
}
