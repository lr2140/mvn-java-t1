package uf;

/**
 * @author suyu
 * @version 1.0.0
 * @ClassName UnionFindTwo
 * @Description ���鼯�ڶ���(Quick find)
 * @Date 2018��07��18��21:25:30
 */
public class UnionFindTwo implements UF {

    private int[] parent;

    public UnionFindTwo(int size) {
        parent = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }


    @Override
    public int getSize() {
        return parent.length;
    }

    /**
     * ���ҹ���,����Ԫ��p��Ӧ�ļ��ϱ��
     * O(h)���Ӷ�,hΪ���ĸ߶�
     *
     * @param p
     * @return
     */
    private int find(int p) {
        if (p < 0 || p >= parent.length) {
            throw new IllegalArgumentException("p is out of bound");
        }
        while (p != parent[p]) {
            p = parent[p];
        }
        return p;
    }

    /**
     * �鿴p��q�Ƿ�����ͬһ����
     * O(h)���Ӷ�,hΪ���ĸ߶�
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
     * �ϲ�Ԫ��p,q �����ļ���
     * O(h)���Ӷ�,hΪ���ĸ߶�
     *
     * @param p ����1
     * @param q ����2
     */
    @Override
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot) {
            return;
        }
        parent[pRoot] = qRoot;
    }
}
