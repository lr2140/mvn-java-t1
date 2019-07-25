package com.imooc.recursion;

import java.util.List;

/**
 * @author suyu
 * @version 1.0.0
 * @ClassName leetCode��listNode
 * @Description
 * @Date 18-5-7 ����10:14
 */
public class ListNode {
    /**
     * �����ֵ
     */
    int val;
    /**
     * �������һ���ڵ�
     */
    ListNode next;

    ListNode(int x) {
        val = x;
    }


    public ListNode(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Arr can note be empty!");
        }
        this.val = arr[0];
        ListNode current = this;
        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
    }

    /**
     * ��дListNode
     * @return
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode current = this;
        while (current!=null){
            sb.append(current.val + "->");
            current = current.next;
        }
        sb.append("NULL ");
        return sb.toString();
    }
}
