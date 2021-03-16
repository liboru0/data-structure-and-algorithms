package com.liboru.datastructure.linkedlist;

public class DoubleOrderLinkedWithHeadList<E extends Comparable<E>> {

    private Node<E> head = new Node<>(null, null, null);

    public Node<E> getHead() {
        return head;
    }

    private static class Node<E extends Comparable<E>> {
        E item;
        Node<E> next;
        Node<E> pre;

        public Node(Node<E> pre, E item, Node<E> next) {
            this.pre = pre;
            this.item = item;
            this.next = next;
        }
    }

    public boolean add(E e) {

        Node<E> newNode = new Node<>(null, e, null);

        Node<E> temp = this.head;

        while (temp.next != null) {

            temp = temp.next;

            if(temp.item.compareTo(newNode.item)==0){
                throw new RuntimeException("不能相同");
            }

            if(temp.item.compareTo(newNode.item)>0){

                Node<E> preTemp = temp.pre;
                temp.pre = newNode;
                newNode.next = temp;
                preTemp.next = newNode;
                newNode.pre = preTemp;

                return true;
            }

        }

        temp.next = newNode;
        newNode.pre = temp;

        return true;
    }

    public boolean remove(E e) {
        Node<E> temp = head.next;

        while (temp != null) {
            if (temp.item.equals(e)) {
                temp.pre.next = temp.next;
                if (temp.next != null) {
                    temp.next.pre = temp.pre;
                }
                return true;
            }
            temp = temp.next;
        }

        return false;

    }

    @Override
    public String toString() {

        Node<E> temp = head;

        if (temp.next == null) {
            return "[]";
        }

        String str = "[";

        while (temp.next != null) {
            temp = temp.next;
            str += temp.item.toString() + "->";
        }

        str = str.substring(0, str.length() - 2) + "]";

        return str;
    }

    public static void main(String[] args) {

        DoubleOrderLinkedWithHeadList<Integer> linked = new DoubleOrderLinkedWithHeadList<>();

        linked.add(3);
        linked.add(2);
        linked.add(1);
        linked.add(5);
        linked.add(4);
        System.out.println(linked);

        linked.remove(1);
        System.out.println(linked);
        linked.remove(5);
        System.out.println(linked);
        linked.remove(3);
        System.out.println(linked);


    }

}
