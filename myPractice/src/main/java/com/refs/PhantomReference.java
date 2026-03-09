package com.refs;

public class PhantomReference {

/*
The objects which are being referenced by phantom references are eligible for garbage collection.
But, before removing them from the memory, JVM puts them in a queue called ‘reference queue’ .
They are put in a reference queue after calling finalize() method on them.To create such references
java.lang.ref.PhantomReference class is used.

Phantom Reference: This is the weakest type of reference. An object is phantom-reachable after it has been finalized but
before its memory has been reclaimed. Phantom references cannot be used to retrieve the object (their get() method always
returns null), but they are used with a ReferenceQueue to schedule pre-mortem cleanup actions more safely and flexibly
than the finalize() method.
*/
    public static void main(String[] args)
    {
        //Strong Reference
        Geeks g = new Geeks();
        g.x();

        //Creating reference queue
        java.lang.ref.ReferenceQueue<Geeks> refQueue = new java.lang.ref.ReferenceQueue<Geeks>();

        //Creating Phantom Reference to Geeks-type object to which 'g' is also pointing.
        java.lang.ref.PhantomReference<Geeks> phantomRef = new java.lang.ref.PhantomReference<Geeks>(g,refQueue);

        //Now, Geeks-type object to which 'g' was pointing earlier is available for garbage collection.
        //But, this object is kept in 'refQueue' before removing it from the memory.
        g = null;

        //It always returns null.
        g = phantomRef.get();

        //It shows NullPointerException.
        g.x();
    }
}