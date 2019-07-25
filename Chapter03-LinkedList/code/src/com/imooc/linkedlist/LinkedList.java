package com.imooc.linkedlist;

/**
 * @author suyu
 * @version 1.0.0
 * @ClassName LinkedListQuery
 * @Description
 * @Date 18-5-3 ����9:19
 */
public class LinkedList<E> {


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

    public LinkedList() {
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
//        Node node = new Node(e);
//        node.next = prev.next;
//        prev.next = node;

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
        add(0, e);
    }

    /**
     * ����������Ԫ��
     *
     * @param e ����Ԫ��
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * ��ȡ����ĵ�index(0-based)��λ�õ�Ԫ��
     * �������в���һ�����õĲ���,�˴�����ϰ�� :)
     *
     * @param index ����λ��
     * @return Ԫ������
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Illegal index!");
        }
        Node current = dummyHead.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.e;
    }

    /**
     * ��ȡ����ĵ�һ��Ԫ��
     *
     * @return
     */
    public E getFirst() {
        return get(0);
    }

    /**
     * ��ȡ�������һ��Ԫ��
     *
     * @return
     */
    public E getLast() {
        return get(size - 1);
    }


    /**
     * ���������Ƴ���Ӧ��Ԫ��λ��
     *
     * @param index
     * @return
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed. Illegal index!");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node delNode = prev.next;
        prev.next = delNode.next;
        delNode.next = null;
        size--;
        return delNode.e;
    }

    /**
     * ��������ɾ��Ԫ��e
     * @param e
     */
    public void removeElement(E e){

        Node prev = dummyHead;
        while (prev.next != null){
            if (prev.next.e.equals(e)){
                break;
            }
            prev = prev.next;
        }

        if (prev.next != null){
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
        }
    }

    /**
     * ɾ�������һ��Ԫ��
     * @return Ԫ�ؽڵ�
     */
    public E removeFirst() {
        return remove(0);
    }
    /**
     * ɾ���������һ��Ԫ��
     * @return Ԫ�ؽڵ�
     */
    public E removeLast() {
        return remove(size - 1);
    }


    /**
     * ��ȡ����ĵ�index(0-based)��λ�õ�Ԫ��
     * �������в���һ�����õĲ���,�˴�����ϰ�� :)
     *
     * @param index ����λ��
     * @param e     Ԫ��
     */
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set failed. Illegal index");
        }
        Node current = dummyHead.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.e = e;
    }

    /**
     * �ж��Ƿ����Ԫ��
     *
     * @param e ����Ԫ��
     * @return
     */
    public boolean contains(E e) {
        Node current = dummyHead.next;
        while (current != null) {
            if (current.e.equals(e)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        //1.��һ��д��
//        Node current = dummyHead.next;
//        while (current != null) {
//            sb.append(current + "->");
//            current = current.next;
//        }

        //2.�ڶ���д��
        for (Node current = dummyHead.next; current != null; current = current.next) {
            sb.append(current + "->");
        }
        sb.append("NULL");
        return sb.toString();
    }
}
