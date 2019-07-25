package com.imooc.recursion;

/**
 * @author suyu
 * @version 1.0.0
 * @ClassName RecursionDebug
 * @Description �ݹ�����ɾ������, ��ӡ����Ľ��˼·
 * @Date 18-5-10 ����10:32
 */
public class RecursionDebug {


    /**
     * �ݹ�ʵ��leetCode�ϵ�203��
     * �ݹ�ɾ������ڵ�
     *
     * @param head  ����
     * @param val   ����ֵ
     * @param depth �ݹ����
     * @return
     */
    public ListNode removeElements(ListNode head, int val, int depth) {

        String depthString = generateDepthString(depth);
        System.out.print(depthString);
        System.out.println("Call: remove " + val + " in " + head);

        //�������ڵ�Ϊ��,�򷵻ؿ�
        if (head == null) {
            System.out.print(depthString);
            System.out.println("Return: " + head);
            return null;
        }

        /**
         * �ݹ�������,����ɾ������
         * �������ֵ���ڴ���Ҫɾ����ֵ,ָ����һ�ڵ�
         */
        ListNode result = removeElements(head.next, val, depth + 1);
        System.out.print(depthString);
        System.out.println("After remove " + val + ":" + result);

        ListNode ret;
        //�����ǰͷ����ֵ����Ҫɾ����ֵ,������ֵ��ret,����ͷ��㸳��ret
        if (head.val == val) {
            ret = result;
        } else {
            head.next = result;
            ret = head;
        }
        System.out.print(depthString);
        System.out.println("Return: " + ret);
        return ret;
    }

    /**
     * ���ݵݹ��������debug��ӡʱ����Ϣ
     * @param depth �ݹ����
     * @return
     */
    private String generateDepthString(int depth) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            sb.append("--");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 6, 4, 5, 6};
        ListNode listNode = new ListNode(arr);
        System.out.println(listNode);

        RecursionDebug recursionDebug = new RecursionDebug();
        recursionDebug.removeElements(listNode, 6, 0);
        System.out.println(listNode);
    }
}
