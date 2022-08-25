package com.example.cycleReference;


public class B {
    private A a;

    public B() {
    }

    public B(A a) {
        this.a = a;
    }

    public void methodB() {
        System.out.println("B");
    }

    public A getA() {
        return a;
    }

    public void setA(A a) {
        this.a = a;
    }
}
