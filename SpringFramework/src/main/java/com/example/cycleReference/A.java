package com.example.cycleReference;

public class A {
    private B b;

    public A() {
    }

    public A(B b) {
        this.b = b;
    }

    public void methodA() {
        System.out.println("A");
    }

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }
}
