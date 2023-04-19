package LV2.스킬트리;
import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        HashSet<String> set = new HashSet<>(List.of(skill.split("")));
        List<String> list;


        for(String skill_tree : skill_trees){
            String[] skills = skill_tree.split("");
            list = new ArrayList<>();
            for(String sk : skills){
                if(set.contains(sk)){
                    list.add(sk);
                }
            }
            if(isRight(list,skill)){
                answer++;
            }
        }

        return answer;
    }

    boolean isRight(List<String> list,String skill){
        String[] skills = skill.split("");
        for(int i=0;i<list.size();i++){
            if(!list.get(i).equals(skills[i])){
                return false;
            }
        }
        return true;
    }
}