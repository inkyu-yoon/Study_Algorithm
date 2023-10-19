package LV3.정수삼각형;

import java.util.*;
class Solution2 {
    public int solution(int[][] triangle) {
        int answer = 0;
        int R = triangle.length;

        for(int r=1;r<R;r++){
            int C = triangle[r].length;
            for(int c=0;c<C;c++){
                if(c==0){
                    triangle[r][c]+=triangle[r-1][c];
                }else if(c==C-1){
                    triangle[r][c]+=triangle[r-1][c-1];
                }else{
                    triangle[r][c] +=Math.max(triangle[r-1][c-1],triangle[r-1][c]);
                }
            }
        }


        return Arrays.stream(triangle[R-1]).max().getAsInt();
    }

}
