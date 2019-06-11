package com.rolan.leetcode.tasks;

import com.rolan.leetcode.IEngine;

/**
 * Created by wangyang on 2019-06-11.15:14
 */
public class Chapter301 implements IEngine {
    @Override
    public void doMath() {
        // TODO: 2019-06-11 有难度，以后再做
        showResultDialg(getQuestion(), "暂时还没有做这道题哦","");
    }

    /**
     * 删除最小数量的无效括号，使得输入的字符串有效，返回所有可能的结果。
     * <p>
     * 说明: 输入可能包含了除 ( 和 ) 以外的字符。
     * <p>
     * 示例 1:
     * <p>
     * 输入: "()())()"
     * 输出: ["()()()", "(())()"]
     * 示例 2:
     * <p>
     * 输入: "(a)())()"
     * 输出: ["(a)()()", "(a())()"]
     * 示例 3:
     * <p>
     * 输入: ")("
     * 输出: [""]
     * <p>
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/remove-invalid-parentheses
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @return
     */
    @Override
    public String getQuestion() {
        return "删除无效的括号";
    }
}
