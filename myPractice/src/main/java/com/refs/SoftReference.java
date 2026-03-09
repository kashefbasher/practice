package com.refs;

public class SoftReference {
/*
Soft Reference: If an object is only reachable by soft references, the garbage collector
will reclaim its memory only when the Java Virtual Machine (JVM) is in danger of running out of memory.
They are suitable for implementing memory-sensitive caches, such as image caches.
*/
    public static void main(String[] args)
    {
        // Strong Reference
        Geeks g = new Geeks();
        g.x();

        // Creating Soft Reference to Gfg-type object to which 'g' is also pointing.
        java.lang.ref.SoftReference<Geeks> softref = new java.lang.ref.SoftReference<Geeks>(g);

        // Now, Gfg-type object to which 'g' was pointing earlier is available for garbage collection.
        g = null;

        // You can retrieve back the object which has been weakly referenced.
        // It successfully calls the method.
        g = softref.get();

        g.x();
    }
}