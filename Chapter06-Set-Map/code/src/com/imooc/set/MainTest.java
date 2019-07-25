package com.imooc.set;

import org.junit.Test;

import java.net.URL;
import java.util.ArrayList;

/**
 * @author suyu
 * @version 1.0.0
 * @ClassName MainTest
 * @Description ���ڶ�����������ʵ�ּ��ϵĲ�����
 * @Date 2018/5/13 19:52
 */
public class MainTest {

    @Test
    public void testBSTSet() {
        System.out.println("Pride and Prejudice");

        ArrayList<String> words1 = new ArrayList<>();

        //��ʼʱ��
        long startTime = System.nanoTime();

        //idea_workspace/Data-Struts-Learning/Chapter6-Set-Map/code/src
        if (FileOperation.readFile("./Data-Struts-Learning/Chapter6-Set-Map/code/src/pride-and-prejudice.txt", words1)) {
            System.out.println("Total words: " + words1.size());

            //����:������������ʱ�临�Ӷ�: log(n)
            BSTSet<String> set1 = new BSTSet<>();
            for (String word : words1) {
                set1.add(word);
            }
            System.out.println("Total different words: " + set1.getSize());
        }

        System.out.println();


        System.out.println("A Tale of Two Cities");

        ArrayList<String> words2 = new ArrayList<>();
        if (FileOperation.readFile("./Data-Struts-Learning/Chapter6-Set-Map/code/src/a-tale-of-two-cities.txt", words2)) {
            System.out.println("Total words: " + words2.size());

            BSTSet<String> set2 = new BSTSet<>();
            for (String word : words2) {
                set2.add(word);
            }
            System.out.println("Total different words: " + set2.getSize());
        }

        //����ʱ��
        long endTime = System.nanoTime();
        double spendTime = (endTime - startTime) / 1000000000;
        System.out.println(spendTime);
    }

    @Test
    public void testLinkedListSet() {
        System.out.println("Pride and Prejudice");

        ArrayList<String> words1 = new ArrayList<>();

        //��ʼʱ��
        long startTime = System.nanoTime();

        if (FileOperation.readFile("./Data-Struts-Learning/Chapter6-Set-Map/code/src/pride-and-prejudice.txt", words1)) {
            System.out.println("Total words: " + words1.size());

            //��������ʵ�ֵ�Setʱ�临�Ӷ�: n
            LinkedListSet<String> set1 = new LinkedListSet<>();
            for (String word : words1) {
                set1.add(word);
            }
            System.out.println("Total different words: " + set1.getSize());
        }

        System.out.println();


        System.out.println("A Tale of Two Cities");

        ArrayList<String> words2 = new ArrayList<>();
        if (FileOperation.readFile("./Data-Struts-Learning/Chapter6-Set-Map/code/src/a-tale-of-two-cities.txt", words2)) {
            System.out.println("Total words: " + words2.size());

            LinkedListSet<String> set2 = new LinkedListSet<>();
            for (String word : words2) {
                set2.add(word);
            }
            System.out.println("Total different words: " + set2.getSize());
        }
        //����ʱ��
        long endTime = System.nanoTime();
        double spendTime = (endTime - startTime) / 1000000000;
        System.out.println(spendTime);
    }
}
