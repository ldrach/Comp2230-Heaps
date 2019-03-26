package com.company;

/**
 * Created by t00015531 on 3/26/2019.
 */
public class heap {

    int[] heap = new int[15];
    int count = 0;
    final int ROOT = 0;

    public void add(int value){
        count++;
        int add_index = count-1;
        heap[add_index] = value;
        int parent = (add_index-1)/2;
        while(heap[add_index]>heap[parent]){
            int temp = heap[add_index];
            heap[add_index]=heap[parent];
            heap[parent]=temp;
            add_index=parent;
        }

    }

    public void remove(){
        int parent=ROOT;
        int left = (2*parent) + 1;
        int right = (2*parent) + 2;
        heap[ROOT] = heap[count-1];

        while (heap[parent] < heap[left] || heap[parent] < heap[right]) {
            if (heap[left] > heap[right]) {
                int temp = heap[left];
                heap[left] = heap[parent];
                heap[parent] = temp;
                parent = left;
            }
            else if (heap[right] > heap[left]) {
                int temp = heap[right];
                heap[right] = heap[parent];
                heap[parent] = temp;
                parent = right;
            }
        }
        count--;
    }

    public void print(){

        for(int i=0;i<count;i++){
            System.out.print(heap[i]+" ");
        }
        System.out.println();
    }
}
