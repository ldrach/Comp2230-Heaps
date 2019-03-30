package com.company;

/**
 * Created by t00015531 on 3/26/2019.
 */
public class heap {

    int[] heap = new int[15];
    int size = 0;
    final int ROOT = 0;

    public void add(int value){
        size++;
        int add_index = size-1;
        heap[add_index] = value;
        addShift(size-1);
    }

    public void addShift(int index){
        int parentIndex, temp;
        if(index!=0){
            parentIndex = (index-1)/2;
            if(heap[parentIndex]<heap[index]){
                temp = heap[parentIndex];
                heap[parentIndex] = heap[index];
                heap[index]=temp;
                addShift(parentIndex);
            }
        }
    }

    public void remove(){
        heap[ROOT] = heap[size-1];
        size--;
        if(size>0){
            removeShift(0);
        }
    }

    public void removeShift(int index){
        int maxIndex;
        int left = (2*index) + 1;
        int right = (2*index) + 2;
        int temp;


            if (right>=size) {
                if(left>size) {
                    return;
                }
                else{
                    maxIndex = left;
                }
            }
            else {
                if(heap[left]>=heap[right]){
                    maxIndex = left;
                }
                else{
                    maxIndex = right;
                }
            }
            if(heap[index]<heap[maxIndex]){
                temp = heap[maxIndex];
                heap[maxIndex]=heap[index];
                heap[index]=temp;
                removeShift(maxIndex);
            }

    }

    public void print(){

        for(int i=0;i<size;i++){
            System.out.print(heap[i]+" ");
        }
        System.out.println();
    }
}
