package com.rolan.leetcode.tasks;

import com.rolan.leetcode.IEngine;

/**
 * Created by wangyang on 2019-06-06.11:02
 */
public class Chapter237 implements IEngine {
    @Override
    public void doMath() {
        //创建链表
        int i=0;
        LinkEntity head=new LinkEntity(i);
        LinkEntity target=null;
        LinkEntity current=head;//为了保持正向链表，所以再声明一个游标
        while (i++<10){
            LinkEntity linkEntity = new LinkEntity(i);
            current.setNext(linkEntity);
            current=linkEntity;
            if(i==5){
                target=linkEntity;
            }
        }
        String input = linkToStr(head);
        solution(target);
        showResultDialg(getQuestion(),input,linkToStr(head));

    }

    /**
     * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
     * 现有一个链表 -- head = [4,5,1,9]，它可以表示为:
     *
     * 示例 1:
     *
     * 输入: head = [4,5,1,9], node = 5
     * 输出: [4,1,9]
     * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
     *
     * 此处给出的就是需要删除的节点。需要我们在链表中删除
     * @param target
     */
    private void solution(LinkEntity target) {
            target.value=target.next.value;
            target.next=target.next.next;
    }

    @Override
    public String getQuestion() {
        return "删除给定的链表中的节点";
    }
}
