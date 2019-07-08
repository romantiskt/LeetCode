package com.rolan.leetcode.tasks;

import com.rolan.leetcode.IEngine;

/**
 * Created by wangyang on 2019-07-08.09:30
 */
public class Chapter147 implements IEngine {
    @Override
    public void doMath() {
        ListNode randomLink = createRandomLink(10, 100);
        String input = linkToStr(randomLink);
        showResultDialg(getQuestion(), input, linkToStr(insertionSortList(randomLink)));
    }


    public ListNode insertionSortList(ListNode head) {
        if(head==null)return null;
        ListNode root = new ListNode(Integer.MIN_VALUE);
        ListNode cur = head.next;
        head.next=null;
        root.next = head;
        while (cur != null) {
            ListNode node=cur;
            ListNode next = cur.next;
            node.next=null;
            inserToLink(root, node);
            cur = next;
        }


        return root.next;
    }

    private void inserToLink(ListNode root, ListNode target) {
        ListNode cur = root;
        while (cur.next != null) {
            if (cur.next.value >= target.value) {
                ListNode next = cur.next;
                cur.next = target;
                target.next = next;
                return;
            }
            cur = cur.next;
        }
        target.next=null;
        cur.next=target;
    }

    /**
     * 对链表进行插入排序。
     * <p>
     * <p>
     * 插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
     * 每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
     * <p>
     *  
     * <p>
     * 插入排序算法：
     * <p>
     * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
     * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
     * 重复直到所有输入数据插入完为止。
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入: 4->2->1->3
     * 输出: 1->2->3->4
     * 示例 2：
     * <p>
     * 输入: -1->5->3->4->0
     * 输出: -1->0->3->4->5
     * <p>
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/insertion-sort-list
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @return
     */
    @Override
    public String getQuestion() {
        return "对链表进行插入排序";
    }
}
