package com.imooc.linkedlist;

/**
 * @author suyu
 * @version 1.0.0
 * @ClassName LinkedListDummyHead
 * @Description ����ͷ��������ʵ��
 * @Date 2018/5/2 13:26
 */
public class LinkedListDummyHead<E> {

    /**
     * �˴����Node�ڵ���Ϊ�ڲ��࣬Ŀ�����£�
     * ����д�������ݽṹ�ĵײ���룬���ͻ�ʹ�õ�ʱ�򣬿ͻ������ע�����ݽṹ��ʲô���ԣ�
     * ʹ�õ�ʱ����Ҫ��ע��ô�ü��ɣ�����Node����Ϊ�ڲ��࣬�Կͻ���ʹ�ö��ԣ������εĲ�����
     */
    private class Node {
        /**
         * ���������Ԫ��
         */
        public E e;
        /**
         * ����Ľڵ�ָ��
         */
        public Node next;

        /**
         * �����ݺ�ָ��Ĺ��캯��,�û���������
         *
         * @param e    ����Ԫ��e
         * @param next ����ָ��
         */
        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        /**
         * �вι��죬�û�����һ������Ԫ��e
         *
         * @param e ����e
         */
        public Node(E e) {
            this(e, null);
        }

        /**
         * Ĭ�ϵĹ��캯�����޲Σ�ֱ�Ӷ���null
         */
        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    /**
     * ����ͷ���ָ��
     */
    private Node dummyHead;
    /**
     * ����Ĵ�С
     */
    private int size;

    public LinkedListDummyHead() {
        //��ʼ������ͷָ��,���ڽڵ㼴��һ��null
        dummyHead = new Node(null, null);
        size = 0;
    }

    /**
     * ��ȡ����Ĵ�С
     *
     * @return ���������С
     */
    public int getSize() {
        return size;
    }

    /**
     * �ж������Ƿ�Ϊ��
     *
     * @return �Ƿ�Ϊ��
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * �����м�����Ԫ��
     *
     * @param index "����",��ν������������������,���㶨�����
     * @param e     ��ӵ�����Ԫ��
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index");
        }
        //1.����Ҫ�����Ԫ��node����Ϊprev,���Ҵ����������ͷ�ڵ���г�ʼ��
        Node prev = dummyHead;
        //2.ѭ������,��dummyHead��ʼ����,0,1,2,3.....index֮ǰ�Ľڵ�
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        //3.�������node.nextָ��prev��next
        Node node = new Node(e);
        node.next = prev.next;
        prev.next = node;

        //���ŵ�д��:��addFirst��һ��,�������е�ע��
        prev.next = new Node(e, prev.next);
        size++;
    }

    /**
     * ����ͷ�������ڵ�
     *
     * @param e ����Ԫ��
     */
    public void addFirst(E e) {
        add(0,e);
    }

    /**
     * ����������Ԫ��
     *
     * @param e ����Ԫ��
     */
    public void addLast(E e) {
        add(size, e);
    }
}
