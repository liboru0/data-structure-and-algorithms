package com.liboru.datastructure.queue;

import java.util.Arrays;

/**
 * 基于数组的环形队列
 * @author lbr
 */
public class ArrayCircleQueue<E> {

    private int maxSize; // 内置数组的长度

    private int front; // 队首，指向队首的前一个位置
    private int rear; // 队尾，指向队尾

    private Object[] elementData;

    public ArrayCircleQueue() {
        this(100);
    }

    public ArrayCircleQueue(int maxSize) {
        this.maxSize = maxSize;
        this.elementData = new Object[maxSize];
        this.front = this.rear = 0;
    }

    /**
     * @apiNote 队列是否已满
     * @author lbr
     */
    private boolean isFull(){
        return (rear+1) % maxSize == front;
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

        elementData[rear] = e;

        rear = (rear+1) % maxSize;

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

        E e = this.elementData(front);

        front = (front+1) % maxSize;

        return e;

    }

    /**
     * 队列的实际长度
     * @author lbr
     */
    private int size(){
        return (rear+maxSize-front)%maxSize;
    }

    @Override
    public String toString() {

        String temp = "    ||    内部数组实际情况:"+Arrays.asList(Arrays.copyOfRange(elementData, 0, maxSize)).toString()
                + "    ||    front="+front+",rear="+rear;

        if(isEmpty()){
            return "队列实际情况:[]"+temp;
        }

        String str = "";

        for (int i = front; i < front+size(); i++) {
            str += elementData(i%maxSize);
            if(i<front+size()-1){
                str += ",";
            }
        }

        return "队列实际情况:["+str+"]"+temp;
    }

    /**
     * 展示队首元素
     * @author lbr
     */
    public E headQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空");
        }

        return elementData(front);
    }

    public static void main(String[] args) {
        ArrayCircleQueue<Integer> queue = new ArrayCircleQueue<>(5);
        System.out.println(queue);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        System.out.println(queue);
        System.out.println(queue.isFull());
        queue.get();
        System.out.println(queue);
        queue.add(5);
        System.out.println(queue);
        queue.get();
        System.out.println(queue);
        queue.add(6);
        System.out.println(queue);

    }

}
