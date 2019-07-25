package com.imooc.queues;

/**
 * @author suyu
 * @version 1.0.0
 * @ClassName Array���İ棬��Ϊ��̬���飩 ����ƪ
 * @Description Ľ��ʵս--���ݽṹƪ �����resize���Ӷȷ���,��̯���Ӷ� �Լ���ֹ���Ӷ���
 * @Date 2018��4��25��21:55:26
 */
public class Array<E> {

    /**
     * �Զ����ʼ��һ��int������
     */
    private E[] data;
    /**
     * ��data��������Ч��Ԫ�ظ���
     */
    private int size;

    /**
     * ���캯�����������������capacity����Array
     *
     * @param capacity
     */
    public Array(int capacity) {
        //����ֱ��new ����,����
        //data = new E[capacity];
        //ֻ��ͨ��Object����������ǿת��
        data = (E[]) new Object[capacity];
        size = 0;
    }

    /**
     * �޲ι��캯����Ĭ�ϵ��ù��캯������10����С������
     */
    public Array() {
        this(10);
    }

    /**
     * ��ȡ�����е�Ԫ�ظ���
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * ������������
     *
     * @return
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * �ж��Ƿ�Ϊ��
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * ���������һλ�����һ��Ԫ��
     * ʱ�临�Ӷ�: O(1)  ��Ϊ��һ������
     *
     * @param e
     */
    public void addLast(E e) {
        //����add�������ɣ�size�������һλ
        add(size, e);
    }

    /**
     * �������һ��λ�����Ԫ��
     *
     * @param e
     */
    public void addFirst(E e) {
        //ͬ�����add����
        add(0, e);
    }

    /**
     * ����ָ��index����λ�����Ԫ��
     *
     * @param index
     * @param e
     */
    public void add(int index, E e) {
        if (size == data.length) {
            resize(2 * data.length);
        }
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("AddLast failed.Require index =>0 and index <= size .");
        }
        for (int i = size - 1; i >= index; i--) {
            //�������һλ�����ƶ�������ڵ��ÿһ���������ƶ�һλ
            data[i + 1] = data[i];
        }
        //�����������λ�������滻Ϊe
        data[index] = e;
        //ÿ�ν�ָ�������ƶ�һ��
        size++;
    }

    /**
     * ��̬�����ع���С
     * ʱ�临�Ӷ�: O(n)
     *
     * @param newCapacity ��������С
     */
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    /**
     * ��ȡindexλ�õ�Ԫ��
     *
     * @param index
     * @return
     */
    E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }
        return data[index];
    }

    /**
     * ��ȡ�������һλ��ֵ
     * @return ����Ϊ-1(���,������python��-1��������)��ֵ
     */
    E getLast() {
        return get(size - 1);
    }

    /**
     * ��ȡ��һλ��Ԫ��
     * @return ����Ϊ1��ֵ
     */
    E getFirst() {
        return get(1);
    }

    /**
     * ����ĳһ�������ֶ�
     *
     * @param index
     * @param e
     */
    void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set failed. Index is illegal.");
        }
        data[index] = e;
    }

    /**
     * �ж��Ƿ����ĳһԪ��
     *
     * @param e
     * @return
     */
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    /**
     * ����Ԫ��e������λ��,������e�򷵻أ���������e�򷵻�-1
     *
     * @param e
     * @return
     */
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * ɾ��ĳһ������Ԫ��
     * �˷�������ɸ��Ӷ��𵴣�����addLast->removeLast->addLast->removeLast�ᵼ������resize
     *
     * @param index
     * @return
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set failed. Index is illegal.");
        }
        //�������������λ�÷��ظ��û�
        E ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        //���ɾ������ʱ,������������С,ʵ�ʿռ�ҲҪ��С,lazy,�������С������������1/4ʱ���ڽ�������
        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }
        size--;
        //loitering objects != memory leak
        data[size] = null;
        return ret;
    }

    /**
     * ɾ����һ��Ԫ��
     *
     * @return
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * ɾ�����һ��Ԫ��
     * ʱ�临�Ӷ�: O(1) ,��addListͬ��,����һ������
     *
     * @return
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * �Ƴ�ĳ��Ԫ��
     *
     * @param e
     * @return
     */
    public boolean removeElement(E e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
            return true;
        }
        return false;
    }


    /**
     * ��д��toString������Ϊ�˴�ӡ����
     *
     * @return
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Array: size = %d , capacity = %d %n", size, data.length));
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i != size - 1) {
                sb.append(", ");
            }
        }

        sb.append("]");
        return sb.toString();
    }
}
