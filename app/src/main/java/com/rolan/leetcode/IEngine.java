package com.rolan.leetcode;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

/**
 * Created by wangyang on 2019-06-05.18:05
 */
public interface IEngine {
    Context context = null;

    void doMath();

    String getQuestion();

    default void showResultDialog(String content) {
        Activity activity = App.activities.firstElement();
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        View inflate = View.inflate(activity, R.layout.dialog_container, null);
        TextView textView = inflate.findViewById(R.id.tv_content);
        textView.setText(content);
        builder.setView(inflate);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    default void showResultDialg(String solution, String input, String output) {
        StringBuffer buffer = new StringBuffer();
        buffer.append("【题干】: ");
        buffer.append(solution);
        buffer.append("\n");
        buffer.append("\n");
        buffer.append(String.format("【输入】: %s\n", input));
        buffer.append("\n");
        buffer.append(String.format("【输出】: %s\n", output));
        showResultDialog(buffer.toString());
    }

    default String intArrayToStr(int[] arr,int start,int end){
        StringBuffer buffer = new StringBuffer();
        int pos = start;
        while (pos <= end) {
            if (pos == end) {
                buffer.append(arr[pos++]);
            } else {
                buffer.append(String.format("%d、", arr[pos++]));
            }
        }
        return buffer.toString();
    }
    default String intArrayToStr(int[] arr) {
        return intArrayToStr(arr,0,arr.length-1);
    }

    default String charArrayToStr(char[] arr) {
        StringBuffer buffer = new StringBuffer();
        int pos = 0;
        while (pos < arr.length) {
            if (pos + 1 == arr.length) {
                buffer.append(arr[pos++]);
            } else {
                buffer.append(String.format("%c、", arr[pos++]));
            }
        }
        return buffer.toString();
    }

    default String treeToStr(TreeNode root) {
        List<List<Integer>> levelList = new ArrayList<>();
        if (root == null) return "";
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int levels = 0;
        while (!queue.isEmpty()) {
            levelList.add(new ArrayList<>());
            int listSize = queue.size();
            for (int i = 0; i < listSize; i++) {
                TreeNode node = queue.remove();
                if (node.val != null)
                    levelList.get(levels).add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            levels++;

        }
        return new Gson().toJson(levelList);
    }

    default String toJson(Object ob){
        return new Gson().toJson(ob);
    }

    default String linkToStr(ListNode entity) {
        StringBuffer buffer = new StringBuffer();
        ListNode current = new ListNode(entity.value);
        current.next = entity.next;
        while (current.next != null) {
            buffer.append(current.value + "、");
            current = current.next;
        }
        buffer.append(current.value);
        return buffer.toString();
    }

    default ListNode createLink(int start, int end) {
        int i = start;
        ListNode head = new ListNode(i);
        ListNode current = head;//为了保持正向链表，所以再声明一个游标
        while (i++ < end) {
            ListNode listNode = new ListNode(i);
            current.setNext(listNode);
            current = listNode;
        }
        return head;
    }

    default ListNode createRandomLink(int size,int max) {
        int i = 0;
        ListNode head = new ListNode(i);
        ListNode current = head;//为了保持正向链表，所以再声明一个游标
        while (i++ < size) {
            ListNode listNode = new ListNode(new Random().nextInt(max));
            current.setNext(listNode);
            current = listNode;
        }
        return head;
    }

    default TreeNode createTree(int[] array) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        for (int i = 0; i < array.length; i++) {
            if(array[i]==-1){
                list.add(new TreeNode(null));
                continue;
            }
            TreeNode node = new TreeNode(array[i], null, null);    //创建结点，每一个结点的左结点和右结点为null
            list.add(node); // list中存着每一个结点
        }
        // 构建二叉树
        if (list.size() > 0) {
            for (int i = 0; i < array.length / 2 - 1; i++) {       // i表示的是根节点的索引，从0开始
                if (list.get(2 * i + 1) != null) {
                    // 左结点
                    list.get(i).left = list.get(2 * i + 1);
                }
                if (list.get(2 * i + 2) != null) {
                    // 右结点
                    list.get(i).right = list.get(2 * i + 2);
                }
            }
            // 判断最后一个根结点：因为最后一个根结点可能没有右结点，所以单独拿出来处理
            int lastIndex = array.length / 2 - 1;
            // 左结点
            list.get(lastIndex).left = list.get(lastIndex * 2 + 1);
            // 右结点，如果数组的长度为奇数才有右结点
            if (array.length % 2 == 1) {
                list.get(lastIndex).right = list.get(lastIndex * 2 + 2);
            }
        }
        return list.get(0);
    }

    /**
     * 链表
     */
    class ListNode {
        public int value;
        public ListNode next;
        public ListNode pre;

        public ListNode(int value) {
            this.value = value;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }
    }

    /**
     * 树
     */
    class TreeNode {
        public Integer val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public TreeNode(Integer x) {
            this.val = x;
        }
    }
}
