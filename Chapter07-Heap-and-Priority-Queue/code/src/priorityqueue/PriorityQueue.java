package priorityqueue;

import com.imooc.queues.Queue;
import heap.MaxHeap;

/**
 * @author suyu
 * @version 1.0.0
 * @ClassName PriorityQueue
 * @Description ��������ʵ�����ȶ���
 * @Date 2018/6/2 22:47
 */
public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {

    private MaxHeap<E> maxHeap;

    /**
     * ���ȶ��е�Ĭ�Ϲ��캯��
     */
    public PriorityQueue(){
        maxHeap = new MaxHeap<>();
    }

    /**
     * ��Ӳ���
     * @param e ����Ԫ��
     */
    @Override
    public void enqueue(E e) {
        maxHeap.add(e);
    }

    /**
     * ���Ӳ���
     * @return
     */
    @Override
    public E dequeue() {
        return maxHeap.extractMax();
    }

    @Override
    public E getHead() {
        return maxHeap.findMax();
    }

    @Override
    public int getSize() {
        return maxHeap.size();
    }

    @Override
    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }
}
