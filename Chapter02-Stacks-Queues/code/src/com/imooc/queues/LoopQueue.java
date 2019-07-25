package com.imooc.queues;

import java.util.Arrays;

/**
 * @author suyu
 * @version 1.0.0
 * @ClassName LoopQueue
 * @Description ѭ�����е�ʵ��
 * @Date 2018/4/29 22:17
 */
public class LoopQueue<E> implements Queue<E> {

    /**
     * ��ʼ����������
     */
    private E[] data;

    /**
     * ����ͷ������β����
     */
    private int head, tail;

    /**
     * ���е�����
     */
    private int size;

    public LoopQueue(int capacity) {
        //�˴���Ϊ��Ҫѭ������,����Ԥ���ſ�һ�����е�λ��
        data = (E[]) new Object[capacity + 1];
        head = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public void enqueue(E e) {
        if ((tail + 1) % data.length == head) {
            //�˴�getCapacity,������data.length,��Ϊ�������Ԥ����һ���ռ�
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        //����%data.length��Ŀ������������ѭ�� ->(����ݻ�-1) ������ֵ
        tail = (tail + 1) % data.length;
        size++;
    }

    /**
     * ���ݵ����ܷ���
     *
     * @param newCapacity �µ�����
     */
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            //����%data.length��Ŀ������������ѭ�� ->(����ݻ�-1) ������ֵ
            newData[i] = data[(i + head) % data.length];
        }
        data = newData;
        head = 0;
        tail = size;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Can't dequeue from an empty queue.");
        }
        E ret = data[head];
        data[head] = null;
        //����%data.length��Ŀ������������ѭ�� ->(����ݻ�-1) ������ֵ
        head = (head + 1) % data.length;
        size--;
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return ret;
    }

    @Override
    public E getHead() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Can't dequeue from an empty queue.");
        }
        return data[head];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Queue: size = %d , capacity = %d %n", size, getCapacity()));
        sb.append("head [");
        for (int i = head; i != tail; i = (i + 1) % data.length) {
            sb.append(data[i]);
            if ((i + 1) % data.length != tail) {
                sb.append(", ");
            }
        }
        sb.append("] tail");
        return sb.toString();
    }

    /**
     * ����ѭ�����е�������
     * @param args
     */
    public static void main(String[] args) {
        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        for (int i = 0; i < 10; i++) {
            loopQueue.enqueue(i);
            System.out.println(loopQueue);

            if (i % 3 == 2) {
                loopQueue.dequeue();
                System.out.println(loopQueue);
            }
        }
    }
}
