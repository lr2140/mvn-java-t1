package com.imooc.array;

/**
 * @author sy
 * @version 1.0.0
 * @ClassName Array�������ƣ�����ֻ�ܷ����Σ�����ƪ
 * @Description Ľ��ʵս--���ݽṹƪ
 * @Date 2018/4/21 11:20
 */
public class Array {

    /**
     * �Զ����ʼ��һ��int������
     */
    private int[] data;
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
        data = new int[capacity];
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
     *
     * @param e
     */
    public void addLast(int e) {
        //����add�������ɣ�size�������һλ
        add(size, e);
    }

    /**
     * �������һ��λ�����Ԫ��
     *
     * @param e
     */
    public void addFirst(int e) {
        //ͬ�����add����
        add(0, e);
    }

    /**
     * ����ָ��index����λ�����Ԫ��
     *
     * @param index
     * @param e
     */
    public void add(int index, int e) {
        if (size == data.length) {
            throw new IllegalArgumentException("AddLast failed.Array is full.");
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
     * ��ȡindexλ�õ�Ԫ��
     *
     * @param index
     * @return
     */
    int get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }
        return data[index];
    }

    /**
     * ����ĳһ�������ֶ�
     *
     * @param index
     * @param e
     */
    void set(int index, int e) {
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
    public boolean contains(int e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
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
    public int find(int e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return i;
            }
        }
        return -1;
    }

    /**
     * ɾ��ĳһ������Ԫ��
     *
     * @param index
     * @return
     */
    public int remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set failed. Index is illegal.");
        }
        //�������������λ�÷��ظ��û�
        int ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        return ret;
    }

    /**
     * ɾ����һ��Ԫ��
     *
     * @return
     */
    public int removeFirst() {
        return remove(0);
    }

    /**
     * ɾ�����һ��Ԫ��
     *
     * @return
     */
    public int removeLast() {
        return remove(size - 1);
    }

    /**
     * �Ƴ�ĳ��Ԫ��
     *
     * @param e
     * @return
     */
    public boolean removeElement(int e) {
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
