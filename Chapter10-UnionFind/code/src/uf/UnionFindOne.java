package uf;

/**
 * @author suyu
 * @version 1.0.0
 * @ClassName UnionFindOne
 * @Description ���鼯��һ��(Quick find)
 * Quick Find:
 * isConnected(p,q):O(1)
 * unionElements(p,q):O(n)
 * @Date 2018/7/15 9:43
 */
public class UnionFindOne implements UF {

    /**
     * ���鼯��Ԫ�ض�Ӧ��idֵ
     */
    private int[] id;

    public UnionFindOne(int size) {
        id = new int[size];
        //ÿһ��Ԫ�ض�Ӧ��id��Ų�һ��,ÿ��Ԫ�����ڲ�ͬ�ļ���
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }

    @Override
    public int getSize() {
        return id.length;
    }

    /**
     * ����Ԫ��p��Ӧ�ļ��ϱ��
     *
     * @param p Ԫ��p
     * @return
     */
    private int find(int p) {
        if (p < 0 || p >= id.length) {
            throw new IllegalArgumentException("p is out of bound");
        }

        return id[p];
    }

    /**
     * �鿴p��q�Ƿ�����ͬһ����
     *
     * @param p ����1
     * @param q ����2
     * @return
     */
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * �ϲ�Ԫ��p��q �����ļ���
     *
     * @param p ����1
     * @param q ����2
     */
    @Override
    public void unionElements(int p, int q) {

        int pID = find(p);
        int qID = find(q);

        if (pID == qID) {
            return;
        }
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pID) {
                id[i] = qID;
            }
        }
    }
}
