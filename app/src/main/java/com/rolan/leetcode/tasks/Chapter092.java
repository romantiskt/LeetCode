package com.rolan.leetcode.tasks;

import com.rolan.leetcode.IEngine;

/**
 * Created by wangyang on 2019-07-08.16:18
 */
public class Chapter092 implements IEngine {
    @Override
    public void doMath() {
        ListNode link = createLink(3, 4);
        String input = linkToStr(link);
        ListNode result = reverseBetween(link, 1, 2);
        showResultDialg(getQuestion(), input, linkToStr(result));
    }

        public ListNode reverseBetween(ListNode head, int m, int n) {//[1，3] 1，2
        ListNode root = new ListNode(Integer.MIN_VALUE);
        root.next = head;
        ListNode left = root;
        for (int i = 1; i < m; i++) {
            left = left.next;
        }
        ListNode reveseStart=left.next;
        for(int j=m;j<n;j++){
            ListNode end = reveseStart.next;
            reveseStart.next=end.next;
            end.next=left.next;
            left.next=end;
        }
        return root.next;
    }

    /**
     * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
     * <p>
     * 说明:
     * 1 ≤ m ≤ n ≤ 链表长度。
     * <p>
     * 示例:
     * <p>
     * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
     * 输出: 1->4->3->2->5->NULL
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @return
     */
    @Override
    public String getQuestion() {
        return "反转链表 II";
    }
}
