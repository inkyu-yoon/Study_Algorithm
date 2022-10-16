package Tree;

import java.util.Arrays;

public class SegmentTreeMain {
    public static void main(String[] args) {
        long[] arr = {1L, 2L, 3L, 4L, 5L, 6L};
        SegmentTree segmentTree = new SegmentTree(arr);
        System.out.println(Arrays.toString(segmentTree.tree));
        long sum = segmentTree.sum(1, 0, 5, 2, 5);
        System.out.println(sum);
        segmentTree.update(1,0,5,1,3L);
        System.out.println(Arrays.toString(segmentTree.tree));
    }
    static class SegmentTree {
        //트리 데이터를 저장할 배열
        long tree[];

        SegmentTree(long [] arr) {
            //트리 높이 계산
            //Math.log 는 밑이 10인 자연로그 이므로 Math.log(2) 로 한번 더 나누어준다.
            // 구간합을 나타내는 세그먼트 트리의 경우 높이는 (log2(N))을 올림한 값이 된다. (예시로 설명 가능)
            int arrSize = arr.length;
            int h = (int) Math.ceil(Math.log(arrSize) / Math.log(2));

            //트리 노드 수 계산
            int treeSize = (int) Math.pow(2, h + 1);

            //트리사이즈로 트리 생성하고 입력된 배열로 초기 트리 생성
            tree = new long[treeSize];
            init(arr,1,0,arrSize-1);
        }


        //트리 구조를 만들기 위한 작업, 재귀식 작업이다. 리프 노드일 때까지(자식 노드를 가지지 않는)
        // 리프 노드에 배열로 전달된 값들을 넣고, 부모 노드에는 구간 합을 삽입하는 방식
        //arr 리프 노드 값들을 표현
        //node 인덱스를 표현, root 노드의 경우 인덱스 1, root 노드의 왼쪽 자식은 인덱스 2, 오른쪽 자식은 3
        //root의 왼쪽자식의 왼쪽 자식은 2*2=4 , 왼쪽 자식의 오른쪽 자식은 2*2 +1 = 5
        //root의 오른쪽 자식의 왼쪽자식은 3*2=6 , 오른쪽 자식의 오른쪽 자식은 3*2+1 = 7
        //즉, 부모 인덱스가 i 라면 왼쪽 자식 인덱스는 i*2 , 오른쪽 자식 인덱스는 2*i+1
        long init(long[] arr, int nodeIndex, int start, int end) {
            if (start == end) { //같아지는 순간 데이터를 집어 넣는다.
                return tree[nodeIndex] = arr[start];
            } else { // 리프 노드를 제외한 노드에는 아래 구문에 의해, 구간 합이 저장될 것이다.
                int midPoint = (start+end)/2;
                return tree[nodeIndex] =
                        init(arr, nodeIndex * 2, start, midPoint)
                                + init(arr, nodeIndex * 2 + 1, midPoint + 1, end);

            }
        }

        //데이터 변경되는 경우
        //index = 변경 할 데이터 인덱스
        //diff = 원래 데이터와 변경 데이터값의 차이
        public void update(int nodeIndex, int start, int end, int index, long diff) {
            if (index < start || end < index) { //유효한 명령이 아니므로 제외
                return ;
            }
            //바꾸려는 데이터에 diff를 더해주면 값이 적용 됨
            tree[nodeIndex] += diff;

            if (start != end) { //리프 노드가 아닌 경우 구간 합에 반영 시켜주어야 함

                int midPoint = (start+end)/2;
                update(nodeIndex*2, start, midPoint, index, diff);
                update(nodeIndex*2+1, midPoint+1, end, index, diff);

            }
        }

        public long sum(int node_idx, int start, int end, int left, int right){
            // 범위를 벗어나게 되는 경우 더할 필요 없음
            if(left > end || right < start){
                return 0;
            }

            // 범위 내 완전히 포함 시에는 더 내려가지 않고 바로 리턴
            //left 랑 right 는 우리가 구하고자 하는 구간이라 고정
            //start~end 는 구간합 즉 left<+start ~ end<=right 를 만족하면 값을 반환하면 됨
            if(left <= start && end <= right){
                return tree[node_idx];
            }
            // 그 외의 경우 좌 / 우측으로 지속 탐색 수행
            int midPoint = (start + end) / 2;
            return sum(node_idx*2, start, midPoint, left, right)+
                    sum(node_idx*2+1, midPoint+1, end, left, right);
        }
    }
}
