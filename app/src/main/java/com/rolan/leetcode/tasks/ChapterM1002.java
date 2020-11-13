package com.rolan.leetcode.tasks;

import com.google.gson.Gson;
import com.rolan.leetcode.IEngine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Rolan on 2020/11/13.10:23
 */
public class ChapterM1002 implements IEngine {
    @Override
    public void doMath() {
        String[] input={"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = solution(input);
        showResultDialg(getQuestion(),GSON.toJson(input),GSON.toJson(result));
    }

    public List<List<String>> solution(String[] strs) {
        List<List<String>> result=new ArrayList();
        int length=strs.length;
        HashMap<String,List<String>> map=new HashMap();
        for(int i=0;i<length;i++){
            char[] arr=strs[i].toCharArray();
            Arrays.sort(arr);
            String key=new String(arr);
            if(map.containsKey(key)){
                List<String> list=map.get(key);
                list.add(strs[i]);
            }else{
                List<String> list=new ArrayList();
                list.add(strs[i]);
                map.put(key,list);
            }

        }
        for(String key:map.keySet()){
            result.add(map.get(key));
        }
        return result;
    }

    /**
     * 编写一种方法，对字符串数组进行排序，将所有变位词组合在一起。变位词是指字母相同，但排列不同的字符串。
     *
     * 注意：本题相对原题稍作修改
     *
     * 示例:
     *
     * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
     * 输出:
     * [
     *   ["ate","eat","tea"],
     *   ["nat","tan"],
     *   ["bat"]
     * ]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/group-anagrams-lcci
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @return
     */
    @Override
    public String getQuestion() {
        return "变位词组";
    }
}
