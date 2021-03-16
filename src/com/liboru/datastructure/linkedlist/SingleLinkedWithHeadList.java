package com.liboru.datastructure.linkedlist;

/**
 * 带 head 的普通单向链表
 * @author lbr
 */
public class SingleLinkedWithHeadList<E> {

    private Node<E> head = new Node<>(null, null);

    /**
      * @apiNote 添加到链表尾部
      * @author lbr
      */
    public boolean add(E e) {

        Node<E> newNode = new Node<>(e, null);

        Node<E> temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;

        return true;
    }

    @Override
    public String toString() {

        Node<E> temp = head;

        if(temp.next==null){
            return "[]";
        }

        String str = "[";

        while(temp.next!=null){
            temp = temp.next;
            str += temp.item.toString() + "->";
        }

        str = str.substring(0,str.length()-2) + "]";

        return str;
    }

    /**
     * 链表内部节点
     */
    private static class Node<E> {
        E item;
        Node<E> next;

        public Node(E item, Node<E> next) {
            this.item = item;
            this.next = next;
        }
    }

    public static void main(String[] args) {

        SingleLinkedWithHeadList<Integer> linkedList = new SingleLinkedWithHeadList<>();
        System.out.println(linkedList);

        linkedList.add(1);
        System.out.println(linkedList);
        linkedList.add(2);
        linkedList.add(3);
        System.out.println(linkedList);

        linkedList.add(1);
        System.out.println(linkedList);

    }

}
