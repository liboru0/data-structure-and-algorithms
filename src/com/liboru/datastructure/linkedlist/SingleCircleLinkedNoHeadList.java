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

    public static void main(String[] args) {
        SingleCircleLinkedNoHeadList<Integer> linked = new SingleCircleLinkedNoHeadList<>();
        for (int i = 1; i <= 5; i++) {
            linked.add(i);
        }
        System.out.println(linked);
    }

}
