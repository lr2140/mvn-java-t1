package segment.tree;

/**
 * @author suyu
 * @version 1.0.0
 * @ClassName Merger
 * @Description �ں���
 * @Date 2018/6/9 16:14
 */
public interface Merger<E> {
    /**
     * ����һ���ӿ�,���ͻ����û�����Ա���壺
     *  �����ںϷ���,�ǽ��߶����������Ӳ���,���Ǳ�Ĳ���
     * @param a
     * @param b
     * @return
     */
    E merger(E a, E b);
}
