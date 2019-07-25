package trie;

/**
 * @author suyu
 * @version 1.0.0
 * @ClassName Set
 * @Description �Զ��弯�ϵĽӿ�
 * @Date 2018/5/18 22:58
 */
public interface Set<E> {

    /**
     * ���Ԫ��
     * @param e
     */
    void add(E e);

    /**
     * ɾ��Ԫ��
     * @param e
     */
    void remove(E e);

    /**
     * �Ƿ����Ԫ��
     * @param e
     * @return
     */
    boolean contains(E e);

    /**
     * ��ȡ���ϴ�С
     * @return
     */
    int getSize();

    /**
     * �Ƿ�Ϊ��
     * @return
     */
    boolean isEmpty();

}
