package com.rolan.leetcode.tasks;

import com.rolan.leetcode.IEngine;

import java.util.Hashtable;

/**
 * Created by wangyang on 2019-06-06.14:22
 */
public class Chapter146 implements IEngine {


    @Override
    public void doMath() {
        solution();

    }


    private void solution() {

        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        int result1 = cache.get(1);// 返回  1
        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        int result2 = cache.get(2);       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        int result3 = cache.get(1);       // 返回 -1 (未找到)
        int result4 = cache.get(3);       // 返回  3
        int result5 = cache.get(4);       // 返回  4

        String result = result1 + " " + result2 + " " + result3 + " " + result4 + " " + result5;

        showResultDialg(getQuestion(), "cache.put(1,1);\n" +
                "     * cache.put(2,2);\n" +
                "     * cache.get(1);       // 返回  1\n" +
                "     * cache.put(3,3);    // 该操作会使得密钥 2 作废\n" +
                "     * cache.get(2);       // 返回 -1 (未找到)\n" +
                "     * cache.put(4,4);    // 该操作会使得密钥 1 作废\n" +
                "     * cache.get(1);       // 返回 -1 (未找到)\n" +
                "     * cache.get(3);       // 返回  3\n" +
                "     * cache.get(4);       // 返回  4", result);
    }

    /**
     * LRU缓存机制
     * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
     * <p>
     * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
     * 写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间
     * 示例:
     * <p>
     * LRUCache cache = new LRUCache( 2 //缓存容量 );
     * <p>
     * cache.put(1,1);
     * cache.put(2,2);
     * cache.get(1);       // 返回  1
     * cache.put(3,3);    // 该操作会使得密钥 2 作废
     * cache.get(2);       // 返回 -1 (未找到)
     * cache.put(4,4);    // 该操作会使得密钥 1 作废
     * cache.get(1);       // 返回 -1 (未找到)
     * cache.get(3);       // 返回  3
     * cache.get(4);       // 返回  4
     */
    @Override
    public String getQuestion() {
        return "LRU缓存机制";
    }


    public static class LRUCache {
        int capacity;
        Hashtable<Integer, Node> table = new Hashtable<>();
        Link link = new Link();

        public LRUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            if (table.containsKey(key)) {
                Node node = table.get(key);
                link.moveToEnd(node);
                return node.value;
            }
            return -1;
        }

        public void put(int key, int value) {
            if (table.containsKey(key)) {
                Node node = table.get(key);
                node.value = value;
                link.moveToEnd(node);
            } else {
                Node node = new Node(key, value);
                if (this.capacity == table.size()) {
                    table.remove(link.head.key);
                    link.removeHead();
                }
                link.add(node);
                table.put(key, node);
            }
        }

        public static class Link {
            Node head;
            Node end;

            public void add(Node node) {
                if (head == null) {
                    head = node;
                    end = node;
                } else {
                    node.pre = end;
                    end.next = node;
                    end = node;

                }
            }


            public void removeHead() {
                if (head == null) return;
                if (head == end) {
                    head = null;
                    end = null;
                } else {
                    Node temp = head;
                    head = head.next;
                    head.pre = null;
                    temp.next = null;
                }

            }

            public void moveToEnd(Node node) {
                if (node == end) return;
                if (node == head) {
                    head = node.next;
                    head.pre = null;
                } else {
                    node.pre.next = node.next;
                    node.next.pre = node.pre;
                }
                end.next = node;
                node.pre = end;
                node.next = null;
                end = node;
            }
        }


        public static class Node {
            int key;
            int value;
            Node pre;
            Node next;

            public Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }
    }
}
