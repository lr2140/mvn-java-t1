package avltree;


import java.util.ArrayList;

/**
 * @author suyu
 * @version 1.0.0
 * @ClassName AVLTree
 * @Description AVLTree��ʵ�� version1.0
 * @Date 2018/8/5 10:19
 */
public class AVLTree<K extends Comparable<K>, V> {

    /**
     * �������ڵ�
     */
    private class Node {
        public K key;
        public V value;
        public Node left, right;
        public int height;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
            height = 1;
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
    public AVLTree() {
        root = null;
        size = 0;
    }

    /**
     * ��ȡ���ĸ߶�
     *
     * @param node
     * @return
     */
    private int getHeight(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    /**
     * ��ȡ����ƽ������
     *
     * @param node
     * @return
     */
    private int getBalanceFactor(Node node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    // �Խڵ�y����������ת����,������ת���µĸ��ڵ�x
    //          y                          x
    //         / \                       /  \
    //        x   T4    ������ת(y)      z    y
    //       / \     -------------->  / \   / \
    //      z  T3                    T1 T2 T3 T4
    //     / \
    //    T1  T2

    private Node rightRotate(Node y) {
        //����ͼ�Ϳ��Ժ�����д����
        Node x = y.left;
        Node T3 = x.right;

        //������ת,
        x.right = y;
        y.left = T3;

        //����height
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;

        return x;
    }


    // �Խڵ�y����������ת����,������ת���µĸ��ڵ�x
    //      y                         x
    //     / \                      /  \
    //    T1  x     ������ת(y)     y    z
    //       / \   ------------> / \   / \
    //      T2  z               T1 T2 T3 T4
    //         / \
    //        T3  T4

    private Node leftRotate(Node y) {
        Node x = y.right;
        Node T2 = x.left;

        //������ת
        x.left = y;
        y.right = T2;

        //����height
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;

        return x;
    }

    /**
     * �жϸö������Ƿ���һ�Ŷ���������
     *
     * @return
     */
    public boolean isBST() {
        ArrayList<K> keys = new ArrayList<>();
        inOrder(root, keys);
        for (int i = 1; i < keys.size(); i++) {
            if (keys.get(i - 1).compareTo(keys.get(i)) > 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * �жϸö������Ƿ���һ��ƽ����
     *
     * @return
     */
    public boolean isBalanced() {
        return isBalanced(root);
    }

    /**
     * �ж���NodeΪ���Ķ������Ƿ���һ��ƽ�������,�ݹ��㷨
     *
     * @param node
     * @return
     */
    private boolean isBalanced(Node node) {

        if (node == null) {
            return true;
        }
        int balanceFactor = getBalanceFactor(node);
        if (Math.abs(balanceFactor) > 1) {
            return false;
        }
        return isBalanced(node.left) && isBalanced(node.right);

    }

    /**
     * �������
     *
     * @param node
     * @param keys
     */
    private void inOrder(Node node, ArrayList<K> keys) {
        if (node == null) {
            return;
        }

        inOrder(node.left, keys);
        keys.add(node.key);
        inOrder(node.right, keys);
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

        //����height,����������
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        int balanceFactor = getBalanceFactor(node);
        if (Math.abs(balanceFactor) > 1) {
            System.out.println("unbalanced:" + balanceFactor);
        }

        //ƽ��ά��
        // LL
        if (balanceFactor > 1 && getBalanceFactor(node.left) >= 0) {
            return rightRotate(node);
        }

        // RR
        if (balanceFactor < -1 && getBalanceFactor(node.right) <= 0) {
            return leftRotate(node);
        }

        // LR
        if (balanceFactor > 1 && getBalanceFactor(node.left) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // RL
        if (balanceFactor < -1 && getBalanceFactor(node.right) > 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
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