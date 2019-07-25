package priorityqueue;

import heap.LeetCodeSolution;
import org.junit.Test;

import java.util.*;
import java.util.PriorityQueue;

/**
 * @author suyu
 * @version 1.0.0
 * @ClassName LeetCodeByJavaPriorityQueue
 * @Description ʹ��javaԭ�������ȶ���(��ײ�ʵ������С��)ʵ��LeetCode 347 ��
 * ����һ���ǿյ��������飬�������г���Ƶ��ǰ k �ߵ�Ԫ�ء�
 * �������� [1,1,1,2,2,3] , �� k = 2������ [1,2]��
 * @Date 2018/6/3 15:58
 */
public class LeetCodeByJavaPriorityQueue3 {

    /**
     * LeetCode������
     *
     * @param nums ����
     * @param k    ���ظ���
     * @return ���ؼ���
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        //key:Ԫ��,value:Ƶ�ʵĴ���
        TreeMap<Integer, Integer> map = new TreeMap<>();
        /*
         * ������������飬���������ֵ�����value��һ
         * ��û�а���keyֵ,˵���ǵ�һ�δ���,value��Ϊ1
         */
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        /**
         * �˴���Ϊ�����ڲ���,�ݱ����,ʹ�ô�����Ӽ�,��ע�͵�
         */
        /*
        PriorityQueue<Freq> queue = new PriorityQueue<>(new Comparator<Freq>(){
            @Override
            public int compare(Freq a, Freq b) {
                return a.freq - b.freq;
            }
        });
        */

        /**
         * ʹ��������ı䴫��Ĳ�������,�˴����Բ�������Freq,ʹ��map��Ƶ��������Ƚ�
         */
//        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>(){
//            @Override
//            public int compare(Integer a, Integer b) {
//                return map.get(a) - map.get(b);
//            }
//        });


        /**
         * �����Լ�ʹ��java8������,ʹ��lambda���ʽ
         */
        PriorityQueue<Integer> queue = new PriorityQueue<>(
                (a,b) -> map.get(a) - map.get(b)
        );


        //�˴���bobo��ʦ�ı����ṹ��ͬ,�����Ƽ�����mapʹ��EntrySet���б���
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key = entry.getKey();
            if (queue.size() < k) {
                queue.add(key);
            } else if (map.get(key) > map.get(queue.peek())) {
                queue.remove();
                queue.add(key);
            }
        }

        LinkedList<Integer> res = new LinkedList<>();
        //�����в�Ϊ��,�򵯳����ʣ������е�keyֵ
        while (!queue.isEmpty()) {
            res.add(queue.remove());
        }
        return res;
    }

    @Test
    public void testPriorityQueue() {
        //Ƶ��
        int k = 2;
        int[] array = {1, 1, 1, 2, 2, 3};

        LeetCodeSolution solution = new LeetCodeSolution();
        List<Integer> list = solution.topKFrequent(array, k);
        System.out.println(list);
    }
}
