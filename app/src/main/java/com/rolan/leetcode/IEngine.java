package com.rolan.leetcode;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

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

    default String intArrayToStr(int[] arr) {
        StringBuffer buffer = new StringBuffer();
        int pos = 0;
        while (pos < arr.length) {
            if (pos + 1 == arr.length) {
                buffer.append(arr[pos++]);
            } else {
                buffer.append(String.format("%d、", arr[pos++]));
            }
        }
        return buffer.toString();
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

    default String linkToStr(LinkEntity entity) {
        StringBuffer buffer = new StringBuffer();
        LinkEntity current = new LinkEntity(entity.value);
        current.next = entity.next;
        while (current.next != null) {
            buffer.append(current.value + "、");
            current = current.next;
        }
        buffer.append(current.value);
        return buffer.toString();
    }

    default LinkEntity createLink(int start, int size) {
        int i = start;
        LinkEntity head = new LinkEntity(i);
        LinkEntity current = head;//为了保持正向链表，所以再声明一个游标
        while (i++ < size) {
            LinkEntity linkEntity = new LinkEntity(i);
            current.setNext(linkEntity);
            current = linkEntity;
        }
        return head;
    }

    default TreeNode createTree(int[] array) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        for (int i = 0; i < array.length; i++) {
            if(array[i]==-1)list.add(null);
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
    class LinkEntity {
        public int value;
        public LinkEntity next;
        public LinkEntity pre;

        public LinkEntity(int value) {
            this.value = value;
        }

        public LinkEntity getNext() {
            return next;
        }

        public void setNext(LinkEntity next) {
            this.next = next;
        }
    }

    /**
     * 树
     */
    class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public TreeNode(int x) {
            this.val = x;
        }
    }
}
