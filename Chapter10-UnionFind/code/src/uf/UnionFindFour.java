package uf;
/**
 * @author suyu
 * @version 1.0.0
 * @ClassName UnionFindFour
 * @Description ���鼯���İ�,����rank���Ż�
 *              rank �����������
 * @Date 2018��07��21��12:55:17
 */
public class UnionFindFour implements UF{

    private int[] parent;

    /**
     * rank[i]��ʾ��iΪ���ļ�������ʾ���Ĳ���
     */
    private int[] rank;

    public UnionFindFour(int size) {
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 1;
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

        //��������Ԫ����������rank��ͬ�жϺϲ�����
        //��rank�͵ļ��Ϻϲ���rank�ߵļ�����
        if (rank[pRoot] < rank[qRoot]) {
            parent[pRoot] = qRoot;
        }else if (rank[qRoot] < rank[pRoot]){
            parent[qRoot] = pRoot;
        } else { //sz[qRoot] == sz[pRoot]
            parent[qRoot] = pRoot;
            rank[pRoot] += 1;
        }
    }
}
