package com.heps.java_core_technology1.generic_paradigm;

public class Pair<T,U> {

    private T first;
    private T second;
    private U third;

    public Pair(){
        first = null;
        second = null;
    }

    public Pair(T first , T second){
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public T getSecond() {
        return second;
    }

    public void setSecond(T second) {
        this.second = second;
    }
}
