package com.rolan.leetcode.tasks;

import com.rolan.leetcode.IEngine;

import java.text.MessageFormat;
import java.util.List;

/**
 * Created by wangyang on 2019-06-25.14:43
 */
public class Chapter155 implements IEngine {
    @Override
    public void doMath() {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        int min = minStack.getMin();// --> 返回 -3.
        minStack.pop();
        int top = minStack.top();//--> 返回 0.
        int min1 = minStack.getMin();// --> 返回 -2.

        showResultDialg(getQuestion(),"push -2 ,0,-3;getmin,pop,top,min", new StringBuffer().append(min+" ").append(top+" ").append(min1).toString());
    }

    class MinStack {
        ListNode node;
        ListNode head;
        int min = Integer.MAX_VALUE;

        /**
         * initialize your data structure here.
         */
        public MinStack() {

        }

        public void push(int x) {
            if (x < min) {
                min = x;
            }
            if (node == null) {
                node = new ListNode(x);
                head = node;
            } else {
                ListNode leaf = new ListNode(x);
                leaf.pre = node;
                node.next = leaf;
                node = leaf;
            }

        }

        public void pop() {
            if (node.pre != null) {
                ListNode pre = node.pre;
                pre.next = null;
                node.next = null;
                node.pre = null;
                node = pre;
            } else {
                node = null;
                head = null;
            }
        }

        public int top() {
            return node.value;

        }

        public int getMin() {
            if(head==null)return 0;
            int min = head.value;
            ListNode l2 = head;
            while (l2.next != null) {
                l2 = l2.next;
                if (l2.value < min) min = l2.value;
            }
            return min;
        }
    }

    /**
     * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
     * <p>
     * push(x) -- 将元素 x 推入栈中。
     * pop() -- 删除栈顶的元素。
     * top() -- 获取栈顶元素。
     * getMin() -- 检索栈中的最小元素。
     * 示例:
     * <p>
     * MinStack minStack = new MinStack();
     * minStack.push(-2);
     * minStack.push(0);
     * minStack.push(-3);
     * minStack.getMin();   --> 返回 -3.
     * minStack.pop();
     * minStack.top();      --> 返回 0.
     * minStack.getMin();   --> 返回 -2.
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/min-stack
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @return
     */
    @Override
    public String getQuestion() {
        return "最小栈";
    }
}
