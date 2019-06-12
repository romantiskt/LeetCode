package com.rolan.leetcode.tasks;

import com.rolan.leetcode.IEngine;

/**
 * Created by wangyang on 2019-06-12.16:54
 */
public class Chapter415 implements IEngine {
    @Override
    public void doMath() {
        String num1="1";
        String num2="9";
        String result = solution(num1, num2);
        showResultDialg(getQuestion(),"\n"+num1+"\n"+num2,result);

    }

    private String solution(String num1, String num2) {
        int length1 = num1.length();
        int length2 = num2.length();
        if(length1==0||length2==0)return num1+num2;
        int min=length1>length2?length2:length1;
        int start=0;
        String result = "";
        boolean isTop = false;
        while (start<min){
            int c1 = num1.charAt(length1-1-start)-'0';
            int c2 = num2.charAt(length2-1-start)-'0';
            int sum = c1 + c2;
            if(isTop){
                sum+=1;
                isTop=false;
            }
            if(sum>9){
                result=(sum-10)+result;
                isTop=true;
            }else {
                result=sum+result;
            }
            start++;
        }
        String prefix = min == length1 ? num2.substring(0, length2 - min) : num1.substring(0, length1 - min);
        if(isTop){
            prefix=solution(prefix,"1");
        }
        result=prefix+result;
        return result;

    }

    /**
     * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
     *
     * 注意：
     *
     * num1 和num2 的长度都小于 5100.
     * num1 和num2 都只包含数字 0-9.
     * num1 和num2 都不包含任何前导零。
     * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
     *
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/add-strings
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @return
     */
    @Override
    public String getQuestion() {
        return "字符串相加";
    }
}
