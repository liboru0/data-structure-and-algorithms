package com.liboru.datastructure.linkedlist;

/**
 * 带 head 的普通单向链表
 * @author lbr
 */
public class SingleLinkedNoHeadList<E> {

    private Node<E> first = null;

    public boolean isEmpty(){
        return first == null;
    }

    /**
      * @apiNote 添加到链表尾部
      * @author lbr
      */
    public boolean add(E e) {

        Node<E> newNode = new Node<>(e,null);

        if(isEmpty()){
            first = newNode;
            return true;
        }

        Node<E> temp = first;

        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = newNode;

        return true;
    }

    @Override
    public String toString() {

        if(isEmpty()){
            return "[]";
        }

        String str = "[" + first.item;

        Node<E> temp = first.next;

        while(temp != null){
            str += "->" + temp.item.toString() ;
            temp = temp.next;
        }

        str = str + "]";

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

        SingleLinkedNoHeadList<Integer> linkedList = new SingleLinkedNoHeadList<>();
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
