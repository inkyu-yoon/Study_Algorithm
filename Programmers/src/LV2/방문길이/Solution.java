package LV2.방문길이;
import java.util.*;
class Solution {
    public int solution(String dirs) {
        int answer = 0;
        HashSet<String> set = new HashSet<>();
        String [] directs = {"U","D","R","L"};
        int [] dx = {0,0,1,-1};
        int [] dy = {1,-1,0,0};

        int x = 0, y = 0,nx=0,ny=0;

        String[] commands = dirs.split("");
        for(int i=0;i<commands.length;i++){
            for(int j=0;j<4;j++){
                if(directs[j].equals(commands[i])){
                    nx = x+dx[j];
                    ny = y+dy[j];
                    break;
                }
            }
            if((-5<=nx && nx<=5) && (-5<=ny && ny<=5)){
                set.add(String.format("%d%d%d%d",x,y,nx,ny));
                set.add(String.format("%d%d%d%d",nx,ny,x,y));
                x=nx;
                y=ny;
            }
        }

        return set.size()/2;
    }
}