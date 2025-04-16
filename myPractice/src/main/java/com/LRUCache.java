package com;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

// Reference: https://www.programcreek.com/2013/03/leetcode-lru-cache-java/
/**
 * The LRU cache is a hash table of keys and double linked nodes.
 * 1 - The hash table makes the time of get() to be O(1).
 * 2 - The list of double linked nodes make the nodes adding/removal operations O(1).
 *
 */
public class LRUCache<K,V> {
    public static void main(String[] args) {
        System.out.println("KB: " + (double) (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024);
        LRUCache cache = new LRUCache<Integer, Integer>(3);
        cache.put(2,20);
        cache.put(3,30);
        cache.put(4,40);
        System.out.println("Value of key 2 is  - " + cache.get(2));
        cache.put(5,50);
        System.out.println("KB: " + (double) (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024);
        cache.print();
    }

    private Map<K, Node> map = new HashMap<>();
    private Deque<Node> deque = new LinkedList<>();
    private Integer cacheSize;

    LRUCache(Integer size){
        cacheSize = size;
    }

    public void put(K key, V value){
        Node node = new Node(key, value);
        map.put(key, node);
        deque.addFirst(node);

        if (map.size() > cacheSize) {
            // remove eldest
            Node value1 = deque.removeLast();
            map.remove(value1.key);
        }

    }

    public V get(K key){
        Node value = map.get(key);
        if(value != null) {
            Node newValue = new Node(key, value.value);
            /**
             * This is giving O(n)
             */
            deque.remove(value);
            deque.addFirst(newValue);
            map.put(key, newValue);
        }
        return value == null ? null : (V)value.value;
    }

    public void print(){
        System.out.println("Map -> ");
        map.forEach((k,v) -> System.out.println(k + " -> " + v));
        System.out.println("DLL -> ");
        deque.forEach(v -> System.out.println(v));
    }


    class Node<K,V> {
        K key;
        V value;
        Node(K key, V value){
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }
}