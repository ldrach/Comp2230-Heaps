package com.company;

public class Main {



    public static void main(String[] args) {


    heap heap = new heap();

    heap.add(19);
    heap.add(17);
    heap.add(16);
    heap.add(12);
    heap.add(9);
    heap.add(15);
    heap.add(1);
    heap.add(2);
    heap.add(11);
    heap.add(7);
    heap.add(3);
    heap.add(10);
    heap.add(14);

    heap.print();

    heap.remove();

    heap.remove();

    heap.print();
    }

}
