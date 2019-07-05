package com.rolan.leetcode.tasks;

import com.rolan.leetcode.IEngine;

/**
 * Created by wangyang on 2019-07-05.19:50
 */
public class Chapter083 implements IEngine {
    @Override
    public void doMath() {
        ListNode link = createLink(0, 10);
        ListNode node = new ListNode(0);
        node.next = link;
        String input = linkToStr(node);
        ListNode result = deleteDuplicates(node);
        showResultDialg(getQuestion(), input, linkToStr(result));

    }


    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
                if(current.value==current.next.value){
                    current.next=current.next.next;
                }else {
                    current=current.next;
                }
        }
        return head;
    }

    /**
     * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
     * <p>
     * 示例 1:
     * <p>
     * 输入: 1->1->2
     * 输出: 1->2
     * 示例 2:
     * <p>
     * 输入: 1->1->2->3->3
     * 输出: 1->2->3
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @return
     */
    @Override
    public String getQuestion() {
        return "删除排序链表中的重复元素";
    }
}
