package com.liboru.datastructure.stack;

import java.util.Arrays;

public class ArrayStack<E> {

    /**
     * 内置数组
     */
    private Object[] elementData;

    /**
     * 栈的大小
     */
    private int maxSize;

    /**
     * 栈顶，初始化为-1
     */
    private int top = -1;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        elementData = new Object[maxSize];
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public boolean push(E e){
        if(isFull()){
            throw new RuntimeException("栈满");
        }
        elementData[++top] = e;
        return true;
    }

    public E pop(){
        if(isEmpty()){
            throw new RuntimeException("栈空");
        }
        return (E) elementData[top--];
    }

    @Override
    public String toString() {
        return isEmpty()?"[]": Arrays.asList(Arrays.copyOfRange(elementData, 0, top+1)).toString();
    }

    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>(10);
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack);
    }

}
