package com.liboru.datastructure.queue;

import java.util.Arrays;

/**
 * 基于数组的简易队列
 * @author lbr
 */
public class ArrayQueue<E> {

    private int maxSize; // 内置数组的长度

    private int front; // 队首，指向队首的前一个位置
    private int rear; // 队尾，指向队尾

    private Object[] elementData;

    public ArrayQueue() {
        this(100);
    }

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        this.elementData = new Object[maxSize];
        this.front = this.rear = -1;
    }

    /**
     * @apiNote 队列是否已满
     * @author lbr
     */
    private boolean isFull(){
        return rear == maxSize-1;
    }

    /**
     * @apiNote 队列是否为空
     * @author lbr
     */
    private boolean isEmpty(){
        return front == rear;
    }

    /**
     * @apiNote 队列是否为空
     * @author 入队
     */
    public boolean add(E e){

        if(isFull()){
            throw new RuntimeException("队列已满");
        }

        elementData[++rear] = e;

        return true;
    }

    @SuppressWarnings("unchecked")
    private E elementData(int index) {
        return (E) elementData[index];
    }

    /**
     * 出队
     * @author lbr
     */
    public E get(){

        if(isEmpty()){
            throw new RuntimeException("队列为空");
        }

        return elementData(++front);

    }

    @Override
    public String toString() {
        return isEmpty()?"[]":Arrays.asList(Arrays.copyOfRange(elementData, front+1, rear+1)).toString();
    }

    /**
     * 展示队首元素
     * @author lbr
     */
    public E headQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空");
        }

        return elementData(front+1);
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>(10);
        System.out.println(queue);
        queue.add(1);
        System.out.println(queue);
        queue.add(2);
        System.out.println(queue);
        System.out.println(queue.headQueue());
        System.out.println(queue);
        System.out.println(queue.get());
        System.out.println(queue);

    }

}
