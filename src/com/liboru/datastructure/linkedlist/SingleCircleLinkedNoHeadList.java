package com.liboru.datastructure.linkedlist;

public class SingleCircleLinkedNoHeadList<E> {

    public Node<E> first;

    private static class Node<E> {
        E item;
        Node<E> next;

        public Node(E item, Node<E> next) {
            this.item = item;
            this.next = next;
        }
    }

    public void add(E e) {
        Node<E> newNode = new Node<>(e, null);

        Node<E> cur = first;

        if (first == null) {
            first = newNode;
        } else {
            while (cur.next != first) {
                cur = cur.next;
            }
            cur.next = newNode;
        }

        newNode.next = first;

    }

    @Override
    public String toString() {

        if (first == null) {
            return "[]";
        }

        String str = "[" + first.item;

        Node<E> temp = first.next;

        while (temp != first) {
            str += "->" + temp.item.toString();
            temp = temp.next;
        }

        str = str + "]";

        return str;
    }

    /**
     * @param startNo  表示从第几个节点开始数数
     * @param countNum 表示数几下
     * @param nums     表示最初的总节点数
     * @apiNote 约瑟夫问题
     * @author lbr
     */
    public void josepfu(int startNo, int countNum, int nums) {

        // 数据校验
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("参数有误！！！");
            return;
        }

        // 初始化 helper ，使其指向最后一个节点
        Node<E> helper = first.next;
        while (helper.next != first) {
            helper = helper.next;
        }

        // 将first移动到开始数的那个节点，helper紧随其后
        for (int i = 0; i < startNo - 1; i++) {
            first = first.next;
            helper = helper.next;
        }

        while (first != helper) {
            for (int i = 0; i < countNum - 1; i++) {
                first = first.next;
                helper = helper.next;
            }
            System.out.println(("出圈：" + first.item));
            first = first.next;
            helper.next = first;
        }

        System.out.println(("出圈：" + first.item));

        first = null;

    }

    public static void main(String[] args) {
        SingleCircleLinkedNoHeadList<Integer> linked = new SingleCircleLinkedNoHeadList<>();
        for (int i = 1; i <= 5; i++) {
            linked.add(i);
        }
        System.out.println(linked);
        linked.josepfu(1, 2, 5);

    }

}
