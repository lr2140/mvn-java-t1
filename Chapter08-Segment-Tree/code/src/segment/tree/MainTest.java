package segment.tree;

import org.junit.Test;

/**
 * @author suyu
 * @version 1.0.0
 * @ClassName MainTest
 * @Description �߶����Ĳ�������
 * @Date 2018/6/9 16:20
 */
public class MainTest {

    @Test
    public void testSegmentTree() {
        Integer[] nums = {-2, 0, 3, -5, 2, -1};
        //��ʽ��д��,�����ڲ���
        /*
       SegmentTree<Integer> segmentTree = new SegmentTree<>(nums, new Merger<Integer>() {
            @Override
            public Integer merger(Integer a, Integer b) {
                return a + b;
            }
        });
        */
        //java8��lambda���ʽд��
        SegmentTree<Integer> segmentTree = new SegmentTree<>(nums, (a, b) -> a + b);
        System.out.println(segmentTree);

        /*
        ���ս����
        [-3, 1, -4, -2, 3, -3, -1, -2, 0, null, null, -5, 2, null, null, null, null, null, null, null, null, null, null, null]
         */
        /////////////////////////////////////////
        //    [-2, 0, 3, -5, 2, -1] sum:(-3)   //
        //            /  \                     //
        //  (1)[-2,0,3]   [-5,2,-1] sum:(-4)   //
        //       /  \          /  \            //
        // (-2)[-2] [0,3](3)(-3)[-5,2] [-1](-1)//
        //   ..............................    //
        /////////////////////////////////////////

    }

    /**
     * �߶����Ĳ�ѯ��������
     */
    @Test
    public void testSegmentTreeQuery() {
        Integer[] nums = {-2, 0, 3, -5, 2, -1};
        //java8��lambda���ʽд��,merger�������sum
        SegmentTree<Integer> segmentTree = new SegmentTree<>(nums, (a, b) -> a + b);
        // 0-2 �������߶���ֵsum = 1
        System.out.println(segmentTree.query(0,2));
        System.out.println(segmentTree.query(2,5));
        System.out.println(segmentTree.query(0,5));
    }
}
