package com.imooc.map;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * @author suyu
 * @version 1.0.0
 * @ClassName Solution
 * @Description LeetCode 349. ��������Ľ���
 * �����������飬дһ���������������ǵĽ�����
 * ����:
 * ���� num1= [1, 2, 2, 1], nums2 = [2, 2], ���� [2].
 * ��ʾ:
 * ÿ���ڽ���е�Ԫ�رض���Ψһ�ġ�
 * ���ǿ��Բ�������������˳��
 * @Date 2018/5/27 11:40
 */
public class Solution {

    public static int[] intersection(int[] nums1, int[] nums2) {

        TreeSet<Integer> treeSet = new TreeSet<>();
        //��������1,������Ԫ����ӵ�TreeSet��,ȥ���ظ�Ԫ��
        for (int i : nums1) {
            treeSet.add(i);
        }

        ArrayList<Integer> list = new ArrayList<>();
        //��������2,���set�а�������2��Ԫ��,�����list��,����Ϊ��ȥ��,�������Ԫ�ش�ԭ�е�set��ȥ����
        for (int i : nums2) {
            if (treeSet.contains(i)) {
                list.add(i);
                treeSet.remove(i);
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] num1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] result = intersection(num1, nums2);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
