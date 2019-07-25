package com.imooc.map;

/**
 * @author suyu
 * @version 1.0.0
 * @ClassName Map-Basic map�����ӿ�
 * @Description
 * @Date 2018��05��23��23:32:12
 */
public interface Map<K, V> {

    /**
     * ����k-v
     *
     * @param key
     * @param value
     */
    void add(K key, V value);

    /**
     * ɾ��������Ӧ����ֵ
     *
     * @param key
     * @return
     */
    V remove(K key);

    /**
     * �Ƿ����key
     *
     * @param key
     * @return
     */
    boolean contains(K key);

    /**
     * ͨ������ȡֵ
     *
     * @param key
     * @return
     */
    V get(K key);

    /**
     * ���ݼ�����ֵ
     * @param key
     * @param newValue
     */
    void set(K key, V newValue);

    /**
     * ��ȡMap��С
     * @return
     */
    int getSize();

    /**
     * �ж�Map�Ƿ�Ϊ��
     * @return
     */
    boolean isEmpty();

}
