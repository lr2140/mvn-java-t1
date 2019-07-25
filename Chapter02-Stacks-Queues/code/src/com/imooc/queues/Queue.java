package com.imooc.queues;
/**
 * @ClassName Queue
 * @Description ���еĽӿڣ������˳���ķ���
 * @author suyu
 * @Date 2018/4/29 21:13
 * @version 1.0.0
 */
public interface Queue<E> {

    /**
     * �����
     * @param e ����Ԫ��
     */
    void enqueue(E e);

    /**
     * ������
     * @return e ����Ԫ��
     */
    E dequeue();

    /**
     * �õ�����ͷ
     * @return e ����Ԫ��
     */
    E getHead();

    /**
     * ��ȡ���е�������С
     * @return ������С
     */
    int getSize();

    /**
     * �����Ƿ�Ϊ��
     * @return �Ƿ�Ϊ��
     */
    boolean isEmpty();


}
