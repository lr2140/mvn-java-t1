package trie;

/**
 * @ClassName BSTSet
 * @Description ��������Ϊ�ײ�����ʵ��
 *              ���ڶ����������ļ���ʵ�֣����÷�װ�õļ��ɡ�
 * @author suyu
 * @Date 2018/5/19 21:09
 * @version 1.0.0
 */
public class BSTSet<E extends Comparable<E>> implements Set<E> {

    private BinarySearchTree bst;

    public BSTSet(){
        this.bst = new BinarySearchTree();
    }


    @Override
    public void add(E e) {
        bst.add(e);
    }

    @Override
    public void remove(E e) {
        bst.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    @Override
    public int getSize() {
        return bst.getSize();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }
}
