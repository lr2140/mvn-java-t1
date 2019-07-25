package com.imooc.set;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author suyu
 * @version 1.0.0
 * @ClassName BinarySearchTreeBasic
 * @Description ����������-���հ�(�ݹ����)
 * @Date 2018��05��17��22:08:10
 */
public class BinarySearchTree<E extends Comparable<E>> {

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
    public BinarySearchTree() {
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
        root = add(root, e);
    }

    /**
     * ����nodeΪ���Ķ����������в���E,�ݹ��㷨
     * ���ز����½ڵ������������ĸ�
     *
     * @param node
     * @param e
     */
    private Node add(Node node, E e) {

        //�жϽڵ��Ƿ�Ϊ��,��Ϊ��,�򷵻���Ϊ���ڵ�
        if (node == null) {
            size++;
            return new Node(e);
        }

        //�ٴεݹ����,�������˽�е�������
        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0){
            node.right = add(node.right, e);
        }
        return node;
    }

    /**
     * �ж϶����������Ƿ����Ԫ��E
     *
     * @param e ���������
     * @return �Ƿ����
     */
    public boolean contains(E e) {
        return contains(root, e);
    }

    /**
     * ����nodeΪ���Ķ������������Ƿ����Ԫ��e, �ݹ��㷨
     *
     * @param node ��nodeΪ���Ķ���������
     * @param e    ���������
     * @return
     */
    private boolean contains(Node node, E e) {

        //���Ϊ��,����false
        if (node == null) {
            return false;
        } else if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        }
        // e.compareTo(node.e) > 0
        else {
            return contains(node.right, e);
        }
    }

    //ǰ�����
    public void preOrder() {
        preOrder(root);
    }

    /**
     * ǰ�������nodeΪ���Ķ������������ݹ��㷨
     * <p>
     * ǰ�����:�ȸ����Ȼ���������������������������
     * <p>
     * ��������Ϊ����������أ�����
     * ��1�����ʸ���㡣
     * ��2��ǰ�������������
     * ��3��ǰ����������� ��
     * ��Ҫע����ǣ�������������ʱ��Ȼ����ǰ�����������
     *
     * @param node
     */
    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }


    /**
     * ʹ��ջʵ�ַǵݹ������ǰ����� (��������������ȱ���)
     * NR:No Recursion �ǵݹ�
     */
    public void preOrderNR() {

        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node current = stack.pop();
            System.out.println(current.e);
            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
        }
    }

    /**
     * �����������Ĳ������(������ȱ���)
     */
    public void levelOrder() {

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node current = queue.remove();
            System.out.println(current.e);
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }


    //�������
    public void midOrder() {
        midOrder(root);
    }

    /**
     * �������
     * ��1���������������
     * ��2�����ʸ����
     * ��3���������������
     * <p>
     * ����:��С��������ı���˳��
     *
     * @param node
     */
    private void midOrder(Node node) {

        if (node == null) {
            return;
        }

        midOrder(node.left);
        System.out.println(node.e);
        midOrder(node.right);

    }

    //�������
    public void postOrder() {
        postOrder(root);
    }

    /**
     * ��������Ϊ����������أ�
     * ����
     * ��1���������������
     * ��2���������������
     * ��3�����ʸ����
     * Ӧ��:
     * �����������ͷ��ڴ�
     *
     * @param node
     */
    private void postOrder(Node node) {
        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    /**
     * Ѱ�Ҷ���������Сֵ
     *
     * @return
     */
    public E minimum() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty");
        }

        return minimum(root).e;
    }

    /**
     * ������nodeΪ���Ķ�������������С�ڵ�
     *
     * @param node �ڵ�
     * @return
     */
    private Node minimum(Node node) {

        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    /**
     * Ѱ�Ҷ����������ֵ
     *
     * @return
     */
    public E maximum() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty");
        }
        return maximum(root).e;
    }

    /**
     * ������nodeΪ���Ķ��������������ڵ�
     *
     * @param node �ڵ�
     * @return
     */
    private Node maximum(Node node) {
        if (node.right == null) {
            return node;
        }
        return maximum(node.right);
    }

    /**
     * �Ӷ�����������ɾ����Сֵ���ڵĽڵ㣬������Сֵ
     *
     * @return
     */
    public E removeMin() {
        E ret = minimum();
        root = removeMin(root);
        return ret;
    }

    /**
     * ɾ����nodeΪ���Ķ����������е���С�ڵ�
     * ����ɾ���ڵ���µĶ����������ĸ�
     *
     * @param node
     * @return
     */
    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }


    /**
     * �Ӷ�����������ɾ�����ֵ���ڵĽڵ㣬�������ֵ
     *
     * @return
     */
    public E removeMax() {
        E ret = maximum();
        root = removeMax(root);
        return ret;
    }

    /**
     * ɾ����nodeΪ���Ķ����������е����ڵ�
     * ����ɾ���ڵ���µĶ����������ĸ�
     *
     * @param node
     * @return
     */
    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }

        node.right = removeMax(node.right);
        return node;
    }

    /**
     * ɾ�������������е�ĳ��Ԫ��
     *
     * @param e
     */
    public void remove(E e) {
        root = remove(root, e);
    }

    /**
     * ɾ������nodeΪ���Ķ�����������ֵΪe�Ľڵ�, �ݹ��㷨
     * ����ɾ���ڵ���µĶ����������ĸ�
     *
     * @param node
     * @param e
     * @return
     */
    private Node remove(Node node, E e) {
        if (node == null) {
            return node;
        }
        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            return node;
        } else if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
            return node;
        } else { //e.compareTo(node.e) == 0
            // ��ɾ���ڵ�������Ϊ�յ����
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }

            // ��ɾ���ڵ�������Ϊ�յ����
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }

            // ��ɾ���ڵ�������������Ϊ�յ����

            // �ҵ��ȴ�ɾ���ڵ�����С�ڵ�, ����ɾ���ڵ�����������С�ڵ�
            // ������ڵ㶥���ɾ���ڵ��λ��
            // successor :��̽ڵ�, precursor : ǰ���ڵ�(��ʵ��)
            Node successor = new Node(minimum(node.right).e);
            size++;

            //����ɾ���ڵ���������ҳ���С�ڵ�Ԫ��ɾ�����ҽ��������ص�ǰ���ڵ����������
            successor.right = removeMin(node.right);
            //��ɾ���ڵ��������Խӵ�ǰ���ڵ����������
            successor.left = node.left;

            //�Ͽ���ɾ���ڵ����������
            node.left = node.right = null;
            size--;

            return successor;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        generateBSTString(root, 0, sb);
        return sb.toString();
    }

    /**
     * ������node Ϊ���ڵ㣬���Ϊdepth�����������������ַ���
     *
     * @param node
     * @param depth
     * @param sb
     */
    private void generateBSTString(Node node, int depth, StringBuilder sb) {
        if (node == null) {
            sb.append(generateDepthString(depth) + "null\n");
            return;
        }
        sb.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1, sb);
        generateBSTString(node.right, depth + 1, sb);
    }

    private String generateDepthString(int depth) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            sb.append("--");
        }
        return sb.toString();
    }
}
