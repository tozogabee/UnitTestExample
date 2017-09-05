package com.test;

public class ParentClass {

    private ChildClass child;

    public ParentClass(ChildClass child) {
        this.child = child;
    }

    public String getResultFromChild() {
        return "Fake Result";
    }
}
