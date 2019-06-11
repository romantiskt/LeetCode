package com.rolan.leetcode.tasks;

import com.rolan.leetcode.IEngine;

import java.util.Stack;

/**
 * Created by wangyang on 2019-06-11.16:26
 */
public class Chapter020 implements IEngine {
    @Override
    public void doMath() {
        String input = "[";
        boolean solution = solution(input);
        showResultDialg(getQuestion(), input, solution ? "true" : "false");
    }

    private boolean solution(String input) {
        int i = 0;
        Stack<Character> stack = new Stack<>();
        while (i < input.length()) {
            char c = input.charAt(i++);
            if ('[' == c || '{' == c || '(' == c) {
                stack.push(c);
            } else {
                if(stack.isEmpty())return false;
                Character pop = stack.pop();
                if (pop == '[' && c == ']'
                        || pop == '{' && c == '}'
                        || pop == '(' && c == ')') {
                    continue;
                } else return false;
            }

        }
        return stack.empty();
    }

    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     * <p>
     * 有效字符串需满足：
     * <p>
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 注意空字符串可被认为是有效字符串。
     * <p>
     * 示例 1:
     * <p>
     * 输入: "()"
     * 输出: true
     * 示例 2:
     * <p>
     * 输入: "()[]{}"
     * 输出: true
     * 示例 3:
     * <p>
     * 输入: "(]"
     * 输出: false
     * 示例 4:
     * <p>
     * 输入: "([)]"
     * 输出: false
     * 示例 5:
     * <p>
     * 输入: "{[]}"
     * 输出: true
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/valid-parentheses
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @return
     */
    @Override
    public String getQuestion() {
        return "有效的括号";
    }
}
