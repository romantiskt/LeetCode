package com.rolan.leetcode.tasks;

import com.rolan.leetcode.IEngine;

/**
 * Created by Rolan on 2020/10/21.18:36
 */
public class Chapter374 implements IEngine {
    public final int target = 80;

    @Override
    public void doMath() {
        int n=100,num=target;
        String input="n:"+n+" num:"+num;
        int result = solution(n);

        showResultDialg(getQuestion(),input, String.valueOf(result));
    }

    private int solution(int n) {
        int start=1,end=n,mid=0;
        while (start<=end){
            mid=start+(end-start)/2;
            switch (guess(mid)){
                case -1:
                    end=mid-1;
                    break;
                case 1:
                    start=mid+1;
                    break;
                case 0:
                    return mid;
            }
        }
        return mid;
    }

    public int guess(int num) {
        if (num>target){
            return -1;
        }else if(num<target){
            return 1;
        }else {
            return 0;
        }
    }

    /**
     * 猜数字游戏的规则如下：
     * <p>
     * 每轮游戏，我都会从 1 到 n 随机选择一个数字。 请你猜选出的是哪个数字。
     * 如果你猜错了，我会告诉你，你猜测的数字比我选出的数字是大了还是小了。
     * 你可以通过调用一个预先定义好的接口 int guess(int num) 来获取猜测结果，返回值一共有 3 种可能的情况（-1，1 或 0）：
     * <p>
     * -1：我选出的数字比你猜的数字小 pick < num
     * 1：我选出的数字比你猜的数字大 pick > num
     * 0：我选出的数字和你猜的数字一样。恭喜！你猜对了！pick == num
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：n = 10, pick = 6
     * 输出：6
     * 示例 2：
     * <p>
     * 输入：n = 1, pick = 1
     * 输出：1
     * 示例 3：
     * <p>
     * 输入：n = 2, pick = 1
     * 输出：1
     * 示例 4：
     * <p>
     * 输入：n = 2, pick = 2
     * 输出：2
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/guess-number-higher-or-lower
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @return
     */
    @Override
    public String getQuestion() {
        return "猜数字";
    }
}
