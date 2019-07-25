package trie;

import java.util.TreeMap;

/**
 * @author suyu
 * @version 1.0.0
 * @ClassName Trie
 * @Description Trie ��
 * @Date 2018/6/17 12:27
 */
public class Trie {

    /**
     * �����ڲ���ڵ�
     */
    private class Node {

        /**
         * �Ƿ���һ������
         */
        public boolean isWord;

        /**
         * ��char-node��Ϊӳ��,��trie��ΪӢ�ĵ���,
         * ��Ϊ��ĸ�ĵ�Ԫ��װ��Character
         */
        public TreeMap<Character, Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        public Node() {
            this(false);
        }
    }

    private Node root;

    private int size;


    public Trie() {
        root = new Node();
        size = 0;
    }

    /**
     * ��ȡTrie�д洢�ĵ�������
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * ��Trie�����һ���µĵ���word
     *
     * @param word
     */
    public void add(String word) {

        Node current = root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (current.next.get(c) == null) {
                current.next.put(c, new Node());
            }
            current = current.next.get(c);
        }
        if (!current.isWord) {
            current.isWord = true;
            size++;
        }
    }

    /**
     * ��ѯword �Ƿ���Trie��
     *
     * @param word
     * @return
     */
    public boolean contains(String word) {

        Node current = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (current.next.get(c) == null) {
                return false;
            }
            current = current.next.get(c);
        }
        return current.isWord;
    }

    /**
     * ��ѯ�Ƿ���Trie���е�����prefixΪǰ׺
     * @param prefix
     * @return
     */
    public boolean isPrefix(String prefix){
        Node current = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (current.next.get(c) == null){
                return false;
            }
            current = current.next.get(c);
        }
        return true;
    }
}
