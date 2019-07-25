package segment.tree;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 * @author suyu
 * @version 1.0.0
 * @ClassName NumArray
 * @Description leetCode303 -- use SegmentTree
 * ���� nums = [-2, 0, 3, -5, 2, -1]����ͺ���Ϊ sumRange()
 * <p>
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * @Date 2018��06��12��21:09:37
 */
public class NumArray {

    private static SegmentTree<Integer> segmentTree;


    public NumArray(int[] nums) {

        if (nums.length > 0) {
            Integer[] data = new Integer[nums.length];
            for (int i = 0; i < nums.length; i++) {
                data[i] = nums[i];
            }
            segmentTree = new SegmentTree<>(data, (a, b) -> a + b);
        }

    }

    public static int sumRange(int i, int j) {

        if (segmentTree == null) {
            throw new IllegalArgumentException("Segment Tree is null!");
        }
        return segmentTree.query(i, j);
    }

    /**
     * ʹ���߶����������²���
     *
     * @param index
     * @param val
     */
    public static void update(int index, int val) {
        if (segmentTree == null) {
            throw new IllegalArgumentException("Segment Tree is null!");
        }
        segmentTree.set(index, val);
    }

    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(sumRange(0, 2));
        update(0, 0);
        //assert == 3 is true
        System.out.println(sumRange(0, 2));
    }
}
