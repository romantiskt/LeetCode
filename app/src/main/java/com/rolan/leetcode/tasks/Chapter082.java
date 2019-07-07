package com.rolan.leetcode.tasks;

import com.rolan.leetcode.IEngine;

/**
 * Created by wangyang on 2019-07-05.20:10
 */
public class Chapter082 implements IEngine {
    @Override
    public void doMath() {
        ListNode link = createLink(0, 10);
        ListNode node = new ListNode(0);
        node.next = link;
        ListNode root = new ListNode(0);
        root.next = node;

        String input = linkToStr(root);
        ListNode result = deleteDuplicates(root);
        showResultDialg(getQuestion(),input,linkToStr(result));

    }


    /**
     * 巧用快慢指针来进行比较
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode root=new ListNode(Integer.MIN_VALUE);
        root.next=head;
       ListNode slow=root;
       ListNode fast=root.next;
       while (fast!=null){
           while (fast.next!=null&&fast.value==fast.next.value)fast=fast.next;
           if(slow.next==fast){
               slow=slow.next;
           }else {
               slow.next=fast.next;
           }
           fast=fast.next;
       }
        return root.next;

    }

    /**
     * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
     *
     * 示例 1:
     *
     * 输入: 1->2->3->3->4->4->5
     * 输出: 1->2->5
     * 示例 2:
     *
     * 输入: 1->1->1->2->3
     * 输出: 2->3
     *
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @return
     */
    @Override
    public String getQuestion() {
        return "删除排序链表中的重复元素 II";
    }
}
