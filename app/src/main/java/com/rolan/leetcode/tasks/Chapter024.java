package com.rolan.leetcode.tasks;

import com.rolan.leetcode.IEngine;

/**
 * Created by wangyang on 2019-07-05.17:58
 */
public class Chapter024 implements IEngine {
    @Override
    public void doMath() {
        ListNode link = createLink(0, 10);
        String input = linkToStr(link);
        ListNode node = swapPairs(link);
        showResultDialg(getQuestion(), input, linkToStr(node));
    }

    public ListNode swapPairs(ListNode head) {
        ListNode root = new ListNode(0);
        root.next = head;
        ListNode current = root;
        while (current.next != null && current.next.next != null) {
            ListNode nextLeft = current.next;
            ListNode nextRight = current.next.next;
            current.next = nextRight;
            nextLeft.next = nextRight.next;
            nextRight.next = nextLeft;
            current = nextLeft;

        }
        return root.next;
    }

    /**
     * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
     * <p>
     * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     * <p>
     *  
     * <p>
     * 示例:
     * <p>
     * 给定 1->2->3->4, 你应该返回 2->1->4->3.
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @return
     */
    @Override
    public String getQuestion() {
        return "两两交换链表中的节点";
    }
}
