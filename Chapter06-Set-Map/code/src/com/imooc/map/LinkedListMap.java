package com.imooc.map;

/**
 * @author suyu
 * @version 1.0.0
 * @ClassName LinkedListMap
 * @Description ����LinkedListʵ�ֵ�Map��
 * @Date 2018��05��24��22:17:38
 */
public class LinkedListMap<K, V> implements Map<K, V> {

    private class Node {
        /**
         * Node�е�Key
         */
        public K key;
        /**
         * Node�е�value
         */
        public V value;
        /**
         * Node�е�next�ڵ�
         */
        public Node next;


        public Node(K key, V vaule, Node next) {
            this.key = key;
            this.value = vaule;
            this.next = next;
        }

        public Node(K key,V value) {
            this(key, value, null);
        }

        public Node() {
            this(null, null, null);
        }

        @Override
        public String toString() {
            return key.toString() + ":" + value.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedListMap() {
        dummyHead = new Node();
        size = 0;
    }

    /**
     * �����ȡKey��Ӧ��Node
     *
     * @param key �û������keyֵ
     * @return
     */
    private Node getNode(K key) {
        Node current = dummyHead.next;
        while (current != null) {
            if (current.key.equals(key)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    /**
     * ��Ӳ���
     * @param key ��
     * @param value ����Ӧ��ֵ
     */
    @Override
    public void add(K key, V value) {

        Node node = getNode(key);
        if (node == null) {
            //����ͷ������һ���ڵ㴴���µĽڵ�
            dummyHead.next = new Node(key, value, dummyHead.next);
            size++;
        } else {
            node.value = value;
        }
    }

    /**
     * ����keyɾ��value
     * @param key �û�����ļ�
     * @return ����ɾ����ֵ
     */
    @Override
    public V remove(K key) {

        //������ͷ��㿪ʼ����,����key���ֱ������ѭ��
        Node prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.key.equals(key)) {
                break;
            }
            prev = prev.next;
        }

        //�Ͽ�Ҫɾ���ڵ��next,��ǰһ���ڵ�ָ��ɾ���ڵ����һ���ڵ�
        if (prev.next != null) {
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            return delNode.value;
        }
        return null;
    }

    /**
     * �ж��Ƿ��д˼�
     * @param key
     * @return
     */
    @Override
    public boolean contains(K key) {
        return getNode(key) != null;
    }

    /**
     * ��ȡ��Ӧ����ֵ
     * @param key ��
     * @return ����ֵ
     */
    @Override
    public V get(K key) {
        Node node = getNode(key);
        //��ȡ�ڵ���Ϊnull,�򷵻�null ,���򷵻ظýڵ��ֵ
        return node == null ? null : node.value;
    }

    /**
     * ���²���
     * @param key ��
     * @param newValue ���µ���ֵ
     */
    @Override
    public void set(K key, V newValue) {

        Node node = getNode(key);
        if (node == null) {
            throw new IllegalArgumentException(key + "doesn't exist!");
        }
        //����,���½ڵ�Ϊ�û�����������ֵ
        node.value = newValue;
    }

    /**
     * ����size
     * @return
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * �ж��Ƿ�Ϊ��
     * @return
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
