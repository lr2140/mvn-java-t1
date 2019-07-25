package com.imooc.linkedlist;

import com.imooc.queues.ArrayQueue;
import com.imooc.queues.LoopQueue;
import com.imooc.queues.Queue;
import com.imooc.stacks.ArrayStack;
import com.imooc.stacks.Stack;
import org.junit.Test;

import java.util.Random;

/**
 * @author suyu
 * @version 1.0.0
 * @ClassName MainTest
 * @Description test LinkedList's Class
 * @Date 18-5-3 22:11
 */
public class MainTest {

    /**
     * linkedList������
     */
    @Test
    public void testLinkedList(){
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }
        linkedList.add(2,666);
        System.out.println(linkedList);

        linkedList.remove(2);
        System.out.println(linkedList);

        linkedList.removeFirst();
        System.out.println(linkedList);

        linkedList.removeLast();
        System.out.println(linkedList);

    }

    /**
     * ����linkedListջ������ջ
     */
    @Test
    public void testLinkedListStack() {
        LinkedListStack<Integer> stack = new LinkedListStack<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);
    }


    /**
     * ��������ջ������ջ��ʱ�����Ĳ��Է���
     */
    @Test
    public void testTimeComplexity() {
        //ѭ������
        int operateCount = 100000;
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        double arrayStackTime = testStack(arrayStack,operateCount);
        System.out.println("arrayStackTime's Time:" + arrayStackTime + "s");

        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        double linkedListStackTime = testStack(linkedListStack,operateCount);
        System.out.println("linkedListStackTime's Time:" + linkedListStackTime + "s");

    }

    /**
     * ��������ջ������ջ�ĺ�ʱʱ��
     * һ����ArrayStack
     * һ����LinkedListStack
     * ����ʱ�临�Ӷ��ǲ���,��cpu��
     * �ҵĲ��Խ����
     * arrayStackTime's Time:0.017628613 s
     * linkedListStackTime's Time:14.658062033 s
     * @return
     */
    public static double testStack(Stack<Integer> stack, int operateCount) {

        //��ʼʱ��
        long startTime = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < operateCount; i++) {
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < operateCount; i++) {
            stack.pop();
        }
        //����ʱ��
        long endTime = System.nanoTime();

        //����������10^9�η�
        return (endTime - startTime) / 1000000000.0;
    }




    /**
     * ����������к�ѭ�����е�ʱ���������е����Ĳ��Է���
     */
    @Test
    public void testTimeComplexityQueue() {
        //ѭ������
        int operateCount = 100000;
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double arrayQueueTime = testQueue(arrayQueue,operateCount);
        System.out.println("ArrayQueue's Time:" + arrayQueueTime + "s");

        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double loopQueueTime = testQueue(loopQueue,operateCount);
        System.out.println("LoopQueue's Time:" + loopQueueTime + "s");

        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        double linkedListQueueTime = testQueue(linkedListQueue,operateCount);
        System.out.println("linkedListQueueTime's Time:" + linkedListQueueTime + "s");

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
