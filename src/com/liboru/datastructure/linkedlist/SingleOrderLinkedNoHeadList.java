package com.liboru.datastructure.linkedlist;

/**
 * 带 head 的有序单向链表-升序
 *
 * @author lbr
 */
public class SingleOrderLinkedNoHeadList<E extends Comparable<E>> {

    private Node<E> first = null;

    public Node<E> getFirst() {
        return first;
    }

    /**
     * @apiNote 有序链表的添加，升序，相同顺序则抛出异常
     * @author lbr
     */
    public boolean add(E e) {

        Node<E> newNode = new Node<>(e, null);

        if (this.isEmpty()) {
            first = newNode;
            return true;
        }

        if (first.item.compareTo(newNode.item) == 0) {
            throw new RuntimeException("已经存在相同元素");
        }

        if (first.item.compareTo(newNode.item) > 0) {
            newNode.next = first;
            first = newNode;
            return true;
        }

        Node<E> temp = first.next;
        Node<E> preTemp = first;

        while (temp != null) {

            if (temp.item.compareTo(newNode.item) == 0) {
                throw new RuntimeException("已经存在相同元素");
            }
            if (temp.item.compareTo(newNode.item) > 0) {
                newNode.next = temp;
                preTemp.next = newNode;
                return true;
            }
            preTemp = temp;
            temp = temp.next;
        }

        preTemp.next = newNode;

        return true;
    }

    /**
     * @apiNote 删除元素
     * @author lbr
     */
    public boolean remove(E e) {

        if (e == null) {
            throw new NullPointerException();
        }

        if (isEmpty()) {
            throw new RuntimeException("链表为空");
        }

        Node<E> newNode = new Node<>(e, null);

        if (first.item.equals(e)) {
            newNode.next = first;
            first = newNode;
            return true;
        }

        Node<E> temp = first.next;
        Node<E> preTemp = first;
        while (temp != null) {
            if (temp.item.equals(newNode.item)) {
                preTemp.next = temp.next;
                return true;
            }
            preTemp = temp;
            temp = temp.next;
        }

        return false;
    }

    /**
     * @apiNote 链表是否为空
     * @author lbr
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Node 节点中的数据必须继承 Comparable 接口
     *
     * @param <E>
     */
    private static class Node<E extends Comparable<E>> {
        E item;
        Node<E> next;

        public Node(E item, Node<E> next) {
            this.item = item;
            this.next = next;
        }
    }

    @Override
    public String toString() {

        if (isEmpty()) {
            return "[]";
        }

        String str = "[" + first.item;

        Node<E> temp = first.next;

        while (temp != null) {
            str += "->" + temp.item.toString();
            temp = temp.next;
        }

        str = str + "]";

        return str;
    }

    /**
     * @apiNote 获取链表的长度
     * @param first 第一个节点
     * @author lbr
     */
    public int getLength(Node<E> first) {

        int length = 0;

        Node<E> temp = first;

        while (temp != null) {
            length++;
            temp = temp.next;
        }

        return length;
    }

    public static void main(String[] args) {

        System.out.println("--------添加-------");
        SingleOrderLinkedNoHeadList<Integer> linkedList = new SingleOrderLinkedNoHeadList<>();
        System.out.println(linkedList.getLength(linkedList.getFirst()));
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(5);
        System.out.println(linkedList);

        linkedList.add(4);
        System.out.println(linkedList);

        linkedList.add(6);
        System.out.println(linkedList);

        linkedList.add(3);
        System.out.println(linkedList);

        linkedList.add(0);
        System.out.println(linkedList);


        System.out.println("--------删除-------");
        linkedList.remove(1);
        System.out.println(linkedList);
        linkedList.remove(6);
        System.out.println(linkedList);
        linkedList.remove(5);
        System.out.println(linkedList);
        linkedList.remove(7);
        System.out.println(linkedList);

        System.out.println(linkedList.getLength(linkedList.getFirst()));

    }


}
