package priorityqueue;

import heap.LeetCodeSolution;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * @author suyu
 * @version 1.0.0
 * @ClassName LeetCodeByJavaPriorityQueue
 * @Description ʹ��javaԭ�������ȶ���(��ײ�ʵ������С��)ʵ��LeetCode 347 ��
 * ����һ���ǿյ��������飬�������г���Ƶ��ǰ k �ߵ�Ԫ�ء�
 * �������� [1,1,1,2,2,3] , �� k = 2������ [1,2]��
 * @Date 2018/6/3 15:58
 */
public class LeetCodeByJavaPriorityQueue {

    /**
     * ����һ��freq�ڲ���,��װ��key-value��Ϊ��������
     * Ŀ����:��map��key-value����freq������,��ΪPriorityQueue<Freq>�ķ��͡�
     * ע: ������Ҫʵ�ֿɱȽϽӿ�,��ΪPriorityQueue��Ҫ�ɱ���
     */
    private class Freq implements Comparable<Freq> {
        int e, freq;

        public Freq(int e, int freq) {
            this.e = e;
            this.freq = freq;
        }

        /**
         * javaԭ�������ȶ���(��ײ�ʵ������С��)
         * ���ԱȽϵ��߼���Ҫ���:
         * �����ǰ��Ƶ��С�ڴ����Ƶ��,����-1������,����1,
         * �˴��߼������ѵ�ʵ���෴....
         * @param another
         * @return
         */
        @Override
        public int compareTo(Freq another) {
            if (this.freq < another.freq) {
                return -1;
            } else if (this.freq > another.freq) {
                return 1;
            } else {
                return 0;
            }
        }
    }


    /**
     * LeetCode������
     * @param nums ����
     * @param k ���ظ���
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


        PriorityQueue<Freq> queue = new PriorityQueue<>();
        //�˴���bobo��ʦ�ı����ṹ��ͬ,�����Ƽ�����mapʹ��EntrySet���б���
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key = entry.getKey();
            if (queue.size() < k){
                queue.add(new Freq(key,map.get(key)));
            }else if (map.get(key) > queue.peek().freq){
                queue.remove();
                queue.add(new Freq(key,map.get(key)));
            }
        }

        LinkedList<Integer> res = new LinkedList<>();
        //�����в�Ϊ��,�򵯳����ʣ������е�keyֵ
        while (!queue.isEmpty()){
            res.add(queue.remove().e);
        }
        return res;
    }

    @Test
    public void testPriorityQueue(){
        //Ƶ��
        int k = 2;
        int[] array = {1,1,1,2,2,3};

        LeetCodeSolution solution = new LeetCodeSolution();
        List<Integer> list = solution.topKFrequent(array,k);
        System.out.println(list);
    }
}
