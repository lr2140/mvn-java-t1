package uf;

import java.util.Random;

/**
 * @author suyu
 * @version 1.0.0
 * @ClassName TestUnionFind
 * @Description ��������UnionFindЧ��
 * @Date 2018��07��19��22:09:49
 */
public class TestUnionFind {

    /**
     * ����ufʵ�����Ч�ʷ���
     *
     * @param uf ʵ����
     * @param m
     * @return ʱ��
     */
    public static double testUF(UF uf, int m) {
        int size = uf.getSize();
        Random random = new Random();
        long startTime = System.nanoTime();
        for (int i = 0; i < m; i++) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.unionElements(a,b);
        }

        for (int i = 0; i < m; i++) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.isConnected(a,b);
        }


        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;

    }

    public static void main(String[] args) {

        int size = 100000;
        int m = 100000;

        /**��ע�͵���������
        UnionFindOne unionFindOne = new UnionFindOne(size);
        System.out.println("UnionFind1 : " +  testUF(unionFindOne,m) + " s");

        UnionFindTwo unionFindTwo = new UnionFindTwo(size);
        System.out.println("UnionFind2 : " +  testUF(unionFindTwo,m) + " s");
        */
        UnionFindThree unionFindThree = new UnionFindThree(size);
        System.out.println("UnionFind3 : " +  testUF(unionFindThree,m) + " s");

        UnionFindFour unionFindFour = new UnionFindFour(size);
        System.out.println("UnionFind4 : " +  testUF(unionFindFour,m) + " s");

        UnionFindFive unionFindFive = new UnionFindFive(size);
        System.out.println("UnionFind5 : " +  testUF(unionFindFive,m) + " s");

        UnionFindSix unionFindSix = new UnionFindSix(size);
        System.out.println("UnionFind6 : " +  testUF(unionFindSix,m) + " s");

    }
}
