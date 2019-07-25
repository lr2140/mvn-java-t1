package com.imooc.stacks;

/**
 * @author suyu
 * @version 1.0.0
 * @ClassName Stack
 * @Description ջ�Ľӿ���
 * @Date 2018/4/27 14:21
 */
public interface Stack<E> {

    /**
     * ��ջ(ѹջ)����
     * @param e ����Ԫ��
     */
    void push(E e);

    /**
     * ��ջ(����ջ)����
     * @return ���س�ջԪ��
     */
    E pop();

    /**
     * peek:Ƴһ�۵���˼
     * �鿴ջ����һ��Ԫ�ص�ֵ
     * @return ����ջ��Ԫ��
     */
    E peek();

    /**
     * ��ȡջ�Ĵ�С
     * @return ���ش�С
     */
    int getSize();

    /**
     * �ж�ջ�Ƿ�Ϊ��
     * @return �����Ƿ�Ϊ��
     */
    boolean isEmpty();


}
