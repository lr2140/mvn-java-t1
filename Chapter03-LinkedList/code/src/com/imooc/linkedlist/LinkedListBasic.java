package com.imooc.linkedlist;

/**
 * @author suyu
 * @version 1.0.0
 * @ClassName LinkedListBasic
 * @Description ������Ķ�̬���ݽṹ--����
 * @Date 2018/5/1 21:52
 */
public class LinkedListBasic<E> {

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
     * ͷ���ָ��
     */
    private Node head;
    /**
     * ����Ĵ�С
     */
    private int size;

    public LinkedListBasic() {
        //��ʼ��ͷָ��Ϊ��,��СΪ0
        head = null;
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
     * ����ͷ�������ڵ�
     *
     * @param e ����Ԫ��
     */
    public void addFirst(E e) {
        //��ͷ������һ��
//        Node node = new Node(e);
//        node.next = head;
//        head = node;

        //���ŵ�д��,һ�������������
        head = new Node(e, head);
        //ά��һ��size
        size++;
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
        if (index == 0) {
            addFirst(e);
        } else {
            //1.����Ҫ�����Ԫ��node����Ϊprev,���Ҵ�����ͷ���г�ʼ��
            Node prev = head;
            //2.ѭ������,ȷ��prev��next��ָ��λ��
            for (int i = 0; i < index - 1; i++) {
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
    }

    /**
     * ����������Ԫ��
     * @param e ����Ԫ��
     */
    public void addLast(E e){
        add(size,e);
    }
}
