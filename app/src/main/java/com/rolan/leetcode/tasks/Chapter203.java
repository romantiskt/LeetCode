package com.rolan.leetcode.tasks;

import com.rolan.leetcode.IEngine;

/**
 * Created by wangyang on 2019-06-05.19:35
 */
public class Chapter203 implements IEngine {


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


        ListNode result = solution(head, 6);
        showResultDialg(getQuestion(), input, linkToStr(result));
    }


    private ListNode solution(ListNode head, int i) {
        ListNode virtual = new ListNode(-100000);//新添加一个头结点，防止给出的数在链表头部的情况
        virtual.next = head;
        ListNode current = virtual;
        while (current.next != null) {
            if (current.next.value == i) {
                ListNode next = current.next;
                current.next = next.next;
                next = null;
            } else {
                current = current.next;
            }
        }
        ListNode result = virtual.next;
        virtual = null;
        return result;
    }

    /**
     * 删除链表中等于给定值 val 的所有节点。
     * <p>
     * 示例:
     * <p>
     * 输入: 1->2->6->3->4->5->6, val = 6
     * 输出: 1->2->3->4->5
     */
    @Override
    public String getQuestion() {
        return "删除链表中等于给定值 val 的所有节点。";
    }

}
