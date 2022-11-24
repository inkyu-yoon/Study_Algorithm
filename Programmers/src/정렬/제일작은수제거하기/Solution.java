package 정렬.제일작은수제거하기;


class Solution {
    //가장 작은 수를 제거한 배열을 리턴
    //리턴하는 배열이 빈 경우에는 -1 리턴
    public int[] solution(int[] arr) {
        int length = arr.length;

        //원소가 1개일 때, -1이 담긴 배열 리턴
        if (length == 1) {
            return new int[]{-1};
        }

        //제일 작은 원소 1개만 제거하기 때문에, 리턴 배열은 원래 배열 크기 -1 일 것
        int[] answer = new int[length - 1];

        //가장 작은 값 구하기
        int min =arr[0];
        for(int i=1;i<arr.length;i++){
            if(min>arr[i]){
                min=arr[i];
            }
        }

        int index = 0;

        // 가장 작은 값인 경우 입력 건너뛰기
        for(Integer element : arr){
            if(element==min){
                continue;
            }
            answer[index++]=element;
        }
        return answer;
    }
}