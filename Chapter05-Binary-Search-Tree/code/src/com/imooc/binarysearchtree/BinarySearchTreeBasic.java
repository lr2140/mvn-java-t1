package com.imooc.binarysearchtree;

/**
 * @author suyu
 * @version 1.0.0
 * @ClassName BinarySearchTreeBasic
 * @Description ����������-������
 * @Date 2018/5/11 22:27
 */
public class BinarySearchTreeBasic<E extends Comparable<E>> {

    private class Node {
        /**
         * ���ڵ�Ĵ洢Ԫ��
         */
        public E e;
        /**
         * ������,������
         */
        public Node left, right;


        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    /**
     * ���ĸ��ڵ�
     */
    private Node root;

    /**
     * ��������
     */
    private int size;

    /**
     * ��ʼ������������
     */
    public BinarySearchTreeBasic() {
        this.root = null;
        this.size = 0;
    }

    /**
     * ��ȡ��������
     *
     * @return ������
     */
    public int getSize() {
        return size;
    }

    /**
     * �ж��Ƿ�Ϊ��
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * ��������������������
     *
     * @param e ��ӵ�����
     */
    public void add(E e) {

        //������ڵ��ǿ�,�������ڵ�,ά��size��������
        if (root == null) {
            root = new Node(e);
            size++;
        } else {
            add(root, e);
        }
    }

    /**
     * ����nodeΪ���Ķ����������в���E,�ݹ��㷨
     *
     * @param node
     * @param e
     */
    private void add(Node node, E e) {

        /**
         * �����e�뵱ǰ��e���,��������
         * ��������eС�ڵ�ǰ���ڵ��e,���Ҹ��ڵ������Ϊ�գ������e�����ڵ�����Ӵ�
         * ��������e���ڵ�ǰ���ڵ��e,���Ҹ��ڵ���Һ���Ϊ�գ������e�����ڵ���Һ��Ӵ�
         */
        if (e.equals(node.e)) {
            return;
        } else if (e.compareTo(node.e) < 0 && node.left == null) {
            node.left = new Node(e);
            size++;
            return;
        } else if (e.compareTo(node.e) > 0 && node.right == null) {
            node.right = new Node(e);
            size++;
            return;
        }
        //�ٴεݹ����,�������˽�е�������
        if (e.compareTo(node.e) < 0) {
            add(node.left, e);
        } else {
            add(node.right, e);
        }
    }


}
