package com.liboru.datastructure.linkedlist;

/**
 * 带 head 的有序单向链表-升序
 *
 * @author lbr
 */
public class SingleOrderLinkedList<E extends Comparable<E>> {

    private Node<E> head = new Node<E>(null, null);

    /**
     * @apiNote 有序链表的添加，升序，相同顺序则抛出异常
     * @author lbr
     */
    public boolean add(E e) {

        Node<E> newNode = new Node<>(e, null);

        Node<E> temp = head;

        Node<E> preTemp = null; // temp 前边的一个节点

        boolean flag = false; // 是否找到位置(没有找到就放到末尾)

        while (temp.next != null) {

            preTemp = temp;
            temp = temp.next;

            if(temp.item.compareTo(newNode.item)==0){
                throw new RuntimeException("元素重复");
            }

            if(temp.item.compareTo(newNode.item)>0){
                flag = true;
                break;
            }

        }

        if(flag){
            newNode.next = temp;
            preTemp.next = newNode;
        }else{
            temp.next = newNode;
        }

        return true;
    }

    /**
     * Node 节点中的数据必须继承 Comparable 接口
     *
     * @param <E>
     */
    private static class Node<E extends Comparable<E>> {
        private E item;
        private Node<E> next;

        public Node(E item, Node<E> next) {
            this.item = item;
            this.next = next;
        }
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

    public static void main(String[] args) {
        SingleOrderLinkedList<Integer> linkedList = new SingleOrderLinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(5);
        System.out.println(linkedList);

        linkedList.add(4);
        System.out.println(linkedList);

        linkedList.add(3);
        System.out.println(linkedList);

    }


}
