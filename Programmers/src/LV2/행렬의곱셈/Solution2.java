package LV2.행렬의곱셈;

class Solution2 {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int I = arr1.length;
        int J = arr1[0].length;
        int K = arr2[0].length;
        int[][] answer = new int[I][K];



        for(int i=0;i<I;i++){
            for(int k=0;k<K;k++){
                for(int j=0;j<J;j++){
                    answer[i][k]+= arr1[i][j]*arr2[j][k];
                }
            }
        }

        return answer;
    }
}
