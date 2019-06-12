package com.rolan.leetcode.tasks;

import com.rolan.leetcode.IEngine;

/**
 * Created by wangyang on 2019-06-11.16:57
 */
public class Chapter021 implements IEngine {
    @Override
    public void doMath() {
        LinkEntity link1 = createLink(0, 10);
        LinkEntity link2 = createLink(3, 9);
        String input="\n"+linkToStr(link1)+"\n \n"+linkToStr(link2);
        LinkEntity solution = solution(link1, link2);
        showResultDialg(getQuestion(),input,linkToStr(solution));

    }

    private LinkEntity solution(LinkEntity link1, LinkEntity link2) {
        if(link1==null)return link2;
        if(link2==null)return link1;

        LinkEntity head;
        if(link1.value<=link2.value){
            head=link1;
            head.next=solution(link1.next,link2);
        }else {
            head=link2;
            head.next=solution(link1,link2.next);
        }
        return head;
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
