package com.refs;

import java.util.*;
public class WeakHashMap {
/*
    WeakHashMap is a type of map in Java where the keys are stored as weak references.
    This means that if there are no strong references to a key object, it can be garbage collected, even if it still exists in the map.

    This differs from the regular HashMap, where the keys are stored as strong references,
    preventing the key objects from being garbage collected.
*/
    public static void main(String[] args) {

        Map<String, String> map = new java.util.WeakHashMap<>();
//        Map<String, String> map = new HashMap<>();

        String key = new String("Key");
        String value = new String("Value");
        map.put(key, value);

        System.out.println("Before GC: " + map);
        key = null;  // Remove strong reference to key

        System.gc();
        System.out.println("After GC: " + map);  // Entry may be removed
    }
}