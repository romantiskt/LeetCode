package com.rolan.leetcode.tasks;

import com.rolan.leetcode.IEngine;

/**
 * Created by wangyang on 2019-07-08.15:36
 */
public class Chapter023 implements IEngine {
    @Override
    public void doMath() {
        ListNode link1 = createLink(1, 5);
        ListNode link2 = createLink(12, 20);
        ListNode link3 = createLink(8, 15);
        String input = LINE_FEED+ linkToStr(link1) + LINE_FEED+ linkToStr(link2) +LINE_FEED+ linkToStr(link3);
        ListNode[] listNodes = new ListNode[]{link1, link2, link3};
        ListNode result = mergeKLists(listNodes);
        showResultDialg(getQuestion(), input, linkToStr(result));

    }

    /**
     * 分治的思想， 先分割成两个有序链表合并，
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        if (lists.length == 1) return lists[0];
        if (lists.length == 2) return merge(lists[0], lists[1]);

        int mid = lists.length / 2;
        ListNode[] left = new ListNode[mid];
        for (int i = 0; i < mid; i++) {
            left[i] = lists[i];
        }

        ListNode[] right = new ListNode[lists.length - mid];
        for (int j = mid; j < lists.length; j++) {
            right[j - mid] = lists[j];
        }
        return merge(mergeKLists(left), mergeKLists(right));
    }

    private ListNode merge(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode root;
        if (list1.value < list2.value) {
            root = list1;
            root.next = merge(list1.next, list2);
        } else {
            root = list2;
            root.next = merge(list1, list2.next);
        }
        return root;
    }

    /**
     * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
     * <p>
     * 示例:
     * <p>
     * 输入:
     * [
     *   1->4->5,
     *   1->3->4,
     *   2->6
     * ]
     * 输出: 1->1->2->3->4->4->5->6
     * <p>
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @return
     */
    @Override
    public String getQuestion() {
        return "合并K个排序链表";
    }
}
