package com.company;

public class Main {
    final int ROOT = 0;
    int[] heap = new int[15];
    int size = 0;

    public static void main(String[] args) {

        //Sets up heap and uses methods
        Main heap = new Main();

        heap.add(15);
        heap.add(40);
        heap.add(2);
        heap.add(6);
        heap.add(7);
        heap.add(3);
        heap.add(10);
        heap.add(14);
        heap.add(25);
        heap.add(55);

        heap.print();

        System.out.println("Remove Called");
        heap.remove();
        heap.print();

        System.out.println("Remove Called");
        heap.remove();
        heap.print();

    }

    //Adds an integer to the heap
    public void add(int value) {
        size++;
        int add_index = size - 1;
        heap[add_index] = value;
        addShift(size - 1);
    }

    //Called by add to organize the heap
    public void addShift(int index) {
        int parentIndex, temp;
        if (index != 0) {
            parentIndex = (index - 1) / 2;
            if (heap[parentIndex] < heap[index]) {
                temp = heap[parentIndex];
                heap[parentIndex] = heap[index];
                heap[index] = temp;
                addShift(parentIndex);
            }
        }
    }

    //Removes the root from the heap
    public void remove() {
        heap[ROOT] = heap[size - 1];
        size--;
        if (size > 0) {
            removeShift(0);
        }
    }

    //Called by remove to reorganize the heap after a removal
    public void removeShift(int index) {
        int maxIndex;
        int left = (2 * index) + 1;
        int right = (2 * index) + 2;
        int temp;

        if (right >= size) {
            if (left > size) {
                return;
            } else {
                maxIndex = left;
            }
        } else {
            if (heap[left] >= heap[right]) {
                maxIndex = left;
            } else {
                maxIndex = right;
            }
        }
        if (heap[index] < heap[maxIndex]) {
            temp = heap[maxIndex];
            heap[maxIndex] = heap[index];
            heap[index] = temp;
            removeShift(maxIndex);
        }
    }

    //Prints the contents of the array
    public void print() {

        System.out.println("Max Heap:");
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
        System.out.println();
    }
}
