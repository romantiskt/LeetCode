package com.rolan.leetcode.tasks;

import com.rolan.leetcode.IEngine;

/**
 * Created by wangyang on 2019-06-25.15:40
 */
public class Chapter148 implements IEngine {
    @Override
    public void doMath() {
        // TODO: 2019-06-25 排序链表
        ListNode randomLink = createRandomLink(10, 100);
        showResultDialg(getQuestion(), linkToStr(randomLink)+"\n", linkToStr(sortList(randomLink)));
    }

    /**
     * 借鉴了网友的一个解题思想，其实这个思想简而言之就是 归并+合并两个有序的链表
     * 只是这里利用了数组很好的模拟了这个思想，这样看起来简单易懂，虽然效率并不高
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null)return head;
        ListNode[] nodes=new ListNode[64];//声明一个64的数组
        ListNode current=head;
        int maxDeep=0;
        while (current!=null){
            ListNode node=current;
            current=current.next;
            node.next=null;//从链中断开，独立为一个结点
            int i=0;
            while (nodes[i]!=null){//当
                ListNode merge = merge(nodes[i], node);
                nodes[i]=null;//把当前位置至为空，
                i++;//角标+1
                node=merge;//会跳出循环，然后把新的链表往右移动一位
            }
            nodes[i]=node;
            if(i>maxDeep){//记录以及存储到数组的第几位了
                maxDeep=i;
            }

        }

        ListNode result = null;//最后合并数组中所有的链表
        for (int i = 0; i <= maxDeep; i++) {
            if (nodes[i] != null) {
                result = merge(result, nodes[i]);
            }
        }

        return result;
    }


    /**
     * 此段代码应该要烂熟于心,合并两个有序的链表
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode current = root;
        while (l1 != null && l2 != null) {
            if (l1.value < l2.value) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;

        }
        current.next = l1 == null ? l2 : l1;
        return root.next;
    }

    /**
     * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
     * <p>
     * 示例 1:
     * <p>
     * 输入: 4->2->1->3
     * 输出: 1->2->3->4
     * 示例 2:
     * <p>
     * 输入: -1->5->3->4->0
     * 输出: -1->0->3->4->5
     * <p>
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/sort-list
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @return
     */
    @Override
    public String getQuestion() {
        return "排序链表";
    }
}
