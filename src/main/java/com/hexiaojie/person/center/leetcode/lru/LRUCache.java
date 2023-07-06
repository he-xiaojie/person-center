package com.hexiaojie.person.center.leetcode.lru;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private class DLinkedNode {
        public int key;
        public int value;
        public DLinkedNode prev;
        public DLinkedNode next;

        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, DLinkedNode> hashTable = new HashMap<Integer, DLinkedNode>();

    private int size;
    private int capacity;
    private DLinkedNode head;
    private DLinkedNode tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        //虚拟头节点
        this.head = new DLinkedNode(-1, -1); //guard node
        //虚拟尾节点
        this.tail = new DLinkedNode(-1, -1); //guard node
        this.head.prev = null;
        this.head.next = tail;
        this.tail.prev = head;
        this.tail.next = null;
    }

    public int get(int key) {
        if (size == 0) {
            return -1;
        }
        DLinkedNode dLinkedNode = hashTable.get(key);
        if (dLinkedNode == null) {
            return -1;
        }
        //从链表益移除元素
        removeNode(dLinkedNode);
        //放到头部
        addNodeAtHead(dLinkedNode);
        return dLinkedNode.value;
    }

    private void removeNode(int key) {
        DLinkedNode dLinkedNode = hashTable.get(key);
        if (dLinkedNode != null) {
            removeNode(dLinkedNode);
            hashTable.remove(key);
        }
    }

    private void removeNode(DLinkedNode dLinkedNode) {
        dLinkedNode.next.prev = dLinkedNode.prev;
        dLinkedNode.prev.next = dLinkedNode.next;
    }

    private void addNodeAtHead(DLinkedNode dLinkedNode){
        dLinkedNode.next = head.next;
        dLinkedNode.next.prev = dLinkedNode;
        head.next = dLinkedNode;
        dLinkedNode.prev = head;
    }

    private void put(int key, int value){
        DLinkedNode dLinkedNode = hashTable.get(key);
        if(dLinkedNode != null){
           dLinkedNode.value = value;
           removeNode(dLinkedNode);
           addNodeAtHead(dLinkedNode);
           return;
        }

        if(size == capacity){
            hashTable.remove(tail.prev.next);
            removeNode(tail.prev);
            size--;
        }
        DLinkedNode newNode = new DLinkedNode(key,value);
        addNodeAtHead(newNode);
        hashTable.put(key,newNode);
        size++;
    }

}
