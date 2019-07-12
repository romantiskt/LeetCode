package com.rolan.leetcode.tasks;

import com.rolan.leetcode.IEngine;

/**
 * Created by wangyang on 2019-07-12.17:34
 */
public class Chapter234 implements IEngine {
    @Override
    public void doMath() {
        ListNode link = createLink(7, 12);
        String input =linkToStr(link);
        showResultDialg(getQuestion(),input, String.valueOf(isPalindrome(link)));
    }

    public boolean isPalindrome(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        ListNode last=null;
        while (fast!=null&&fast.next!=null){//快慢指针，快指针走完则慢指针刚好走一半
            fast=fast.next.next;
            ListNode next = slow.next;
            slow.next=last;
            last=slow;
            slow=next;
        }
        if(fast!=null){//链数目为奇数  否则为偶数(如果是偶数，则快指针最后肯定会为null，如果是奇数，则快指针最后会停留在末尾)
            ListNode left=new ListNode(slow.value);
            left.next=last;
            last=left;
        }
        while (last!=null&&slow!=null){
            if(last.value!=slow.value)return false;
            last=last.next;
            slow=slow.next;
        }
        if(last==null&&slow==null)return true;
        return false;
    }
    /**
     * 请判断一个链表是否为回文链表。
     *
     * 示例 1:
     *
     * 输入: 1->2
     * 输出: false
     * 示例 2:
     *
     * 输入: 1->2->2->1   1->2->5->2->1
     * 输出: true
     * 进阶：
     * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/palindrome-linked-list
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @return
     */
    @Override
    public String getQuestion() {
        return "回文链表";
    }
}
