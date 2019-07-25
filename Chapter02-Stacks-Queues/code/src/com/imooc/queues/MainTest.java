package com.imooc.queues;

import com.imooc.stacks.ArrayStack;
import org.junit.Test;

import java.util.Random;

/**
 * @author suyu
 * @version 1.0.0
 * @ClassName MainTest
 * @Description ������еĲ�����
 * @Date 2018/4/27 14:28
 */
public class MainTest {

    /**
     * ����������е���ӡ�����
     */
    @Test
    public void testArrayQueue() {
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }

    /**
     * ����������к�ѭ�����е�ʱ�����Ĳ��Է���
     */
    @Test
    public void testTimeComplexity() {
        //ѭ������
        int operateCount = 100000;
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double arrayQueueTime = testQueue(arrayQueue,operateCount);
        System.out.println("ArrayQueue's Time:" + arrayQueueTime + "s");

        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double loopQueueTime = testQueue(loopQueue,operateCount);
        System.out.println("LoopQueue's Time:" + loopQueueTime + "s");

    }

    /**
     * ����������к�ѭ�����еĺ�ʱʱ��
     * һ��ʱ�临�Ӷ���O(n^2),ArrayQueue
     * һ��ʱ�临�Ӷ���O(1),LoopQueue
     *
     * @return
     */
    public static double testQueue(Queue<Integer> queue, int operateCount) {

        //��ʼʱ��
        long startTime = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < operateCount; i++) {
            queue.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < operateCount; i++) {
            queue.dequeue();
        }
        //����ʱ��
        long endTime = System.nanoTime();

        //����������10^9�η�
        return (endTime - startTime) / 1000000000.0;
    }
}
