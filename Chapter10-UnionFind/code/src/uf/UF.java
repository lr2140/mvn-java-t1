package uf;
/**
 * @author suyu
 * @version 1.0.0
 * @ClassName UF
 * @Description UnionFind ���鼯�Ĺ淶�ӿ�
 * @Date 2018��07��11��10:37:55
 */
public interface UF {

    /**
     * ��ȡ��С����
     * @return ��С
     */
    int getSize();

    /**
     * �����,�鿴����Ԫ���Ƿ�����һ������,�Ƿ�����
     * @param p ����1
     * @param q ����2
     * @return �Ƿ�����
     */
    boolean isConnected(int p,int q);

    /**
     * �� �� ����, ������Ԫ�ز���һ��
     * @param p ����1
     * @param q ����2
     */
    void unionElements(int p,int q);
}
