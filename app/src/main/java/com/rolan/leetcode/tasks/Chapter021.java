package com.rolan.leetcode.tasks;

import com.rolan.leetcode.IEngine;

/**
 * Created by wangyang on 2019-06-11.16:57
 */
public class Chapter021 implements IEngine {
    @Override
    public void doMath() {
        ListNode link1 = createLink(0, 10);
        ListNode link2 = createLink(3, 9);
        String input = "\n" + linkToStr(link1) + "\n \n" + linkToStr(link2);
        ListNode solution = solution(link1, link2);
        showResultDialg(getQuestion(), input, linkToStr(solution));

    }

    private ListNode solution(ListNode link1, ListNode link2) {
        ListNode root = new ListNode(0);
        ListNode current = root;
        while (link1 != null && link2 != null) {
            if (link1.value <= link2.value) {
                current.next = link1;
                link1=link1.next;
            } else {
                current.next = link2;
                link2=link2.next;
            }
            current=current.next;
        }
        current.next = link1 == null ? link2 : link1;
        return root.next;
    }

    /**
     * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
     * <p>
     * 示例：
     * <p>
     * 输入：1->2->4, 1->3->4
     * 输出：1->1->2->3->4->4
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @return
     */
    @Override
    public String getQuestion() {
        return "合并两个有序链表";
    }
}
