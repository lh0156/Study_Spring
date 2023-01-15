package com.java.theEssenceOfJava.chapter12_generics;

public class Box {
    Object item;

    public Object getItem() {
        return item;
    }

    public void setItem(Object item) {
        this.item = item;
    }

    static class genericBox<T> {
        T item;

        public T getItem() {
            return item;
        }

        public void setItem(T item) {
            this.item = item;
        }
    }
}
