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
        String input = linkToStr(node);
        ListNode result = deleteDuplicates(node);
        showResultDialg(getQuestion(),input,linkToStr(result));

    }



    public ListNode deleteDuplicates(ListNode head) {
        // TODO: 2019-07-05  删除排序链表中的重复元素 II 
        return null;

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
