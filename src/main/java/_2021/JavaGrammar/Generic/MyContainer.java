package _2021.JavaGrammar.Generic;

import java.util.ArrayList;

public class MyContainer<E>{

    private ArrayList<E> list;

    public MyContainer() {
        list = new ArrayList<E>();
    }
    public E get(int index){
        return list.get(index);
    }

    public void add(E element){
        list.add(element);
    }

    public static void main(String[] args) {
        MyContainer<String> ql = new MyContainer<String>();
        ql.add("alal");
        ql.add("c");

    }
}
