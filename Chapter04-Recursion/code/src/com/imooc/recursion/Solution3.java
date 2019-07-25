package com.imooc.recursion;
/**
 * @author suyu
 * @version 1.0.0
 * @ClassName Solution3
 * @Description  �ݹ�ʵ�ֽ������ɾ������ leetCode 203��
 * @Date 18-5-10 ����10:33
 */
public class Solution3 {

    /**
     * �ݹ�ʵ��leetCode�ϵ�203��
     * �ݹ�ɾ������ڵ�
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {

        //�������ڵ�Ϊ��,�򷵻ؿ�
        if (head == null){
            return null;
        }

        /**
         * �ݹ�������,����ɾ������
         * �������ֵ���ڴ���Ҫɾ����ֵ,ָ����һ�ڵ�
         */
        head.next = removeElements(head.next,val);
        return head.val == val ? head.next : head;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 6, 4, 5, 6};
        ListNode listNode = new ListNode(arr);
        System.out.println(listNode);

        Solution3 solution3 = new Solution3();
        solution3.removeElements(listNode, 6);
        System.out.println(listNode);
    }
}
