package com.imooc.recursion;

/**
 * @author suyu
 * @version 1.0.0
 * @ClassName Sum
 * @Description ��ͷֽ�ݹ�
 * @Date 18-5-9 ����9:58
 */
public class Sum {

    /**
     * �������sum(l,.....n)��Χ������ĺ�
     * ��������С��
     * @param arr
     * @param l
     * @return
     */
    public static int sum(int[] arr, int l) {
        //���������
        if (l == arr.length) {
            return 0;
        }
        //���߼����ǽ�������С��
        return arr[l] + sum(arr, l + 1);
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        System.out.println(sum(arr,0));
    }
}
