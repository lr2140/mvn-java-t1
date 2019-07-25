package com.imooc.recursion;

/**
 * @author suyu
 * @version 1.0.0
 * @ClassName Solution
 * @Description leetCode ���203��
 * <p>
 * ɾ�������е��ڸ���ֵ val �����нڵ㡣
 * ʾ��:
 * ����: 1->2->6->3->4->5->6, val = 6
 * ���: 1->2->3->4->5
 *
 * ������ͷ����
 * @Date 18-5-7 ����10:10
 */

public class Solution2 {

    public ListNode removeElements(ListNode head, int val) {

        //��������ͷ���
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode prev = dummyHead;

        while (prev.next != null) {
            if (prev.next.val == val){
//                ListNode delNode = prev.next;
//                prev.next = delNode.next;
//                delNode.next = null;
                //��������������һ��ԭ��
                prev.next = prev.next.next;
            }else {
                prev = prev.next;
            }
        }

        return dummyHead.next;
    }

    /**
     * leetCode 203 ��,�Լ���ʵ��һ��listNode�ڵ�ķ������ڽ����Լ��Ĳ��������
     * debug ���֣�������������޵ݹ�,���Nodeʱ,value����Node1��,��Node1��
     * next��null,�������ʱ,Node2�е�value���Node1��next�ڵ�,��Node2�����next��Ȼ�ǿա�
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 6, 4, 5, 6};
        ListNode listNode = new ListNode(arr);
        System.out.println(listNode);

        Solution2 solution2 = new Solution2();
        solution2.removeElements(listNode, 6);
        System.out.println(listNode);
    }
}

