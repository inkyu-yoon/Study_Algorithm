package Tree;

import java.util.Arrays;

public class SegmentTree {
    public static void main(String[] args) {
        long[] arr = {1L, 2L, 3L, 4L, 5L, 6L};
        SegmentTreeMain.SegmentTree segmentTree = new SegmentTreeMain.SegmentTree(arr);
        System.out.println(Arrays.toString(segmentTree.tree));
        long sum = segmentTree.sum(1, 0, 5, 4, 5);
        System.out.println(sum);
        segmentTree.update(1,0,5,0,3L);
        System.out.println(Arrays.toString(segmentTree.tree));
    }
    long tree[];

    public SegmentTree(long[] arr) {
        int arrSize = arr.length;
        int treeHeight = (int) Math.ceil(Math.log(arrSize) / Math.log(2));
        int treeSize = (int) Math.pow(2, treeHeight + 1);
        tree = new long[treeSize];
        init(arr, 1, 0, arrSize - 1);
    }

    long init(long[] arr, int nodeIndex, int start, int end) {
        if (start == end) {
            return tree[nodeIndex] = arr[start];
        } else {
            int midPoint = (start + end) / 2;
            return tree[nodeIndex] = init(arr, nodeIndex * 2, start, midPoint)
                    + init(arr, nodeIndex * 2 + 1, midPoint + 1, end);
        }
    }

    void update(int nodeIndex, int start, int end, int index, int diff) {
        if (index < start || index > end) {
            return ;
        }
        tree[nodeIndex] += diff;

        if (start != end) {
            int midPoint = (start + end) / 2;
            update(nodeIndex * 2, start, midPoint, index, diff);
            update(nodeIndex * 2 + 1, midPoint + 1, end, index, diff);
        }
    }

    long sum(int nodeIndex, int start, int end, int left, int right) {
        if (right < start || left > end) {
            return 0;
        }

        if (left <= start && end <= right) {
            return tree[nodeIndex];
        }

        int midPoint = (start + end) / 2;
        return sum(nodeIndex * 2, start, midPoint, left, right)
                + sum(nodeIndex * 2 + 1, midPoint + 1, end, left, right);


    }
}
