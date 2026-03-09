package com.refs;

public class WeakReference {

/*
Weak Reference: An object with only weak references is eligible for garbage collection in the very next GC cycle,
even if there is plenty of memory available. This is useful for implementing canonicalizing mappings or data structures
like WeakHashMap, where the entry should not prevent the key from being reclaimed.
*/
    public static void main(String[] args)
    {
        // Strong Reference
        Geeks g = new Geeks();
        g.x();

        // Creating Weak Reference to Geeks-type object to which 'g' is also pointing.
        java.lang.ref.WeakReference<Geeks> weakref = new java.lang.ref.WeakReference<Geeks>(g);

        //Now, Gfg-type object to which 'g' was pointing earlier is available for garbage collection.
        //But, it will be garbage collected only when JVM needs memory.

        g = null;

        // You can retrieve back the object which has been weakly referenced.
        // It successfully calls the method.
        g = weakref.get();

        g.x();
    }

}

