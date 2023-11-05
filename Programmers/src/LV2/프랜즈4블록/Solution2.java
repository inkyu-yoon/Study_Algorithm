package LV2.프랜즈4블록;

class Solution2 {
    String[][] map;
    int R;
    int C;
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        R = m;
        C = n;
        map = new String[R][C];
        for(int r=0;r<R;r++){
            String[] boardInfo = board[r].split("");
            for(int c=0;c<C;c++){
                map[r][c]=boardInfo[c];
            }
        }

        while(checkBreak()){
            moveBlocks();
        }

        for(int r=0;r<R;r++){
            for(int c=0;c<C;c++){
                if(map[r][c].equals("")){
                    answer++;
                }
            }
        }
        return answer;
    }

    public boolean checkBreak(){
        boolean isBreak = false;
        boolean[][] checked = new boolean[R][C];
        for(int r=0;r<R-1;r++){
            for(int c=0;c<C-1;c++){
                String target = map[r][c];
                if(target.equals("")){
                    continue;
                }
                if(target.equals(map[r+1][c]) && target.equals(map[r][c+1]) && target.equals(map[r+1][c+1])){
                    checked[r][c]=true;
                    checked[r+1][c]=true;
                    checked[r][c+1]=true;
                    checked[r+1][c+1]=true;
                }
            }
        }

        for(int r=0;r<R;r++){
            for(int c=0;c<C;c++){
                if(checked[r][c]){
                    map[r][c]="";
                    isBreak = true;
                }
            }
        }
        return isBreak;
    }

    public void moveBlocks(){
        for(int r = R-1;r>=0;r--){
            for(int c=0;c<C;c++){
                int idx = r;
                while(idx>=0 && map[r][c].equals("")){
                    map[r][c]=map[idx][c];
                    map[idx][c]="";
                    idx--;
                }
            }
        }
    }
}