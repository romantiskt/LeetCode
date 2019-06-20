package com.rolan.leetcode.tasks;

import com.rolan.leetcode.IEngine;

/**
 * Created by wangyang on 2019-06-06.16:31
 */
public class Chapter206 implements IEngine {
    @Override
    public void doMath() {
        //创建链表
        int i = 0;
        ListNode head = new ListNode(i);
        ListNode current = head;//为了保持正向链表，所以再声明一个游标
        while (i++ < 10) {
            ListNode listNode = new ListNode(i);
            current.setNext(listNode);
            current = listNode;
        }
        String input = linkToStr(head);

        ListNode result = solution(head);
        showResultDialg(getQuestion(), input, linkToStr(result));


    }

    private ListNode solution(ListNode head) {
        ListNode current = new ListNode(head.value);
        current.next = null;
        ListNode lastEntity = current;
        while (head.next != null) {
            ListNode entity = new ListNode(head.next.value);
            entity.next = lastEntity;
            lastEntity = entity;
            head = head.next;
        }
        return lastEntity;
    }

    /**
     * 反转一个单链表。
     * <p>
     * 示例:
     * <p>
     * 输入: 1->2->3->4->5->NULL
     * 输出: 5->4->3->2->1->NULL
     *
     * @return
     */
    @Override
    public String getQuestion() {
        return "反转链表";
    }
}
