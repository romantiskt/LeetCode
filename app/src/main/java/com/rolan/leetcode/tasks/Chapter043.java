package com.rolan.leetcode.tasks;

import com.rolan.leetcode.IEngine;

import java.math.BigInteger;

/**
 * Created by wangyang on 2019-06-14.18:01
 */
public class Chapter043 implements IEngine {
    @Override
    public void doMath() {
        String num1="123";
        String num2="456";
        String result = solution(num1, num2);
        showResultDialg(getQuestion(),LINE_FEED+num1+LINE_FEED+num2+LINE_FEED,result);
    }


    /**
     * 上一道【415】字符串累加的题与这题类似，我自己实习的比较菜，这里借鉴其他同学的答案，佩服
     *  num1的第i位(高位从0开始)和num2的第j位相乘的结果在乘积中的位置是[i+j, i+j+1]
     *         例: 123 * 45,  123的第1位 2 和45的第0位 4 乘积 08 存放在结果的第[1, 2]位中
     *           index:    0 1 2 3 4
     *
     *                         1 2 3
     *                     *     4 5
     *                     ---------
     *                           1 5
     *                         1 0
     *                       0 5
     *                     ---------
     *                       0 6 1 5
     *                         1 2
     *                       0 8
     *                     0 4
     *                     ---------
     *                     0 5 5 3 5
     *
     * @param num1
     * @param num2
     */
    private String solution(String num1, String num2) {
        if(num1==null||num2==null||num1.length()==0||num2.length()==0||num1.equals("0")||num2.equals("0"))return "0";
        int circle1=num1.length()-1;
        int circle2=num2.length()-1;

        int[] result=new int[circle1+circle2+2];
        for(int i=circle1;i>=0;i--){
            for(int j=circle2;j>=0;j--){
                int i1 = num1.charAt(i) - '0';
                int i2 = num2.charAt(j) - '0';
                int sum=i1*i2;
                sum+=result[i+j+1];
                result[i+j+1]=sum%10;
                result[i+j]+=sum/10;

            }
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i < result.length-1 && result[i] == 0)// 去掉前导0
            i++;
        for(; i < result.length; ++i)
            sb.append(result[i]);
        return sb.toString();

    }


    /**
     * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
     *
     * 示例 1:
     *
     * 输入: num1 = "2", num2 = "3"
     * 输出: "6"
     * 示例 2:
     *
     * 输入: num1 = "123", num2 = "456"
     * 输出: "56088"
     * 说明：
     *
     * num1 和 num2 的长度小于110。
     * num1 和 num2 只包含数字 0-9。
     * num1 和 num2 均不以零开头，除非是数字 0 本身。
     * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/multiply-strings
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @return
     */
    @Override
    public String getQuestion() {
        return "字符串相乘";
    }
}
