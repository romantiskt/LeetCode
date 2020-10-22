package com.rolan.leetcode.tasks;

import com.google.gson.Gson;
import com.rolan.leetcode.IEngine;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Rolan on 2020/10/21.19:01
 */
public class Chapter310 implements IEngine {
    @Override
    public void doMath() {
        String input="n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]";
        int n=6;
        int[][] edges={{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}};
        List<Integer> solution = solution(n, edges);
        showResultDialg(getQuestion(),input,new Gson().toJson(solution));
    }

    /**
     * 核心思想就是剥洋葱的做法，或者是剪树枝的做法，总是从最外层开始剥，
     * 这里也是一样，我们先从外面出度为1的开始循环，每一次循环之后把最外层的舍弃，开始往里面找，
     * 理论上来说，最理想的结果是二分或者高位数，所以结果只可能有一个或者两个
     * @param n
     * @param edges
     * @return
     */
    private List<Integer> solution(int n, int[][] edges) {
        List<Integer> result=new ArrayList<>();
        if (n==1){//如果节点为1则就是结果
            result.add(0);
            return result;
        }
        int [] indexed=new int[n];
        List<List<Integer>> map=new ArrayList<>();
        for (int i=0;i<n;i++){//先填好容器，保存每个节点相邻的节点
            map.add(new ArrayList<>());
        }
        for (int[] item:edges){
            indexed[item[0]]++;//节点的出度
            indexed[item[1]]++;
            map.get(item[0]).add(item[1]);//保存相邻的节点
            map.get(item[1]).add(item[0]);
        }
        Queue<Integer> queue=new LinkedList();
        for (int i=0;i<indexed.length;i++){
            if (indexed[i]==1){//从外面开始，先将节点为1的入队列，
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()){
            result=new ArrayList<>();
            int size = queue.size();
            for (int i=0;i<size;i++){
                Integer poll = queue.poll();
                result.add(poll);
                List<Integer> integers = map.get(poll);
                for (int item:integers){
                    indexed[item]--;
                    if(indexed[item]==1){
                        queue.offer(item);
                    }
                }
            }
        }
        return result;

    }

    /**
     * 对于一个具有树特征的无向图，我们可选择任何一个节点作为根。图因此可以成为树，在所有可能的树中，具有最小高度的树被称为最小高度树。给出这样的一个图，写出一个函数找到所有的最小高度树并返回他们的根节点。
     *
     * 格式
     *
     * 该图包含 n 个节点，标记为 0 到 n - 1。给定数字 n 和一个无向边 edges 列表（每一个边都是一对标签）。
     *
     * 你可以假设没有重复的边会出现在 edges 中。由于所有的边都是无向边， [0, 1]和 [1, 0] 是相同的，因此不会同时出现在 edges 里。
     *
     * 示例 1:
     *
     * 输入: n = 4, edges = [[1, 0], [1, 2], [1, 3]]
     *
     *         0
     *         |
     *         1
     *        / \
     *       2   3 
     *
     * 输出: [1]
     * 示例 2:
     *
     * 输入: n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]
     *
     *      0  1  2
     *       \ | /
     *         3
     *         |
     *         4
     *         |
     *         5 
     *
     * 输出: [3, 4]
     * 说明:
     *
     *  根据树的定义，树是一个无向图，其中任何两个顶点只通过一条路径连接。 换句话说，一个任何没有简单环路的连通图都是一棵树。
     * 树的高度是指根节点和叶子节点之间最长向下路径上边的数量。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/minimum-height-trees
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @return
     */
    @Override
    public String getQuestion() {
        return "最小高度树";
    }
}
