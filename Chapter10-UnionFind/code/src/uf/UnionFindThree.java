package uf;

/**
 * @author suyu
 * @version 1.0.0
 * @ClassName UnionFindThree
 * @Description ���鼯������--����size���Ż�(���鼯���ĸ��ڵ��size,sizeС��ָ����)
 * @Date 2018��07��19��22:20:56
 */
public class UnionFindThree implements UF {

    private int[] parent;

    /**
     * sz[i]��ʾ��iΪ���ļ�����Ԫ�ظ���
     */
    private int[] sz;

    public UnionFindThree(int size) {
        parent = new int[size];
        sz = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            sz[i] = 1;
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

        if (sz[pRoot] < sz[qRoot]) {
            parent[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        } else { //sz[qRoot] <= sz[pRoot]
            parent[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }
    }
}
