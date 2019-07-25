package avltree;

import com.imooc.map.Map;

/**
 * @author suyu
 * @version 1.0.0
 * @ClassName BST
 * @Description ���ڶ���������������Map
 * @Date 2018/5/25 22:07
 */
public class BST<K extends Comparable<K>, V> {

    /**
     * �������ڵ�
     */
    private class Node {
        public K key;
        public V value;
        public Node left, right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
        }
    }

    /**
     * ���ڵ�
     */
    private Node root;
    /**
     * BSTMap��С
     */
    private int size;

    /**
     * ���캯��
     */
    public BST() {
        root = null;
        size = 0;
    }


    public void add(K key, V value) {
        //��Ӷ������������Ԫ�أ����ڵ�k-vֵ
        root = add(root, key, value);
    }

    /**
     * �������ݹ����K-V����
     *
     * @param node
     * @param key
     * @param value
     * @return
     */
    private Node add(Node node, K key, V value) {
        //����ڵ�Ϊ��,�����µ����ڵ�
        if (node == null) {
            size++;
            return new Node(key, value);
        }
        //�����ֵ�����ڵ����Ա�,С�ڵݹ�������,���ڵݹ�������
        if (key.compareTo(node.key) < 0) {
            node.left = add(node.left, key, value);
        } else if (key.compareTo(node.key) > 0) {
            node.right = add(node.right, key, value);
        } else { //key.compareTo(node.key) == 0
            node.value = value;
        }
        return node;
    }


    /**
     * ������nodeΪ���Ķ�������������Сֵ���ڽڵ�
     *
     * @param node node�ڵ�
     * @return
     */
    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    /**
     * ɾ������nodeΪ���Ķ����������е���С�ڵ�
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
     * ɾ����nodeΪ���Ķ�����������key�Ľڵ㣬�ݹ��㷨
     *
     * @param node
     * @param key
     * @return ɾ���ڵ����½ڵ�
     */
    private Node remove(Node node, K key) {

        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            return node;
        } else if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            return node;
        } else { //key.compareTo(node.key)==0
            //ɾ��������Ϊ�յ����
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            //ɾ��������Ϊ�յ����
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }


            //ɾ��������������Ϊ�յ����
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;

            node.left = node.right = null;
            return successor;
        }
    }


    /**
     * ������nodeΪ���ڵ�Ķ����������У�key���ڵĽڵ�
     * �ݹ����,���ݴ����keyֵ�ж���ڵ��keyֵ��Ƚ�,���ҵݹ�
     *
     * @param node ���ڵ�
     * @param key  keyֵ
     * @return node�ڵ�
     */
    private Node getNode(Node node, K key) {
        if (node == null) {
            return null;
        }
        //���key���ڽڵ��е�key,����node,�����������ȥ
        if (key.equals(node.key)) {
            return node;
        } else if (key.compareTo(node.key) < 0) {
            return getNode(node.left, key);
        } else {
            return getNode(node.right, key);
        }
    }

    /**
     * ����getNode�����ж��Ƿ�����ڵ�
     *
     * @param key
     * @return
     */
    public boolean contains(K key) {
        return getNode(root, key) != null;
    }

    /**
     * ��ȡ��Ӧ����ֵ
     *
     * @param key
     * @return
     */
    public V get(K key) {
        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

    /**
     * ����key,���¶�Ӧ��valueֵ
     *
     * @param key
     * @param newValue
     */
    public void set(K key, V newValue) {
        Node node = getNode(root, key);
        if (node == null) {
            throw new IllegalArgumentException(key + "doesn't exist!");
        }
        node.value = newValue;
    }


    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
