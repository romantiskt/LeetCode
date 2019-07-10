package com.rolan.leetcode.tasks;

import com.rolan.leetcode.IEngine;

/**
 * Created by wangyang on 2019-07-10.10:59
 */
public class Chapter160 implements IEngine {
    @Override
    public void doMath() {
        ListNode link1 = createLink(5, 15);
        ListNode link2 = createLink(16, 22);
        String input=LINE_FEED+linkToStr(link1)+LINE_FEED+linkToStr(link2);
        ListNode intersectionNode = getIntersectionNode(link1, link2);
        showResultDialg(getQuestion(),input,linkToStr(intersectionNode));
    }

    /**
     * 可以简化为求两个相同长度的链表最后的公共链
     * 所以我们这里先要做的是让两个链表从最短的那个链的头结点开始循环
     *
     * 需要将链表切成两个长度相同的链表（下面说思路）
     * 假设链表A长度为lenA  B长度为B
     *
     * 假设短的链为B,则当B走到末尾时(走了lenB)，将他赋值为A链，此时记作A1,而此时A也走了LenB,则此时A和A1之间相差 LenB
     * 当 A走到A链末尾时，A1在离A链末尾LenB长度的位置，此时再将A赋值为B链，则就做到了抵消长度，让两个链从离末尾相同位置(lenB)处开始走动
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null)return null;
        ListNode curA=headA;
        ListNode curB=headB;
       while (curA==null||curB==null||curA.value!=curB.value){
           if(curA==null&&curB==null)break;
           curA=curA==null?headB:curA.next;
           curB=curB==null?headA:curB.next;
       }

        return curA;

    }

    /**
     * 编写一个程序，找到两个单链表相交的起始节点。
     *
     * 如下面的两个链表：
     *
     *
     *
     * 在节点 c1 开始相交。
     *
     *  
     *
     * 示例 1：
     *
     *
     *
     * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
     * 输出：Reference of the node with value = 8
     * 输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
     *  
     *
     * 示例 2：
     *
     *
     *
     * 输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
     * 输出：Reference of the node with value = 2
     * 输入解释：相交节点的值为 2 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
     *  
     *
     * 示例 3：
     *
     *
     *
     * 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
     * 输出：null
     * 输入解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
     * 解释：这两个链表不相交，因此返回 null。
     *  
     *
     * 注意：
     *
     * 如果两个链表没有交点，返回 null.
     * 在返回结果后，两个链表仍须保持原有的结构。
     * 可假定整个链表结构中没有循环。
     * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
     *
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/intersection-of-two-linked-lists
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @return
     */
    @Override
    public String getQuestion() {
        return "相交链表";
    }
}
