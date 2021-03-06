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
        E item;
        Node<E> next;

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

        if (k <= 0 || k > length) {
            return null;
        }

        Node<E> cur = head;
        for (int i = 0; i <= length - k; i++) {
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

        for (int i = 0; i < k && fast != null; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow.item;

    }

    /**
     * @apiNote 单链表反转
     * @author lbr
     */
    public void reverse(Node<E> head) {

        // head  1  2  3  4
        // head  4  3  2  1

        // 如果当前链表为空 或者 只有一个节点 则无需反转
        if (head.next == null || head.next.next == null) {
            return;
        }

        Node<E> temp = head.next;
        Node<E> next = null; // 存储下一个节点位置

        Node<E> reverseHead = new Node<>(null, null);

        while (temp != null) {
            next = temp.next;
            temp.next = reverseHead.next;
            reverseHead.next = temp;
            temp = next;
        }

        head.next = reverseHead.next;

    }

    public void reversePrintByStack(Node<E> head) {

        if (head.next == null) {
            return;
        }

        if (head.next.next == null) {
            System.out.println(head.item);
        }

        Node<E> cur = head.next;
        int count = 0;
        while (cur != null) {
            cur = cur.next;
            count++;
        }

        Object[] arr = new Object[count];

        cur = head.next;
        for (int i = count - 1; i >= 0; i--) {
            arr[i] = cur.item;
            cur = cur.next;
        }

        for (Object a : arr) {
            System.out.println(a);
        }

    }

    public SingleOrderLinkedWithHeadList<E> mergeTwoLists(Node<E> head1, Node<E> head2){

        SingleOrderLinkedWithHeadList<E> merge = new SingleOrderLinkedWithHeadList<>();

        merge.getHead().next = merge.mergeTwoListsNode(head1.next,head2.next);

        return merge;

    }

    public Node<E> mergeTwoListsNode(Node<E> l1, Node<E> l2){
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.item.compareTo(l2.item)<0) {
            l1.next = mergeTwoListsNode(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoListsNode(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        /*testInsertAndDelete();*/

        /*testGetKthFromEnd();*/

        /*testGetKthFromEnd2();*/

        /*testReverse();*/

        /*testReversePrint();*/

        testMergeTwoLists();

    }

    public static void testMergeTwoLists(){
        SingleOrderLinkedWithHeadList<Integer> one = new SingleOrderLinkedWithHeadList<>();
        one.add(1);
        one.add(4);
        System.out.println(one);

        SingleOrderLinkedWithHeadList<Integer> tow = new SingleOrderLinkedWithHeadList<>();
        tow.add(2);
        tow.add(3);
        System.out.println(tow);

        SingleOrderLinkedWithHeadList<Integer> merge = one.mergeTwoLists(one.getHead(), tow.getHead());
        System.out.println(merge);

    }

    public static void testReversePrint() {
        SingleOrderLinkedWithHeadList<Integer> linked = new SingleOrderLinkedWithHeadList<>();
        for (int i = 0; i < 5; i++) {
            linked.add(i + 1);
        }
        System.out.println(linked);

        linked.reversePrintByStack(linked.getHead());
    }

    public static void testReverse() {
        SingleOrderLinkedWithHeadList<Integer> linked = new SingleOrderLinkedWithHeadList<>();
        for (int i = 0; i < 5; i++) {
            linked.add(i + 1);
        }
        System.out.println(linked);

        linked.reverse(linked.getHead());
        System.out.println(linked);
    }

    public static void testGetKthFromEnd2() {
        SingleOrderLinkedWithHeadList<Integer> linked = new SingleOrderLinkedWithHeadList<>();
        for (int i = 0; i < 5; i++) {
            linked.add(i + 1);
        }
        System.out.println(linked);

        System.out.println(linked.getKthFromEnd2(linked.getHead(), 1));
        System.out.println(linked.getKthFromEnd2(linked.getHead(), 2));
        System.out.println(linked.getKthFromEnd2(linked.getHead(), 3));
        System.out.println(linked.getKthFromEnd2(linked.getHead(), 4));
        System.out.println(linked.getKthFromEnd2(linked.getHead(), 5));
        System.out.println(linked.getKthFromEnd2(linked.getHead(), 6));
        System.out.println(linked.getKthFromEnd2(linked.getHead(), 7));
    }

    public static void testGetKthFromEnd() {
        SingleOrderLinkedWithHeadList<Integer> linked = new SingleOrderLinkedWithHeadList<>();
        for (int i = 0; i < 1; i++) {
            linked.add(i + 1);
        }
        System.out.println(linked);

        System.out.println(linked.getKthFromEnd(linked.getHead(), 1));
        System.out.println(linked.getKthFromEnd(linked.getHead(), 2));
        System.out.println(linked.getKthFromEnd(linked.getHead(), 3));
        System.out.println(linked.getKthFromEnd(linked.getHead(), 4));
        System.out.println(linked.getKthFromEnd(linked.getHead(), 5));
        System.out.println(linked.getKthFromEnd(linked.getHead(), 6));
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
