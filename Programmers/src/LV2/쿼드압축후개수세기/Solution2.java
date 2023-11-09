class Solution2 {
    int totalOne = 0;
    int totalZero = 0;
    public int[] solution2(int[][] arr) {
        int[] answer = {};
        int N = arr.length;
        divide(arr,0,N,0,N);
        return new int[]{totalZero,totalOne};
    }

    void divide(int[][] arr, int rs, int re, int cs, int ce){
        if(isSame(arr,rs,re,cs,ce)){
            return;
        }

        int N = (re-rs)/2;
        divide(arr,rs,rs+N,cs,cs+N);
        divide(arr,rs,rs+N,cs+N,cs+2*N);
        divide(arr,rs+N,rs+N*2,cs,cs+N);
        divide(arr,rs+N,rs+N*2,cs+N,cs+2*N);

    }

    boolean isSame(int[][] arr, int rs, int re, int cs, int ce){
        int cntOfOne =0;
        int cntOfZero = 0;
        for(int r=rs;r<re;r++){
            for(int c=cs;c<ce;c++){
                if(arr[r][c]==0){
                    cntOfZero++;
                }else{
                    cntOfOne++;
                }
            }
        }
        if(cntOfOne==0){
            totalZero++;
        }
        if(cntOfZero==0){
            totalOne++;
        }
        return (cntOfOne == 0 || cntOfZero==0);
    }
}