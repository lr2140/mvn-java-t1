package leetcode;

import java.util.TreeMap;

/**
 * @author suyu
 * @version 1.0.0
 * @ClassName MapSum
 * @Description leetcode 677
 * ����: insert("apple", 3), ���: Null
 * ����: sum("ap"), ���: 3
 * ����: insert("app", 2), ���: Null
 * ����: sum("ap"), ���: 5
 * @Date 2018��06��26��21:16:43
 */
public class MapSum {

    /**
     * �����ڲ���ڵ�
     */
    private class Node {

        /**
         * �Ƿ���һ������
         */
        public int value;

        /**
         * ��char-node��Ϊӳ��,��trie��ΪӢ�ĵ���,
         * ��Ϊ��ĸ�ĵ�Ԫ��װ��Character
         */
        public TreeMap<Character, Node> next;

        public Node(int value) {
            this.value = value;
            next = new TreeMap<>();
        }

        public Node() {
            this(0);
        }
    }

    private Node root;
    /**
     * Initialize your data structure here.
     */
    public MapSum() {
        root = new Node();
    }

    public void insert(String word, int val) {

        Node current = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (current.next.get(c) == null){
                current.next.put(c,new Node());
            }
            current = current.next.get(c);
        }
        current.value = val;

    }

    public int sum(String prefix) {

        Node current = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (current.next.get(c) == null){
                return 0;
            }
            current = current.next.get(c);
        }

        return sum(current);
    }

    private int sum(Node node){

//        if (node.next.size()==0){
//            return node.value;
//        }

        int res = node.value;
        for (char c : node.next.keySet()) {
            res += sum(node.next.get(c));
        }
        return res;
    }
}
