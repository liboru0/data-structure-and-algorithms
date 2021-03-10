package com.liboru.datastructure.linkedlist;

/**
 * 带 head 的有序单向链表-升序
 *
 * @author lbr
 */
public class SingleOrderLinkedWithHeadList<E extends Comparable<E>> {

    private Node<E> head = new Node<E>(null, null);

    public Node<E> getHead() {
        return head;
    }

    /**
     * @apiNote 有序链表的添加，升序，相同顺序则抛出异常
     * 关键点：temp 指向预插入位置的前一个位置
     * @author lbr
     */
    public boolean add(E e) {

        if (e == null) {
            throw new NullPointerException();
        }

        Node<E> newNode = new Node<>(e, null);

        Node<E> temp = head;

        while (temp.next != null) {

            if (temp.next.item.compareTo(newNode.item) == 0) {
                throw new RuntimeException("元素重复");
            }

            // 找到位置就添加到中间
            if (temp.next.item.compareTo(newNode.item) > 0) {
                newNode.next = temp.next;
                temp.next = newNode;
                return true;
            }

            temp = temp.next;

        }

        // 没有找到中间位置就添加到最后
        temp.next = newNode;

        return true;
    }

    /**
     * @apiNote 删除元素
     * 关键点：temp 指向预删除节点的前一个位置
     * @author lbr
     */
    public boolean remove(E e) {

        if (e == null) {
            throw new NullPointerException();
        }

        Node<E> temp = head; // temp 指向待删除的前一个节点

        while (temp.next != null) {
            if (temp.next.item.equals(e)) {
                temp.next = temp.next.next;
                return true;
            }
            temp = temp.next;
        }

        return false;
    }

    /**
     * @apiNote 链表是否为空
     * @author lbr
     */
    public boolean isEmpty() {
        return head.next == null;
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

    /**
     * @param head 头结点
     * @apiNote 获取链表的长度
     * @author lbr
     */
    public int getLength(Node<E> head) {

        int length = 0;

        Node<E> temp = head;

        while (temp.next != null) {
            length++;
            temp = temp.next;
        }

        return length;
    }

    /**
     * @param head head节点
     * @param k    倒数第k个 从1开始
     * @return E 此处返回元素
     * @apiNote 查找倒数第k个元素
     * @author lbr
     */
    public E getKthFromEnd(Node<E> head, int k) {

        int length = 0; // 总长度
        Node<E> temp = head;
        while (temp.next != null) {
            length++;
            temp = temp.next;
        }

        if(k<=0 || k>length){
            return null;
        }

        Node<E> cur = head;
        for (int i = 0; i <= length - k ; i++) {
            cur = cur.next;
        }

        return cur.item;
    }

    /**
     * @param head head节点
     * @param k    倒数第k个 从1开始
     * @return E 此处返回元素
     * @apiNote 查找倒数第k个元素
     * @author lbr
     */
    public E getKthFromEnd2(Node<E> head, int k) {

        Node<E> fast = head;
        Node<E> slow = head;

        for (int i = 0; i < k && fast!=null; i++) {
            fast = fast.next;
        }

        while(fast!=null){
            fast = fast.next;
            slow = slow.next;
        }

        return slow.item;

    }

    public static void main(String[] args) {
        /*testInsertAndDelete();*/

        /*testGetKthFromEnd();*/

        testGetKthFromEnd2();

    }

    public static void testGetKthFromEnd2() {
        SingleOrderLinkedWithHeadList<Integer> linked = new SingleOrderLinkedWithHeadList<>();
        for (int i = 0; i < 5; i++) {
            linked.add(i+1);
        }
        System.out.println(linked);

        System.out.println(linked.getKthFromEnd2(linked.getHead(),1));
        System.out.println(linked.getKthFromEnd2(linked.getHead(),2));
        System.out.println(linked.getKthFromEnd2(linked.getHead(),3));
        System.out.println(linked.getKthFromEnd2(linked.getHead(),4));
        System.out.println(linked.getKthFromEnd2(linked.getHead(),5));
        System.out.println(linked.getKthFromEnd2(linked.getHead(),6));
        System.out.println(linked.getKthFromEnd2(linked.getHead(),7));
    }

    public static void testGetKthFromEnd() {
        SingleOrderLinkedWithHeadList<Integer> linked = new SingleOrderLinkedWithHeadList<>();
        for (int i = 0; i < 1; i++) {
            linked.add(i+1);
        }
        System.out.println(linked);

        System.out.println(linked.getKthFromEnd(linked.getHead(),1));
        System.out.println(linked.getKthFromEnd(linked.getHead(),2));
        System.out.println(linked.getKthFromEnd(linked.getHead(),3));
        System.out.println(linked.getKthFromEnd(linked.getHead(),4));
        System.out.println(linked.getKthFromEnd(linked.getHead(),5));
        System.out.println(linked.getKthFromEnd(linked.getHead(),6));
    }

    public static void testInsertAndDelete() {
        System.out.println("--------添加-------");
        SingleOrderLinkedWithHeadList<Integer> linkedList = new SingleOrderLinkedWithHeadList<>();
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
        linkedList.remove(0);
        System.out.println(linkedList);

        System.out.println(linkedList.getLength(linkedList.getHead()));
    }


}
