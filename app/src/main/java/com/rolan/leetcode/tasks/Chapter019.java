package com.rolan.leetcode.tasks;

import com.rolan.leetcode.IEngine;

/**
 * Created by wangyang on 2019-07-05.16:43
 */
public class Chapter019 implements IEngine {
    @Override
    public void doMath() {
        ListNode randomLink = createRandomLink(10, 100);
        String input = linkToStr(randomLink);
        ListNode result = removeNthFromEnd(randomLink, 3);
        showResultDialg(getQuestion(),input,linkToStr(result));
    }

    /**
     * 第一种方法.该题可通过2次遍历来实现，第一遍得到链表的长度len,第二遍遍历到len-n初然后切断重连链表得到答案
     *
     * 第二种方法。创建两个指针。第一个纸质先遍历到n位置，然后第2个指针和第1个指针同时遍历，直到第1个指针到达末尾，第2个指针停留的位置则为需要删除的位置
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode root=new ListNode(0);
        root.next=head;
        ListNode first=root;
        ListNode second=root;
        int i=0;
        while (i++<=n){
            first=first.next;
        }
        while (first!=null){//first因为到了最后位置还是会循环一次，所以前面的循环角标是从0开始
            first=first.next;
            second=second.next;
        }
        second.next=second.next.next;

        return root.next;

    }

    /**
     * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
     *
     * 示例：
     *
     * 给定一个链表: 1->2->3->4->5, 和 n = 2.
     *
     * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
     * 说明：
     *
     * 给定的 n 保证是有效的。
     *
     * 进阶：
     *
     * 你能尝试使用一趟扫描实现吗？
     *
     *
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @return
     */
    @Override
    public String getQuestion() {
        return "删除链表的倒数第N个节点";
    }
}
