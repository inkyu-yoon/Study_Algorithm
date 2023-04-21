package LV2.쿼드압축후개수세기;

import java.util.*;
class Solution {
    int countOfZero = 0;
    int countOfOne = 0;

    public int[] solution(int[][] arr) {
        if(!isAllSame(arr)){
            divide(arr,arr.length/2);
        }

        return new int[]{countOfZero,countOfOne};
    }

    void divide(int[][] arr,int size){
        if(size<=1){
            for(int r=0;r<=size;r++){
                for(int c=0;c<=size;c++){
                    if(arr[r][c]==0){
                        countOfZero++;
                    }else{
                        countOfOne++;
                    }
                }
            }
            return;
        }
        int [] dr = new int[]{0,0,size,size};
        int [] dc = new int[]{0,size,0,size};
        for(int i=0;i<4;i++){
            int[][] divided = new int[size][size];
            for(int r=0;r<size;r++){
                for(int c=0;c<size;c++){
                    divided[r][c]=arr[r+dr[i]][c+dc[i]];
                }
            }
            if(!isAllSame(divided)){
                divide(divided,divided.length/2);
            }
        }
    }

    boolean isAllSame(int[][] arr){
        int target = arr[0][0];
        for(int r =0;r<arr.length;r++){
            for(int c =0;c<arr.length;c++){
                if(arr[r][c]!=target){
                    return false;
                }
            }
        }
        if(target ==0){
            countOfZero++;
        }else{
            countOfOne++;
        }
        return true;
    }
}